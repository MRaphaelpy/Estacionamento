package org.estacionamento.Pagamento;

import org.estacionamento.AbstractClass.PagamentoAbstract;
import org.estacionamento.Atores.Cliente;
import org.estacionamento.Estacionamento.TaxasEstacionamento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pagamento extends PagamentoAbstract{

    private Scanner scanner = new Scanner(System.in);

    public double precoTicket(Cliente cliente) {
        int horasEstacionado = solicitarHorasEstacionado();
        if (horasEstacionado > 0) {
            double valorTotal = TaxasEstacionamento.calcularValorEstacionamento(horasEstacionado);
            System.out.println("Valor total: " + valorTotal);
            return valorTotal;
        } else {
            System.out.println("Valor total: 0.0");
            return 0.0;
        }
    }

    private int solicitarHorasEstacionado() {
        int horasEstacionado = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite o tempo de estacionamento em horas: ");
                horasEstacionado = scanner.nextInt();
                if (horasEstacionado >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Digite um valor válido (maior ou igual a zero).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor válido (número inteiro).");
                scanner.nextLine();
            }
        }

        return horasEstacionado;
    }
}
