<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Aluno</title>
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
        input, button {
            width: 95%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }
        button {
            background: #4facfe;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover { background: #00f2fe; }
    </style>
</head>
<body>
<div class="container">
    <h1>Editar Aluno</h1>

    <form method="post" action="/aluno/editar/${aluno.cpf}">
        <label>Nome:</label>
        <input type="text"  id="nome" name="nome" value="${aluno.nome!}" required>

        <label>Data de Nascimento:</label>
        <input type="date" id="datanasc" name="datanasc" value="${aluno.datanasc!}" required>

        <label>Email:</label>
        <input type="email" id="email" name="email" value="${aluno.email!}" required>

        <label>CPF:</label>
        <input type="text" name="cpf" value="${aluno.cpf!}" required readonly>

        <label>Notas (N1, N2, N3, N4):</label>
       <input type="text" id="nota1" name="nota1" value="${aluno.notas.n1!}">
       <input type="text" id="nota2" name="nota2" value="${aluno.notas.n2!}">
       <input type="text" id="nota3" name="nota3" value="${aluno.notas.n3!}">
       <input type="text" id="nota4" name="nota4" value="${aluno.notas.n4!}">

        <button type="submit">Salvar Alterações</button>
    </form>
    <br>
    <a href="/listar">Voltar à Lista</a>
</div>
</body>
</html>
