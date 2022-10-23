package org.example.jdbc_atividade;

import lombok.extern.log4j.Log4j2;
import org.example.jdbc_atividade.domain.Carro;
import org.example.jdbc_atividade.service.CarroService;

@Log4j2
public class CarroApplication {
    public static void main(String[] args) {
        CarroService carroService = new CarroService();
        log.info(carroService.selectCarroById(1L));
        for (Carro carro : carroService.selectAllCarros()) {
            log.info(carro);
        }
        Carro carro = Carro.builder().nome("Camaro").cor("Azul").modelo("Flex").marca("Chevrolet").build();
        carroService.insertCarro(carro);
        carroService.deleteCarro(12L);
        carroService.updateCarro(carro, 11L);
        carroService.existByNome("Chevet");
    }
}

