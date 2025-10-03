package br.edu.ifpr.pgua.eic.tads.config;

import br.edu.ifpr.pgua.eic.tads.Main;

import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;



public class AppConfig {
    public Javalin iniciaApp(){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
        cfg.setClassForTemplateLoading(Main.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        Javalin app = Javalin.create(config -> {
            //config.staticFiles.add("/public", Location.CLASSPATH);
            config.fileRenderer(new JavalinFreemarker(cfg));
        }).start(7077);
        

        return app;

    }
   

 
    
}
