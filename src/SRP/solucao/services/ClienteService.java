package SRP.solucao.services;

import SRP.solucao.dao.ClienteDAO;
import SRP.solucao.domain.Cliente;

public class ClienteService {
    public String adicionarCliente(Cliente cliente) {
    	
        ClienteDAO clienteDAO = new ClienteDAO();
        String resultadoCadastro = clienteDAO.adicionarCliente(cliente);

        EmailService emailService = new EmailService();
        String resultadoEmail = emailService.enviarEmail(cliente.getEmail(), "Bem Vindo.", "Parabéns! Você está cadastrado.");

        return resultadoCadastro + " " + resultadoEmail;
    }
}
