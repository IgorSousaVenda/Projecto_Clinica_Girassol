package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ConsultaView {

    private int id;
    private String nomePaciente;
    private String nomeEspecialidade;
    private LocalDate dataConsulta;
    private String estado;

    public ConsultaView() {
        // Construtor vazio
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ConsultaView> listarConsultas() throws Exception {
        List<ConsultaView> consultas = new ArrayList<>();
        String sql = "SELECT id, nome_paciente, nome_especialidade, data_consulta, Estado FROM consultas";

        try (Connection conexao = Conection.getConectar();
             PreparedStatement prep = conexao.prepareStatement(sql);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {
                ConsultaView consulta = new ConsultaView();
                consulta.setId(rs.getInt("id"));
                consulta.setNomePaciente(rs.getString("nome_paciente"));
                consulta.setNomeEspecialidade(rs.getString("nome_especialidade"));
                consulta.setDataConsulta(rs.getDate("data_consulta").toLocalDate());
                consulta.setEstado(rs.getString("Estado"));
                consultas.add(consulta);
            }
        }
        return consultas;
    }
}
