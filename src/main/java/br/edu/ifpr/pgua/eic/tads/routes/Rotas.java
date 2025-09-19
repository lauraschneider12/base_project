package br.edu.ifpr.pgua.eic.tads.routes;
import br.edu.ifpr.pgua.eic.tads.controllers.ContatoController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import io.javalin.Javalin;
public class Rotas {


    ContatoController contatoController = new ContatoController();
    IndexController indexController = new IndexController();


    public Rotas(){
        this.contatoController = new ContatoController();
        this.indexController = new IndexController();
    }
    public void registrarRotas(Javalin app){

        app.get("/", indexController.get);
        app.get("/cadastro", contatoController.get);
        app.post("/contatos", contatoController.post);


    }

    
}
