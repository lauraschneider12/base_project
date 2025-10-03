package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Handler;

public class ErroController {

    public Handler mostrarErro = ctx -> {
        String mensagem = ctx.queryParam("msg"); 
        ctx.html("<div style='text-align:center; margin-top:50px; font-family:Arial,sans-serif;'>" +
                 "<h2>Erro: " + mensagem + "</h2>" +
                 "<a href='/'>Voltar para Home</a>" +
                 "</div>");
    };

    public String verificarAluno(br.edu.ifpr.pgua.eic.tads.models.Aluno aluno){
        String erro = null;

        if(aluno.getCpf() == null || !aluno.getCpf().matches("\\d{11}")){
            erro = "CPF inválido!";
        } else if(aluno.getEmail() == null || !aluno.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
            erro = "Email inválido!";
        } else if(aluno.getNotas().getN1() < 0 || aluno.getNotas().getN1() > 10 ||
                  aluno.getNotas().getN2() < 0 || aluno.getNotas().getN2() > 10 ||
                  aluno.getNotas().getN3() < 0 || aluno.getNotas().getN3() > 10 ||
                  aluno.getNotas().getN4() < 0 || aluno.getNotas().getN4() > 10){
            erro = "Notas devem estar entre 0 e 10!";
        } else if(aluno.getDatanasc().isAfter(java.time.LocalDate.now())){
            erro = "Data de nascimento não pode ser futura!";
        } else if(aluno.getNome() == null || aluno.getNome().trim().isEmpty()){
            erro = "Nome obrigatório!";
        }

        return erro; // retorna null se não houver erro
    }
}
