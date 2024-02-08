package OCP.solucao;

import java.math.BigDecimal;

public class DebitoContaCorrente extends DebitoConta {
    @Override
    public String debitar(BigDecimal valor, String conta) {
        // Lógica para debitar Conta Corrente
        return formatarTransacao();
    }
}
