package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Handler;

public class IndexController {

     public Handler get = ctx ->{

        ctx.render("index.ftl");
     };
    }


  