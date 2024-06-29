package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Enidades.Paciente;

public class PacienteBD {

    public int cadastrarPaciente(Paciente paciente) throws Exception {
        String sql = "INSERT INTO paciente (nome, bi, endereco, telefone, sexo, dataNascimento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setString(1, paciente.getNome());
            prep.setString(2, paciente.getBi());
            prep.setString(3, paciente.getEndereco());
            prep.setString(4, paciente.getTelefone());
            prep.setString(5, paciente.getSexo());
            prep.setDate(6, java.sql.Date.valueOf(paciente.getDataNascimento())); // Convertendo LocalDate para java.sql.Date

            return prep.executeUpdate();
        }
    }

    public void excluirPaciente(int id) throws Exception {
        String sql = "DELETE FROM paciente WHERE id=?";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setInt(1, id);
            prep.executeUpdate();
        }
    }

    public void atualizarPaciente(Paciente paciente) throws Exception {
        String sql = "UPDATE paciente SET nome=?, bi=?, endereco=?, telefone=?, sexo=?, dataNascimento=? WHERE id=?";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setString(1, paciente.getNome());
            prep.setString(2, paciente.getBi());
            prep.setString(3, paciente.getEndereco());
            prep.setString(4, paciente.getTelefone());
            prep.setString(5, paciente.getSexo());
            prep.setDate(6, java.sql.Date.valueOf(paciente.getDataNascimento())); // Convertendo LocalDate para java.sql.Date
            prep.setInt(7, paciente.getId());

            prep.executeUpdate();
        }
    }
    public List<Paciente> listarPacientes() throws Exception {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente ORDER BY nome";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql);
             ResultSet rs = prep.executeQuery()) {
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setBi(rs.getString("bi"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setSexo(rs.getString("sexo"));
                
                java.sql.Date dataNascimentoSQL = rs.getDate("dataNascimento");
                if (dataNascimentoSQL != null) {
                    paciente.setDataNascimento(dataNascimentoSQL.toLocalDate());
                } else {
                    paciente.setDataNascimento(null); // Ou outra ação, dependendo do caso
                }
                
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }
 }
    
