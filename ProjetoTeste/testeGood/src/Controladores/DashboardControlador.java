package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardControlador {

    @FXML
    private Button bntClose;

    @FXML
    private Button btnVoltarMenu11;

    @FXML
    void CloseWindows(ActionEvent event) {
        Stage stage = (Stage)  bntClose.getScene().getWindow();
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