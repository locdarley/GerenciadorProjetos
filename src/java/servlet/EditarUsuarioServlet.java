package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;
import apoio.Usuario;

@WebServlet("/EditarUsuarioServlet")
public class EditarUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        String nivelAcesso = request.getParameter("nivelAcesso");

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setNivelAcesso(nivelAcesso);

        UsuarioDAO dao = new UsuarioDAO();
        dao.editarUsuario(usuario);

        response.sendRedirect("consulta-usuario.jsp");
    }
}
