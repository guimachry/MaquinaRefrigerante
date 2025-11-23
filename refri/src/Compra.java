public class Compra {
    private double credito = 0;

    public void adicionarCredito(double valor){
        credito += valor;
    }
    public double getCredito(){
        return credito;
    }

    public void descontarCredito(double valor){
        credito -= valor;
    }
    public double devolverTroco(){
    double t = credito;
    credito = 0;
    return t;
    }
}
