package LSP.violacao;

import java.util.Scanner;

public class CalculoArea {

    @SuppressWarnings("resource")
	private static void obterAreaRetangulo(Retangulo ret) {
        System.out.println("Calculo da área do Retangulo");
        System.out.println();
        System.out.println(ret.altura + " * " + ret.largura);
        System.out.println();
        System.out.println(ret.calcularArea());
        new Scanner(System.in).nextLine();
    }

    public static void calcular() {
        Quadrado quad = new Quadrado();
        quad.altura = 10;
        quad.largura = 5;

        obterAreaRetangulo(quad);
    }
}
