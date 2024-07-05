package Enidades;
public class AgendConsulta {
    private String hora;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String dataConsulta;
    private String paciente;
    private String medico;
    private String especialidade;

    // Construtor vazio
    public AgendConsulta() {
    }

    // Construtor com parâmetros
    public AgendConsulta(String hora, String dataConsulta, String paciente, String medico, String especialidade) {
        this.hora = hora;
        this.dataConsulta = dataConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "AgendaConsulta{" +
                "hora='" + hora + '\'' +
                ", dataConsulta='" + dataConsulta + '\'' +
                ", paciente='" + paciente + '\'' +
                ", medico='" + medico + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}

    

