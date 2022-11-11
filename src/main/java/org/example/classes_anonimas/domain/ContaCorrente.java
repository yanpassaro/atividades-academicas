package org.example.classes_anonimas.domain;

public class ContaCorrente {
    private double valor = 0d;
    private double saldo;

    public ContaCorrente() {
    }

    public void executarOperacao(Operacao opr){
        saldo=this.saldo+(opr.operar(valor));
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoAtual() {
        return saldo;
    }
}
