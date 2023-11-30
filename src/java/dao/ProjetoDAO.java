package dao;

import apoio.ConexaoBD;
import apoio.Projeto;
import apoio.Requisito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoDAO {

    public String cadastrarProjeto(String nome, String descricao, String dataInicio, Integer responsavel) {
        try {
            String sql = "INSERT INTO Projeto (Nome, Descricao, DataInicio, Responsavel) VALUES (?, ?, ?, ?)";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setString(3, dataInicio);
                stmt.setInt(4, responsavel);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    return null;
                } else {
                    return "Erro ao cadastrar projeto";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public ArrayList<Projeto> consultarProjetos() {
        ArrayList<Projeto> listaProjetos = new ArrayList<>();

        try {
            String sql = "SELECT id, Nome, Descricao, DataInicio, Responsavel FROM Projeto";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("Nome");
                    String descricao = rs.getString("Descricao");
                    String dataInicio = rs.getString("DataInicio");
                    int responsavel = rs.getInt("Responsavel");

                    Projeto projeto = new Projeto(id, nome, descricao, dataInicio, responsavel);
                    listaProjetos.add(projeto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProjetos;
    }

    public boolean excluirProjeto(int projetoId) {
        try {
            String sql = "DELETE FROM Projeto WHERE id = ?";
            java.sql.Connection connection = ConexaoBD.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, projetoId);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Projeto getID(int id) {
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Projeto projeto = null;

        try {
            con = ConexaoBD.getInstance().getConnection();
            String query = "SELECT * FROM Projeto WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                projeto = new Projeto();
                projeto.setId(rs.getInt("id"));
                projeto.setNome(rs.getString("Nome"));
                projeto.setDescricao(rs.getString("Descricao"));
                projeto.setDataInicio(rs.getString("DataInicio"));
                projeto.setResponsavel(rs.getInt("Responsavel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return projeto;
    }

    public void editarProjeto(Projeto projeto) {
        java.sql.Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexaoBD.getInstance().getConnection();
            String query = "UPDATE Projeto SET Nome=?, Descricao=?, DataInicio=?, Responsavel=? WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getDataInicio());
            ps.setInt(4, projeto.getResponsavel());
            ps.setInt(5, projeto.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public ArrayList<Requisito> consultarRequisitosDoProjeto(int projetoId) {
        ArrayList<Requisito> listaRequisitos = new ArrayList<>();

        try {
            String sql = "SELECT id, Nome, Descricao, Prioridade, Complexidade, ProjetoID FROM Requisito WHERE ProjetoID = ?";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
                stmt.setInt(1, projetoId);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("Nome");
                        String descricao = rs.getString("Descricao");
                        String prioridade = rs.getString("Prioridade");
                        String complexidade = rs.getString("Complexidade");
                        int projetoID = rs.getInt("ProjetoID");

                        Requisito requisito = new Requisito(id, nome, descricao, prioridade, complexidade, projetoID);
                        listaRequisitos.add(requisito);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaRequisitos;
    }

}
