
package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Handler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class IndexController {
    private String caminhoArquivo = "arquivo.txt";

    public Handler get = ctx -> {
        GravarArquivoDeTexto();

        lerArquivoDeTexto();
        ctx.render("index.ftl");
    };

    public void lerArquivoDeTexto() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));

        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                br.close();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void GravarArquivoDeTexto() {
        String conteudo = ("bem vindo!");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo));
            bw.write(conteudo);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
