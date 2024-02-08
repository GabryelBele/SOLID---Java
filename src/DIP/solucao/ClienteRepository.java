package DIP.solucao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DIP.solucao.interfaces.IClienteRepository;

public class ClienteRepository implements IClienteRepository {
	
    @Override
    public void adicionarCliente(Cliente cliente) {
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
        }
    }
}
