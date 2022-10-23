package org.example.jdbc_atividade.repository;

import lombok.extern.log4j.Log4j2;
import org.example.jdbc_atividade.config.MySQLConnector;
import org.example.jdbc_atividade.domain.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CarroRepository {

    private final MySQLConnector connector;
    private Carro carro;

    public CarroRepository() {
        this.connector = new MySQLConnector();
    }

    public List<Carro> selectAllCarros() {
        log.info("Executando: selectAllCarros()");
        List<Carro> carros = new ArrayList<>();
        String script = "SELECT * FROM carros;";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script);
             ResultSet resultSet = myStmt.executeQuery()) {

            while (resultSet.next()) {
                carro = Carro.builder()
                        .cor(resultSet.getString("cor"))
                        .nome(resultSet.getString("nome"))
                        .modelo(resultSet.getString("modelo"))
                        .marca(resultSet.getString("marca"))
                        .build();
                carros.add(carro);
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'selectAllCarros()'");
        } finally {
            connector.closeConnetion();
        }
        return carros;
    }

    public Carro selectCarroById(Long id) {
        log.info("Executando: selectCarroById({})", id);
        String script = "SELECT * FROM carros WHERE id = ?;";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script)) {

            myStmt.setLong(1, id);
            ResultSet result = myStmt.executeQuery();

            if (result.next()) {
                log.info("Result: Selecionado com sucesso.");
                carro = Carro.builder()
                        .cor(result.getString("cor"))
                        .nome(result.getString("nome"))
                        .modelo(result.getString("modelo"))
                        .marca(result.getString("marca"))
                        .build();
            } else {
                log.info("Result: Carro id: '{}', não existe.", id);
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'getCarroById().'");
        } finally {
            connector.closeConnetion();
        }
        return carro;
    }

    public void insertCarro(Carro carro) {
        log.info("Executando: insertCarro({}).", carro);
        String script = "INSERT INTO carros (nome, cor, modelo, marca) VALUES (?, ?, ?, ?);";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script)) {

            myStmt.setString(1, carro.getNome());
            myStmt.setString(2, carro.getCor());
            myStmt.setString(3, carro.getModelo());
            myStmt.setString(4, carro.getMarca());

            int rowAffects = myStmt.executeUpdate();
            if (rowAffects > 0) {
                log.info("Result: Inserido com sucesso.");
            } else {
                log.info("Result: Não foi possivel inserir ao banco.");
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'insertCarro()'");
        } finally {
            connector.closeConnetion();
        }
    }

    public void deleteCarroById(Long id) {
        log.info("Executando: deleteCarroByID({})", id);
        String script = "DELETE FROM carros WHERE id = ?;";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script)) {

            myStmt.setLong(1, id);
            int rowAffects = myStmt.executeUpdate();

            if (rowAffects > 0) {
                log.info("Result: Deletado com sucesso!");
            } else {
                log.info("Result: Não foi possivel deletar o registro de id: {}", id);
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'insertCarro()'");
        } finally {
            connector.closeConnetion();
        }
    }

    public void updateCarro(Carro carro, Long id) {
        log.info("Executando: updateCarro({},id = {}).", carro, id);
        String script = "UPDATE carros SET nome = ?, cor = ?, modelo = ?, marca = ? WHERE id = ?;";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script)) {

            myStmt.setString(1, carro.getNome());
            myStmt.setString(2, carro.getCor());
            myStmt.setString(3, carro.getModelo());
            myStmt.setString(4, carro.getMarca());
            myStmt.setLong(5, id);

            int rowAffects = myStmt.executeUpdate();
            if (rowAffects > 0) {
                log.info("Result: Atualizado com sucesso.");
            } else {
                log.info("Result: Não foi possivel atualizar registro.");
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'updateCarro()'");
        } finally {
            connector.closeConnetion();
        }
    }

    public boolean existeById(Long id) {
        log.info("Executando: existByID({}).", id);
        String script = "SELECT * FROM carros WHERE id = ?;";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script)) {

            myStmt.setLong(1, id);

            boolean rowAffects = myStmt.executeQuery().next();
            if (rowAffects) {
                log.info("Result: Carro existe.");
                return true;
            } else {
                log.info("Result: Carro não existe.");
                return false;
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'existById()'");
        } finally {
            connector.closeConnetion();
        }
        return false;
    }

    public boolean existeByNome(String nome) {
        log.info("Executando: existByNome({}).", nome);
        String script = "SELECT * FROM carros WHERE nome = ?;";
        try (PreparedStatement myStmt = connector.getConnetion().prepareStatement(
                script)) {

            myStmt.setString(1, nome);

            boolean rowAffects = myStmt.executeQuery().next();
            if (rowAffects) {
                log.info("Result: Carro existe.");
                return true;
            } else {
                log.info("Result: Carro não existe.");
                return false;
            }

        } catch (SQLException e) {
            log.error("Erro: Erro no método 'existByNome()'");
        } finally {
            connector.closeConnetion();
        }
        return false;
    }

}
