package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Enidades.Especialidade;

public class EspecialidadeBD {

    public void cadastrarEspecialidade(Especialidade especialidade) throws Exception {
        Connection conexao = Conection.getConectar();
        String sql = "INSERT INTO especialidade (nome, descricao) VALUES (?, ?)";
        try {
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setString(1, especialidade.getNome());
            prep.setString(2, especialidade.getDescricao());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.err.println("Dados Inseridos com Sucesso na BD!");
        } catch (Exception ex) {
            System.out.println("Erro ao inserir dados na BD: " + ex.getMessage());
        }
    }

    public void excluirEspecialidade(Especialidade especialidade) throws Exception {
        Connection conexao = Conection.getConectar();
        String sql = "DELETE FROM especialidade WHERE id=?";
        try {
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setInt(1, especialidade.getId());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.err.println("Especialidade Excluída com sucesso da BD");
        } catch (Exception ex) {
            System.out.println("Erro ao deletar especialidade da BD: " + ex.getMessage());
        }
    }

    public void atualizarEspecialidade(Especialidade especialidade) throws Exception {
        Connection conexao = Conection.getConectar();
        String sql = "UPDATE especialidade SET nome=?, descricao=? WHERE id=?";
        try {
            PreparedStatement prep = conexao.prepareStatement(sql);
            prep.setString(1, especialidade.getNome());
            prep.setString(2, especialidade.getDescricao());
            prep.setInt(3, especialidade.getId());
            prep.executeUpdate();
            prep.close();
            conexao.close();
            System.out.println("Dados atualizados com sucesso na BD");
        } catch (Exception ex) {
            System.out.println("Erro ao atualizar dados na BD: " + ex.getMessage());
        }
    }

    public List<Especialidade> listarEspecialidades() throws Exception {
        Connection conexao = Conection.getConectar();
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidade ORDER BY nome";
        try {
            PreparedStatement prep = conexao.prepareStatement(sql);
            ResultSet resultado = prep.executeQuery();
            while (resultado.next()) {
                Especialidade especialidade = new Especialidade();
                especialidade.setId(resultado.getInt("id"));
                especialidade.setNome(resultado.getString("nome"));
                especialidade.setDescricao(resultado.getString("descricao"));
                lista.add(especialidade);
            }
            System.err.println("Listagem de especialidades realizada com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao listar especialidades: " + ex.getMessage());
        } finally {
            conexao.close(); // Fechar a conexão no final
        }
        return lista;
    }
}
