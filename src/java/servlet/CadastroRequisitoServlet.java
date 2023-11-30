package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RequisitoDAO;

@WebServlet("/CadastroRequisitoServlet")
public class CadastroRequisitoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String prioridade = request.getParameter("prioridade");
        String complexidade = request.getParameter("complexidade");
        int projetoId = Integer.parseInt(request.getParameter("projetoId"));

        String mensagemCadastro = new RequisitoDAO().cadastrarRequisito(nome, descricao, prioridade, complexidade, projetoId);

        if (mensagemCadastro == null) {

            response.sendRedirect("sucesso.jsp");
        } else {

            response.getWriter().print(mensagemCadastro);
        }
    }
}
