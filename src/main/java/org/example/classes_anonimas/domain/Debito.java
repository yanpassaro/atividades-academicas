package org.example.classes_anonimas.domain;

public class Debito extends Operacao{
    public Debito(double valor) {
        super(valor);
    }

    @Override
    public double operar(double saldo) {
        return super.operar(saldo-valor);
    }
}
