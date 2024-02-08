package SRP.violacao;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Cliente {
    private int clienteId;
    private String nome;
    private String email;
    private String cpf;
    private Date dataCadastro;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String adicionarCliente() {
        if (!email.contains("@"))
            return "Cliente com e-mail inválido";

        if (cpf.length() != 11)
            return "Cliente com CPF inválido";

        try (Connection connection = DriverManager.getConnection("MinhaConnectionString", "user", "password")) {
            String sql = "INSERT INTO CLIENTE (NOME, EMAIL, CPF, DATACADASTRO) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.setString(2, email);
                statement.setString(3, cpf);
                statement.setDate(4, new java.sql.Date(dataCadastro.getTime()));

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar cliente";
        }

        String from = "empresa@empresa.com";
        String to = email;
        String host = "smtp.google.com";

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("your_username", "your_password");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Bem Vindo.");
            message.setText("Parabéns! Você está cadastrado.");

            Transport.send(message);

            return "Cliente cadastrado com sucesso!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        Cliente cliente = new Cliente();
        cliente.setNome("Fulano");
        cliente.setEmail("fulano@gmail.com");
        cliente.setCpf("12345678901");
        cliente.setDataCadastro(new Date());

        String resultado = cliente.adicionarCliente();
        System.out.println(resultado);
    }
}
