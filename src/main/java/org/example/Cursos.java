package org.example;

public class Cursos {

    private int id;
    private String nome;
    private int duracao;

    public Cursos(int id, String nome, int duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public Cursos(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public Cursos() {

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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "{" +
                " id = " + id +
                ", nome = " + nome + '\'' +
                ", duracao = " + duracao +
                '}';
    }
}
