<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Alunos Cadastrados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #4facfe, #00f2fe);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            width: 500px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }
        h1 { text-align: center; margin-bottom: 20px; }
        hr { margin: 10px 0; }
        a.btn {
            display: inline-block;
            padding: 8px 15px;
            margin: 5px 0;
            background: #4facfe;
            color: white;
            border-radius: 5px;
            text-decoration: none;
        }
        a.btn:hover { background: #00f2fe; }
    </style>
</head>
<body>
<div class="container">
    <h1>Alunos Cadastrados</h1>

    <#if alunos?? && (alunos?size > 0)>
        <#list alunos as aluno>
            Nome: ${aluno.nome} <br>
            CPF: ${aluno.cpf} <br>
            <#if aluno.notas.n1??>
                Notas:Notas: ${aluno.notas.n1}, ${aluno.notas.n2}, ${aluno.notas.n3}, ${aluno.notas.n4} <br>
                Média: ${aluno.media} <br>
               <a class="btn" href="/editar/${aluno.cpf}">Editar</a>
               <a class="btn" href="/excluir/${aluno.cpf}">Excluir</a>
 <br>
            <#else>
                Notas: Sem notas <br>
            </#if>
        </#list>
    <#else>
        Nenhum aluno cadastrado ainda. <a href="/cadastro" class="btn">Cadastre o primeiro!</a>
    </#if>
    <br><a href="/" class="btn">Voltar para Home</a>

</div>
</body>
</html>
