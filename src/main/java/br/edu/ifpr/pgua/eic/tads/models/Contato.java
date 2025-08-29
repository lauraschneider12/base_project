package br.edu.ifpr.pgua.eic.tads.models;

import br.edu.ifpr.pgua.eic.tads.Main;

public class Contato {

    private String nome;
    private String email;
    private String telefone;

    public Contato(String Nome, String Email, String Telefone){
         
        this.nome = Nome;
        this.email = Email;
        this.telefone = Telefone;

    }
    @Override
    public String toString() {
        
        return "Nome "+this.nome+" Email: "+this.email+" número de telefone: "+this.telefone;
    }
    

    
}
