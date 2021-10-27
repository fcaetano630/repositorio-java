package Exercicio5;

import java.util.Scanner;

public  class Controle {

    public Controle(){}

    public static int contaPluviometro() {
        System.out.println("Digite quantos pluviometros tem no caminhao");
        Scanner teclado = new Scanner(System.in);
        int entrada = teclado.nextInt();
        return entrada;
    }

    public static String falaTipoCaminhao() {
        System.out.println("Digite o tipo do caminhao: Alfa/Beta/Fim para sair: ");
        Scanner teclado = new Scanner(System.in);
        String entrada = teclado.nextLine();

        return verificaOpcao(entrada);
    }

    private static String verificaOpcao(String entrada) {
        if(entrada.equalsIgnoreCase("Alfa") || entrada.equalsIgnoreCase("Beta") || entrada.equalsIgnoreCase("Fim")) {
            return entrada;
        }
        System.out.println("Digite a opcao correta");
        return falaTipoCaminhao();
    }
}



