package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Enidades.Paciente;

public class PacienteBD {
    public void CadastrarPaciente(Paciente P) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql= " INSERT INTO  paciente ( nome, bi,endereco, telefone) VALUES( ?,?,?,?)";
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setString(1,P.getNome());
            prep.setString(2,P.getBi());
            prep.setString(3,P.getEndereco());
            prep.setString(4, P.getTelefone());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.err.println(" Dados Inseridos com Sucesso na BD! ");

        }catch( Exception ex){
            System.out.println("Erro ao inserir dados na BD "+ ex.getMessage());

        }
    }
     
    public void ExcluirPaciente( Paciente P) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql= " DELETE FROM paciente WHERE id_paciente=?";
        // Colocar algumas informações perguntado se deseja realmente deletear esse paxiente
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setInt(1, P.getId());
            prep.executeQuery();
            prep.close();
            conexao.close();
            System.err.println(" Cliente Excluido com sucesso da BD");



        }catch(Exception ex){
            System.out.println( "Erro ao Deletar o paciente da bd"+ ex.getMessage());
        }

        
    }
    public void ActualizarPaciente( Paciente P) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql = "UPDATE paciente SET nome=?, bi=?, sexo=?,email=?, endereco=? WHERE id=?";
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setString(1, P.getNome());
            prep.setString(2, P.getBi());
            prep.setString(3, P.getEndereco());
            prep.setString(4, P.getTelefone());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.out.println(" Dados Inseridos Com Sucesso na BD");

             } catch(Exception ex){
                System.out.println("Erro ao Actualizar Dados na BD"+ex.getMessage());
             }

    }
    public List<Paciente> ListarPaciente() throws Exception{
        Connection conexao = Conection.getConectar();
        List<Paciente> lista= new ArrayList<>();
        String sql = " SELECT* FROM paciente ORDER BY nome";
        try{
        PreparedStatement prep = conexao.prepareStatement(sql);
        ResultSet resultado = prep.executeQuery();
        while( resultado.next()){
            Paciente P = new Paciente();
            P.setId(resultado.getInt("id"));
            P.setNome(resultado.getString("nome"));
            P.setBi(resultado.getString("bi"));
            P.setEndereco(resultado.getString("endereco"));
            lista.add(P);
        }

    }catch( Exception ex){
        System.out.println("Erro ao Listar Pacientes"+ ex.getMessage());

    }
    return lista;
 }
 

 
}



