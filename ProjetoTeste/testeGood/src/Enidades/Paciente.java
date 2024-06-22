package Enidades;

public class Paciente {
    private int id;
    private String nome;
    private String bi;
    private String telefone;
    private String endereco;
    
    

   
    
    
    
    public Paciente(  String nome, String bi, String telefone, String endereco){
        this.nome= nome;
        this.bi= bi;
        this.telefone=telefone;
        this.endereco= endereco;
    }
    public Paciente(){

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getBi() {
        return bi;
    }


    public void setBi(String bi) {
        this.bi = bi;
    }



public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
     
    
}
