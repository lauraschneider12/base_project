package br.edu.ifpr.pgua.eic.tads.controllers;
import io.javalin.http.Handler;

public class CadastroController {
    
    public Handler get = ctx ->{
        ctx.render("cadastro.ftl");
    };
}
