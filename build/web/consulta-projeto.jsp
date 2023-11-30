<%@page import="java.util.ArrayList"%>
<%@page import="apoio.Projeto"%>
<%@page import="dao.ProjetoDAO"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Consulta de Projetos</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }

            .cadastro-button {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-bottom: 20px;
            }

            .aplicacao-conteiner {
                background-color: #f4f4f4;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                width: 80%;
                margin: 0 auto;
                text-align: center;
            }

            .aplicacao-conteiner h2 {
                font-size: 24px;
                color: #333;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ccc;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            a {
                text-decoration: none;
                color: #0074D9;
            }

            a:hover {
                text-decoration: underline;
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
            .btn-abrir{
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

            .btn-excluir {
                background-color: #d9534f;
                color: #fff;
                padding: 5px 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .btn-excluir:hover {
                background-color: #c9302c;
            }

            .btn-editar {
                background-color: #0074D9;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
 <div style="display: flex; justify-content: space-between; margin-bottom: 20px;">
    <button class="cadastro-button" onclick="window.location.href = 'cadastro-projeto.jsp'">Cadastrar Projeto</button>
    <div style="margin-left: 10px;"></div> 
    <button class="cadastro-button" onclick="window.location.href = 'cadastro-requisito.jsp'">Cadastrar Requisito</button>
</div>

</div>


        <div class="aplicacao-conteiner">
            <h2>Consulta de Projetos</h2>
            <%
                ArrayList<Projeto> projetos = new ProjetoDAO().consultarProjetos();
            %>
            <h4>Total de cadastros: <%= projetos.size()%></h4>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome do Projeto</th>
                    <th>Descrição</th>
                    <th>Data de Início</th>
                    <th>Responsável</th>
                    <th>Ações</th>
                </tr>
                <%
                    for (int i = 0; i < projetos.size(); i++) {
                        Projeto projeto = projetos.get(i);
                %>
                <tr>
                    <td><%= projeto.getId()%></td>
                    <td><%= projeto.getNome()%></td>
                    <td><%= projeto.getDescricao()%></td>
                    <td><%= projeto.getDataInicio()%></td>
                    <td><%= projeto.getResponsavel()%></td>
                    <td>
                        <button onclick="abrirModal(<%= projeto.getId()%>)" class="btn-abrir">Abrir</button> 
                        <a href="javascript:void(0);" onclick="excluirProjeto(<%= projeto.getId()%>)" class="btn-excluir">Excluir</a>
                        <button onclick="window.location.href = 'editar-projeto.jsp?id=<%= projeto.getId()%>'" class="btn-editar">Editar</button>

                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <div class="menu-button">
                <a href="menu.jsp" class="btn-voltar">Voltar ao Menu</a>
            </div>
        </div>

        <script>
            function excluirProjeto(id) {
                var confirmar = confirm("Tem certeza que deseja excluir este projeto?");
                if (confirmar) {
                    window.location.href = "ExcluirProjetoServlet?id=" + id;
                }
            }
            function abrirModal(id) {
                window.location.href = 'modal-projeto.jsp?id=' + id;
            }
        </script>
    </body>
</html>
