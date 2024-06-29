package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuControlador { 

    

    @FXML
    private MenuItem bntDashboard;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button BntHome;

    @FXML
    private BorderPane MenuPane;

    @FXML
    private Button bntCLose;

    @FXML
    private Button bntClose;

    @FXML
    private Button bntHome;

    @FXML
    void Agenda(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Agenda");

    }

    @FXML
    void Close(ActionEvent event) {
        Stage stage = (Stage)  bntClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Home(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Login");

        Stage stage = (Stage)  bntHome.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Pacientes(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Paciente");   

    }

    @FXML
    void Profissionais(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Profissional");

    }

    @FXML
    void DashBoard(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("DashBoard");


    }

    @FXML
    void Sair(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Login");

        
        Stage stage = (Stage)  bntClose.getScene().getWindow();
        stage.close();

        

    }

    @FXML
    void IrParaDoctor(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Doctor");

    }


    @FXML
    void VoltarLogin(ActionEvent event) {

    }


}
