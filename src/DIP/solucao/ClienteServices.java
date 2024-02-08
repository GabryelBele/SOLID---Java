package DIP.solucao;

import DIP.solucao.interfaces.IClienteRepository;
import DIP.solucao.interfaces.IClienteService;
import DIP.solucao.interfaces.IEmailServices;

public class ClienteServices implements IClienteService {

	private final IEmailServices emailServices;
	private final IClienteRepository clienteRepository;

	public ClienteServices(IEmailServices emailServices, IClienteRepository clienteRepository) {
		this.emailServices = emailServices;
		this.clienteRepository = clienteRepository;
	}

	@Override
	public String adicionarCliente(Cliente cliente) {
		if (!cliente.isValid()) {
			return "Dados inválidos";
		}

		clienteRepository.adicionarCliente(cliente);

		emailServices.enviar("empresa@empresa.com", cliente.getEmail(), "Bem Vindo", "Parabéns está Cadastrado");

		return "Cliente cadastrado com sucesso";
	}
}
