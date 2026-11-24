/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.Status;
import model.TipoServico;
import modelo.dao.AgendamentoDAO;

/**
 *
 * @author Evelyn
 */
public class AgendamentoService {

    public static List<Object[]> obterTodos() throws ClassNotFoundException, SQLException {

        AgendamentoDAO dao = new AgendamentoDAO();

        List<Agendamento> agendamentos = dao.listarTodos();

        List<Object[]> retorno = new ArrayList<>();

        for (Agendamento a : agendamentos) {

            retorno.add(new Object[]{
                a.getId(),
                a.getDataHora(),
                a.getCliente().getNome(),
                a.getTipoServico().getNome(),
                a.getStatus().name(),    
                a.getVeiculo().getPlaca()
            });
        }

        return retorno;
    }
    
    public static void agendar(String[] atributos)throws ClassNotFoundException, SQLException {

            model.Agendamento a = new model.Agendamento();

            model.Cliente cliente = new model.Cliente();
            cliente.setId(Integer.parseInt(atributos[0]));
            a.setCliente(cliente);

            model.TipoServico servico = new model.TipoServico();
            servico.setNome(atributos[1]);
            a.setTipoServico(servico);

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");

            a.setDataHora(LocalDateTime.parse(atributos[2], formato));

            a.setStatus(model.Status.pendente);

            model.Veiculo veiculo = new model.Veiculo();
            veiculo.setPlaca(atributos[3]);
            a.setVeiculo(veiculo);

            modelo.dao.AgendamentoDAO dao =
                    new modelo.dao.AgendamentoDAO();

            dao.agendar(a);
        }
    public static void alterarStatus(String[] atributos) throws ClassNotFoundException, SQLException {

        Agendamento a = new Agendamento();

        a.setId(Integer.parseInt(atributos[0]));
        a.setStatus(Status.valueOf(atributos[1]));

        AgendamentoDAO dao = new AgendamentoDAO();

        dao.alterarStatus(a);
    }
    public static java.util.List<LocalTime> obterHorariosOcupados(LocalDate data) throws ClassNotFoundException, SQLException {

            modelo.dao.AgendamentoDAO adao =
                    new modelo.dao.AgendamentoDAO();

            return adao.obterHorariosOcupados(data);
        }

}
