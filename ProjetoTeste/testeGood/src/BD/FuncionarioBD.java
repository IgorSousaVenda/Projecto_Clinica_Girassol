package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Enidades.Funcionario;

public class FuncionarioBD {

    public void CadastrarFuncionario( Funcionario F) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql = " INSERT INTO funcionario ( nome, bi, sexo, email,telefone,endereco,dataContratacao,cargo,salario,senha) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
             PreparedStatement prep = conexao.prepareStatement(sql);
             prep.setString(1, F.getNome());
             prep.setString(2, F.getBi());
             prep.setString(3, F.getSexo());
             prep.setString(4, F.getEmail());
             prep.setInt(5, F.getTelefone());
             prep.setString(6, F.getEndereco());
             prep.setString(7, F.getDataContratacao());
             prep.setString(8, F.getCargo());
             prep.setFloat(9, F.getSalario());
             prep.setString(10, F.getSenha());
             prep.executeUpdate();
             prep.close();
             conexao.close();
             System.out.println(" Dados Inseridos Com Sucesso na BD");

        }catch( Exception ex){
            System.out.println("Erro ao inserir dados na BD "+ ex.getMessage());

        }
    }
    public void ExcluirFuncionario( Funcionario F) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql= " DELETE FROM funcionario WHERE id_funcionario=?";
        // Colocar algumas informações perguntado se deseja realmente deletear esse paxiente
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setInt(1, F.getId());
            prep.executeQuery();
            prep.close();
            conexao.close();
            System.err.println(" Funcionario Excluido com sucesso da BD");



        }catch(Exception ex){
            System.out.println( "Erro ao Deletar o Funcionario da bd"+ ex.getMessage());
        }

    }
    public void ActualizarFuncionario( Funcionario F) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql = "UPDATE funcionario SET nome=?, bi=?, sexo=?, email?,telefone=?,endereco=?,dataContratacao=?,cargo=?,salario=?,senha=? WHERE id=?";
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setString(1, F.getNome());
            prep.setString(2, F.getBi());
            prep.setString(3, F.getSexo());
            prep.setString(4, F.getEmail());
            prep.setInt(5, F.getTelefone());
            prep.setString(6, F.getEndereco());
            prep.setString(7, F.getDataContratacao());
            prep.setString(8, F.getCargo());
            prep.setFloat(9, F.getSalario());
            prep.setString(10, F.getSenha());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.out.println(" Dados Inseridos Com Sucesso na BD");

             } catch(Exception ex){
                System.out.println("Erro ao Actualizar Dados na BD"+ex.getMessage());
             }

    }
    public  List<Funcionario> ListarFuncionario() throws Exception{
        Connection conexao = Conection.getConectar();
          List<Funcionario> lista= new ArrayList<>();
        String sql = " SELECT* FROM paciente ORDER BY nome";
        try{
        PreparedStatement prep = conexao.prepareStatement(sql);
        ResultSet resultado = prep.executeQuery();
        while( resultado.next()){
            Funcionario F = new Funcionario();
            F.setId(resultado.getInt("id"));
            F.setNome(resultado.getString("nome"));
            F.setBi(resultado.getString("bi"));
            F.setSexo(resultado.getString("sexo"));
            F.setEmail(resultado.getString("email"));
            F.setTelefone(resultado.getInt("telefone"));
            F.setEndereco(resultado.getString("endereco"));
            F.setDataContratacao(resultado.getString("datacontratacao"));
            F.setCargo(resultado.getString("cargo"));
            F.setSalario(resultado.getFloat("salario"));
            F.setSenha(resultado.getString("senha"));
            
          lista.add(F);
        }

    }catch( Exception ex){
        System.out.println("Erro ao Listar Pacientes"+ ex.getMessage());

    }
    return lista;
 }
 

 
    }

