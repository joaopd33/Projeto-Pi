
package br.com.projetoPi.dal;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {
    
   
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // A linha abaixo chama o drive 
        String driver = "com.mysql.cj.jdbc.Driver";

        //Armazenando informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbgertservi";
        String user = "root";
        String password = "123456789";
        

        //Estabelecendo a conexao com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            

        } catch (Exception e) {
            return null;
        }
    }
}
