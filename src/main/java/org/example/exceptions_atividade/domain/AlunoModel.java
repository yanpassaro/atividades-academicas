package org.example.exceptions_atividade.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {

    private String nome;
    private String endereco;
    private String matricula;

}
