import BD.PacienteBD;
import Enidades.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class cadastrarController {

    @FXML
    private TextField bi;

    @FXML
    private Button btnEnviar;

    @FXML
    private TextField end;

    @FXML
    private TextField nome;

    @FXML
    private TextField tel;

    @FXML
    void enviar(ActionEvent event) throws Exception {
         Paciente P = new Paciente(nome.getText(),bi.getText(), end.getText(), tel.getText());
        PacienteBD novo = new PacienteBD();
        novo.CadastrarPaciente(P); 
        System.out.println("Cadastro feito");
    }

}
