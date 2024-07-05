package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Enidades.Funcionario;

public class FuncionarioBD {

    public int cadastrarFuncionario(Funcionario funcionario) throws Exception {
        String sql = "INSERT INTO funcionario (nome, cargo, salario, especialidade, BI, telefone, Endereco, dataNascimento,Crm) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            prep.setString(1, funcionario.getNome());
            prep.setString(2, funcionario.getCargo());
            prep.setDouble(3, funcionario.getSalario());
            prep.setString(4, funcionario.getEspecialidade());
            prep.setString(5, funcionario.getBi());
            prep.setInt(6, funcionario.getTelefone());
            prep.setString(7, funcionario.getEndereco());
            prep.setDate(8, java.sql.Date.valueOf(funcionario.getDataNascimento()));
            prep.setString(9, funcionario.getCrm());

            int linhas = prep.executeUpdate();
            if (linhas > 0) {
                try (ResultSet resultado = prep.getGeneratedKeys()) {
                    if (resultado.next()) {
                        return resultado.getInt(1); // Retorna o ID gerado
                    }
                }
            }
        }
        return -1; // Retorna -1 em caso de erro
    }

    public void ExcluirFuncionario(int idFuncionario) throws Exception {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {

            prep.setInt(1, idFuncionario);
            prep.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro ao deletar o funcionário do BD: " + ex.getMessage());
        }
    }

    public void AtualizarFuncionario(Funcionario funcionario) throws Exception {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, salario = ?, especialidade = ?, BI = ?, telefone = ?, Endereco = ?, dataNascimento = ?, Crm =?  WHERE id = ?";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {

            prep.setString(1, funcionario.getNome());
            prep.setString(2, funcionario.getCargo());
            prep.setDouble(3, funcionario.getSalario());
            prep.setString(4, funcionario.getEspecialidade());
            prep.setString(5, funcionario.getBi());
            prep.setInt(6, funcionario.getTelefone());
            prep.setString(7, funcionario.getEndereco());
            prep.setDate(8, java.sql.Date.valueOf(funcionario.getDataNascimento()));
            prep.setString(9, funcionario.getCrm());
            prep.setInt(9, funcionario.getId());
            prep.executeUpdate();
            System.out.println("Dados atualizados com sucesso no BD");
        } catch (Exception ex) {
            System.out.println("Erro ao atualizar dados no BD: " + ex.getMessage());
        }
    }

    public List<Funcionario> ListarFuncionario() throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario ORDER BY nome";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql);
             ResultSet resultado = prep.executeQuery()) {

            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultado.getInt("id"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setEspecialidade(resultado.getString("especialidade"));
                funcionario.setBi(resultado.getString("BI"));
                funcionario.setTelefone(resultado.getInt("telefone"));
                funcionario.setEndereco(resultado.getString("Endereco"));
                java.sql.Date dataNascimentoSQL = resultado.getDate("dataNascimento");
                if (dataNascimentoSQL != null) {
                    funcionario.setDataNascimento(dataNascimentoSQL.toLocalDate());
                } else {
                    funcionario.setDataNascimento(null); // Ou outra ação, dependendo do caso
                }
                funcionario.setCrm(resultado.getString("Crm"));
                lista.add(funcionario);
            }
            System.out.println("Funcionários listados com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao listar funcionários: " + ex.getMessage());
        }
        return lista;
    }

    public List<String> listarMedicos() throws Exception {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM funcionario WHERE cargo = 'médico' ORDER BY nome";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql);
             ResultSet resultado = prep.executeQuery()) {

            while (resultado.next()) {
                String nomeMedico = resultado.getString("nome");
                lista.add(nomeMedico);
            }
            System.out.println("Médicos listados com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao listar médicos: " + ex.getMessage());
        }
        return lista;
    }
    public int obterIdMedicoPorNome(String nomeMedico) throws Exception {
        String sql = "SELECT id FROM funcionario WHERE nome = ?";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setString(1, nomeMedico);
            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        throw new Exception("Médico não encontrado: " + nomeMedico);
    }
    
    public List<String> listarMedicosPorEspecialidade(String especialidade) throws Exception {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM funcionario WHERE cargo = 'médico' AND especialidade = ? ORDER BY nome";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setString(1, especialidade);
            try (ResultSet resultado = prep.executeQuery()) {
                while (resultado.next()) {
                    String nomeMedico = resultado.getString("nome");
                    lista.add(nomeMedico);
                }
            }
            System.out.println("Médicos listados com sucesso por especialidade: " + especialidade);
        } catch (Exception ex) {
            System.out.println("Erro ao listar médicos por especialidade: " + ex.getMessage());
        }
        return lista;
    }
}
