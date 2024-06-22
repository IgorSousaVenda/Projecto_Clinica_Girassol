/*package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MenuControlador {

    @FXML
    private Button bntClose;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private Button btnAgenda;

    @FXML
    private Button btnPaciente;

    @FXML
    private Button btnProfissionais;

    @FXML
    private Button btnSair;

    @FXML
    private ImageView entretelas;

    @FXML
    void Close(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void Agenda(ActionEvent event) {
         CarregarTela entretela = new CarregarTela();
        Pane entretelas = entretela.mostarTela("Agenda");
        BorderPane.setCenter(entretelas);

    }


    @FXML
    void BorderPane(MouseEvent event) {

    }

    @FXML
    void Centro(MouseEvent event) {

    }

    @FXML
    void Paciente(ActionEvent event) {

    }

    @FXML
    void Profissionais(ActionEvent event) {

    }

    @FXML
    void Sair(ActionEvent event) {

    }

}*/

package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class MenuControlador {

    @FXML
    private BorderPane BorderPane;

    @FXML
    private Button bntClose;

    @FXML
    private Button btnAgenda;

    @FXML
    private Button btnPaciente;

    @FXML
    private Button btnProfissionais;

    @FXML
    private Button btnSair;

    @FXML
    private AnchorPane entretelas;

    @FXML
    void Agenda(ActionEvent event) {
        CarregarTela nova = new CarregarTela();
          nova.abrirTela("cadastar");

       

    }

    @FXML
    void BorderPane(MouseEvent event) {

    }

    @FXML
    void Centro(MouseEvent event) {

    }

    @FXML
    void Close(ActionEvent event) {
        System.exit(1);

    }

    @FXML
    void Paciente(ActionEvent event) {

    }

    @FXML
    void Profissionais(ActionEvent event) {

    }

    @FXML
    void Sair(ActionEvent event) {

    }

}
