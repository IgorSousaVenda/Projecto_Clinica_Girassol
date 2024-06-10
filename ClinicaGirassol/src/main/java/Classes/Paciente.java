
package Classes;

import java.time.LocalDate;
public class Paciente {
    String nome;
    String numDocIdent;
    LocalDate dataNascimento;
    String enderco;
    String telefone;
    public Paciente( String nome, String numDocIdent, String endereco, String telefone){
        this.nome = nome;
        this.numDocIdent = numDocIdent;
        this. enderco = endereco;
        this.telefone = telefone;
        
    }
  public void mostrarDados(){
      System.out.println(" Nome "+ getNome());
      System.out.println(" Nome "+ getNumDocIdent());  
  }
    public String getNome() {
        return nome;
    }

    public String getNumDocIdent() {
        return numDocIdent;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEnderco() {
        return enderco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumDocIdent(String numDocIdent) {
        this.numDocIdent = numDocIdent;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEnderco(String enderco) {
        this.enderco = enderco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
