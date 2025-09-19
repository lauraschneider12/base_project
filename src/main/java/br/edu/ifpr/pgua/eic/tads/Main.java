package br.edu.ifpr.pgua.eic.tads;

import java.util.ArrayList;


import br.edu.ifpr.pgua.eic.tads.models.Contato;
import br.edu.ifpr.pgua.eic.tads.routes.Rotas;
import br.edu.ifpr.pgua.eic.tads.config.AppConfig;

public class Main {

    public static ArrayList<Contato> databaseContato = new ArrayList<>();

    public static void main(String[] args) {

       Rotas rotas = new Rotas();
       AppConfig appConfig = new AppConfig();

       rotas.registrarRotas(appConfig.iniciaApp());
       
       

    }
}
