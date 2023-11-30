<!DOCTYPE html>
<html>
    <head>
        <title>Menu</title>
        <style>
            body {
                font-family: Roboto, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .app-container {
                text-align: center;
                border: 1px solid #ccc;
                border-radius: 10px;
                padding: 20px;
                background-color: #fff;
            }

            .title {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 20px;
            }

            .card-container {
                display: flex;
                justify-content: center;
                align-items: center;
                flex-wrap: wrap;
            }

            .card {
                background-color: #ffffff;
                padding: 30px;
                border-radius: 15px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
                width: 200px;
                height: 200px;
                text-align: center;
                margin: 0 10px 20px;
                cursor: pointer;
                transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-decoration: none;
            }

            .card h2 {
                font-size: 28px;
                color: #333;
                margin-bottom: 10px;
            }

            .card:hover {
                transform: scale(1.05);
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
            }

            .card a {
                text-decoration: none;
                color: #fff;
                display: inline-block;
                background-color: #007bff;
                padding: 10px 20px;
                border-radius: 5px;
            }


            .btn-sair {
                background-color: #d9534f;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                text-decoration: none;
                margin-top: 20px;
            }

            .btn-sair:hover {
                background-color: #c9302c;
            }
        </style>
    </head>
    <body>
        <div class="app-container">
            <div class="title">Gerenciador de Projetos - Administrar Sistema</div>
            <div class="card-container">
                <a href="menu-usuario.jsp" class="card">
                    <h2>Gestão de Usuários</h2>
                </a>
                <a href="consulta-projeto.jsp" class="card">
                    <h2>Gerenciador de Projetos</h2>
                </a>
            </div>
            <a href="login.jsp" class="btn-sair">Sair</a>
        </div>
    </body>
</html>
