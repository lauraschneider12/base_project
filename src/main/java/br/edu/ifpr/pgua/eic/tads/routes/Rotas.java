package br.edu.ifpr.pgua.eic.tads.routes;

import br.edu.ifpr.pgua.eic.tads.controllers.CadastrarAluno;
import br.edu.ifpr.pgua.eic.tads.controllers.ErroController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import io.javalin.Javalin;

public class Rotas {

    private CadastrarAluno alunoController;
    private IndexController indexController;
    private ErroController erroController;  // This was null—now initialized below

    public Rotas() {
        this.alunoController = new CadastrarAluno();
        this.indexController = new IndexController();
        this.erroController = new ErroController();  // FIX: Initialize to avoid NPE
    }

    public void registrarRotas(Javalin app) {

        app.get("/", indexController.get);

        app.get("/cadastro", alunoController.get);

        app.post("/alunospro", alunoController.post);

        app.get("/listar", alunoController.getList);

        app.get("/editar/{cpf}", alunoController.editarGet);

        app.post("/aluno/editar/{cpf}", alunoController.editarPost);

        app.get("/excluir/{cpf}", alunoController.excluir);

        app.get("/erro", erroController.mostrarErro);
    }
}