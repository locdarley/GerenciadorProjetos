package servlet;

import dao.ProjetoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastroProjetoServlet", urlPatterns = {"/CadastroProjetoServlet"})
public class CadastroProjetoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeProjeto = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String dataInicio = request.getParameter("dataInicio");
        int responsavel = Integer.parseInt(request.getParameter("responsavel"));

        ProjetoDAO projetoDAO = new ProjetoDAO();
        String resultadoCadastro = projetoDAO.cadastrarProjeto(nomeProjeto, descricao, dataInicio, responsavel);

        if (resultadoCadastro == null) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("cadastro-projeto.jsp?erro=" + resultadoCadastro);
        }
    }
}
