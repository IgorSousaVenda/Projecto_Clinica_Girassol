package Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import BD.FuncionarioBD;
import BD.EspecialidadeBD;
import Enidades.Especialidade;
import Enidades.Funcionario;

import java.util.List;

public class ProfissionalControlador {

    @FXML
    private RadioButton OpcaoF;

    @FXML
    private RadioButton OpcaoM;

    @FXML
    private TextField TxtNome;

    @FXML
    private Button bntPesquisar;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRemov;

    @FXML
    private Button btnVoltarMenu11;

    @FXML
    private ComboBox<String> cmbxEspecialidade; // Alteração aqui para utilizar String

    @FXML
    private TableColumn<Funcionario, Integer> tabelaID; // Alteração para especificar o tipo de dados

    @FXML
    private TableColumn<Funcionario, String> tabelaBi;

    @FXML
    private TableColumn<Funcionario, String> tabelaCargo;

    @FXML
    private TableColumn<Funcionario, Double> tabelaSalario;

    @FXML
    private TableColumn<Funcionario, String> tabelaEspecialidade;

    @FXML
    private TableColumn<Funcionario, String> tabelaNome;

    @FXML
    private TableView<Funcionario> tabelaProfissionais; // Alteração para especificar o tipo de dados

    @FXML
    private TableColumn<Funcionario, Integer> tabelaTelefone;

    @FXML
    private TableColumn<Funcionario, String> tabelaEndereco;

    @FXML
    private CheckBox checkFuncionario;

    @FXML
    private TextField txtBi;

  

    @FXML
    private Button btnAtualizar;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtCargo;

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField txtNascimento;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtSalario;

    private EspecialidadeBD especialidadeBD = new EspecialidadeBD();
    private ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
    private FuncionarioBD funcionarioBD = new FuncionarioBD();

