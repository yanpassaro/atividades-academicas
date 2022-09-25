package org.example.exceptions_atividade.dao;

import org.example.exceptions_atividade.domain.AlunoModel;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final List<AlunoModel> alunos;

    public AlunoDAO() {
        this.alunos = new ArrayList<>();
    }

    public void salvar(AlunoModel aluno) {
        alunos.add(aluno);
    }

    List<AlunoModel> listarAlunos() {
        return alunos;
    }

    public boolean existsAluno(AlunoModel aluno) {
        return listarAlunos().stream().anyMatch(a -> a.getMatricula().equals(aluno.getMatricula()));
    }

}
