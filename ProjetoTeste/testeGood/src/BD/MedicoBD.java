package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Enidades.Medico;



public class MedicoBD {

    public boolean CadastrarMedico(Medico medico) throws Exception {
        String sql = "INSERT INTO medico (crm, especialidade_id, funcionario_id) VALUES (?, ?, ?)";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {

            prep.setString(1, medico.getCrm());
            prep.setInt(2, medico.getEspecialidadeId());
            prep.setInt(3, medico.getFuncionarioId());

            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;
        }
    }


public Medico BuscarMedico(int id) {
    Medico medico = null;
    try (Connection connection = Conection.getConectar()) {
        String sql = "SELECT * FROM medico WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            medico = new Medico();
            medico.setId(rs.getInt("id"));
            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidadeId(rs.getInt("especialidade_id"));
            medico.setFuncionarioId(rs.getInt("funcionario_id"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return medico;
}


public List<Medico> ListarMedicos() {
    List<Medico> lista = new ArrayList<>();
    try (Connection connection = Conection.getConectar()) {
        String sql = "SELECT * FROM medico";
        PreparedStatement prep = connection.prepareStatement(sql);

        ResultSet resultado = prep.executeQuery();
        while (resultado.next()) {
            Medico medico = new Medico();
            medico.setId(resultado.getInt("id"));
            medico.setCrm(resultado.getString("crm"));
            medico.setEspecialidadeId(resultado.getInt("especialidade_id"));
            medico.setFuncionarioId(resultado.getInt("funcionario_id"));
            lista.add(medico);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}  

    
public boolean AtualizarMedico(Medico medico) {
    try (Connection conexao = Conection.getConectar()) {
        String sql = "UPDATE medico SET crm = ?, especialidade_id = ?, funcionario_id = ? WHERE id = ?";
        PreparedStatement prep = conexao.prepareStatement(sql);
        prep.setString(1, medico.getCrm());
        prep.setInt(2, medico.getEspecialidadeId());
        prep.setInt(3, medico.getFuncionarioId());
        prep.setInt(4, medico.getId());

        int rowsAffected = prep.executeUpdate();
        return rowsAffected > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

public boolean ExcluirMedico(int id) {
    try (Connection conexao = Conection.getConectar()) {
        String sql = "DELETE FROM medico WHERE id = ?";
        PreparedStatement prep = conexao.prepareStatement(sql);
        prep.setInt(1, id);

        int rowsAffected = prep.executeUpdate();
        return rowsAffected > 0;
    } catch ( Exception e) {
        e.printStackTrace();
        return false;
    }
}
public List<Medico> pesquisarMedicosPorNome(String nome) throws Exception {
    Connection connection = Conection.getConectar();
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT m.*, f.nome, f.bi, f.endereco, f.telefone, e.nome AS especialidadeNome FROM medico m " +
                     "JOIN funcionario f ON m.funcionario_id = f.id " +
                     "JOIN especialidade e ON m.especialidade_id = e.id WHERE f.nome LIKE ?";

        try{
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + nome + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medico medico = new Medico();
                medico.setId(resultSet.getInt("id"));
                medico.setFuncionarioId(resultSet.getInt("funcionario_id"));
                medico.setEspecialidadeId(resultSet.getInt("especialidade_id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setBi(resultSet.getString("bi"));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicos;
    }
}

