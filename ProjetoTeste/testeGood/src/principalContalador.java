


import Controladores.CarregarTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class principalContalador {

    @FXML
    private Button bntAgenda;

    @FXML
    private Button bntClose;

    @FXML
    private ImageView bntPacientes;

    @FXML
    private Button bntProfissionais;

    @FXML
    private Button btnSair;

    @FXML
    void Agenda(ActionEvent event)   {
         System.out.println("entrar");
         CarregarTela nova = new CarregarTela();
         nova.abrirTela("Agenda");

    }     

    @FXML
    void Close(ActionEvent event) {

    }

    @FXML
    void Paciente(MouseEvent event) {

    }

    @FXML
    void Profissionais(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) {

    }

}
