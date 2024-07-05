package Enidades;

public class Medico extends Funcionario{

        private int id;
        private String crm;
        private int especialidadeId;
        private int funcionarioId;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getCrm() {
            return crm;
        }
        public void setCrm(String crm) {
            this.crm = crm;
        }
        public int getEspecialidadeId() {
            return especialidadeId;
        }
        public void setEspecialidadeId(int especialidadeId) {
            this.especialidadeId = especialidadeId;
        }
        public int getFuncionarioId() {
            return funcionarioId;
        }
        public void setFuncionarioId(int funcionarioId) {
            this.funcionarioId = funcionarioId;
        }
    

    }
    
    
    

