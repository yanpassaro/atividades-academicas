package org.example.exceptions_atividade.bo;

import org.example.exceptions_atividade.dao.AlunoDAO;
import org.example.exceptions_atividade.domain.AlunoModel;
import org.example.exceptions_atividade.exceptions.AlunoExistException;

public class AlunoBO {

    final AlunoDAO alunoDAO;

    public AlunoBO() {
        this.alunoDAO = new AlunoDAO();
    }

    public void salvar(AlunoModel aluno) throws AlunoExistException {
        if (alunoDAO.existsAluno(aluno)) throw new AlunoExistException();
        alunoDAO.salvar(aluno);
        System.out.println("Aluno foi cadastrado!");
    }

}
