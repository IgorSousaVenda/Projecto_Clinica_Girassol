package Enidades;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
    private int id;
    private Date dataConsulta;
    private Time horaConsulta;
    private int pacienteId;
    private int medicoId;
    private int especialidadeId;

    
    
    public Consulta(){

}



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public Time getHoraConsulta() {
        return horaConsulta;
    }
    public void setHoraConsulta(Time horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
    public int getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
    public int getMedicoId() {
        return medicoId;
    }
    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }
    public int getEspecialidadeId() {
        return especialidadeId;
    }
    public void setEspecialidadeId(int especialidadeId) {
        this.especialidadeId = especialidadeId;
    }


}
    

