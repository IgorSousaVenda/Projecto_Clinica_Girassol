package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dashboard {

    // Método para obter número de pacientes
    public int obterNumeroPacientes() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numPacientes = 0;

        try {
            conn = Conection.getConectar();
            String sql = "SELECT COUNT(*) AS total FROM paciente";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                numPacientes = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return numPacientes;
    }

    // Método para obter número de profissionais
    public int obterNumeroProfissionais() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numProfissionais = 0;

        try {
            conn = Conection.getConectar();
            String sql = "SELECT COUNT(*) AS total FROM funcionario WHERE cargo = 'Médico'";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                numProfissionais = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return numProfissionais;
    }

    // Método para obter número de agendamentos
    public int obterNumeroAgendamentos() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numAgendamentos = 0;

        try {
            conn = Conection.getConectar();
            String sql = "SELECT COUNT(*) AS total FROM consulta";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                numAgendamentos = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return numAgendamentos;
    }
}
