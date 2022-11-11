package org.example.classes_anonimas.domain;

public abstract class Operacao {
    protected double valor;

    public Operacao(double valor) {
        this.valor = valor;
    }

    public double operar(double saldo){
        return (saldo);
    }
}
