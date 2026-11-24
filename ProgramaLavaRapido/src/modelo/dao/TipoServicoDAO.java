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
import model.TipoServico;
import util.Conexao;
/**
 *
 * @author Evelyn
 */
public class TipoServicoDAO {
        public List<model.TipoServico> listarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tiposervico");
        ResultSet rs = comando.executeQuery();
        
        List<model.TipoServico> lser = new ArrayList<model.TipoServico>();
        while(rs.next()){
            model.TipoServico ser = new model.TipoServico();
            ser.setNome(rs.getString("nome"));
            ser.setDescricao(rs.getString("descricao"));
            ser.setPreco(rs.getDouble("preco"));
           lser.add(ser);
        } 
        con.close();
        return lser;
    }
    
    public void cadastrar(model.TipoServico ts) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into tiposervico (nome, descricao, preco) values (?,?,?)");
        comando.setString(1, ts.getNome());
        comando.setString(2, ts.getDescricao());
        comando.setDouble(3, ts.getPreco());
        comando.execute();
        con.close();
    }
    public List<TipoServico> obterServicos() throws ClassNotFoundException, SQLException {

    TipoServicoDAO dao = new TipoServicoDAO();

    return dao.listarTodos();
    }
}
