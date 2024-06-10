
package Classes;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Funcionario {
    String codico;
    String endereco;
    String telefone;
    String nome;
    String cargo;
    BigDecimal salario;
    LocalDate dataContacao;

   public boolean cadastrarFuncionario(String codico, String nome, String cargo, BigDecimal salario,LocalDate dataContacao){
        return true;
    }

    public String getCodico() {
        return codico;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public LocalDate getDataContacao() {
        return dataContacao;
    }

    public void setCodico(String codico) {
        this.codico = codico;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setDataContacao(LocalDate dataContacao) {
        this.dataContacao = dataContacao;
    }
   
}

   

