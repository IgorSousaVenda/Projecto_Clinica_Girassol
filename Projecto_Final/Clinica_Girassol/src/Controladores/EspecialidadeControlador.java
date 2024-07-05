package Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

import BD.EspecialidadeBD;
import Enidades.Especialidade;

public class EspecialidadeControlador {

    @FXML
    private Button BntEdit;

    @FXML
    private Button bntPesquisar;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRemov;

    @FXML
    private Button btnVoltarMenu1;

    @FXML
    private TableColumn<Especialidade, String> tabelaDescricao;

    @FXML
    private TableView<Especialidade> tabelaEspecialidade;

    @FXML
    private TableColumn<Especialidade, String> tabelaNome;

    @FXML
    private TableColumn<Especialidade, Float> tabelaValor;

    @FXML
    private TextArea txtDescrição;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtValor;

    @FXML
    public void initialize() {
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tabelaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        listarEspecialidades();

        // Adiciona um listener para atualizar os campos de texto quando uma especialidade é selecionada na tabela
        tabelaEspecialidade.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                preencherCampos(newSelection);
            }
        });
    }

    @FXML
    void Adicionar(ActionEvent event) {
        String nome = txtNome.getText();
        String descricao = txtDescrição.getText();
        String valorStr = txtValor.getText();

        if (nome.isEmpty() || descricao.isEmpty() || valorStr.isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        try {
            float valor = Float.parseFloat(valorStr);
            Especialidade especialidade = new Especialidade();
            especialidade.setNome(nome);
            especialidade.setDescricao(descricao);
            especialidade.setValor(valor);

            EspecialidadeBD especialidadeBD = new EspecialidadeBD();
            especialidadeBD.cadastrarEspecialidade(especialidade);
            listarEspecialidades(); // Atualiza a tabela após adicionar
            limparCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Valor deve ser um número válido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Especialidade especialidade = tabelaEspecialidade.getSelectionModel().getSelectedItem();
        if (especialidade != null) {
            String nome = txtNome.getText();
            String descricao = txtDescrição.getText();
            String valorStr = txtValor.getText();

            if (nome.isEmpty() || descricao.isEmpty() || valorStr.isEmpty()) {
                mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
                return;
            }

            try {
                float valor = Float.parseFloat(valorStr);
                especialidade.setNome(nome);
                especialidade.setDescricao(descricao);
                especialidade.setValor(valor);

                EspecialidadeBD especialidadeBD = new EspecialidadeBD();
                especialidadeBD.atualizarEspecialidade(especialidade);
                listarEspecialidades(); // Atualiza a tabela após atualizar
                limparCampos();
            } catch (NumberFormatException e) {
                mostrarAlerta("Erro", "Valor deve ser um número válido.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mostrarAlerta("Erro", "Nenhuma especialidade selecionada.");
        }
    }

    private void listarEspecialidades() {
        ObservableList<Especialidade> observableEspecialidades = FXCollections.observableArrayList();
        try {
            EspecialidadeBD especialidadeBD = new EspecialidadeBD();
            List<Especialidade> especialidades = especialidadeBD.listarEspecialidades();
            observableEspecialidades.addAll(especialidades);
            tabelaEspecialidade.setItems(observableEspecialidades);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        txtNome.clear();
        txtDescrição.clear();
        txtValor.clear();
    }

    private void preencherCampos(Especialidade especialidade) {
        txtNome.setText(especialidade.getNome());
        txtDescrição.setText(especialidade.getDescricao());
        txtValor.setText(String.valueOf(especialidade.getValor()));
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    void CancelarConsulta(ActionEvent event) {}

    @FXML
    void Close(ActionEvent event) {}

    @FXML
    void Editar(ActionEvent event) {
        // Este método não é necessário, pois a funcionalidade foi incluída no método Atualizar
    }

    @FXML
    void Remover(ActionEvent event) {
        Especialidade especialidade = tabelaEspecialidade.getSelectionModel().getSelectedItem();
        if (especialidade != null) {
            try {
                EspecialidadeBD especialidadeBD = new EspecialidadeBD();
                especialidadeBD.excluirEspecialidade(especialidade);
                listarEspecialidades(); // Atualiza a tabela após remover
                limparCampos();
                mostrarAlertaInformativo("Sucesso", "Especialidade removida com sucesso.");
            } catch (Exception e) {
                mostrarAlerta("Erro", "Erro ao remover a especialidade.");
                e.printStackTrace();
            }
        } else {
            mostrarAlerta("Erro", "Nenhuma especialidade selecionada.");
        }
    }
    
    private void mostrarAlertaInformativo(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    

    
 @FXML
    void VoltarMenu(ActionEvent event) {
      CarregarTela nova = new CarregarTela();
        nova.abrirTela("Menu");

        Stage stage = (Stage)  btnVoltarMenu1.getScene().getWindow();
        stage.close();

    }


    @FXML
    void cadastrar(ActionEvent event) {
        Adicionar(event); // Reutilizando o método Adicionar para cadastrar
    }
}
