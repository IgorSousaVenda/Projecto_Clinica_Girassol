package Controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class CarregarTela {
    private Pane painel;

    
  
        public void abrirTela(String nomeArquivo) {
            try {
                Stage tela = new Stage();
                // Carregar o arquivo FXML usando getResource para obter o caminho absoluto
                URL caminho = getClass().getResource("/Telas/"+nomeArquivo + ".fxml");
                if (caminho == null) {
                    throw new IOException("FXML não encontrado: " + nomeArquivo);
                }
                FXMLLoader loader = new FXMLLoader(caminho);
                Parent root = loader.load();
                Scene cena = new Scene(root);
                tela.setScene(cena);
                //tela.initStyle(StageStyle.UNDECORATED);//
                tela.show();
            } catch (IOException e) {
                System.out.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
                e.printStackTrace();
            }
        }
    

    public Pane mostarTela(String arquivoNome) {
        try {
            // Adicione uma barra à esquerda para garantir que o caminho é absoluto
            URL caminho = getClass().getResource(arquivoNome+".fxml");
            if (caminho == null) {
                throw new java.io.FileNotFoundException("FXML não foi encontrado: " + arquivoNome);
            }
            new FXMLLoader();
            painel = FXMLLoader.load(caminho);
            return painel;
        } catch (Exception e) {
            System.out.println("Erro ao carregar o ficheiro: " + e.getMessage());
            e.printStackTrace();
        }
        return painel;
    }


    public void setCenter(Pane mostrar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCenter'");
    }
    
  
  
}