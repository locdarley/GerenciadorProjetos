package dao;

import apoio.ConexaoBD;
import apoio.Requisito;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequisitoDAO {

    public String cadastrarRequisito(String nome, String descricao, String prioridade, String complexidade, int projetoId) {
        try {
            String sql = "INSERT INTO Requisito (Nome, Descricao, Prioridade, Complexidade, ProjetoID) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setString(3, prioridade);
                stmt.setString(4, complexidade);
                stmt.setInt(5, projetoId);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    return null;
                } else {
                    return "Erro ao cadastrar requisito";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public ArrayList<Requisito> consultarRequisitosPorProjeto(int projetoId) {
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
                        int projetoIdDoBanco = rs.getInt("ProjetoID");

                        Requisito requisito = new Requisito(id, nome, descricao, prioridade, complexidade, projetoIdDoBanco);
                        listaRequisitos.add(requisito);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaRequisitos;
    }

    public ArrayList<Requisito> consultarRequisitos() {
        ArrayList<Requisito> listaRequisitos = new ArrayList<>();

        try {
            String sql = "SELECT id, Nome, Descricao, Prioridade, Complexidade, ProjetoID FROM Requisito";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("Nome");
                    String descricao = rs.getString("Descricao");
                    String prioridade = rs.getString("Prioridade");
                    String complexidade = rs.getString("Complexidade");
                    int projetoId = rs.getInt("ProjetoID");

                    Requisito requisito = new Requisito(id, nome, descricao, prioridade, complexidade, projetoId);
                    listaRequisitos.add(requisito);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaRequisitos;
    }

    public boolean excluirRequisito(int requisitoId) {
        try {
            String sql = "DELETE FROM Requisito WHERE id = ?";
            java.sql.Connection connection = ConexaoBD.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, requisitoId);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Requisito getRequisitoById(int id) {
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Requisito requisito = null;

        try {
            con = ConexaoBD.getInstance().getConnection();
            String query = "SELECT * FROM Requisito WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                requisito = new Requisito();
                requisito.setId(rs.getInt("id"));
                requisito.setNome(rs.getString("Nome"));
                requisito.setDescricao(rs.getString("Descricao"));
                requisito.setPrioridade(rs.getString("Prioridade"));
                requisito.setComplexidade(rs.getString("Complexidade"));
                requisito.setProjetoId(rs.getInt("ProjetoID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return requisito;
    }

    public void editarRequisito(Requisito requisito) {
        java.sql.Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexaoBD.getInstance().getConnection();
            String query = "UPDATE Requisito SET Nome=?, Descricao=?, Prioridade=?, Complexidade=?, ProjetoID=? WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, requisito.getNome());
            ps.setString(2, requisito.getDescricao());
            ps.setString(3, requisito.getPrioridade());
            ps.setString(4, requisito.getComplexidade());
            ps.setInt(5, requisito.getProjetoId());
            ps.setInt(6, requisito.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
