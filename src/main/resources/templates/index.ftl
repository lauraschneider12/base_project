<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Responsivo para mobile -->
    <title>Home - Cadastro de Alunos</title>
    <style>
        
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
            color: #333;
        }

    
        .container {
            background: white;
            padding: 40px;
            border-radius: 20px; /* Bordas arredondadas */
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2); /* Sombra suave para profundidade */
            text-align: center;
            max-width: 500px;
            width: 100%;
            animation: fadeIn 0.8s ease-in-out; /* Animação de entrada suave */
        }

        /* Título principal: Maior e com cor gradiente */
        h1 {
            font-size: 2.5em;
            background: linear-gradient(135deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            margin-bottom: 20px;
            font-weight: 700;
        }

        /* Parágrafos: Espaçamento e cor suave */
        p {
            font-size: 1.1em;
            line-height: 1.6;
            margin-bottom: 20px;
            color: #555;
        }

        /* Botões (links): Estilo moderno com gradiente e hover animado */
        .btn {
            display: inline-block;
            background: linear-gradient(135deg, #007bff, #0056b3); /* Gradiente azul */
            color: white;
            padding: 15px 30px;
            text-decoration: none;
            border-radius: 50px; /* Super arredondado, como pílula */
            font-size: 1.1em;
            font-weight: 600;
            margin: 10px;
            transition: all 0.3s ease; /* Transição suave para hover */
            box-shadow: 0 5px 15px rgba(0, 123, 255, 0.3); /* Sombra azul */
            border: none;
        }

        /* Hover nos botões: Escala e mudança de cor */
        .btn:hover {
            transform: translateY(-3px); /* Levanta o botão */
            box-shadow: 0 8px 25px rgba(0, 123, 255, 0.4);
            background: linear-gradient(135deg, #0056b3, #004085); /* Azul mais escuro */
        }

        /* Animação de fade-in para o card */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        /* Responsivo: Ajustes para telas pequenas (mobile) */
        @media (max-width: 600px) {
            .container {
                padding: 30px 20px;
                margin: 10px;
            }
            h1 {
                font-size: 2em;
            }
            p {
                font-size: 1em;
            }
            .btn {
                padding: 12px 25px;
                font-size: 1em;
                display: block; /* Empilha botões em mobile */
                margin: 10px auto;
                width: 100%;
                max-width: 300px;
            }
        }

        /* Footer opcional: Adiciona um rodapé sutil */
        .footer {
            margin-top: 30px;
            font-size: 0.9em;
            color: #888;
            border-top: 1px solid #eee;
            padding-top: 15px;
        }
</style>
</head>
<body>
    <div class="container">
        <h1>Bem-vindo à Home!</h1>
        <p>Para cadastrar um aluno, clique no botão abaixo:</p>
        <a href="/cadastro" class="btn">Ir para Cadastro de Aluno</a>
        <br><br>
        <a href="/listar" class="btn">Ver Lista de Alunos</a>

    </div>
</body>
</html>