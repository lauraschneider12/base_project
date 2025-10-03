package br.edu.ifpr.pgua.eic.tads.models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class Aluno {

    private String nome;
    private LocalDate datanasc;
    private String email;
    private String cpf;
    private Notas notas;


    private static final String ARQUIVO = System.getProperty("user.dir") + File.separator + "alunos.txt";

    public Aluno(String nome, LocalDate datanasc, String email, String cpf, Notas notas) {
        this.nome = nome;
        this.datanasc = datanasc;
        this.email = email;
        this.cpf = cpf;
        this.notas = notas;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public Notas getNotas() { return notas; }
    public LocalDate getDatanasc(){ return datanasc;}
    public String getEmail(){ return email;}

    public Double getMedia(){
         Double media = (notas.getN1()+ notas.getN2()+notas.getN3()+notas.getN4())/4;
         return media;
    }

    @Override
    public String toString() {
        return nome + "$" + datanasc + "$" + email + "$" + cpf + "$" + (notas != null ? notas.toString() : "Sem notas");
    }

  public void salvarArquivo() {
    try {
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Arquivo criado: " + ARQUIVO);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(this.toString());
            bw.newLine();
            System.out.println("Aluno salvo: " + this.toString());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  public static ArrayList<Aluno> recuperarAlunos() {
    ArrayList<Aluno> alunos = new ArrayList<>();
    File file = new File(ARQUIVO);
    if (!file.exists()) {
        System.out.println("Arquivo não existe: " + ARQUIVO);
        return alunos;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String linha;
        while ((linha = br.readLine()) != null) {
            System.out.println("Linha lida: " + linha);
            String[] partes = linha.split("\\$");
            if (partes.length >= 5) {
                String nome = partes[0];
                LocalDate datanasc = LocalDate.parse(partes[1]);
                String email = partes[2];
                String cpf = partes[3];
                Notas notas = "Sem notas".equals(partes[4]) ? null : Notas.fromString(partes[4]);
                alunos.add(new Aluno(nome, datanasc, email, cpf, notas));
                System.out.println(cpf);
            } else {
                System.out.println("Linha inválida: " + linha);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Total de alunos recuperados: " + alunos.size());
    return alunos;
}
    public static void salvarTodos(ArrayList<Aluno> alunos){
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO,false))){
        for(Aluno a: alunos){
            bw.write(a.toString());
            bw.newLine();
        }
    } catch(Exception e){ e.printStackTrace(); }
}

public static boolean excluirAluno(String cpf){
    ArrayList<Aluno> alunos = recuperarAlunos();
    boolean ok = alunos.removeIf(a -> a.getCpf().equals(cpf));
    if(ok) salvarTodos(alunos);
    return ok;
}

public static boolean editarAluno(String cpfAntigo, Aluno novo){
    ArrayList<Aluno> alunos = recuperarAlunos();
    for(int i=0; i<alunos.size(); i++){
        if(alunos.get(i).getCpf().equals(cpfAntigo)){
            alunos.set(i, novo);
            salvarTodos(alunos);
            return true;
        }
    }
    return false;
}

public static Aluno buscarPorCpf(String cpf) {
    ArrayList<Aluno> alunos = recuperarAlunos(); 
    for(Aluno a : alunos) {
        if(a.getCpf().equals(cpf)) {
            return a; 
        }
    }
    return null;
}

}