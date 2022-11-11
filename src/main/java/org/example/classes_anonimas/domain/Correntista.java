package org.example.classes_anonimas.domain;

public class Correntista {
    private String nome;
    private ContaCorrente contaCorrente;

    public Correntista(String nome, ContaCorrente contaCorrente) {
        this.nome = nome;
        this.contaCorrente = contaCorrente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
