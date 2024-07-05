package Controladores;

import BD.EspecialidadeBD;
import BD.FuncionarioBD;
import BD.HoraBD;
import BD.AgendarConsultaBD;
import BD.ConsultaBD;
import BD.PacienteBD;
import Enidades.AgendConsulta;
import Enidades.Consulta;
import Enidades.Especialidade;
import Enidades.Hora;
import Enidades.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AgendaControlador {

    @FXML
    private Button btnAgendar;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnVoltarMenu;
    @FXML
    private Button btnCancelarConsulta;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRemov;
    @FXML
    private Button btnEdit;

    @FXML
    private DatePicker Data;

    @FXML
    private ComboBox<String> cbbxEspecialidade;
    @FXML
    private ComboBox<String> cbbxHora;
    @FXML
    private ComboBox<String> cbbxPaciente;
    @FXML
    private ComboBox<String> cbbxProfissionanal;

    @FXML
    private TableView<AgendConsulta> tabelaAgenda;

    @FXML
    private TableColumn<AgendConsulta, String> tabelaNome;
    @FXML
    private TableColumn<AgendConsulta, String> tabelaMedico;
    @FXML
    private TableColumn<AgendConsulta, String> tabelaEspecialidade;
    @FXML
    private TableColumn<AgendConsulta, LocalDate> tabelaData;
    @FXML
    private TableColumn<AgendConsulta, String> tabelaHora;

    private void configurarTabela() {
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        tabelaMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
        tabelaEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        tabelaData.setCellValueFactory(new PropertyValueFactory<>("dataConsulta"));
        tabelaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
    }

    private void carregarConsultas() {
        try {
            AgendarConsultaBD agendarConsultaBD = new AgendarConsultaBD();
            List<AgendConsulta> consultas = agendarConsultaBD.listarConsultas();
            ObservableList<AgendConsulta> listaConsultas = FXCollections.observableArrayList(consultas);
            tabelaAgenda.setItems(listaConsultas);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao carregar consultas: " + e.getMessage());
            alert.show();
        }
    }

    
    
    @FXML
    void VoltarMenu(ActionEvent event) {
      CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage)  btnVoltarMenu.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Adicionar(ActionEvent event) {
        // Implemente a lógica para adicionar uma consulta
    }

    @FXML
    void verificarData(ActionEvent event) {
        LocalDate dataSelecionada = Data.getValue();
        String nomeProfissional = cbbxProfissionanal.getValue();

        if (dataSelecionada != null && nomeProfissional != null) {
            DayOfWeek diaSemana = dataSelecionada.getDayOfWeek();
            String diaSemanaPortugues = convertDayOfWeekToPortuguese(diaSemana);

            try {
                FuncionarioBD funcionarioBD = new FuncionarioBD();
                int id_funcionario = funcionarioBD.obterIdMedicoPorNome(nomeProfissional);

                HoraBD horaBD = new HoraBD();
                List<Hora> horasDisponiveis = horaBD.listarHorasNaoAgendadas(dataSelecionada, id_funcionario);

                ObservableList<String> horasDisponiveisStr = FXCollections.observableArrayList();
                for (Hora hora : horasDisponiveis) {
                    horasDisponiveisStr.add(hora.getHora().toString());
                }

                cbbxHora.setItems(horasDisponiveisStr);

                if (!horasDisponiveis.isEmpty()) {
                    System.out.println("Médico disponível nesse horário: " + diaSemanaPortugues);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Médico disponível nesse horário: " + diaSemanaPortugues);
                    alert.show();
                } else {
                    System.out.println("Médico indisponível nesse horário: " + diaSemanaPortugues);
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Médico indisponível nesse horário: " + diaSemanaPortugues);
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao verificar disponibilidade: " + e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Data ou profissional não selecionado.");
            alert.show();
            System.out.println("Data ou profissional não selecionado.");
        }
    }

    private String convertDayOfWeekToPortuguese(DayOfWeek diaSemana) {
        switch (diaSemana) {
            case MONDAY:
                return "Segunda-feira";
            case TUESDAY:
                return "Terça-feira";
            case WEDNESDAY:
                return "Quarta-feira";
            case THURSDAY:
                return "Quinta-feira";
            case FRIDAY:
                return "Sexta-feira";
            case SATURDAY:
                return "Sábado";
            case SUNDAY:
                return "Domingo";
            default:
                throw new IllegalArgumentException("Dia da semana inválido: " + diaSemana);
        }
    }

    @FXML
    void CancelarConsulta(ActionEvent event) {
        
    }

    @FXML
    void Editar(ActionEvent event) {
    
    }
    @FXML
    void Remover(ActionEvent event) {
        AgendConsulta consultaSelecionada = tabelaAgenda.getSelectionModel().getSelectedItem();
        if (consultaSelecionada != null) {
            try {
                ConsultaBD agendarConsultaBD = new ConsultaBD();
                //agendarConsultaBD.ExcluirConsulta(consultaSelecionada.getId();
                carregarConsultas(); // Atualiza a tabela após remover
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Consulta removida com sucesso.");
                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao remover consulta: " + e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nenhuma consulta selecionada.");
            alert.show();
        }
    }
    

    @FXML
    void Close(ActionEvent event) {
        // Implemente a lógica para fechar a janela
    }

    @FXML
void cadastrar(ActionEvent event) {
    try {
        LocalDate dataSelecionada = Data.getValue();
        String horaSelecionada = cbbxHora.getValue();
        String nomePaciente = cbbxPaciente.getValue();
        String nomeProfissional = cbbxProfissionanal.getValue();
        String nomeEspecialidade = cbbxEspecialidade.getValue();

        if (dataSelecionada == null || horaSelecionada == null || nomePaciente == null ||
            nomeProfissional == null || nomeEspecialidade == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Todos os campos devem ser preenchidos.");
            alert.show();
            return;
        }

        PacienteBD pacienteBD = new PacienteBD();
        Paciente paciente = pacienteBD.buscarPacientePorNome(nomePaciente);
        int idPaciente = paciente.getId();

        FuncionarioBD funcionarioBD = new FuncionarioBD();
        int id_funcionario = funcionarioBD.obterIdMedicoPorNome(nomeProfissional);

        EspecialidadeBD especialidadeBD = new EspecialidadeBD();
        int idEspecialidade = especialidadeBD.obterIdEspecialidadePorNome(nomeEspecialidade);

        // Convertendo a hora selecionada para um formato que possa ser armazenado no banco de dados
        LocalTime horaConvertida = LocalTime.parse(horaSelecionada);

        // Criando o objeto Consulta
        Consulta consulta = new Consulta();
        consulta.setPacienteId(idPaciente);
        consulta.setFuncionarioId(id_funcionario);
        consulta.setEspecialidadeId(idEspecialidade);
        consulta.setDataConsulta(dataSelecionada);
        consulta.setHoraConsulta(horaConvertida);

        ConsultaBD consultaBD = new ConsultaBD(); // Supondo que ConsultaBD seja sua classe de acesso a dados para consultas
        boolean cadastrado = consultaBD.CadastrarConsulta(consulta);

        if (cadastrado) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Consulta agendada com sucesso.");
            alert.show();
            configurarTabela();
            carregarConsultas();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao cadastrar consulta.");
            alert.show();
        }

    } catch (Exception e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao cadastrar consulta: " + e.getMessage());
        alert.show();
    }
}

    @FXML
    void initialize() {
        preencherComboBoxes();
        configurarTabela();
        carregarConsultas();
        
        // Adiciona um listener para o ComboBox de especialidades
        cbbxEspecialidade.setOnAction(this::atualizarProfissionaisPorEspecialidade);
    }

    private void atualizarProfissionaisPorEspecialidade(ActionEvent event) {
        try {
            String nomeEspecialidade = cbbxEspecialidade.getValue();
            
            if (nomeEspecialidade != null) {
                FuncionarioBD funcionarioBD = new FuncionarioBD();
                List<String> medicosPorEspecialidade = funcionarioBD.listarMedicosPorEspecialidade(nomeEspecialidade);

                ObservableList<String> nomesMedicos = FXCollections.observableArrayList(medicosPorEspecialidade);
                cbbxProfissionanal.setItems(nomesMedicos);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao atualizar profissionais por especialidade: " + e.getMessage());
            alert.show();
        }
    }

    private void preencherComboBoxes() {
        preencherComboBoxPacientes();
        preencherComboBoxEspecialidades();
        preencherComboBoxProfissionais();
    }

    private void preencherComboBoxPacientes() {
        try {
            PacienteBD pacienteBD = new PacienteBD();
            List<Paciente> pacientes = pacienteBD.listarPacientes();

            ObservableList<String> nomesPacientes = FXCollections.observableArrayList();
            for (Paciente paciente : pacientes) {
                nomesPacientes.add(paciente.getNome());
            }

            cbbxPaciente.setItems(nomesPacientes);

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao preencher ComboBox de pacientes: " + e.getMessage());
            alert.show();
        }
    }

    private void preencherComboBoxEspecialidades() {
        try {
            EspecialidadeBD especialidadeBD = new EspecialidadeBD();
            List<Especialidade> especialidades = especialidadeBD.listarEspecialidades();

            ObservableList<String> nomesEspecialidades = FXCollections.observableArrayList();
            for (Especialidade especialidade : especialidades) {
                nomesEspecialidades.add(especialidade.getNome());
            }

            cbbxEspecialidade.setItems(nomesEspecialidades);

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao preencher ComboBox de especialidades: " + e.getMessage());
            alert.show();
        }
    }

    private void preencherComboBoxProfissionais() {
        try {
            FuncionarioBD funcionarioBD = new FuncionarioBD();
            List<String> medicos = funcionarioBD.listarMedicos();

            ObservableList<String> nomesMedicos = FXCollections.observableArrayList(medicos);

            cbbxProfissionanal.setItems(nomesMedicos);

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao preencher ComboBox de profissionais: " + e.getMessage());
            alert.show();
        }
    }
}
