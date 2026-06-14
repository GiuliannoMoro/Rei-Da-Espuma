package controller;

import model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {

    public void inserir(Veiculo veiculo) {

        String sql = """
                INSERT INTO tb_veiculo
                (placa, marca, modelo, cor, observacao, id_cliente)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
            Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql)
        ) {
            pst.setString(1, veiculo.getPlaca());
            pst.setString(2, veiculo.getMarca());
            pst.setString(3, veiculo.getModelo());
            pst.setString(4, veiculo.getCor());
            pst.setString(5, veiculo.getObservacao());
            pst.setInt(6, veiculo.getIdCliente());

            pst.executeUpdate();
            System.out.println("Veículo cadastrado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Veiculo> listar() {

        ArrayList<Veiculo> lista = new ArrayList<>();

        String sql = "SELECT * FROM tb_veiculo ORDER BY placa";

        try (
            Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()
        ) {
            while (rs.next()) {

                Veiculo v = new Veiculo();

                v.setId(rs.getInt("id"));
                v.setPlaca(rs.getString("placa"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setCor(rs.getString("cor"));
                v.setObservacao(rs.getString("observacao"));
                v.setIdCliente(rs.getInt("id_cliente"));

                lista.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public void atualizar(Veiculo veiculo) {

    String sql = """
        UPDATE tb_veiculo
        SET
        placa = ?,
        marca = ?,
        modelo = ?,
        cor = ?,
        observacao = ?,
        id_cliente = ?
        WHERE id = ?
        """;

    try (

        Connection con = Conexao.conectar();
        PreparedStatement pst = con.prepareStatement(sql)

    ) {

        pst.setString(1, veiculo.getPlaca());
        pst.setString(2, veiculo.getMarca());
        pst.setString(3, veiculo.getModelo());
        pst.setString(4, veiculo.getCor());
        pst.setString(5, veiculo.getObservacao());
        pst.setInt(6, veiculo.getIdCliente());

        // ID DO VEÍCULO
        pst.setInt(7, veiculo.getId());

        pst.executeUpdate();

        System.out.println("Veículo atualizado!");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}