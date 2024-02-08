package DIP.violacao;

public class ClienteService {

	public String adicionarCliente(Cliente cliente) {
		if (!cliente.isValid())
			return "Dados inválidos";

		ClienteRepository repo = new ClienteRepository();
		repo.adicionarCliente(cliente);

		EmailServices.enviar("empresa@empresa.com", cliente.getEmail(), "Bem Vindo", "Parabéns está Cadastrado");

		return "Cliente cadastrado com sucesso";
	}
}
