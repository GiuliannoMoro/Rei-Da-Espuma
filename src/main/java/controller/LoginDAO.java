package controller;

import model.Usuario;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginDAO {
    
    public boolean login(Usuario usuario){

    String sql = """
            SELECT * FROM tb_usuario
            WHERE email = ?
            AND senha = MD5(?)
            """;

    try(
            Connection con = Conexao.conectar();
            PreparedStatement pst =
                    con.prepareStatement(sql)
    ){

        pst.setString(1, usuario.getEmail());
        pst.setString(2, usuario.getSenha());

        ResultSet rs = pst.executeQuery();

        return rs.next();

    } catch(SQLException e){
        e.printStackTrace();
    }

    return false;
}
}