    @FXML
    void initialize() {
        inicializarTabela();
        carregarEspecialidades();

        // Listener para monitorar mudanças no CheckBox checkFuncionario
        checkFuncionario.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // Se selecionado "Funcionário comum", desabilita a ComboBox cmbxEspecialidade
                cmbxEspecialidade.setDisable(true);
            
            } else {
                // Se desmarcado "Funcionário comum", habilita a ComboBox cmbxEspecialidade
                cmbxEspecialidade.setDisable(false);
                txtCargo.setText("Medico");
            }
        });
    }

    private void carregarEspecialidades() {
        try {
            List<Especialidade> especialidades = especialidadeBD.listarEspecialidades();
            ObservableList<String> nomesEspecialidades = FXCollections.observableArrayList();
            for (Especialidade especialidade : especialidades) {
                nomesEspecialidades.add(especialidade.getNome());
            }
            cmbxEspecialidade.setItems(nomesEspecialidades);
        } catch (Exception e) {
            System.out.println("Erro ao carregar especialidades: " + e.getMessage());
        }
    }

    private void inicializarTabela() {
        tabelaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaBi.setCellValueFactory(new PropertyValueFactory<>("bi"));
        tabelaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        tabelaEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        // tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        // Carregar dados da tabela
        try {
            listaFuncionarios.addAll(funcionarioBD.ListarFuncionario());
            tabelaProfissionais.setItems(listaFuncionarios);
        } catch (Exception e) {
            System.out.println("Erro ao carregar funcionários: " + e.getMessage());
        }
    }

    @FXML
    void Confirmar(ActionEvent event) {
        // Criação de um novo funcionário com os dados do formulário
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(TxtNome.getText());
        novoFuncionario.setBi(txtBi.getText());
        if (checkFuncionario.isSelected()) {
            // Funcionário comum
            novoFuncionario.setCargo(txtCargo.getText()); // Define o cargo diretamente do campo de texto
            novoFuncionario.setEspecialidade(null); // Especialidade é nula para funcionário comum
        } else {
            // Médico
            novoFuncionario.setCargo("Médico"); // Cargo padrão para médicos
            novoFuncionario.setEspecialidade(cmbxEspecialidade.getValue()); // Especialidade selecionada na ComboBox
        }
        novoFuncionario.setSalario(Double.parseDouble(txtSalario.getText())); // Converte para double
        novoFuncionario.setTelefone(Integer.parseInt(txtTelefone.getText())); // Converte para int
        novoFuncionario.setEndereco(txtEndereco.getText());

        try {
            // Chama o método para cadastrar no banco de dados
            int idGerado = funcionarioBD.cadastrarFuncionario(novoFuncionario);
            if (idGerado != -1) {
                novoFuncionario.setId(idGerado);
                listaFuncionarios.add(novoFuncionario);
                limparCampos();
                System.out.println("Funcionário cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar funcionário");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    @FXML
    void Adicionar(ActionEvent event) {
        Funcionario funcionarioSelecionado = tabelaProfissionais.getSelectionModel().getSelectedItem();
        if (funcionarioSelecionado != null) {
            // Preencher campos do formulário com os dados do funcionário selecionado
            TxtNome.setText(funcionarioSelecionado.getNome());
            txtBi.setText(funcionarioSelecionado.getBi());
            txtCargo.setText(funcionarioSelecionado.getCargo());
            if (funcionarioSelecionado.getCargo().equals("Médico")) {
                cmbxEspecialidade.setValue(funcionarioSelecionado.getEspecialidade());
                checkFuncionario.setSelected(false);
                cmbxEspecialidade.setDisable(false);
            } else {
                checkFuncionario.setSelected(true);
                cmbxEspecialidade.setDisable(true);
            }
            txtSalario.setText(String.valueOf(funcionarioSelecionado.getSalario()));
            txtTelefone.setText(String.valueOf(funcionarioSelecionado.getTelefone()));
            txtEndereco.setText(funcionarioSelecionado.getEndereco());
           
          
        } else {
            System.out.println("Selecione um funcionário para adicionar.");
        }
    }
    
    @FXML
    void Atualizar (ActionEvent event) {
        Funcionario funcionarioSelecionado = tabelaProfissionais.getSelectionModel().getSelectedItem();
        if (funcionarioSelecionado != null) {
            // Atualizar campos na interface com os dados do formulário
            funcionarioSelecionado.setNome(TxtNome.getText());
            funcionarioSelecionado.setBi(txtBi.getText());
            funcionarioSelecionado.setCargo(txtCargo.getText());
            if (!checkFuncionario.isSelected()) {
                funcionarioSelecionado.setCargo("Médico");
                funcionarioSelecionado.setEspecialidade(cmbxEspecialidade.getValue());
            } else {
                funcionarioSelecionado.setEspecialidade(null);
            }
            funcionarioSelecionado.setSalario(Double.parseDouble(txtSalario.getText()));
            funcionarioSelecionado.setTelefone(Integer.parseInt(txtTelefone.getText()));
            funcionarioSelecionado.setEndereco(txtEndereco.getText());
    
            try {
                // Atualizar no banco de dados
                funcionarioBD.AtualizarFuncionario(funcionarioSelecionado);
                // Atualizar na tabela
                tabelaProfissionais.refresh();
                limparCampos();
                System.out.println("Funcionário atualizado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
            }
        } else {
            System.out.println("Selecione um funcionário para atualizar.");
        }
    }
    

    private void limparCampos() {
        TxtNome.clear();
        txtBi.clear();
        txtCargo.clear();
        cmbxEspecialidade.getSelectionModel().clearSelection();
        txtTelefone.clear();
        txtEndereco.clear();
    }

    @FXML
    void Remover(ActionEvent event) {
        Funcionario funcionarioSelecionado = tabelaProfissionais.getSelectionModel().getSelectedItem();
        if (funcionarioSelecionado != null) {
            try {
                // Chamada ao método para remover do banco de dados
                funcionarioBD.ExcluirFuncionario(funcionarioSelecionado.getId());
                listaFuncionarios.remove(funcionarioSelecionado);
                System.out.println("Funcionário removido com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao remover funcionário: " + e.getMessage());
            }
        } else {
            System.out.println("Selecione um funcionário para remover.");
        }
    }

    @FXML
    void Pesquisar(ActionEvent event) {
        /* 
        String textoPesquisa = txtPesquisa.getText();
        // Implementar lógica de pesquisa na tabela de funcionários
        // Pode ser filtragem na ObservableList ou novo método no FuncionarioBD*/
    }

    @FXML
    void Cancelar(ActionEvent event) {
        limparCampos();
    }

    @FXML
    void Close(ActionEvent event) {
        Stage stage = (Stage)  btnClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void VoltarMenu(ActionEvent event) {
      CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage)  btnVoltarMenu11.getScene().getWindow();
        stage.close();

    }

}
