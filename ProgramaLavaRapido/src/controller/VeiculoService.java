/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;
import model.Cliente;
import model.TipoVeiculo;
import modelo.dao.VeiculoDAO;

/**
 *
 * @author Evelyn
 */
public class VeiculoService {
    
    public static void cadastrar(String[] atributos)throws ClassNotFoundException, SQLException {

            Veiculo v = new Veiculo();

            v.setPlaca(atributos[0]);
            v.setTipo(TipoVeiculo.valueOf(atributos[1]));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(atributos[2]));

            v.setCliente(cliente);

            VeiculoDAO dao = new VeiculoDAO();

            dao.cadastrar(v);
        }
   
    
    public static List<Object[]> obterTodos()throws ClassNotFoundException, SQLException {

            VeiculoDAO dao = new VeiculoDAO();

            List<Veiculo> veiculos = dao.listarTodos();

            List<Object[]> retorno = new ArrayList<>();

            for (Veiculo v : veiculos) {

                Object dados[] = new Object[3];

                dados[0] = v.getPlaca();
                dados[1] = v.getTipo().name();
                dados[2] = v.getCliente().getId();

                retorno.add(dados);
            }

            return retorno;
        }
    
    public static List<Veiculo> obterVeiculosPorCliente(int idCliente)throws ClassNotFoundException, SQLException {

        VeiculoDAO dao = new VeiculoDAO();

        return dao.listarPorCliente(idCliente);
    }
}
