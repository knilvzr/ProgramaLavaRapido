/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Evelyn
 */
public class AgendamentoDAO {
   public void agendar(model.Agendamento a) throws ClassNotFoundException, SQLException {

    Connection con = Conexao.getConexao();

    PreparedStatement comando = con.prepareStatement(
        "INSERT INTO agenda (data, id_cliente, id_tiposervico, status, placa_veiculo) "
        + "VALUES (?, ?, (SELECT id FROM tiposervico WHERE nome = ?), ?, ?)"
    );

    comando.setTimestamp(1, java.sql.Timestamp.valueOf(a.getDataHora()));
    comando.setInt(2, a.getCliente().getId());
    comando.setString(3, a.getTipoServico().getNome());
    comando.setString(4, a.getStatus().name());
    comando.setString(5, a.getVeiculo().getPlaca());

    comando.executeUpdate();

    con.close();

    }
   
   public void cancelarAgendamento(model.Agendamento a)
        throws ClassNotFoundException, SQLException {

    Connection con = Conexao.getConexao();

    PreparedStatement comando = con.prepareStatement(
        "UPDATE agenda SET status = ? WHERE id = ?"
    );

    comando.setString(1, "CANCELADO");
    comando.setInt(2, a.getId());

    comando.execute();
    con.close();
    }
   
    public List<model.Agendamento> listarTodos() throws ClassNotFoundException, SQLException {

        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement(
            "SELECT * FROM consulta_agenda"
    );

        ResultSet rs = comando.executeQuery();

        List<model.Agendamento> retorno = new ArrayList<>();

        while (rs.next()) {
            

            model.Agendamento a = new model.Agendamento();

          model.Cliente cliente = new model.Cliente();
            cliente.setId(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("cliente"));

            model.TipoServico servico = new model.TipoServico();
            servico.setNome(rs.getString("servico"));

            a.setId(rs.getInt("id"));
            a.setDataHora(rs.getTimestamp("data").toLocalDateTime());
            a.setCliente(cliente);
            a.setTipoServico(servico);
            a.setStatus(model.Status.valueOf(rs.getString("status").toLowerCase()));

            retorno.add(a);
            
            model.Veiculo veiculo = new model.Veiculo();

            veiculo.setPlaca(rs.getString("placa_veiculo"));

            a.setVeiculo(veiculo);
        }

        con.close();

        return retorno;
        }
    
    public void alterarStatus(model.Agendamento a) throws ClassNotFoundException, SQLException {

        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement(
            "UPDATE agenda SET status = ? WHERE id = ? AND status = 'PENDENTE'"
        );

        comando.setString(1, a.getStatus().name());
        comando.setInt(2, a.getId());

        comando.executeUpdate();
        con.close();
    }
    
    public java.util.List<LocalTime> obterHorariosOcupados(LocalDate data) throws ClassNotFoundException, SQLException {

            Connection con = Conexao.getConexao();

            PreparedStatement comando = con.prepareStatement(
                "SELECT data FROM agenda WHERE DATE(data) = ? " +
                "AND status IN ('PENDENTE', 'CONCLUIDO')"
            );

            comando.setDate(1, java.sql.Date.valueOf(data));

            ResultSet rs = comando.executeQuery();

            java.util.List<LocalTime> retorno = new java.util.ArrayList<>();

            while (rs.next()) {

                retorno.add(rs.getTimestamp("data")
                              .toLocalDateTime()
                              .toLocalTime());
            }

            con.close();

            return retorno;
        }
}
