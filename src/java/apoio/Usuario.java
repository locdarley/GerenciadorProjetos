package apoio;

public class Usuario {

    private int id;
    private String nomeUsuario;
    private String senha;
    private String nivelAcesso;

    public Usuario(int id, String nomeUsuario, String senha, String nivelAcesso) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
