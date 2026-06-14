package controller;

import model.Usuario;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;

public class UsuarioDAO {
    
    public void inserir(Usuario usuario){
        String sql = """
                INSERT INTO tb_usuario
                (nome, email, senha)
                VALUES (?, ?, MD5(?))
                """;
        try (
                Connection con = Conexao.conectar();
                PreparedStatement pst =
                        con.prepareStatement(sql)
        ) {

            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());

            pst.executeUpdate();

            System.out.println("Empregado cadastrado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }
