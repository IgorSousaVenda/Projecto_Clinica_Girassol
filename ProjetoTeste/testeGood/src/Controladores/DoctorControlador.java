package Controladores;

import BD.ConsultaView;
import BD.EspecialidadeBD;
import BD.FuncionarioBD; 
import BD.PacienteBD;
import Enidades.Especialidade;
import Enidades.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class DoctorControlador {

    @FXML
    private Button bntPesquisar;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnHistoricoConsultas;

    @FXML
    private Button btnRemov;

    @FXML
    private Button btnVoltarMenu;

    @FXML
    private ComboBox<String> cbbxEspecialidade;

    @FXML
    private ComboBox<String> checkPaciente;

    @FXML
    private ComboBox<String> checkMedico;

    @FXML
    private TableColumn<ConsultaView, Integer> id;

    @FXML
    private TableColumn<ConsultaView, String> nomePaciente;

    @FXML
    private TableColumn<ConsultaView, String> especialidade;

    @FXML
    private TableColumn<ConsultaView, LocalDate> dataConsulta;

    @FXML
    private TableColumn<ConsultaView, String> estado;

    @FXML
    private TableView<ConsultaView> tabelaConsulta;

    private final ConsultaView consultaView = new ConsultaView();

    private final FuncionarioBD funcionarioBD = new FuncionarioBD(); 

    private final PacienteBD pacienteBD = new PacienteBD();
    private final EspecialidadeBD especialidadeBD = new EspecialidadeBD();

    @FXML
    void initialize() {
        // Inicializar colunas da tabela
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomePaciente.setCellValueFactory(new PropertyValueFactory<>("nomePaciente"));
        especialidade.setCellValueFactory(new PropertyValueFactory<>("nomeEspecialidade"));
        dataConsulta.setCellValueFactory(new PropertyValueFactory<>("dataConsulta"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Carregar as consultas ao iniciar
        try {
            listarConsultas();
        } catch (Exception e) {
            e.printStackTrace();
            // Tratar exceção adequadamente
        }

        // Carregar combobox de especialidades
        carregarEspecialidades();

        // Carregar combobox de médicos
        carregarMedicos();

        // Carregar combobox de pacientes
        carregarPacientes();
    }

    @FXML
    void Adicionar(ActionEvent event) {
        // Implementar ação de adicionar consulta
        // Exemplo de uso:
        // ConsultaView consultaSelecionada = tabelaConsulta.getSelectionModel().getSelectedItem();
        // if (consultaSelecionada != null) {
        //     // Lógica para adicionar consulta
        // }
    }

    @FXML
    void Cancelar(ActionEvent event) {
        // Implementar ação de cancelar consulta
    }

    @FXML
    void close(ActionEvent event) {
       
    }

    @FXML
    void Editar(ActionEvent event) {
        // Implementar ação de editar consulta
    }

    @FXML
    void especialidadeSelecionada(ActionEvent event) {
        // Implementar ação relacionada à escolha de especialidade
    }

    @FXML
    void irParaHistorico(ActionEvent event) {
        // Implementar ação de ir para o histórico de consultas
    }

    @FXML
    void Pesquisar(ActionEvent event) {
        // Implementar ação de pesquisar consulta
    }

    @FXML
    void Remover(ActionEvent event) {
        // Implementar ação de remover consulta
    }

    @FXML
    void VoltarMenu(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage)  btnVoltarMenu.getScene().getWindow();
        stage.close();

    }

    private void listarConsultas() throws Exception {
        List<ConsultaView> consultas = consultaView.listarConsultas();
        tabelaConsulta.getItems().addAll(consultas);
    }

    private void carregarEspecialidades() {
        try {
            List<Especialidade> especialidades = especialidadeBD.listarEspecialidades();
            ObservableList<String> nomesEspecialidades = FXCollections.observableArrayList();
            for (Especialidade especialidade : especialidades) {
                nomesEspecialidades.add(especialidade.getNome());
            }
            cbbxEspecialidade.setItems(nomesEspecialidades);
        } catch (Exception e) {
            e.printStackTrace();
            // Tratar exceção adequadamente
        }
    }

    private void carregarMedicos() {
        try {
            List<String> nomesMedicos = funcionarioBD.listarMedicos();
            ObservableList<String> nomesMedicosObservable = FXCollections.observableArrayList(nomesMedicos);
            checkMedico.setItems(nomesMedicosObservable);
        } catch (Exception e) {
            e.printStackTrace();
            // Tratar exceção adequadamente
        }
    }

    private void carregarPacientes() {
        try {
            List<Paciente> pacientes = pacienteBD.listarPacientes();
            ObservableList<String> nomesPacientes = FXCollections.observableArrayList();
            for (Paciente paciente : pacientes) {
                nomesPacientes.add(paciente.getNome());
            }
            checkPaciente.setItems(nomesPacientes);
        } catch (Exception e) {
            e.printStackTrace();
            // Tratar exceção adequadamente
        }
    }
}
