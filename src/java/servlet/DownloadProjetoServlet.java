package servlet;

import apoio.Projeto;
import apoio.Requisito;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ProjetoDAO;
import dao.RequisitoDAO;
import java.util.ArrayList;

@WebServlet("/DownloadProjetoServlet")
public class DownloadProjetoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=projeto.pdf");

        int projetoId = Integer.parseInt(request.getParameter("id"));

        Projeto projeto = obterDetalhesDoProjeto(projetoId);

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            document.add(new Paragraph("Detalhes do Projeto"));
            document.add(new Paragraph("ID: " + projeto.getId()));
            document.add(new Paragraph("Nome do Projeto: " + projeto.getNome()));
            document.add(new Paragraph("Descrição: " + projeto.getDescricao()));
            document.add(new Paragraph("Data de Início: " + projeto.getDataInicio()));
            document.add(new Paragraph("Responsável: " + projeto.getResponsavel()));

            document.add(new Paragraph("\nLista de Requisitos"));
            for (Requisito requisito : obterRequisitosDoProjeto(projetoId)) {
                document.add(new Paragraph("ID do Requisito: " + requisito.getId()));
                document.add(new Paragraph("Nome do Requisito: " + requisito.getNome()));
                document.add(new Paragraph("Descrição: " + requisito.getDescricao()));
                document.add(new Paragraph("Prioridade: " + requisito.getPrioridade()));
                document.add(new Paragraph("Complexidade: " + requisito.getComplexidade()));
                document.add(new Paragraph("\n"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    private Projeto obterDetalhesDoProjeto(int projetoId) {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        return projetoDAO.getID(projetoId);
    }

    private ArrayList<Requisito> obterRequisitosDoProjeto(int projetoId) {
        RequisitoDAO requisitoDAO = new RequisitoDAO();
        return requisitoDAO.consultarRequisitosPorProjeto(projetoId);
    }
}
