
import BaseDeDados.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Main {

    public static void main(String[] args) throws Exception {
        Connection conectar = null;
        PreparedStatement busca = null;
        try {
            conectar = Conection.getConectar();
            String query = "INSERT INTO especialidade(id, nome, descricao) VALUES (?, ?, ?)";
            busca = conectar.prepareStatement(query);
            busca.setNull(1, java.sql.Types.INTEGER); // Assuming `id` is an auto-increment field
            busca.setString(2, "Teste1");
            busca.setString(3, "Teste2");
            busca.executeUpdate();
            System.out.println("Conexão feita com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (busca != null) {
                try {
                    busca.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conectar != null) {
                try {
                    Conection.fecharConexao();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
