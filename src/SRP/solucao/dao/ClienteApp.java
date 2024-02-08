package SRP.solucao.dao;

import java.util.Date;

import SRP.solucao.domain.Cliente;
import SRP.solucao.services.ClienteService;
import SRP.solucao.services.EmailService;

public class ClienteApp {

    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Fulano");
        cliente.setEmail("fulano@gmail.com");
        cliente.setCpf("12345678901");
        cliente.setDataCadastro(new Date());

        // Serviço de Cliente
        ClienteService clienteService = new ClienteService();
        String resultadoCadastro = clienteService.adicionarCliente(cliente);

        // Serviço de E-mail
        EmailService emailService = new EmailService();
        String resultadoEmail = emailService.enviarEmail(cliente.getEmail(), "Bem Vindo.", "Parabéns! Você está cadastrado.");

        // Exibindo resultados
        System.out.println(resultadoCadastro);
        System.out.println(resultadoEmail);
    }
}
