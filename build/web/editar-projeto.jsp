<%@page import="java.util.ArrayList"%>
<%@page import="apoio.Projeto"%>
<%@page import="dao.ProjetoDAO"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edição de Projeto</title>
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

        .aplicacao-conteiner .form-group {
            margin-bottom: 10px;
        }

        .aplicacao-conteiner label {
            font-size: 16px;
            color: #555;
            display: block;
        }

        .aplicacao-conteiner input[type="text"],
        .aplicacao-conteiner input[type="date"],
        .aplicacao-conteiner textarea,
        .aplicacao-conteiner select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .aplicacao-conteiner button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .aplicacao-conteiner button[type="submit"]:hover {
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
        <form action="EditarProjetoServlet" method="post" onsubmit="return validarForm()">
            <h1>Edição de Projeto</h1>
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" id="id" name="id" value="${param.id}" readonly>
            </div>
            <div class="form-group">
                <label for="nome">Nome do Projeto:</label>
                <input type="text" id="nome" name="nome" value="${param.nome}" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea id="descricao" name="descricao" rows="4" required>${param.descricao}</textarea>
            </div>
            <div class="form-group">
                <label for="dataInicio">Data de Início:</label>
                <input type="date" id="dataInicio" name="dataInicio" value="${param.dataInicio}" required>
            </div>
            <div class="form-group">
                <label for="responsavel">Responsável:</label>
                <input type="number" id="responsavel" name="responsavel" value="${param.responsavel}" required>
            </div>
            <button type="submit">Salvar Alterações</button>
        </form>
        <div class="menu-button">
            <a href="consulta-projeto.jsp" class="btn-voltar">Voltar à Consulta</a>
        </div>
    </div>
</body>

</html>
