import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class MaquinaRefrigerante {

    private Map<String, Bebida> estoqueRefrigerante = new HashMap<>();
    private double saldoMaquina = 10.0;

    public MaquinaRefrigerante(){
        estoqueRefrigerante.put("Coca", new Refrigerante("Coca", 6.00, 20));
        estoqueRefrigerante.put("Guaraná", new Refrigerante("Guaraná", 5.50, 20));
        estoqueRefrigerante.put("Fanta", new Refrigerante("fanta", 5.00, 20));
        estoqueRefrigerante.put("Sprite", new Refrigerante("Sprite", 5.50, 20));
        estoqueRefrigerante.put("Pepsi", new Refrigerante("Pepsi", 5.80, 20));

    }

    public void verEstoqueRefrigerante(){
        System.out.println("Estoque Refrigerante");
        for(Bebida b : estoqueRefrigerante.values()){
            Refrigerante r = (Refrigerante)b;
            System.out.println(r.getNome() + " : " + r.getQuantidade() + " unidade");

        }
    }

    public  void receberCredito(double valor, Compra compra){

        if (valor != 0.10 && valor != 0.25 && valor != 0.50 && valor != 1.00){
            System.out.println("moeda inválida");
            return;
        }

        compra.adicionarCredito(valor);
        saldoMaquina += valor;
        System.out.println("credito inserido com sucesso");
    }

    public void comprar(String nome, Compra compra){
        Bebida b = estoqueRefrigerante.get(nome);
        if(b == null){
            System.out.println("refrigerante nao encontrado");
            return;
        }

        Refrigerante r = (Refrigerante)b;

        if (r.getQuantidade() == 0){
            System.out.println("refrigerante nao encontrado");
            return;
        }

        if (compra.getCredito() < r.getValor()){
            System.out.println("credito insuficiente");
            return;
        }
        r.remover();
        compra.descontarCredito(r.getValor());
        saldoMaquina += r.getValor();

        b.info();

        System.out.println("refrigerante comprado com sucesso");
        System.out.println("troco : " + compra.devolverTroco());
    }

    public void comprarPorNumero(int numero, Compra compra) {

        String nome = null;

        switch (numero) {
            case 1: nome = "Coca"; break;
            case 2: nome = "Guaraná"; break;
            case 3: nome = "Fanta"; break;
            case 4: nome = "Sprite"; break;
            case 5: nome = "Pepsi"; break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        comprar(nome, compra);
    }




}
