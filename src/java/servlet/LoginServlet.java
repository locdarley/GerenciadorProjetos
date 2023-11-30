package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeusuario = request.getParameter("nomeusuario");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean autenticado = usuarioDAO.autenticar(nomeusuario, senha);

        if (autenticado) {
            response.sendRedirect("menu.jsp");
        } else {
            response.sendRedirect("login.jsp?erro=1");
        }
    }
}
