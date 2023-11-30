<%@page import="java.util.ArrayList"%>
<%@page import="apoio.Usuario"%>
<%@page import="dao.UsuarioDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Consulta de Usuários</title>
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
        <div class="aplicacao-conteiner">
            <h2>Consulta de Usuários</h2>
            <%
                ArrayList<Usuario> usuarios = new UsuarioDAO().consultarUsuario();
            %>
            <h4>Total de cadastros: <%= usuarios.size()%></h4>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome de Usuário</th>
                    <th>Senha</th>
                    <th>Nível de Acesso</th>
                    <th>Ações</th>
                </tr>
                <%
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario usuario = usuarios.get(i);
                %>
                <tr>
                    <td><%= usuario.getId()%></td>
                    <td><%= usuario.getNomeUsuario()%></td>
                    <td><%= usuario.getSenha()%></td>
                    <td><%= usuario.getNivelAcesso()%></td>
                    <td>
                        <a href="javascript:void(0);" onclick="excluirUsuario(<%= usuario.getId()%>)" class="btn-excluir">Excluir</a>
                        <button onclick="window.location.href = 'editar-usuario.jsp?id=<%= usuario.getId()%>'" class="btn-editar">Editar</button>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <div class="menu-button">
                <a href="menu-usuario.jsp" class="btn-voltar">Voltar ao Menu</a>
            </div>
        </div>

        <script>
            function excluirUsuario(id) {
                var confirmar = confirm("Tem certeza que deseja excluir este usuário?");
                if (confirmar) {
                    window.location.href = "ExcluirUsuarioServlet?id=" + id;
                }
            }
        </script>

    </body>
</html>