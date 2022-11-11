package org.example.classes_anonimas;

import lombok.extern.log4j.Log4j2;
import org.example.classes_anonimas.service.Banco;
import org.example.classes_anonimas.domain.ContaCorrente;

@Log4j2
public class BancoApp {
    public static void main(String[] args) {
        ContaCorrente contaCorrente1 = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();
        ContaCorrente contaCorrente3 = new ContaCorrente();
        Banco banco = new Banco("Heitor",contaCorrente1,"Yan",contaCorrente2,"Mikhael",contaCorrente3);
        banco.debitar("Heitor",1000);
        banco.creditar("Heitor", 50000);
        banco.transferir("Heitor","Yan",6000);
        log.info(banco.getSaldo("Yan"));
        log.info(banco.getSaldo("Heitor"));
    }
}
