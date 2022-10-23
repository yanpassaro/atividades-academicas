package org.example.jdbc_atividade.service;

import lombok.extern.log4j.Log4j2;
import org.example.jdbc_atividade.domain.Carro;
import org.example.jdbc_atividade.repository.CarroRepository;

import java.util.List;

@Log4j2
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService() {
        this.carroRepository = new CarroRepository();
    }

    public List<Carro> selectAllCarros() {
        return carroRepository.selectAllCarros();
    }

    public Carro selectCarroById(Long id) {
        if (carroRepository.existeById(id)) {
            return carroRepository.selectCarroById(id);
        } else {
            log.info("Error: Carro id: {} , não existe.", id);
        }
        return null;
    }

    public void insertCarro(Carro carro) {
        if (!carroRepository.existeByNome(carro.getNome())) {
            carroRepository.insertCarro(carro);
        } else {
            log.info("Error: Carro já existe");
        }
    }

    public void updateCarro(Carro carro, Long id) {
        if (carroRepository.existeById(id)) {
            carroRepository.updateCarro(carro, id);
        } else {
            log.info("Error: Carro id: {} , não existe.", id);
        }
    }

    public void deleteCarro(Long id) {
        if (carroRepository.existeById(id)) {
            carroRepository.deleteCarroById(id);
        } else {
            log.info("Error: Carro id: {} , não existe.", id);
        }
    }

    public boolean existByNome(String nome) {
        return carroRepository.existeByNome(nome);
    }
}