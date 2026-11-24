/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Evelyn
 */
  

    public class Teste extends javax.swing.JFrame {

        /**
         * Creates new form viewTeste
         */
        public Teste() throws SQLException, ClassNotFoundException {

            initComponents();
            criaJTable();

            obterClientes((DefaultTableModel) tabelaClientes.getModel());

            carregarClientes();
            carregarServicos();

            carregarDatas();
            carregarHorarios();
            
            carregarProprietarios();
            carregarTiposVeiculo();
            
            carregarClientes();
            carregarVeiculos();

            obterAgendamentos((DefaultTableModel) tabelaAgendamentos.getModel());
            
            
        }
        
        

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Teste.class.getName());

        private void criaJTable() throws SQLException {

            DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();

            modelo.setColumnIdentifiers(new String[]{
                "Id", "nome", "cpf", "email", "telefone"
            });

            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(110);
            tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(11);

            obterClientes(modelo);
  
        }
        
        
        private void carregarVeiculos() throws ClassNotFoundException, SQLException {

            veiculoComboBox.removeAllItems();

            model.Cliente cliente =
                    (model.Cliente) clienteComboBox.getSelectedItem();

            if (cliente != null) {

                java.util.List<model.Veiculo> veiculos =
                        controller.VeiculoService.obterVeiculosPorCliente(cliente.getId());

                for (model.Veiculo v : veiculos) {

                    veiculoComboBox.addItem(v);

                }
            }
        }
        
        private void carregarTiposVeiculo() {

            tipoVeiculoComboBox.removeAllItems();

            for (model.TipoVeiculo tipo : model.TipoVeiculo.values()) {

                tipoVeiculoComboBox.addItem(tipo.name());

            }
        }
        
        
        private void carregarProprietarios() throws ClassNotFoundException, SQLException {

            proprietarioComboBox.removeAllItems();

            java.util.List<model.Cliente> clientes =
                    controller.ClienteService.obterClientes();

            for (model.Cliente c : clientes) {

                proprietarioComboBox.addItem(c);
            }
}

        
        private void carregarDatas() {

            dataTxt.removeAllItems();

            LocalDate hoje = LocalDate.now();

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for (int i = 0; i < 30; i++) {

                dataTxt.addItem(hoje.plusDays(i).format(formato));

            }
        }
        
        
        private void carregarHorarios() throws ClassNotFoundException, SQLException {

            horaTxt.removeAllItems();

            if (dataTxt.getSelectedItem() == null) {
                return;
            }

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate data = LocalDate.parse(
                    (String) dataTxt.getSelectedItem(), formato);

            java.util.List<LocalTime> ocupados =
                    controller.AgendamentoService.obterHorariosOcupados(data);

            LocalTime inicio = LocalTime.of(8, 0);
            LocalTime fim = LocalTime.of(18, 0);

            while (!inicio.isAfter(fim)) {

                if (!ocupados.contains(inicio)) {

                    horaTxt.addItem(inicio.toString());

                }

                inicio = inicio.plusMinutes(30);
            }
        }
   
        
        public static void obterClientes(DefaultTableModel modeloTab) throws SQLException {
            try {
// limpa a tabela excluindo qualquer dado anteriormente inserido nela
                modeloTab.setNumRows(0);
// obtém a lista de produtos, invocando o método obterTodos da classe ProdutoControle
                java.util.List<Object[]> produtos = controller.ClienteService.obterTodos();
// insere cada produto em uma nova linha da tabela
                for (Object[] p : produtos) {
                    modeloTab.addRow(p);
                }
            } catch (ClassNotFoundException ex) {
                System.out.print("erro:" + ex.getMessage());
            }
        }
        
        
        public static void obterAgendamentos(DefaultTableModel modeloTab) throws SQLException {
                try {

                    modeloTab.setNumRows(0);

                    java.util.List<Object[]> agendamentos =
                            controller.AgendamentoService.obterTodos();

                    for (Object[] a : agendamentos) {
                        modeloTab.addRow(a);
                    }

                } catch (ClassNotFoundException ex) {

                    System.out.print("Erro: " + ex.getMessage());

                }
            }
        
       
        private void carregarClientes() throws ClassNotFoundException, SQLException {

            clienteComboBox.removeAllItems();

            java.util.List<model.Cliente> clientes =
                    controller.ClienteService.obterClientes();

            for (model.Cliente c : clientes) {
                clienteComboBox.addItem(c);
            }
        }
        
        private void carregarServicos() throws ClassNotFoundException, SQLException {

            servicoComboBox.removeAllItems();

            java.util.List<model.TipoServico> servicos =
                    controller.TipoServicoService.obterServicos();

            for (model.TipoServico s : servicos) {

                servicoComboBox.addItem(s);

            }
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomeClienteLbl = new javax.swing.JLabel();
        nomeClienteTxt = new javax.swing.JTextField();
        inserirClienteButton = new javax.swing.JButton();
        nomeClienteLbl1 = new javax.swing.JLabel();
        cpfClienteTxt = new javax.swing.JTextField();
        nomeClienteLbl2 = new javax.swing.JLabel();
        nomeClienteLbl3 = new javax.swing.JLabel();
        emailClienteTxt = new javax.swing.JTextField();
        telefoneClienteTxt = new javax.swing.JTextField();
        excluirClienteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        servicoComboBox = new javax.swing.JComboBox<>();
        agendarBtn = new javax.swing.JButton();
        clienteComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dataTxt = new javax.swing.JComboBox<>();
        horaTxt = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAgendamentos = new javax.swing.JTable();
        alterarStatusBtn = new javax.swing.JButton();
        statusOpc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        servicoBtn = new javax.swing.JButton();
        nomeServicoTxt = new javax.swing.JTextField();
        descricaoServicoTxt = new javax.swing.JTextField();
        precoServicoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cadastrarVeiculoBtn = new javax.swing.JButton();
        placaTxt = new javax.swing.JTextField();
        tipoVeiculoComboBox = new javax.swing.JComboBox<>();
        veiculoComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        proprietarioComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeClienteLbl.setText("nome: ");

        nomeClienteTxt.addActionListener(this::nomeClienteTxtActionPerformed);

        inserirClienteButton.setText("inserir");
        inserirClienteButton.addActionListener(this::inserirClienteButtonActionPerformed);

        nomeClienteLbl1.setText("cpf:");

        cpfClienteTxt.addActionListener(this::cpfClienteTxtActionPerformed);

        nomeClienteLbl2.setText("email");

        nomeClienteLbl3.setText("telefone");

        emailClienteTxt.addActionListener(this::emailClienteTxtActionPerformed);

        telefoneClienteTxt.addActionListener(this::telefoneClienteTxtActionPerformed);

        excluirClienteButton.setText("excluir");
        excluirClienteButton.addActionListener(this::excluirClienteButtonActionPerformed);

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeClienteLbl3)
                    .addComponent(nomeClienteLbl2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeClienteLbl)
                            .addComponent(nomeClienteLbl1))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cpfClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inserirClienteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(excluirClienteButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeClienteLbl)
                    .addComponent(nomeClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeClienteLbl1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeClienteLbl2)
                    .addComponent(emailClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeClienteLbl3)
                    .addComponent(telefoneClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirClienteButton)
                    .addComponent(excluirClienteButton))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("gerenciamento Cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("gerenciamento Agendamento");

        servicoComboBox.addActionListener(this::servicoComboBoxActionPerformed);

        agendarBtn.setText("agendar");
        agendarBtn.addActionListener(this::agendarBtnActionPerformed);

        clienteComboBox.addActionListener(this::clienteComboBoxActionPerformed);

        jLabel3.setText("cliente");

        jLabel4.setText("tipo servico");

        jLabel5.setText("data");

        dataTxt.addActionListener(this::dataTxtActionPerformed);

        jLabel6.setText("horario");

        tabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "horario", "nome ", "tipo servico", "status", "veiculo"
            }
        ));
        jScrollPane3.setViewportView(tabelaAgendamentos);

        alterarStatusBtn.setText("alterar Status");
        alterarStatusBtn.addActionListener(this::alterarStatusBtnActionPerformed);

        statusOpc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "concluido", "cancelado" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("cadastrar Servico");

        servicoBtn.setText("cadastrar");
        servicoBtn.addActionListener(this::servicoBtnActionPerformed);

        nomeServicoTxt.setText("nome");
        nomeServicoTxt.addActionListener(this::nomeServicoTxtActionPerformed);

        descricaoServicoTxt.setText("descricao");
        descricaoServicoTxt.addActionListener(this::descricaoServicoTxtActionPerformed);

        precoServicoTxt.setText("preco");
        precoServicoTxt.addActionListener(this::precoServicoTxtActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("cadastrar veiculo");

        cadastrarVeiculoBtn.setText("cadastrar");
        cadastrarVeiculoBtn.addActionListener(this::cadastrarVeiculoBtnActionPerformed);

        placaTxt.setText("placa");
        placaTxt.addActionListener(this::placaTxtActionPerformed);

        jLabel9.setText("veiculo");

        jLabel10.setText("cliente");

        jLabel11.setText("tipo veiculo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeServicoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaoServicoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precoServicoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 162, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(agendarBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabel5)
                                                .addGap(60, 60, 60)
                                                .addComponent(jLabel6)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(servicoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(horaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(veiculoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(7, 7, 7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(108, 108, 108)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(proprietarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(108, 108, 108)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(tipoVeiculoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(cadastrarVeiculoBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(statusOpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(alterarStatusBtn)
                                .addGap(159, 159, 159))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(servicoBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(servicoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(veiculoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(agendarBtn)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(158, 158, 158)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusOpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alterarStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeServicoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descricaoServicoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoServicoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(servicoBtn)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(proprietarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tipoVeiculoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cadastrarVeiculoBtn)))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeClienteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeClienteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteTxtActionPerformed

    private void cpfClienteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfClienteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfClienteTxtActionPerformed

    private void emailClienteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailClienteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailClienteTxtActionPerformed

    private void telefoneClienteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneClienteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneClienteTxtActionPerformed

    private void inserirClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirClienteButtonActionPerformed
        // TODO add your handling code here:
        String[] dados = new String[]{
            nomeClienteTxt.getText(),
            cpfClienteTxt.getText(),
            emailClienteTxt.getText(),
            telefoneClienteTxt.getText()
        };

        try {
            controller.ClienteService.inserirCliente(dados);
        } catch (ClassNotFoundException ex) {
            System.getLogger(Teste.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(Teste.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        JOptionPane.showMessageDialog(null, "cliente " + dados[0] + " inserido ");
    }//GEN-LAST:event_inserirClienteButtonActionPerformed

    private void excluirClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirClienteButtonActionPerformed
        // TODO add your handling code here:
        String dados[] = new String[5];
        int linhaselecionada = tabelaClientes.getSelectedRow();
        if (linhaselecionada >= 0) {
            nomeClienteTxt.setText((String) tabelaClientes.getValueAt(linhaselecionada, 1));
            dados[0] = String.valueOf(tabelaClientes.getValueAt(linhaselecionada, 0));
            dados[1] = (String) tabelaClientes.getValueAt(linhaselecionada, 1);
            dados[2] = (String) tabelaClientes.getValueAt(linhaselecionada, 2);
            dados[3] = (String) tabelaClientes.getValueAt(linhaselecionada, 3);
            dados[4] = (String) tabelaClientes.getValueAt(linhaselecionada, 4);
            try {
                controller.ClienteService.deletarCliente(dados);
            } catch (ClassNotFoundException ex) {
                System.getLogger(Teste.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (SQLException ex) {
                System.getLogger(Teste.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

            JOptionPane.showMessageDialog(this, "linha " + linhaselecionada + "id = " + dados[0] + " nome = " + dados[1] + "sera removido");

            ((DefaultTableModel) tabelaClientes.getModel()).removeRow(linhaselecionada);
        } else {
            JOptionPane.showMessageDialog(this, "é necesssario selecionar uma linha");
        }

    }//GEN-LAST:event_excluirClienteButtonActionPerformed

    private void agendarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarBtnActionPerformed
        // TODO add your handling code here:
     
            String dados[] = new String[4];

    model.Cliente cliente =
            (model.Cliente) clienteComboBox.getSelectedItem();

    model.TipoServico servico =
            (model.TipoServico) servicoComboBox.getSelectedItem();

    model.Veiculo veiculo =
            (model.Veiculo) veiculoComboBox.getSelectedItem();

    if (cliente != null && servico != null && veiculo != null) {

        dados[0] = String.valueOf(cliente.getId());
        dados[1] = servico.getNome();
        dados[2] = dataTxt.getSelectedItem() + " " + horaTxt.getSelectedItem();
        dados[3] = veiculo.getPlaca();

        try {

            controller.AgendamentoService.agendar(dados);

            carregarHorarios();

            obterAgendamentos(
                (DefaultTableModel) tabelaAgendamentos.getModel()
            );

            JOptionPane.showMessageDialog(this,
                    "Agendamento realizado com sucesso!");

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this,
                    "Erro ao agendar: " + ex.getMessage());

        } catch (java.time.format.DateTimeParseException ex) {

            JOptionPane.showMessageDialog(this,
                    "Data ou horário inválido!");

        }

    } else {

        JOptionPane.showMessageDialog(this,
                "Selecione um cliente, um serviço e um veículo!");

    }
            
    }//GEN-LAST:event_agendarBtnActionPerformed

    private void alterarStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarStatusBtnActionPerformed
        // TODO add your handling code here:]
        String dados[] = new String[2];

        int linhaselecionada = tabelaAgendamentos.getSelectedRow();

        if (linhaselecionada >= 0) {

            dados[0] = String.valueOf(tabelaAgendamentos.getValueAt(linhaselecionada, 0));
            dados[1] = (String) statusOpc.getSelectedItem();

            if ("pendente".equals(tabelaAgendamentos.getValueAt(linhaselecionada, 4))) {

                try {

                    controller.AgendamentoService.alterarStatus(dados);

                    tabelaAgendamentos.setValueAt(dados[1], linhaselecionada, 4);
                    carregarHorarios(); 

                    JOptionPane.showMessageDialog(this, "Status alterado com sucesso!");

                } catch (ClassNotFoundException | SQLException ex) {

                    JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());

                }

            } else {

                JOptionPane.showMessageDialog(this, "O agendamento não está pendente");

            }

        } else {

            JOptionPane.showMessageDialog(this, "É necessário selecionar uma linha");

        }
    
    }//GEN-LAST:event_alterarStatusBtnActionPerformed

    private void dataTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataTxtActionPerformed
        // TODO add your handling code here:
       try {

                carregarHorarios();

            } catch (ClassNotFoundException | SQLException ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage());

            }
        
    }//GEN-LAST:event_dataTxtActionPerformed

    private void nomeServicoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeServicoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeServicoTxtActionPerformed

    private void servicoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoBtnActionPerformed
        // TODO add your handling code here:

    String dados[] = new String[4];

    dados[1] = nomeServicoTxt.getText();
    dados[2] = descricaoServicoTxt.getText();
    dados[3] = precoServicoTxt.getText().replace(",", ".");

    try {

        controller.TipoServicoService.cadastrar(dados);

        carregarServicos();

        JOptionPane.showMessageDialog(this,
                "Serviço cadastrado com sucesso!");

        nomeServicoTxt.setText("");
        descricaoServicoTxt.setText("");
        precoServicoTxt.setText("");

    } catch (ClassNotFoundException | SQLException ex) {

        JOptionPane.showMessageDialog(this, ex.getMessage());

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(this, "Preço inválido!");

    }

    }//GEN-LAST:event_servicoBtnActionPerformed

    private void descricaoServicoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoServicoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoServicoTxtActionPerformed

    private void precoServicoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoServicoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoServicoTxtActionPerformed

    private void servicoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicoComboBoxActionPerformed

    private void cadastrarVeiculoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarVeiculoBtnActionPerformed
        // TODO add your handling code here:
        

            String dados[] = new String[3];

            model.Cliente cliente =
                (model.Cliente) proprietarioComboBox.getSelectedItem();

            if (cliente != null && tipoVeiculoComboBox.getSelectedItem() != null) {

                dados[0] = placaTxt.getText().trim().toUpperCase();
                dados[1] = tipoVeiculoComboBox.getSelectedItem().toString();
                dados[2] = String.valueOf(cliente.getId());
                
               
                if (dados[0].isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "Informe a placa do veículo!");

                    return;
                }

                try {

                    controller.VeiculoService.cadastrar(dados);
                    carregarVeiculos();

                    JOptionPane.showMessageDialog(this,
                            "Veículo cadastrado com sucesso!");

                    placaTxt.setText("");

                } catch (ClassNotFoundException | SQLException ex) {

                    JOptionPane.showMessageDialog(this, ex.getMessage());

                }

            } else {

                JOptionPane.showMessageDialog(this,
                        "Selecione um proprietário e um tipo de veículo!");

            }

    }//GEN-LAST:event_cadastrarVeiculoBtnActionPerformed

    private void placaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placaTxtActionPerformed

    private void clienteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteComboBoxActionPerformed
        // TODO add your handling code here:
     
        try {

            carregarVeiculos();

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage());

        }

    }//GEN-LAST:event_clienteComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Teste().setVisible(true);
            } catch (SQLException | ClassNotFoundException ex) {
                System.getLogger(Teste.class.getName())
                        .log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendarBtn;
    private javax.swing.JButton alterarStatusBtn;
    private javax.swing.JButton cadastrarVeiculoBtn;
    private javax.swing.JComboBox<model.Cliente> clienteComboBox;
    private javax.swing.JTextField cpfClienteTxt;
    private javax.swing.JComboBox<String> dataTxt;
    private javax.swing.JTextField descricaoServicoTxt;
    private javax.swing.JTextField emailClienteTxt;
    private javax.swing.JButton excluirClienteButton;
    private javax.swing.JComboBox<String> horaTxt;
    private javax.swing.JButton inserirClienteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nomeClienteLbl;
    private javax.swing.JLabel nomeClienteLbl1;
    private javax.swing.JLabel nomeClienteLbl2;
    private javax.swing.JLabel nomeClienteLbl3;
    private javax.swing.JTextField nomeClienteTxt;
    private javax.swing.JTextField nomeServicoTxt;
    private javax.swing.JTextField placaTxt;
    private javax.swing.JTextField precoServicoTxt;
    private javax.swing.JComboBox<model.Cliente> proprietarioComboBox;
    private javax.swing.JButton servicoBtn;
    private javax.swing.JComboBox<model.TipoServico> servicoComboBox;
    private javax.swing.JComboBox<String> statusOpc;
    private javax.swing.JTable tabelaAgendamentos;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField telefoneClienteTxt;
    private javax.swing.JComboBox<String> tipoVeiculoComboBox;
    private javax.swing.JComboBox<model.Veiculo> veiculoComboBox;
    // End of variables declaration//GEN-END:variables

}

