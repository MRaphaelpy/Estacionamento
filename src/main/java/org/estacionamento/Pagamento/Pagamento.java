package org.estacionamento.Pagamento;

import org.estacionamento.Atores.Cliente;
import org.estacionamento.Estacionamento.TaxasEstacionamento;

import java.util.Scanner;

public class Pagamento {

    private Scanner scanner = new Scanner(System.in);

    public double precoTicket(Cliente cliente) {
        System.out.println("Digite o tempo de estacionamento em horas: ");
        int horasEstacionado = scanner.nextInt();
        if (horasEstacionado > 0) {
            double valorTotal = TaxasEstacionamento.calcularValorEstacionamento(horasEstacionado);
            System.out.println("Valor total: " + valorTotal);
            return valorTotal;
        } else {
            System.out.println("Valor total: 0.0");
            return 0.0;
        }
    }

}
