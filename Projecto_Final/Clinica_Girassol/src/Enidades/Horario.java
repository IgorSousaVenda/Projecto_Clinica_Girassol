package Enidades;

import java.sql.Time;

public class Horario {
private int id;
private int id_funcionario;
private Time Hora;
private String diaSemana;


public String getDiaSemana() {
    return diaSemana;
}
public void setDiaSemana(String diaSemana) {
    this.diaSemana = diaSemana;
}




public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}

public int getId_funcionario() {
    return id_funcionario;
}
public void setId_funcionario(int id_funcionario) {
    this.id_funcionario = id_funcionario;
}
public Time getHora() {
    return Hora;
}
public void setHora(Time hora) {
    Hora = hora;
}


    
}
