import Controladores.CarregarTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TesteTelaControlador {
    @FXML
    private Pane entretelas;
    @FXML
    private BorderPane BorderPane;

    @FXML
    private AnchorPane bdrCenter;

    @FXML
    private Button bntEntrar;

    @FXML
    void Centro(MouseEvent event) {

    }

    @FXML
    void Entrar(ActionEvent event) {
        CarregarTela entretela = new CarregarTela();
        Pane entretelas = entretela.mostarTela("Login");
        BorderPane.setCenter(entretelas);


    }

    @FXML
    void Pane(MouseEvent event) {

    }

}
