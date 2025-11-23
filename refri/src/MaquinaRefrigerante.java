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
        compra.adicionarCredito(valor);
        saldoMaquina += valor;
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



}
