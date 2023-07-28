package org.estacionamento.Pagamento;

import java.util.Scanner;

public class PagamentoDinheiro extends Pagamento {

    private Scanner leitor = new Scanner(System.in);

    public boolean realizarPagamentoDinheiro(double valorTotal) {
        System.out.println("Pagamento em dinheiro");
        System.out.println("Valor total: " + valorTotal);

        double valorRecebido = 0.0;
        boolean valorValido = false;

        while (!valorValido) {
            try {
                System.out.print("Digite o valor recebido: ");
                valorRecebido = leitor.nextDouble();

                if (valorRecebido >= 0.0) {
                    valorValido = true;
                } else {
                    System.out.println("Digite um valor válido (maior ou igual a zero).");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um valor válido (número).");
                leitor.nextLine();
            }
        }

        if (valorRecebido >= valorTotal) {
            double troco = valorRecebido - valorTotal;
            System.out.println("Pagamento recebido com sucesso! Troco: " + troco);
            return true; // Pagamento realizado com sucesso
        } else {
            System.out.println("Valor insuficiente. Pagamento não realizado.");
            return false; // Pagamento não realizado
        }
    }
}
