/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.SQLException;
import modelo.dao.TipoServicoDAO;
/**
 *
 * @author Evelyn
 */
public class TipoServicoService {
    public static java.util.List<model.TipoServico> obterServicos()throws ClassNotFoundException, SQLException {

    modelo.dao.TipoServicoDAO sdao = new modelo.dao.TipoServicoDAO();

    return sdao.listarTodos();
    }
    
    public static void cadastrar(String[] atributos)throws ClassNotFoundException, SQLException {

            model.TipoServico ts = new model.TipoServico();

            ts.setNome(atributos[1]);
            ts.setDescricao(atributos[2]);
            ts.setPreco(Double.parseDouble(atributos[3]));

            TipoServicoDAO dao = new TipoServicoDAO();

            dao.cadastrar(ts);
        }

}
