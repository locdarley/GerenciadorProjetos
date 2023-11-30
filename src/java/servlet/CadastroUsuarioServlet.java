package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = {"/CadastroUsuarioServlet"})
public class CadastroUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        String nivelAcesso = request.getParameter("nivelAcesso");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String resultadoCadastro = usuarioDAO.cadastrarUsuario(nomeUsuario, senha, nivelAcesso);

        if (resultadoCadastro == null) {

            response.sendRedirect("sucesso.jsp");
        } else {

            response.sendRedirect("cadastro.jsp?erro=" + resultadoCadastro);
        }
    }
}
