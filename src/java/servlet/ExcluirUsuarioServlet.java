package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

@WebServlet("/ExcluirUsuarioServlet")
public class ExcluirUsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                boolean excluidoComSucesso = usuarioDAO.excluirUsuario(id);

                if (excluidoComSucesso) {
                    response.sendRedirect("consulta-usuario.jsp");
                } else {
                    response.sendRedirect("erro.jsp?erro=Erro ao excluir usuário");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("erro.jsp?erro=ID inválido");
            } catch (SQLException e) {
                response.sendRedirect("erro.jsp?erro=Erro ao acessar o banco de dados");
            }
        } else {
            response.sendRedirect("erro.jsp?erro=ID não fornecido");
        }
    }
}
