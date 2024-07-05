package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Dashboard;


public class DashboardControlador implements Initializable {

    @FXML
    private Button bntClose;

    @FXML
    private Button btnVoltarMenu11;

    @FXML
    private Label txtPacientes;

    @FXML
    private Label txtProfissionais;

    @FXML
    private Label txtAgendamentos;

    private Dashboard dashboardService = new Dashboard(); // Serviço para dados da dashboard

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherDashboardComDados(); // Chama o método ao inicializar o controlador
    }

    // Método para preencher os campos da Dashboard com dados reais do banco de dados
    public void preencherDashboardComDados() {
        try {
            int numPacientes = dashboardService.obterNumeroPacientes();
            int numProfissionais = dashboardService.obterNumeroProfissionais();
            int numAgendamentos = dashboardService.obterNumeroAgendamentos();

            txtPacientes.setText(String.valueOf(numPacientes));
            txtProfissionais.setText(String.valueOf(numProfissionais));
            txtAgendamentos.setText(String.valueOf(numAgendamentos));
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
    }

    @FXML
    void CloseWindows(ActionEvent event) {
        // Implementação do método de fechar a janela, se necessário
    }

    @FXML
    void VoltarMenu(ActionEvent event) {
        // Implementação para voltar ao menu
        CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage) btnVoltarMenu11.getScene().getWindow();
        stage.close();
    }
}

