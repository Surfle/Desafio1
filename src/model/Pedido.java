package model;

public class Pedido {
    private String descricao;
    private Pessoa pessoa;
    private boolean ativo;

    public Pedido() {
    }

    public Pedido(String descricao, Pessoa pessoa, boolean ativo) {
        this.descricao = descricao;
        this.pessoa = pessoa;
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
