package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BD.Conection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class LoginControlador {

    @FXML
    private PasswordField Password;

    @FXML
    private ImageView btnClose;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtName;

    @FXML
    void Entrar(ActionEvent event) throws Exception {
    String nome= txtName.getText();
    String senha= Password.getText();
    if(txtName.getText().isEmpty()|| Password.getText().isEmpty()){

        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setTitle(" erro");
        erro.setContentText("Prencha os campos novamente ");
        erro.show();
       
     }
     Connection conexao = Conection.getConectar();

     String sql= " SELECT nome, senha FROM  User where nome=? and senha=?" ;
   
      try {
        PreparedStatement prep =  conexao.prepareStatement(sql);
        prep.setString(1, nome);
        prep.setString(2, senha);
        ResultSet resultado = prep.executeQuery();

        if (resultado.next()){
          CarregarTela nova = new CarregarTela();
          nova.abrirTela("Menu");

           Stage stage = (Stage)  btnLogin.getScene().getWindow();
        stage.close();
        }
        else{

              txtName.setText("");
              Password.setText( "");
             Alert erro = new Alert(Alert.AlertType.ERROR);
             erro.setTitle(" Erro ");
             erro.setContentText(" Usuario ou Senha estão Incoretos ");
             erro.show();

        
        }
        
    } catch(Exception e){
        System.err.println(" Deu pau mo brother" + e.getMessage());
    }

    }    

    @FXML
    void Close(ActionEvent event) {
        Stage stage = (Stage)  btnClose.getScene().getWindow();
        stage.close();
       

    }
    @FXML
    void Fechar(MouseEvent event) {
        

    }

    @FXML
    void Name(ActionEvent event) {

    }

    @FXML
    void codigo(ActionEvent event) {

    }

}

