package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HistoricoControlador {

    @FXML
    private Button BntEdit;

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
    void Adicionar(ActionEvent event) {

    }

    @FXML
    void Close(ActionEvent event) {

        Stage stage = (Stage)  btnClose.getScene().getWindow();
        stage.close();


    }

    @FXML
    void Editar(ActionEvent event) {

    }

    @FXML
    void Pesquisar(ActionEvent event) {

    }

    @FXML
    void Remover(ActionEvent event) {

    }

    @FXML
    void VoltarMenu(ActionEvent event) {
           CarregarTela nova = new CarregarTela();
        nova.abrirTela("Doctor");

        Stage stage = (Stage)  btnVoltarMenu.getScene().getWindow();
        stage.close();


    }

}
