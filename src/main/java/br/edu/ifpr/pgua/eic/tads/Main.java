package br.edu.ifpr.pgua.eic.tads;

import java.util.ArrayList;

import br.edu.ifpr.pgua.eic.tads.controllers.CadastroController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import br.edu.ifpr.pgua.eic.tads.models.Contato;
import br.edu.ifpr.pgua.eic.tads.models.Agenda;


public class Main {

     public static ArrayList<Contato> databaseContato = new ArrayList<>();
    public static void main( String[] args ){

        //Contato contato = new Contato("Augusto","augusto123@gmail.com","95982078972");

        //Agenda  agenda = new Agenda("info24", "online");
        //agenda.adicionarContato(contato);
       // System.out.println(agenda);

       Javalin app =  Javalin.create(config ->{
        config.staticFiles.add("/public", Location.CLASSPATH);
       }).start(7000);
       CadastroController cadastroController = new CadastroController();
       IndexController indexController = new IndexController();

       app.get("/index", indexController.get);
       
       app.get("/cadastro", cadastroController.get);
        
    }
}
