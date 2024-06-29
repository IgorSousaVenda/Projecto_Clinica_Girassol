package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Enidades.Funcionario;

public class FuncionarioBD {

    public int cadastrarFuncionario(Funcionario funcionario) throws Exception {
        String sql = "INSERT INTO funcionario (nome, cargo, salario, especialidade, BI, telefone, Endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            prep.setString(1, funcionario.getNome());
            prep.setString(2, funcionario.getCargo());
            prep.setDouble(3, funcionario.getSalario());
            prep.setString(4, funcionario.getEspecialidade());
            prep.setString(5, funcionario.getBi());
            prep.setInt(6, funcionario.getTelefone());
            prep.setString(7, funcionario.getEndereco());

            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = prep.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // Retorna o ID gerado
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
            System.out.println("Funcionário excluído com sucesso do BD");
        } catch (Exception ex) {
            System.out.println("Erro ao deletar o funcionário do BD: " + ex.getMessage());
        }
    }

    public void AtualizarFuncionario(Funcionario funcionario) throws Exception {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, salario = ?, especialidade = ?, BI = ?, telefone = ?, Endereco = ? WHERE id = ?";
        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {

            prep.setString(1, funcionario.getNome());
            prep.setString(2, funcionario.getCargo());
            prep.setDouble(3, funcionario.getSalario());
            prep.setString(4, funcionario.getEspecialidade());
            prep.setString(5, funcionario.getBi());
            prep.setInt(6, funcionario.getTelefone());
            prep.setString(7, funcionario.getEndereco());
            prep.setInt(8, funcionario.getId());
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
    
}
