package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enidades.Hora;

public class HoraBD {
   
  

    public List<Hora> listarHorasNaoAgendadas(LocalDate dataSelecionada, int id_funcionario) {
        List<Hora> lista = new ArrayList<>();
        String sql =" SELECT horas FROM horas WHERE horas NOT IN (SELECT Hora FROM consulta WHERE data_consulta =? AND id_funcionario =?)";

        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql)) {

            prep.setDate(1, java.sql.Date.valueOf(dataSelecionada));
            prep.setInt(2, id_funcionario);

            try (ResultSet resultado = prep.executeQuery()) {
                while (resultado.next()) {
                    Hora hora = new Hora();
                    hora.setHora(resultado.getTime("horas"));
                    lista.add(hora);
                }
                System.out.println("Horas não agendadas listadas com sucesso");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar horas não agendadas: " + ex.getMessage());
        }
        return lista;
    }
}
