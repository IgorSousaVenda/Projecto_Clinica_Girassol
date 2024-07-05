package BD;

import Enidades.AgendConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgendarConsultaBD {

    public List<AgendConsulta> listarConsultas() throws Exception {
        Connection conexao = Conection.getConectar();
        List<AgendConsulta> lista = new ArrayList<>();
        String sql = "SELECT Hora, data_consulta, paciente, medico, especialidade FROM agendaconsulta ORDER BY data_consulta, Hora";
        try {
            PreparedStatement prep = conexao.prepareStatement(sql);
            ResultSet resultado = prep.executeQuery();
            while (resultado.next()) {
                AgendConsulta consulta = new AgendConsulta();
                consulta.setHora(resultado.getString("Hora"));
                consulta.setDataConsulta(resultado.getString("data_consulta"));
                consulta.setPaciente(resultado.getString("paciente"));
                consulta.setMedico(resultado.getString("medico"));
                consulta.setEspecialidade(resultado.getString("especialidade"));
                lista.add(consulta);
            }
            prep.close();
            resultado.close();
            System.err.println("Listagem de consultas realizada com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao listar consultas: " + ex.getMessage());
        } finally {
            conexao.close(); // Fechar a conexão no final
        }
        return lista;
    }

    public void removerConsulta(AgendConsulta consulta) throws Exception {
        Connection conexao = null;
        PreparedStatement prep = null;
        try {
            conexao = Conection.getConectar();
            String sql = "DELETE FROM agendaconsulta WHERE Hora = ? AND data_consulta = ? AND paciente = ? AND medico = ? AND especialidade = ?";
            prep = conexao.prepareStatement(sql);
            prep.setString(1, consulta.getHora());
            prep.setString(2, consulta.getDataConsulta());
            prep.setString(3, consulta.getPaciente());
            prep.setString(4, consulta.getMedico());
            prep.setString(5, consulta.getEspecialidade());
            prep.executeUpdate();
            System.out.println("Consulta removida com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao remover consulta: " + ex.getMessage());
            throw ex;
        } finally {
            if (prep != null) {
                prep.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
}
}

