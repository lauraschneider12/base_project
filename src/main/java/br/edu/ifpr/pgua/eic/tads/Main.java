package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.routes.Rotas;
import br.edu.ifpr.pgua.eic.tads.config.AppConfig;

public class Main{
   
     public static void main(String[] args) {

       Rotas rotas = new Rotas();
       AppConfig appConfig = new AppConfig();
       

       rotas.registrarRotas(appConfig.iniciaApp());
       
       

    }
}
