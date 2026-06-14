package controller;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public void inserir(Cliente cliente){

        String sql = """
                INSERT INTO tb_cliente
                (nome, telefone, cpf, endereco, nascimento, observacao)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try(

                Connection con = Conexao.conectar();

                PreparedStatement pst =
                        con.prepareStatement(sql)

        ){

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getEndereco());
            pst.setDate(5, java.sql.Date.valueOf(cliente.getNascimento()));
            pst.setString(6, cliente.getObservacao());

            pst.executeUpdate();

            System.out.println("Cliente cadastrado!");

        } catch(SQLException e){

            e.printStackTrace();

        }
    }

    public ArrayList<Cliente> listar(){

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM tb_cliente ORDER BY nome";

        try(

                Connection con = Conexao.conectar();

                PreparedStatement pst =
                        con.prepareStatement(sql);

                ResultSet rs = pst.executeQuery()

        ){

            while(rs.next()){

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));

                lista.add(c);
            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return lista;
    }
}