package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProjetoDAO;
import apoio.Projeto;

@WebServlet("/EditarProjetoServlet")
public class EditarProjetoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String dataInicio = request.getParameter("dataInicio");
        int responsavel = Integer.parseInt(request.getParameter("responsavel"));

        Projeto projeto = new Projeto();
        projeto.setId(id);
        projeto.setNome(nome);
        projeto.setDescricao(descricao);
        projeto.setDataInicio(dataInicio);
        projeto.setResponsavel(responsavel);

        ProjetoDAO dao = new ProjetoDAO();
        dao.editarProjeto(projeto);

        response.sendRedirect("consulta-projeto.jsp");
    }
}
