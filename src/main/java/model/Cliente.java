package model;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;
    private String cpf;
    private String endereco;
    private String nascimento;
    private String observacao;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String cpf, String endereco, String nascimento, String observacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.observacao = observacao;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
public String toString() {
    return nome;
}
}