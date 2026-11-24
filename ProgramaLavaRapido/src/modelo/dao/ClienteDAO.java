/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author Evelyn
 */
public class ClienteDAO {

      
      
      
      
      
        public void cadastrar(model.Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into clientes (nome, cpf, email, telefone) values (?,?,?,?)");
        comando.setString(1, c.getNome());
        comando.setString(2, c.getCpf());
        comando.setString(3, c.getEmail());
        comando.setString(4, c.getTelefone());
        comando.execute();
        con.close();
    }
    
    public void deletar(model.Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from clientes where id = ?");
        comando.setInt(1, c.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(model.Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update produtos set nome = ?, cpf = ?, email = ?, telefone = ? where id = ?");
        comando.setString(1, c.getNome());
        comando.setString(2, c.getCpf());
        comando.setString(3, c.getEmail());
        comando.setString(4, c.getTelefone());
        comando.setInt(5, c.getId());
        comando.execute();
        con.close();
    }

    public model.Cliente consultarById(model.Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from clientes where id = ?");
        comando.setInt(1, c.getId());
        ResultSet rs = comando.executeQuery();
        model.Cliente client = new model.Cliente();
        if (rs.next()){
            client.setId(rs.getInt("id"));
            client.setNome(rs.getString("nome"));
            client.setCpf(rs.getString("cpf"));
            client.setEmail(rs.getString("email"));
            client.setTelefone(rs.getString("telefone"));
            
        }        
        return client;
    }
    

    public List<model.Cliente> listarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from clientes");
        ResultSet rs = comando.executeQuery();
        
        List<model.Cliente> lcli = new ArrayList<model.Cliente>();
        while(rs.next()){
            model.Cliente cli = new model.Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNome(rs.getString("nome"));
            cli.setCpf(rs.getString("cpf"));
            cli.setEmail(rs.getString("email"));
            cli.setTelefone(rs.getString("telefone"));
            lcli.add(cli);
        }        
        return lcli;
    }
    
    
    
    
      /**    public java.util.List<model.Cliente> listarTodos() throws ClassNotFoundException{
      java.sql.Connection con = null;
      java.sql.Statement stmt = null;
      java.sql.ResultSet rs = null;
      java.util.List<model.Cliente> clientes = new java.util.ArrayList<>();
      
      try {
        con = Conexao.getConexao();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM clientes");
        while (rs.next()){
           model.Cliente c = new model.Cliente();
                   rs.getInt("id"); 
                   rs.getString("nome");
                   rs.getString("cpf");
                   rs.getString("telefone");
                   rs.getString("email");
           clientes.add(c);
        }
        con.close();
      } catch (java.sql.SQLException ex){
          System.out.println("Erro ao acessar o banco de dados lava rapido"+ex);
      }
      return clientes;
      } **/
    
}
