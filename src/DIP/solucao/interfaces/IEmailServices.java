package DIP.solucao.interfaces;

public interface IEmailServices {

	boolean isValid(String email);
	void enviar(String de, String para, String assunto, String mensagem);
}
