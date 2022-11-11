package org.example.classes_anonimas.domain;

public class Credito extends Operacao{
    public Credito(double valor) {
        super(valor);
    }

    @Override
    public double operar(double saldo) {
        return super.operar(saldo+valor);
    }

}
