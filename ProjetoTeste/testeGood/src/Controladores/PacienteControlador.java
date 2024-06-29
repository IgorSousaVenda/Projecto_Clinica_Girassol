package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import BD.PacienteBD;
import Enidades.Paciente;

public class PacienteControlador {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnCancelarConsulta;

    @FXML
    private Button btnRemov;

    @FXML
    private Button BntEdit;

    @FXML
    private Button bntPesquisar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnVoltarMenu1;

    @FXML
    private DatePicker data;

    @FXML
    private TableView<Paciente> tabelaPaciente;

    @FXML
    private TableColumn<Paciente, Integer> tabelaId;

    @FXML
    private TableColumn<Paciente, String> tabelaNome;

    @FXML
    private TableColumn<Paciente, String> tabelaBi;

    @FXML
    private TableColumn<Paciente, String> tabelaEndereco;

    @FXML
    private TableColumn<Paciente, String> tabelaTelefone;

    @FXML
    private TableColumn<Paciente, LocalDate> tabelaDataNascimento;

    @FXML
    private TableColumn<Paciente, String> tabelaSexo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtBi;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtTelefone;

    @FXML
    private ComboBox<String> CombSexo;

    private final PacienteBD pacienteBD = new PacienteBD();

    @FXML
    void initialize() {
        // Inicializa as colunas da tabela
        tabelaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaBi.setCellValueFactory(new PropertyValueFactory<>("bi"));
        tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tabelaDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        tabelaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        // Inicializa a ComboBox de sexo
        inicializarComboBoxSexo();

        // Carrega os pacientes ao iniciar
        carregarPacientes();
    }

    private void inicializarComboBoxSexo() {
        List<String> opcoesSexo = Arrays.asList("Masculino", "Feminino", "Outro");
        CombSexo.getItems().addAll(opcoesSexo);
    }

    private void carregarPacientes() {
        try {
            List<Paciente> pacientes = pacienteBD.listarPacientes();
            tabelaPaciente.getItems().addAll(pacientes);
        } catch (Exception e) {
            e.printStackTrace(); // Tratar exceção adequadamente
        }
    }

    @FXML
    void Adicionar(ActionEvent event) {
        limparCampos();
     
    }

    @FXML
void Atualizar(ActionEvent event) {
    Paciente pacienteSelecionado = tabelaPaciente.getSelectionModel().getSelectedItem();
    if (pacienteSelecionado != null) {
        // Atualizar dados do paciente selecionado
        pacienteSelecionado.setNome(txtNome.getText());
        pacienteSelecionado.setBi(txtBi.getText());
        pacienteSelecionado.setEndereco(txtEndereco.getText());
        pacienteSelecionado.setTelefone(txtTelefone.getText());
        pacienteSelecionado.setSexo(CombSexo.getValue());
        pacienteSelecionado.setDataNascimento(data.getValue());

        try {
            // Atualizar na base de dados
            pacienteBD.atualizarPaciente(pacienteSelecionado);

            // Limpar a tabela antes de recarregar os dados
            tabelaPaciente.getItems().clear();

            // Recarregar tabela de pacientes
            carregarPacientes();

            // Limpar campos e desabilitar edição
            limparCampos();
        } catch (Exception e) {
            e.printStackTrace(); // Tratar exceção adequadamente
        }
    }
}

    @FXML
    void CancelarConsulta(ActionEvent event) {
        limparCampos();
    
    }

    @FXML
    void Close(ActionEvent event) {
        Stage stage = (Stage)  btnVoltarMenu1.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Editar(ActionEvent event) {
        Paciente pacienteSelecionado = tabelaPaciente.getSelectionModel().getSelectedItem();
        if (pacienteSelecionado != null) {
            // Preencher campos de cadastro com dados do paciente selecionado
            txtNome.setText(pacienteSelecionado.getNome());
            txtBi.setText(pacienteSelecionado.getBi());
            txtEndereco.setText(pacienteSelecionado.getEndereco());
            txtTelefone.setText(pacienteSelecionado.getTelefone());
            CombSexo.setValue(pacienteSelecionado.getSexo());
            data.setValue(pacienteSelecionado.getDataNascimento());
    
            // Desabilitar botão de confirmar
            btnCadastrar.setDisable(true);
        }
    }

    @FXML
    void Pesquisar(ActionEvent event) {
        /* 
        String nome = txtNome.getText();
        try {
            List<Paciente> pacientes = pacienteBD.pesquisarPacientesPorNome(nome);
            tabelaPaciente.getItems().clear();
            tabelaPaciente.getItems().addAll(pacientes);
        } catch (Exception e) {
            e.printStackTrace(); // Tratar exceção adequadamente
        }
        */
    }

    @FXML
    void Remover(ActionEvent event) {
        Paciente pacienteSelecionado = tabelaPaciente.getSelectionModel().getSelectedItem();
        if (pacienteSelecionado != null) {
            try {
                pacienteBD.excluirPaciente(pacienteSelecionado.getId());
                carregarPacientes(); 
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }
    }

    @FXML
    void VoltarMenu(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage)  btnVoltarMenu1.getScene().getWindow();
        stage.close();

    }

    @FXML
    void cadastrar(ActionEvent event) {
        Paciente novoPaciente = new Paciente();
        novoPaciente.setNome(txtNome.getText());
        novoPaciente.setBi(txtBi.getText());
        novoPaciente.setEndereco(txtEndereco.getText());
        novoPaciente.setTelefone(txtTelefone.getText());
        novoPaciente.setSexo(CombSexo.getValue());
        novoPaciente.setDataNascimento(data.getValue());
    
        try {
            pacienteBD.cadastrarPaciente(novoPaciente);
            // Limpa os itens da tabela antes de recarregar
            tabelaPaciente.getItems().clear();
            carregarPacientes(); // Recarrega a tabela após cadastrar
            limparCampos();
         
        } catch (Exception e) {
            e.printStackTrace(); // Tratar exceção adequadamente
        }
    }

    private void limparCampos() {
        txtNome.clear();
        txtBi.clear();
        txtEndereco.clear();
        txtTelefone.clear();
        CombSexo.getSelectionModel().clearSelection();
        data.setValue(null);
    }


}
