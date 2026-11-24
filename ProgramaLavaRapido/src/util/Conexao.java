/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Evelyn
 */
public class Conexao {
    public static java.sql.Connection getConexao()throws ClassNotFoundException, SQLException{
        java.sql.Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con =  java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/lavarapido","root","12Rn35pt!");
        } catch (ClassNotFoundException | java.sql.SQLException ex){
            System.out.println("Erro:" +ex.getMessage());
            throw ex;
        }
        return con;
    }
}
