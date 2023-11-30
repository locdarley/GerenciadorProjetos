<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu</title>
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

            .menu-container {
                background-color: #f4f4f4;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                width: 15%;
                margin: 0 auto;
                text-align: center;
                position: relative;
            }

            .menu-container h2 {
                font-size: 24px;
                color: #333;
            }

            ul {
                list-style-type: none;
                padding: 0;
            }

            li {
                margin-bottom: 10px;
            }

            .menu-button {
                background-color: #007bff;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: block;
                margin-bottom: 10px;
            }

            .menu-button:hover {
                background-color: #0056b3;
            }


            .btn-voltar {
                background-color: #007bff;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: block;
                margin: 20px auto;
            }

            .btn-voltar:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="menu-container">
            <h2>Menu</h2>
            <ul>
                <li><a href="cadastro-usuario.jsp" class="menu-button">Cadastrar Usuário</a></li>
                <li><a href="consulta-usuario.jsp" class="menu-button">Consultar Usuários</a></li>
            </ul>
            <button class="btn-voltar" onclick="voltarAoMenu()">Voltar ao Menu Principal</button>
        </div>

        <script>
            function voltarAoMenu() {
                window.location.href = "menu.jsp";
            }
        </script>
    </body>
</html>
