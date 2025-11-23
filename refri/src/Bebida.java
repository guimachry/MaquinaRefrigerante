public abstract class Bebida {
    protected String nome;
    protected double valor;

    public Bebida(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public abstract void info();
}
