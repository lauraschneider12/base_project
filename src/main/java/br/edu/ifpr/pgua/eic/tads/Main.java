package br.edu.ifpr.pgua.eic.tads;

import java.util.ArrayList;

import br.edu.ifpr.pgua.eic.tads.controllers.ContatoController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import br.edu.ifpr.pgua.eic.tads.models.Contato;

public class Main {

    public static ArrayList<Contato> databaseContato = new ArrayList<>();

    public static void main(String[] args) {

        // Contato contato = new
        // Contato("Augusto","augusto123@gmail.com","95982078972");

        // Agenda agenda = new Agenda("info24", "online");
        // agenda.adicionarContato(contato);
        // System.out.println(agenda);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
        cfg.setClassForTemplateLoading(Main.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        Javalin app = Javalin.create(config -> {
            //config.staticFiles.add("/public", Location.CLASSPATH);
            config.fileRenderer(new JavalinFreemarker(cfg));
        }).start(5000);
        ContatoController contatoController = new ContatoController();
        IndexController indexController = new IndexController();

        app.get("/", indexController.get);
        app.get("/cadastro", contatoController.get);
        app.post("/contatos", contatoController.post);


    }
}
