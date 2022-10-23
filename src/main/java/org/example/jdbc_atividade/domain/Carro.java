package org.example.jdbc_atividade.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Carro {

    private String nome;
    private String modelo;
    private String cor;
    private String marca;

    @Override
    public String toString() {
        return "Carro (" +
                " nome = '" + nome + '\'' +
                ", modelo = '" + modelo + '\'' +
                ", cor = '" + cor + '\'' +
                ", marca = '" + marca + '\'' +
                ')';
    }
}