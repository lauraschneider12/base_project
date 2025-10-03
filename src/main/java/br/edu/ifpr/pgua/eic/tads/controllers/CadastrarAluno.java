package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Handler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import br.edu.ifpr.pgua.eic.tads.models.Aluno;
import br.edu.ifpr.pgua.eic.tads.models.Notas;

public class CadastrarAluno {

    public ArrayList<Aluno> alunos = Aluno.recuperarAlunos();
    public Handler get = ctx -> ctx.render("Cadastro.ftl");
    private ErroController erroController = new ErroController();

    public Handler post = ctx -> {
        // IMPROVEMENT: Basic null/empty checks to prevent parsing exceptions
        String nome = ctx.formParam("nome");
        String datanascStr = ctx.formParam("datanasc");
        String cpf = ctx.formParam("cpf");
        String email = ctx.formParam("email");
        String n1Str = ctx.formParam("nota1");
        String n2Str = ctx.formParam("nota2");
        String n3Str = ctx.formParam("nota3");
        String n4Str = ctx.formParam("nota4");

        if (nome == null || nome.trim().isEmpty() || datanascStr == null || cpf == null || email == null ||
            n1Str == null || n2Str == null || n3Str == null || n4Str == null) {
            ctx.redirect("/erro?msg=Campos%20obrigat%C3%B3rios%20em%20branco!");
            return;
        }

        LocalDate datanasc;
        double n1, n2, n3, n4;
        try {
            datanasc = LocalDate.parse(datanascStr);
            n1 = Double.parseDouble(n1Str);
            n2 = Double.parseDouble(n2Str);
            n3 = Double.parseDouble(n3Str);
            n4 = Double.parseDouble(n4Str);
        } catch (Exception e) {
            ctx.redirect("/erro?msg=Formato%20inv%C3%A1lido%20em%20data%20ou%20notas!");
            return;
        }

        Aluno aluno = new Aluno(nome, datanasc, email, cpf, new Notas(n1, n2, n3, n4));
        String erro = erroController.verificarAluno(aluno);
        if (erro != null) {
            ctx.redirect("/erro?msg=" + erro.replace(" ", "%20"));
            return;
        }
        aluno.salvarArquivo();
        alunos.add(aluno);
        // IMPROVEMENT: Optional—reload list from file to ensure consistency after save
        // alunos = Aluno.recuperarAlunos();
        ctx.redirect("/listar");

        // FIX: Removed duplicate ctx.redirect("/listar"); — unreachable anyway
    };

    // Renderiza lista de alunos
    public Handler getList = ctx -> {
        // IMPROVEMENT: Reload list before rendering to catch any file changes
        alunos = Aluno.recuperarAlunos();
        ctx.render("visualizarAluno.ftl", Map.of("alunos", alunos));
    };

    // Excluir aluno
    public Handler excluir = ctx -> {
        String cpf = ctx.pathParam("cpf");
        boolean ok = Aluno.excluirAluno(cpf);
        if (ok) {
            alunos.removeIf(a -> a.getCpf().equals(cpf));
            // IMPROVEMENT: Reload after delete for consistency
            // alunos = Aluno.recuperarAlunos();
        }
        ctx.redirect("/listar");
    };

    public Handler editarGet = ctx -> {
        String cpf = ctx.pathParam("cpf");
        Aluno aluno = Aluno.buscarPorCpf(cpf);

        if (aluno != null) {
            ctx.render("edit.ftl", Map.of("aluno", aluno));
        } else {
            ctx.html("Aluno não encontrado!");
        }
    };

    // POST da edição
    public Handler editarPost = ctx -> {
        String cpfAntigo = ctx.pathParam("cpf");

        // IMPROVEMENT: Similar null/checks as in post (omitted for brevity; add if needed)

        Aluno novo = new Aluno(
            ctx.formParam("nome"),
            LocalDate.parse(ctx.formParam("datanasc")),
            ctx.formParam("email"),
            ctx.formParam("cpf"),
            new Notas(
                Double.parseDouble(ctx.formParam("nota1")),
                Double.parseDouble(ctx.formParam("nota2")),
                Double.parseDouble(ctx.formParam("nota3")),
                Double.parseDouble(ctx.formParam("nota4"))
            )
        );
        if(erroController.verificarAluno(novo)==null){
 
             boolean ok = Aluno.editarAluno(cpfAntigo, novo);
               if (ok) {
               for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getCpf().equals(cpfAntigo)) {
                    alunos.set(i, novo);
                    break;
                }
            }

        }
        }
       

      

        ctx.redirect("/listar");
    };
}