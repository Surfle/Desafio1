package model;

import java.util.List;

public class Pessoa {
    private int idade;
    private String nome;

    private List<Endereco> endereco;
    public Pessoa() {
    }

    public Pessoa(int idade, String nome, List<Endereco> endereco) {
        this.idade = idade;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
