import java.sql.Connection;
import java.sql.PreparedStatement;

import BD.Conection;

public class teste {  
    public static void main (String[]args){

try {
    Connection conexao = Conection.getConectar();
    String sql= "INSERT INTO User ( nome, senha) VALUES( ?,?)"; 
    PreparedStatement prep = conexao.prepareStatement(sql);
    prep.setString(1," Igor venda ");
    prep.setString(2, " Minharainha123");
    prep.executeUpdate();
    prep.close();
    conexao.close();

System.out.println(" Dados inseridos com sucesso ");
    
}catch(Exception e){
System.out.println(  "Erro ao inserir os dados na base de dados " + e.getMessage());
}
}
 

    }
   
   
