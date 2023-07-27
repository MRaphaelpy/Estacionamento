package org.estacionamento.Atores;
import org.estacionamento.Actions.AccountImplementation;
import org.estacionamento.Pagamento.Pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Atendente extends AccountImplementation {
    public Object getUser;
    private final Pagamento pagamentos;
    Scanner leitor = new Scanner(System.in);

    public Atendente(String usuario, String senha) {
        this.username = usuario;
        this.password = senha;
        this.pagamentos = new Pagamento();
    }


    public String getUser() {
        return this.username;
    }

    //
    public boolean receberPagamento(Cliente cliente) {
        double valorTotal = pagamentos.precoTicket(cliente);

        System.out.println("Como deseja pagar ?");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - Voltar");
        System.out.print("Digite sua opção: ");
        String opcao = leitor.next();

        switch (opcao) {
            case "1":
                System.out.println("Pagamento em dinheiro");
                System.out.println("Pagamento recebido com sucesso!");
                return true;
            case "2":
                System.out.println("Pagamento em cartão");
                System.out.println("Digite o numero do cartão: ");
                String numeroCartao = leitor.next();
                System.out.println("Digite o nome do titular do cartão: ");
                String nomeTitular = leitor.next();
                System.out.println("Pagamento recebido com sucesso!");
                return true;
            case "3":
                System.out.println("Voltando...");
                return false;
            default:
                System.out.println("Opção escolhida não é válida");
                return false;
        }
    }
}
