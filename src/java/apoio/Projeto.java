package apoio;

public class Projeto {

    private int id;
    private String nome;
    private String descricao;
    private String dataInicio;
    private int responsavel; // Alterei para int assumindo que responsável é um ID de usuário

    public Projeto(int id, String nome, String descricao, String dataInicio, int responsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.responsavel = responsavel;
    }

    public Projeto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(int responsavel) {
        this.responsavel = responsavel;
    }
}
