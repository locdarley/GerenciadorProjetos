package dao;

import apoio.ConexaoBD;
import apoio.Usuario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public boolean autenticar(String NomeUsuario, String Senha) {
        try {
            String sql = "SELECT *"
                    + " FROM Usuario "
                    + "WHERE "
                    + "Nomeusuario = '" + NomeUsuario + "'  and "
                    + "senha = '" + Senha + "';";

            System.out.println("SQL: " + sql);

            ResultSet resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultadoQ.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao autenticar usuário: " + e);
            return false;
        }
    }

    public String cadastrarUsuario(String nomeUsuario, String senha, String nivelAcesso) {
        try {
            String sql = "INSERT INTO Usuario (NomeUsuario, Senha, NivelAcesso) VALUES (?, ?, ?)";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql)) {
                stmt.setString(1, nomeUsuario);
                stmt.setString(2, senha);
                stmt.setString(3, nivelAcesso);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    return null; // Cadastro bem-sucedido
                } else {
                    return "Erro ao cadastrar usuário";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public ArrayList<Usuario> consultarUsuario() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            String sql = "SELECT id, NomeUsuario, Senha, NivelAcesso FROM Usuario";

            try (PreparedStatement stmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nomeUsuario = rs.getString("NomeUsuario");
                    String senha = rs.getString("Senha");
                    String nivelAcesso = rs.getString("NivelAcesso");

                    Usuario usuario = new Usuario(id, nomeUsuario, senha, nivelAcesso);
                    listaUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUsuarios;
    }

    public boolean excluirUsuario(int usuarioId) throws SQLException {
        try {
            String sql = "DELETE FROM Usuario WHERE id = ?";
            java.sql.Connection connection = ConexaoBD.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, usuarioId);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario getID(int id) {
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            con = ConexaoBD.getInstance().getConnection();
            String query = "SELECT * FROM Usuario WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNomeUsuario(rs.getString("NomeUsuario"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setNivelAcesso(rs.getString("NivelAcesso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.getInstance().closeConnection(con, ps);
        }

        return usuario;
    }

    public void editarUsuario(Usuario usuario) {
        java.sql.Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexaoBD.getInstance().getConnection();
            String query = "UPDATE Usuario SET NomeUsuario=?, Senha=?, NivelAcesso=? WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNivelAcesso());
            ps.setInt(4, usuario.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
