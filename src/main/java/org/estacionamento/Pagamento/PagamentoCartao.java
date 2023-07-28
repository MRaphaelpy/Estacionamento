package org.estacionamento.Pagamento;

import org.estacionamento.AbstractClass.PagamentoAbstract;

import java.util.Scanner;

public class PagamentoCartao extends Pagamento {

    private Scanner leitor = new Scanner(System.in);

    public void realizarPagamentoCartao(double valorTotal) {
        System.out.println("Pagamento em cartão");

        String numeroCartao = null;
        String nomeTitular = null;
        boolean numeroCartaoValido = false;
        boolean nomeTitularValido = false;

        while (!numeroCartaoValido) {
            try {
                System.out.println("Numero cartao Valido pra teste ;): 5515154508693985");
                System.out.print("Digite o numero do cartão: ");
                numeroCartao = leitor.next();

                if (numeroCartao.matches("\\d{16}")) {
                    numeroCartaoValido = true;
                } else {
                    System.out.println("Digite um número de cartão válido (com 16 dígitos).");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um número de cartão válido (apenas dígitos numéricos).");
                leitor.nextLine(); // Limpar o buffer
            }
        }

        while (!nomeTitularValido) {
            try {
                System.out.print("Digite o nome do titular do cartão: ");
                nomeTitular = leitor.next();
                // Verifica se o nome do titular tem apenas letras (sem números ou caracteres especiais).
                if (nomeTitular.matches("[a-zA-Z]+")) {
                    nomeTitularValido = true;
                } else {
                    System.out.println("Digite um nome válido (apenas letras).");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um nome válido (apenas letras).");
                leitor.nextLine(); // Limpar o buffer
            }
        }

        System.out.println("Pagamento recebido com sucesso!");
    }

}
