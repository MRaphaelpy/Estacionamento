package org.estacionamento.Atores;

import org.estacionamento.AbstractClass.Account;

import org.estacionamento.Pagamento.Pagamento;
import org.estacionamento.Pagamento.PagamentoCartao;
import org.estacionamento.Pagamento.PagamentoDinheiro;

import java.util.Scanner;

public class Atendente extends Account {
    private final Pagamento pagamentos;
    private Scanner leitor = new Scanner(System.in);
    private PagamentoDinheiro pagamentoDinheiro = new PagamentoDinheiro();
    private PagamentoCartao pagamentoCartao = new PagamentoCartao();

    public Atendente(String usuario, String senha) {
        super(usuario, senha);
        this.pagamentos = new Pagamento();

    }

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
                if (pagamentoDinheiro.realizarPagamentoDinheiro(valorTotal)) {
                    return true;
                } else {
                    System.out.println("Pagamento não realizado totalmente.");
                    return false;
                }

            case "2":
                pagamentoCartao.realizarPagamentoCartao(valorTotal);
                return true;
            case "3":
                System.out.println("Voltando...");
                return false;
            default:
                System.out.println("Opção escolhida não é válida");
                return false;
        }
    }

//    public void atendenteFunc(ArrayList<Cliente> cliente, Portal portal) {
//        boolean continuar = true;
//        while (continuar) {
//            System.out.println("Escolha uma opção:");
//            System.out.println("1 - Ver vagas livres");
//            System.out.println("2 - Sair");
//            System.out.print("Digite sua opção: ");
//            String opcao = leitor.next();
//
//            switch (opcao) {
//                case "1":
//                    mostrarPisos();
//                    break;
//                case "2":
//                    System.out.println("Voltando...");
//                    continuar = false;
//                    break;
//                default:
//                    System.out.println("Opção escolhida não é válida");
//                    break;
//
//            }
//
//
//
//}
//    }

}
