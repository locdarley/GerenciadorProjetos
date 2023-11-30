<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Requisito</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .aplicacao-conteiner {
            background-color: #f4f4f4;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 300px;
            margin: 0 auto;
            text-align: center;
        }

        .aplicacao-conteiner h1 {
            font-size: 24px;
            color: #333;
        }

        .form-group {
            margin-bottom: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        label {
            font-size: 16px;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        textarea,
        input[type="date"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .menu-button {
            margin-top: 20px;
        }

        .btn-voltar {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-voltar:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
    <div class="aplicacao-conteiner">
        <form action="CadastroRequisitoServlet" method="post" onsubmit="return validarForm()">
            <h1>Cadastro de Requisito</h1>
            <div class="form-group">
                <label for="nome">Nome do Requisito:</label>
                <input type="text" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea id="descricao" name="descricao" rows="4" required></textarea>
            </div>
            <div class="form-group">
                <label for="prioridade">Prioridade:</label>
                <select id="prioridade" name="prioridade" required>
                    <option value="Baixa">Baixa</option>
                    <option value="Média">Média</option>
                    <option value="Alta">Alta</option>
                </select>
            </div>
            <div class="form-group">
                <label for="complexidade">Complexidade:</label>
                <select id="complexidade" name="complexidade" required>
                    <option value="Baixa">Baixa</option>
                    <option value="Média">Média</option>
                    <option value="Alta">Alta</option>
                </select>
            </div>
            <div class="form-group">
                <label for="projetoId">ID do Projeto:</label>
                <input type="number" id="projetoId" name="projetoId" required>
            </div>
            <button type="submit">Cadastrar</button>
        </form>
        <div class="menu-button">
            <a href="consulta-projeto.jsp" class="btn-voltar">Voltar</a>
        </div>
    </div>
</body>

</html>
