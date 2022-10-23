package org.example.jdbc_atividade.config;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class MySQLConnector {

    public Connection getConnetion() {
        String user = "root";
        String pass = "Admin#local5";
        String url = "jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true";
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            log.error("Erro: erro ao conectar ao banco de dados!");
        }
        return null;
    }

    public void closeConnetion() {
        try {
            getConnetion().close();
        } catch (SQLException e) {
            log.error("Erro: Conexão não pode ser fechada!");
        }
    }
}