
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Aluno</title>
    <style>
/* Reset básico */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
}

/* Fundo da página */
body {
    background: linear-gradient(120deg, #4facfe, #00f2fe);
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}

/* Container central */
.container {
    background: #fff;
    padding: 30px;
    border-radius: 12px;
    width: 420px;
    box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
    text-align: center;
}

/* Título */
.container h1 {
    margin-bottom: 20px;
    color: #333;
}

/* Labels */
form label {
    display: block;
    text-align: left;
    font-weight: bold;
    margin-bottom: 6px;
    color: #555;
}

/* Inputs */
form input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 8px;
    outline: none;
    transition: all 0.2s ease-in-out;
}

form input:focus {
    border-color: #4facfe;
    box-shadow: 0 0 6px rgba(79, 172, 254, 0.5);
}

/* Botões */
.btn, form button {
    display: inline-block;
    padding: 10px 18px;
    background: #4facfe;
    color: #fff;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    font-size: 15px;
    transition: background 0.3s ease;
    text-decoration: none;
}

.btn:hover, form button:hover {
    background: #00c6ff;
}

/* Link voltar */
a.btn {
    margin-top: 15px;
    display: inline-block;
}

    </style>
</head>
<body>
    <div class="container">
        <h1>Cadastro de Aluno</h1>
        <form action ="/alunospro" method = "post">
            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome" required><br><br>

            <label for="email">E-mail:</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="cpf">CPF:</label><br>
            <input type="text" id="cpf" name="cpf" required><br><br>

            <label for="datanasc">Data de Nascimento:</label><br>
            <input type="date" id="datanasc" name="datanasc" required><br><br>

            <h3>Notas:</h3>
            <label for="nota1">Nota 1:</label>
            <input type="number" step="0.10" id="nota1" name="nota1" required><br><br>

            <label for="nota2">Nota 2:</label>
            <input type="number" step="0.10" id="nota2" name="nota2" required><br><br>

            <label for="nota3">Nota 3:</label>
            <input type="number" step="0.10" id="nota3" name="nota3" required><br><br>

            <label for="nota4">Nota 4:</label>
            <input type="number" step="0.10" id="nota4" name="nota4" required><br><br>

            <button type="submit" class="btn">Cadastrar</button>
        </form>
        <br>
        <a href="/" class="btn">Voltar para Home</a>
    </div>
</body>
</html>

