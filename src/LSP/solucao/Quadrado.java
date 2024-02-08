package LSP.solucao;

public class Quadrado extends Paralelogramo{

	protected Quadrado(int altura, int largura) {
		super(altura, largura);
		 if (getLargura() != getAltura()) {
	            throw new IllegalArgumentException("Os dois lados do quadrado precisam ser iguais");
	        }
	}

}
