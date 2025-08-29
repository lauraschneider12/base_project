package br.edu.ifpr.pgua.eic.tads.models;

import java.util.ArrayList;

import br.edu.ifpr.pgua.eic.tads.Main;

public class Agenda{

    private String des;
    private String tipo;

    public Agenda(String Desc, String Tp){
        this.des = Desc;
        this.tipo = Tp;

    }

    public void adicionarContato(Contato contato){
        Main.databaseContato.add(contato);
        
    }

    public ArrayList<Contato> listarContatos(){
        return Main.databaseContato;
    }
    public String toString(){
        return"Descrição: " +this.des +"\n"+"Tipo: "+this.tipo+"Contatos: "+this.listarContatos();
    }

}