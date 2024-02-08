package DIP.solucao;

import java.util.Date;

import DIP.solucao.interfaces.ICpfServices;
import DIP.solucao.interfaces.IEmailServices;

public class Cliente {
	private int clienteId;
	private String nome;
	private String email;
	private String cpf;
	private Date dataCadastro;
	
	private final IEmailServices emailServices;
	private final ICpfServices cpfServices;
	
	public Cliente(IEmailServices emailServices, ICpfServices cpfServices) {
        this.emailServices = emailServices;
        this.cpfServices = cpfServices;
    }
	

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

	public boolean isValid() {
		return emailServices.isValid(email) && cpfServices.isValid(cpf);
	}
}
