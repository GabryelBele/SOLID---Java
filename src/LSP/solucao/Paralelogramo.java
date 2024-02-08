package LSP.solucao;

public abstract class Paralelogramo {

    protected Paralelogramo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    private double altura;
    private double largura;

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getArea() {
        return altura * largura;
    }
}
