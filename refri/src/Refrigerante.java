public class Refrigerante extends Bebida{

    private int quantidade;

    public Refrigerante(String nome, double valor,int quantidade) {
        super(nome, valor);
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void remover(){
        quantidade--;
    }

    @Override
    public void info() {
        System.out.println("Refrigerante : " + nome + " vale " + valor);
    }
}
