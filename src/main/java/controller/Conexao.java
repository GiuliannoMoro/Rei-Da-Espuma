package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    //Parâmetros para Conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/DB_REIESPUMA";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1004";
    
    public static Connection conectar(){
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    //Testar Conexão
    
    public static void main(String[] args) {
        Connection con = Conexao.conectar();
        if (con != null){
            System.out.println("Conexao realizada com sucesso!");
        }
    }
}