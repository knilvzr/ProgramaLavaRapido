/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import modelo.dao.ClienteDAO;

/**
 *
 * @author Evelyn
 */
public class ClienteService {
    

    public static void inserirCliente(String[] atributos) throws ClassNotFoundException, SQLException {
    model.Cliente cli = new model.Cliente();
    cli.setNome(atributos[0]);
    cli.setCpf(atributos[1]);
    cli.setEmail(atributos[2]);
    cli.setTelefone(atributos[3]);
    
    modelo.dao.ClienteDAO cdao = new modelo.dao.ClienteDAO();
    cdao.cadastrar(cli);
    
    }
    
    
    public static java.util.List<Object[]> obterTodos() throws ClassNotFoundException, SQLException{
    java.util.List<Object[]> retorno = new java.util.ArrayList<>();
    modelo.dao.ClienteDAO cdao = new modelo.dao.ClienteDAO();
    java.util.List<model.Cliente> clientes = cdao.listarTodos();
    for (model.Cliente c : clientes) {
    retorno.add(new Object[] {c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getTelefone()});
        }
    return retorno;
    }
    
 public static void deletarCliente(String[] atributos) throws ClassNotFoundException, SQLException {

    model.Cliente cli = new model.Cliente();

    cli.setId(Integer.parseInt(atributos[0]));

    modelo.dao.ClienteDAO cdao = new modelo.dao.ClienteDAO();

    cdao.deletar(cli);
    }
 
 public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {

    ClienteDAO dao = new ClienteDAO();

    return dao.listarTodos();
    }
    
    
}

