
package Classes;

import java.time.LocalDate;

public class Medico extends Funcionario {
    String numeroMedico;
    Especialidade especialidade;
    LocalDate horaTrabalho;

    public String getNumeroMedico() {
        return numeroMedico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public LocalDate getHoraTrabalho() {
        return horaTrabalho;
    }

    public void setNumeroMedico(String numeroMedico) {
        this.numeroMedico = numeroMedico;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public void setHoraTrabalho(LocalDate horaTrabalho) {
        this.horaTrabalho = horaTrabalho;
    }
    
    public boolean cadastrarMedico(String codigo, String nome, String cargo, double salario, LocalDate dataContratacao){
        return true;
    }
}
