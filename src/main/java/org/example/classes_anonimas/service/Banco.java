package org.example.classes_anonimas.service;

import org.example.classes_anonimas.domain.ContaCorrente;
import org.example.classes_anonimas.domain.Correntista;
import org.example.classes_anonimas.domain.Credito;
import org.example.classes_anonimas.domain.Debito;

public class Banco {
    Correntista conta1;
    Correntista conta2;
    Correntista conta3;

    public Banco(String correntista1, ContaCorrente co1, String correntista2, ContaCorrente co2, String correntista3, ContaCorrente co3) {
        conta1 = new Correntista(correntista1, co1);
        conta2 = new Correntista(correntista2, co2);
        conta3 = new Correntista(correntista3, co3);
    }

    public Correntista getCorrentista(String nome) {
        if (conta1.getNome().equals(nome)) {
            return conta1;
        }
        if (conta2.getNome().equals(nome)) {
            return conta2;
        }
        if (conta3.getNome().equals(nome)) {
            return conta3;
        }
        return null;
    }

    public void debitar(String nomeCorrentista, double valor) {
        Debito d = new Debito(valor);
        getCorrentista(nomeCorrentista).getContaCorrente().executarOperacao(d);
    }

    public void creditar(String nomeCorrentista, double valor) {
        Credito c = new Credito(valor);
        getCorrentista(nomeCorrentista).getContaCorrente().executarOperacao(c);
    }

    public double getSaldo(String nomeCorrentista) {
        return getCorrentista(nomeCorrentista).getContaCorrente().getSaldoAtual();
    }

    public void transferir(String nomeCorrentistaOrigem, String nomeCorrentistaDestino, double valor) {
        debitar(nomeCorrentistaOrigem, valor);
        creditar(nomeCorrentistaDestino, valor);
    }

}
