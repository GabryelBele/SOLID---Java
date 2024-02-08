package OCP.solucao;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class DebitoConta {
	private String numeroTransacao;

	public String getNumeroTransacao() {
		return numeroTransacao;
	}

	public abstract String debitar(BigDecimal valor, String conta);

	public String formatarTransacao() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		numeroTransacao = IntStream.range(0, 15)
				.mapToObj(i -> String.valueOf(chars.charAt(random.nextInt(chars.length()))))
				.collect(Collectors.joining());

		// Número de transação formatado
		return numeroTransacao;
	}
}
