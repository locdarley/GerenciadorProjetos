<%@page import="java.util.ArrayList"%>
<%@page import="apoio.Projeto"%>
<%@page import="apoio.Requisito"%>
<%@page import="dao.ProjetoDAO"%>
<%@page import="dao.RequisitoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes do Projeto</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .modal-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 800px; 
            text-align: center;
        }

        .modal-container h2 {
            font-size: 24px;
            color: #333;
        }

        .fecharModal, .baixarProjeto {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px; 
        }

        .fecharModal {
            background-color: #007bff;
            color: #fff;
        }

        .baixarProjeto {
            background-color: #28a745; 
            color: #fff;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            margin-bottom: 20px; 
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<%
    int projetoId = Integer.parseInt(request.getParameter("id"));
    ProjetoDAO projetoDAO = new ProjetoDAO();
    Projeto projeto = projetoDAO.getID(projetoId);

    RequisitoDAO requisitoDAO = new RequisitoDAO();
    ArrayList<Requisito> listaRequisitos = requisitoDAO.consultarRequisitosPorProjeto(projetoId);
%>

<div class="modal-container">
    <h2>Detalhes do Projeto</h2>
    <table>
        <tr>
            <th>ID</th>
            <td><%= projeto.getId()%></td>
        </tr>
        <tr>
            <th>Nome do Projeto</th>
            <td><%= projeto.getNome()%></td>
        </tr>
        <tr>
            <th>Descrição</th>
            <td><%= projeto.getDescricao()%></td>
        </tr>
        <tr>
            <th>Data de Início</th>
            <td><%= projeto.getDataInicio()%></td>
        </tr>
        <tr>
            <th>Responsável</th>
            <td><%= projeto.getResponsavel()%></td>
        </tr>
    </table>

    <!-- Tabela de Requisitos -->
    <table>
        <h2>Lista de Requisitos</h2>
        <thead>
        <tr>
            <th>ID do Requisito</th>
            <th>Nome do Requisito</th>
            <th>Descrição</th>
            <th>Prioridade</th>
            <th>Complexidade</th>
            
        </tr>
        </thead>
        <tbody>
        <% for (Requisito requisito : listaRequisitos) { %>
            <tr>
                <td><%= requisito.getId() %></td>
                <td><%= requisito.getNome() %></td>
                <td><%= requisito.getDescricao() %></td>
                <td><%= requisito.getPrioridade() %></td>
                <td><%= requisito.getComplexidade() %></td>
                
            </tr>
        <% } %>
        </tbody>
    </table>

    <!-- Botões -->
    <button onclick="fecharModal()" class="fecharModal">Fechar</button>
    <button onclick="baixarProjeto()" class="baixarProjeto">Baixar Projeto</button>

</div>

<script>
    function fecharModal() {
        window.location.href = 'consulta-projeto.jsp';
    }

    function baixarProjeto() {
        var downloadServletURL = '<%= request.getContextPath() %>/DownloadProjetoServlet?id=<%= projeto.getId() %>';
        window.location.href = downloadServletURL;
    }
</script>

</body>
</html>
