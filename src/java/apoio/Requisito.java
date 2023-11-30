package apoio;

public class Requisito {

    private int id;
    private String nome;
    private String descricao;
    private String prioridade;
    private String complexidade;
    private int projetoId; 

    public Requisito(int id, String nome, String descricao, String prioridade, String complexidade, int projetoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.complexidade = complexidade;
        this.projetoId = projetoId;
    }

    public Requisito() {
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }
}
