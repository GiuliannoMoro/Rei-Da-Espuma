package controller;

import model.Servico;
import model.ConsultaServico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class ServicoDAO {

    public void inserir(Servico servico) {

        String sql = """
                INSERT INTO tb_servico
                (tipo_servico, cera, higienizacao_ar,
                 hidratacao_couro, valor_total, id_veiculo)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
            Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql)
        ) {

            pst.setString(1, servico.getTipoServico());
            pst.setBoolean(2, servico.isCera());
            pst.setBoolean(3, servico.isHigienizacaoAr());
            pst.setBoolean(4, servico.isHidratacaoCouro());
            pst.setDouble(5, servico.getValorTotal());
            pst.setInt(6, servico.getIdVeiculo());

            int linhas = pst.executeUpdate();

            System.out.println("Linhas afetadas: " + linhas);
            System.out.println("Serviço registrado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Servico servico) {

        String sql = """
            UPDATE tb_servico
            SET
            tipo_servico = ?,
            cera = ?,
            higienizacao_ar = ?,
            hidratacao_couro = ?,
            valor_total = ?,
            id_veiculo = ?
            WHERE id = ?
            """;

        try (
            Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql)
        ) {

            pst.setString(1, servico.getTipoServico());
            pst.setBoolean(2, servico.isCera());
            pst.setBoolean(3, servico.isHigienizacaoAr());
            pst.setBoolean(4, servico.isHidratacaoCouro());
            pst.setDouble(5, servico.getValorTotal());
            pst.setInt(6, servico.getIdVeiculo());
            pst.setInt(7, servico.getId());

            pst.executeUpdate();

            System.out.println("Serviço atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ConsultaServico> listarTabela() {

        ArrayList<ConsultaServico> lista = new ArrayList<>();

        String sql = """
            SELECT
                s.id,
                c.nome AS cliente,
                v.placa,
                v.modelo,
                s.tipo_servico,
                s.cera,
                s.higienizacao_ar,
                s.hidratacao_couro,
                s.valor_total
            FROM tb_servico s
            INNER JOIN tb_veiculo v
                ON s.id_veiculo = v.id
            INNER JOIN tb_cliente c
                ON v.id_cliente = c.id
            ORDER BY c.nome
            """;

        try (
            Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()
        ) {

            while(rs.next()) {

                ConsultaServico cs = new ConsultaServico();

                cs.setId(rs.getInt("id"));
                cs.setCliente(rs.getString("cliente"));
                cs.setPlaca(rs.getString("placa"));
                cs.setVeiculo(rs.getString("modelo"));
                cs.setTipoServico(rs.getString("tipo_servico"));

                String adicionais = "";

                if(rs.getBoolean("cera")) adicionais += "Cera ";
                if(rs.getBoolean("higienizacao_ar")) adicionais += "Ar ";
                if(rs.getBoolean("hidratacao_couro")) adicionais += "Couro ";

                cs.setAdicionais(adicionais);
                cs.setValor(rs.getDouble("valor_total"));

                lista.add(cs);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ArrayList<ConsultaServico> pesquisar(String pesquisa) {

        ArrayList<ConsultaServico> lista = new ArrayList<>();

        String sql = """
            SELECT
                s.id,
                c.nome AS cliente,
                v.placa,
                v.modelo,
                s.tipo_servico,
                s.cera,
                s.higienizacao_ar,
                s.hidratacao_couro,
                s.valor_total
            FROM tb_servico s
            INNER JOIN tb_veiculo v
                ON s.id_veiculo = v.id
            INNER JOIN tb_cliente c
                ON v.id_cliente = c.id
            WHERE
                LOWER(c.nome) LIKE LOWER(?)
                OR LOWER(v.placa) LIKE LOWER(?)
                OR LOWER(v.modelo) LIKE LOWER(?)
            ORDER BY c.nome
            """;

        try (
            Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql)
        ) {

            String termo = "%" + pesquisa + "%";

            pst.setString(1, termo);
            pst.setString(2, termo);
            pst.setString(3, termo);

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                ConsultaServico cs = new ConsultaServico();

                cs.setId(rs.getInt("id"));
                cs.setCliente(rs.getString("cliente"));
                cs.setPlaca(rs.getString("placa"));
                cs.setVeiculo(rs.getString("modelo"));
                cs.setTipoServico(rs.getString("tipo_servico"));

                String adicionais = "";

                if(rs.getBoolean("cera")) adicionais += "Cera ";
                if(rs.getBoolean("higienizacao_ar")) adicionais += "Ar ";
                if(rs.getBoolean("hidratacao_couro")) adicionais += "Couro ";

                cs.setAdicionais(adicionais);
                cs.setValor(rs.getDouble("valor_total"));

                lista.add(cs);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}