import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MaquinaRefrigerante mr = new MaquinaRefrigerante();
        Compra compra = new Compra();

        int opcao = 0;

        do{
            System.out.println(" ---MAQUINA DE REFRIGERANTE --- ");
            System.out.println(" 1 - inserir credito ");
            System.out.println(" 2 - Comprar refrigerante ");
            System.out.println(" 3 - ver estoque ");
            System.out.println(" 4 - ver credito disponivel");
            System.out.println(" 5 - sair");
            System.out.println(" Selecione a opção : ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    sc.nextLine(); // limpa o buffer pra nao dar erro nos centavos
                    System.out.print("Valor da moeda: ");
                    System.out.println("valores : 0.10 0.25 0.50 e 1 real");
                    String entrada = sc.nextLine().replace(",", ".");
                    double valor = Double.parseDouble(entrada);
                    mr.receberCredito(valor, compra);
                    break;

                case 2:
                    System.out.println(" escolha o refri:");
                    System.out.println("1 - Coca R$ 6");
                    System.out.println("2 - Guaraná R$ 5.50");
                    System.out.println("3 - Fanta R$ 5");
                    System.out.println("4 - Sprite R$ 5.50");
                    System.out.println("5 - Pepsi R$ 5.80");
                    System.out.print(" Opção: ");
                    int escolha = sc.nextInt();

                    mr.comprarPorNumero(escolha, compra);
                    break;

                case 3:
                    mr.verEstoqueRefrigerante();
                    break;

                case 4:
                    System.out.println("credito atual : " + compra.getCredito());
                    break;

                case 5:
                    System.out.println("Aé logo....");
                    break;

                default:
                    System.out.println("opc inválida");
            }

        }while(opcao != 5);

        sc.close();

    }
}