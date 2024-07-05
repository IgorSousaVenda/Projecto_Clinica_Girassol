package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
     
    public class HorarioBD {
        public boolean verificarHorario(String diaSemana, int id_funcionario) throws Exception {
            Connection conexao = Conection.getConectar();
            String sql = "SELECT * FROM Horario WHERE diaSemana=? AND id_funcionario=?";
            try {
                PreparedStatement prep = conexao.prepareStatement(sql);
                prep.setString(1, diaSemana);
                prep.setInt(2, id_funcionario);
                ResultSet resultado = prep.executeQuery();
                return resultado.next();
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
    




    

