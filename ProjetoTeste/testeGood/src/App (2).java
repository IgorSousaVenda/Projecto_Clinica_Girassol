import Controladores.CarregarTela;
import javafx.application.Application;

import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage inicioStage) throws Exception {
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Login");
    }
}
