
package Classes;


public class HistoricoMedico {
    Consulta consulta;
    Paciente paciente;
    Medico medico;
    Exame exame;

    public HistoricoMedico(Consulta consulta, Paciente paciente, Medico medico, Exame exame) {
        this.consulta = consulta;
        this.paciente = paciente;
        this.medico = medico;
        this.exame = exame;
    }
    
}
