package org.example.exceptions_atividade.exceptions;

public class AlunoExistException extends Exception{

    @Override
    public String getMessage() {
        return "Erro: Aluno ja existe!";
    }

}
