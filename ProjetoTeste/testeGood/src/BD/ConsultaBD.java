package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Enidades.Consulta;


public class ConsultaBD {
   
    public boolean CadastrarConsulta(Consulta C) throws Exception {
        String sqlVerificar = "SELECT * FROM Consulta WHERE medico_id = ? AND data_consulta = ? AND hora_consulta = ?";
        String sqlInserir = "INSERT INTO consulta (medico_id, paciente_id, especialidade_id, data_consulta, hora_consulta) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conexao = Conection.getConectar()) {
            // Verificação de disponibilidade do médico
            try (PreparedStatement prep = conexao.prepareStatement(sqlVerificar)) {
                prep.setInt(1,  C.getMedicoId());
                prep.setInt(2, C.getPacienteId());
                prep.setInt(0, C.getEspecialidadeId());
                prep.setDate(2, (C.getDataConsulta()));
                prep.setTime(3,  (C.getHoraConsulta()));
                
                ResultSet resultado = prep.executeQuery();
                if (resultado.next()) {
                    System.out.println("Médico indisponível nesse horário");
                    return false;
                }
            }
    
            // Inserção da consulta
            try (PreparedStatement prepa = conexao.prepareStatement(sqlInserir)) {
                prepa.setInt(1, C.getMedicoId());
                prepa.setInt(2, C.getPacienteId());
                prepa.setInt(3, C.getEspecialidadeId());
                prepa.setDate(4, C.getDataConsulta());
                prepa.setTime(5, C.getHoraConsulta());
                int rowsAffected = prepa.executeUpdate();
                System.out.println("Dados da consulta inseridos na base de dados com sucesso");
                return rowsAffected > 0;
                
                
            }
        } catch (Exception ex) {
            System.err.println("Erro ao inserir dados da consulta na BD: " + ex.getMessage());
            ex.printStackTrace(); // Log detalhado para depuração
            return false;
        }
    }
    
      public void ExcluirConsulta( Consulta C) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql= " DELETE FROM consulta WHERE id_consulta=?";
        // Colocar algumas informações perguntado se deseja realmente deletear esse paxiente
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setInt(1, C.getId());
            prep.executeQuery();
            prep.close();
            conexao.close();
            System.err.println(" Consulta  Excluida com sucesso da BD");   
          
        }catch(Exception ex){
            System.out.println( "Erro ao Deletar a consulta da bd"+ ex.getMessage());
           
        }
    }
        


    public void ActualizarConsulta( Consulta C) throws Exception{
        Connection conexao = Conection.getConectar();
        String sql = "UPDATE consulta SET id_medico=?, id_paciente=?,  data_consulta=?,  WHERE id=?";
        try{
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setTime(3, C.getHoraConsulta());
            prep.setDate(4,C.getDataConsulta());
            prep.setTime(3, C.getHoraConsulta());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.out.println(" Dados da consulta Actualizados Com Sucesso na BD ");

             } catch(Exception ex){
                System.out.println("Erro ao Actualizar Dados  da consulta na BD "+ex.getMessage());
             }
    }

    public List<Consulta> listarConsulta() throws Exception {
        String sql = "SELECT * FROM consulta " +
                     "INNER JOIN paciente ON paciente.id = consulta.id_paciente " +
                     "INNER JOIN medico ON medico.id = consulta.id_medico " +
                     "INNER JOIN especialidade ON medico.id_especialidade = especialidade.id";
    
        List<Consulta> lista = new ArrayList<>();
    
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql);
             ResultSet resultado = prep.executeQuery()) {
    
            while (resultado.next()) {
            
            }
    
        } catch (Exception ex) {
            System.err.println("Erro ao listar consultas: " + ex.getMessage());
            ex.printStackTrace(); // Log detalhado para depuração
        }
    
        return lista;
    }
   
    
}





   /*  public List<Consulta> ObterTodasConsultas() throws Exception {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT c.id, c.data_consulta, c.hora_consulta, p.nome AS paciente_nome, m.crm AS medico_crm, e.nome AS especialidade_nome " +
                     "FROM consulta c " +
                     "JOIN paciente p ON c.paciente_id = p.id " +
                     "JOIN medico m ON c.medico_id = m.id " +
                     "JOIN especialidade e ON c.especialidade_id = e.id";
        try (Connection connection = Conection.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                    rs.getInt("id");
                    rs.getDate("data_consulta").toString();
                    rs.getTime("hora_consulta").toString();
                    rs.getString("paciente_nome").toString();
                    rs.getString("medico_crm").toString();
                    rs.getString("especialidade_nome").toString();
                
                consultas.add(consulta);
            }
        }
        return consultas;
    }*/

