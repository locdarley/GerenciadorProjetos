<!DOCTYPE html>
<html>
    <head>
        <title>Sucesso</title>
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

            .container {
                text-align: center;
            }

            .success-container {
                background-color: #f4f4f4;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                width: 60%;
                margin: 0 auto;
                text-align: center;
                position: relative;
            }

            .success-container h2 {
                font-size: 24px;
                color: #333;
                margin-bottom: 20px;
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
                display: inline-block;
                margin-top: 20px;
                text-decoration: none;
            }

            .menu-button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="success-container">
                <h2>Cadastrado Efetuado!</h2>
            </div>

            <a href="menu.jsp" class="menu-button">Voltar ao Menu</a>
        </div>
    </body>
</html>
