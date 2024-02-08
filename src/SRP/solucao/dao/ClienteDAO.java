package SRP.solucao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import SRP.solucao.domain.Cliente;

public class ClienteDAO {
    public String adicionarCliente(Cliente cliente) {
        if (!validarEmail(cliente.getEmail()))
            return "Cliente com e-mail inválido";

        if (!validarCPF(cliente.getCpf()))
            return "Cliente com CPF inválido";

        try (Connection connection = DriverManager.getConnection("MinhaConnectionString", "user", "password")) {
            String sql = "INSERT INTO CLIENTE (NOME, EMAIL, CPF, DATACADASTRO) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, cliente.getNome());
                statement.setString(2, cliente.getEmail());
                statement.setString(3, cliente.getCpf());
                statement.setDate(4, new java.sql.Date(cliente.getDataCadastro().getTime()));

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar cliente";
        }

        return "Cliente cadastrado com sucesso!";
    }

    private boolean validarEmail(String email) {
        // Lógica de validação do e-mail
        return email.contains("@");
    }

    private boolean validarCPF(String cpf) {
        // Lógica de validação do CPF
        return cpf.length() == 11;
    }
}
