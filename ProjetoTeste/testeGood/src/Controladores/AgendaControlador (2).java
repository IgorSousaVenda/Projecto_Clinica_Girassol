package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgendaControlador {

    @FXML
    private Button BntEdit;

    @FXML
    private TableColumn<?, ?> TabelaConsultHora;

    @FXML
    private Button bntPesquisar;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRemov;

    @FXML
    private Button btnVoltarMenu;

    @FXML
    private ComboBox<?> cbbxEspecialidadeConsulta;

    @FXML
    private ComboBox<?> cmbxData;

    @FXML
    private ComboBox<?> cmbxHora;

    @FXML
    private ComboBox<?> cmbxPaciente;

    @FXML
    private ComboBox<?> cmbxProfissional;

    @FXML
    private TextField pesquisaConsulta;

    @FXML
    private TableColumn<?, ?> tabelaConsltData;

    @FXML
    private TableColumn<?, ?> tabelaConsltDoctor;

    @FXML
    private TableColumn<?, ?> tabelaConsltEspecialidade;

    @FXML
    private TableColumn<?, ?> tabelaConsltID;

    @FXML
    private TableColumn<?, ?> tabelaConsltNome;

    @FXML
    private TableColumn<?, ?> tabelaConsltSintoma;

    @FXML
    private TableView<?> tabelaConsulta;

    @FXML
    void Adicionar(ActionEvent event) {

    }

    @FXML
    void CancelarConsulta(ActionEvent event) {

    }

    @FXML
    void Close(ActionEvent event) {
         Stage stage = (Stage)  btnClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Data(ActionEvent event) {

    }

    @FXML
    void Editar(ActionEvent event) {

    }

    
    @FXML
    void Especialidade(ActionEvent event) {

    }

    @FXML
    void Hora(ActionEvent event) {

    }

    @FXML
    void Pesquisar(ActionEvent event) {

    }

    @FXML
    void Remover(ActionEvent event) {

    }

    @FXML
    void SalvarConsulta(ActionEvent event) {

    }

    @FXML
    void VoltarMenu(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage)  btnVoltarMenu.getScene().getWindow();
        stage.close();


    }



}
