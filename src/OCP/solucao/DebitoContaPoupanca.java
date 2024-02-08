package OCP.solucao;

import java.math.BigDecimal;

public class DebitoContaPoupanca extends DebitoConta {
	@Override
	public String debitar(BigDecimal valor, String conta) {
		// Lógica para debitar Conta Corrente
		return formatarTransacao();
	}
}
