package Enidades;


import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int id;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
     
    
    
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
   
    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
    private int pacienteId;
    private int funcionarioId;
    
    
    public int getFuncionarioId() {
        return funcionarioId;
    }



    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    private int especialidadeId;

    
    
    public Consulta(){

}



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public int getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
    
    public int getEspecialidadeId() {
        return especialidadeId;
    }
    public void setEspecialidadeId(int especialidadeId) {
        this.especialidadeId = especialidadeId;
    }


}
    

