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
import model.Veiculo;
import model.Cliente;
import model.TipoVeiculo;
import util.Conexao;

/**
 *
 * @author Evelyn
 */
public class VeiculoDAO {
    public void cadastrar(Veiculo v) throws ClassNotFoundException, SQLException {

            Connection con = Conexao.getConexao();

            PreparedStatement comando = con.prepareStatement(
                "INSERT INTO veiculo (placa, tipo, id_cliente) VALUES (?, ?, ?)"
            );

            comando.setString(1, v.getPlaca());
            comando.setString(2, v.getTipo().name());
            comando.setInt(3, v.getCliente().getId());

            comando.execute();
            con.close();
        }
    
    public List<Veiculo> listarTodos() throws ClassNotFoundException, SQLException {

            Connection con = Conexao.getConexao();

            PreparedStatement comando = con.prepareStatement(
                "SELECT * FROM veiculo"
            );

            ResultSet rs = comando.executeQuery();

            List<Veiculo> retorno = new ArrayList<>();

            while (rs.next()) {

                Veiculo v = new Veiculo();

                v.setPlaca(rs.getString("placa"));
                v.setTipo(TipoVeiculo.valueOf(rs.getString("tipo")));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));

                v.setCliente(cliente);

                retorno.add(v);
            }

            con.close();

            return retorno;
        }
    
    public List<Veiculo> listarPorCliente(int idCliente) throws ClassNotFoundException, SQLException {

            Connection con = Conexao.getConexao();

            PreparedStatement comando = con.prepareStatement(
                "SELECT * FROM veiculo WHERE id_cliente = ?"
            );

            comando.setInt(1, idCliente);

            ResultSet rs = comando.executeQuery();

            List<Veiculo> retorno = new ArrayList<>();

            while (rs.next()) {

                Veiculo v = new Veiculo();

                v.setPlaca(rs.getString("placa"));
                v.setTipo(TipoVeiculo.valueOf(rs.getString("tipo")));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));

                v.setCliente(cliente);

                retorno.add(v);
            }

            con.close();

            return retorno;
        }
}
