package org.example;

import org.example.exceptions_atividade.bo.AlunoBO;
import org.example.exceptions_atividade.domain.AlunoModel;
import org.example.exceptions_atividade.exceptions.AlunoExistException;

public class Main {
    public static void main(String[] args) {
        AlunoBO alunoBO = new AlunoBO();
        AlunoModel aluno = new AlunoModel("Yan", "Rua Bela Vista", "123");
        AlunoModel aluno1 = new AlunoModel("Yan", "Rua Bela Vista", "123");
        try {
            alunoBO.salvar(aluno);
        } catch (AlunoExistException a) {
            System.out.println(a.getMessage());
        }
        try {
            alunoBO.salvar(aluno1);
        } catch (AlunoExistException a) {
            System.out.println(a.getMessage());
        }
    }
}
