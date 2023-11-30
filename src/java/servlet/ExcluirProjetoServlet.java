package servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjetoDAO;

@WebServlet("/ExcluirProjetoServlet")
public class ExcluirProjetoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);

                ProjetoDAO projetoDAO = new ProjetoDAO();
                boolean excluidoComSucesso = projetoDAO.excluirProjeto(id);

                if (excluidoComSucesso) {
                    response.sendRedirect("consulta-projeto.jsp");
                } else {
                    response.sendRedirect("erro.jsp?erro=Erro ao excluir projeto");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("erro.jsp?erro=ID inválido");
            }
        } else {
            response.sendRedirect("erro.jsp?erro=ID não fornecido");
        }
    }
}
