package View;

public class Consulta {
    private int id;
    private String dataConsulta;
    private String horaConsulta;
    private String pacienteNome;
    private String medicoCrm;
    private String especialidadeNome;
    
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getHoraConsulta() {
        return horaConsulta;
    }
    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
    public String getPacienteNome() {
        return pacienteNome;
    }
    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }
    public String getMedicoCrm() {
        return medicoCrm;
    }
    public void setMedicoCrm(String medicoCrm) {
        this.medicoCrm = medicoCrm;
    }
    public String getEspecialidadeNome() {
        return especialidadeNome;
    }
    public void setEspecialidadeNome(String especialidadeNome) {
        this.especialidadeNome = especialidadeNome;
    }

}
