import javafx.application.Application;
import javafx.stage.Stage;
import Controladores.*;

public class App extends Application{
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Login");
    }
 
}
