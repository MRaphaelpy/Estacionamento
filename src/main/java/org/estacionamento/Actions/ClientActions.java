package org.estacionamento.Actions;

import org.estacionamento.Atores.Atendente;
import org.estacionamento.Atores.Cliente;
import org.estacionamento.Atores.Sistema;
import org.estacionamento.Estacionamento.Ticket;
import org.estacionamento.Piso.Pisos;
import org.estacionamento.Veiculos.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ClientActions {
    private ArrayList<Pisos> pisos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentesList;
    private final Sistema sistema;
    private final Scanner leitor = new Scanner(System.in);

    public ClientActions(ArrayList<Pisos> pisos, ArrayList<Atendente> atendentesList, ArrayList<Cliente> clientes) {
        this.pisos = pisos;
        this.clientes = clientes;
        this.atendentesList = atendentesList;
        this.sistema = new Sistema();
    }

    public void clientInit() {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Estacionar");
        System.out.println("2 - Sair");
        System.out.println("3 - Mostrar Vagas Livres em um Piso");
        System.out.println("4 - Voltar");
        System.out.print("Digite sua opção: ");
        int opcao;
        try {
            opcao = leitor.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida. Digite um número válido.");
            leitor.nextLine();
            clientInit();
            return;
        }

        switch (opcao) {
            case 1:
                estacionarVeiculo();
                clientInit();
                break;
            case 2:
                retirarVeiculo();
                clientInit();
                break;
            case 3:
                mostrarPisos();
                clientInit();
                break;
            case 4:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção escolhida não é válida");
                clientInit();
        }
    }

    private void estacionarVeiculo() {
        if (pisos.isEmpty()) {
            System.out.println("\nSem Pisos cadastrados. Não é possível estacionar.");
            return;
        }

        Veiculos veiculo = criarVeiculo();

        if (veiculo == null) {
            return;
        }

        if (this.verifyVehicleExists(clientes, veiculo)) {
            System.out.println("\nVeículo já está estacionado!");
            return;
        }

        System.out.println("\nEm qual piso deseja estacionar?");
        for (int i = 0; i < pisos.size(); i++) {
            System.out.println("Piso " + i);
        }

        int andar = -1;
        try {
            System.out.print("Digite o número do piso: ");
            andar = leitor.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida. Digite um número válido.");
            leitor.nextLine();
        }

        if (andar < 0 || andar >= pisos.size()) {
            System.out.println("Piso inválido!");
        } else {
            Ticket ticket = new Ticket(veiculo, pisos.get(andar));
            Cliente cliente = new Cliente(ticket);
            clientes.add(cliente);
            sistema.adicionarVeiculo(ticket);
            System.out.println("\nVeículo estacionado com sucesso!");
        }
    }

    private boolean verifyVehicleExists(ArrayList<Cliente> clientes, Veiculos novoVeiculo) {
        for (Cliente cliente : clientes) {
            if (cliente.getTicket().getVeiculo().equals(novoVeiculo)) {
                return true;
            }
        }
        return false;
    }

    private Veiculos criarVeiculo() {
        System.out.print("\nInforme a placa do seu Veículo: ");
        String placa = leitor.next();

        System.out.println("\nQual é o seu Veículo?");
        System.out.println("1 - Caminhão");
        System.out.println("2 - Van");
        System.out.println("3 - Carro");
        System.out.println("4 - Carro Elétrico");
        System.out.println("5 - Motocicleta");

        while (true) {
            System.out.print("Digite sua opção: ");
            int opcao;
            try {
                opcao = leitor.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número válido.");
                leitor.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    return new Caminhao(placa);
                case 2:
                    return new Van(placa);
                case 3:
                    return new Carro(placa);
                case 4:
                    return new Eletrico(placa);
                case 5:
                    return new Moto(placa);
                default:
                    System.out.println("Opção escolhida não é válida, tente novamente!");
            }
        }
    }

    private void retirarVeiculo() {
        System.out.println("Quantidade de Atendente: " + atendentesList.size());
        if (atendentesList.isEmpty()) {
            System.out.println("\nPelo visto todos os Atendentes estão Ocupados no Momento!");
            return;
        }

        Cliente cliente = procurarCliente();

        if (cliente != null) {
            System.out.print("Deseja fazer o pagamento agora? 1 Sim 2 Não: ");
            int opcao = leitor.nextInt();
            if (opcao == 1) {
                Random gerador = new Random();
                Atendente atendente = atendentesList.get(gerador.nextInt(atendentesList.size()));
                boolean condition = atendente.receberPagamento(cliente);
                if (condition) {
                    sistema.removerVeiculo(cliente.getTicket());
                }
            } else {
                System.out.println("Pagamento não realizado!");
            }
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }

    private Cliente procurarCliente() {
        System.out.print("\nInforme a placa do seu Veículo: ");
        String placa = leitor.next();

        for (Cliente cliente : clientes) {
            if (cliente.getTicket().getVeiculo().getPlaca().equals(placa)) {
                return cliente;
            }
        }
        System.out.println("Veículo não encontrado!");
        return null;
    }
    private void mostrarPisos() {
        if (pisos.isEmpty()) {
            System.out.println("\nSem pisos cadastrados!");
            return;
        }
        System.out.println("PISOS");
        for (int i = 0; i < pisos.size(); i++) {
            System.out.println(i + " - Piso Andar: " + pisos.get(i).getAndar());
        }

        int opcao;
        try {
            System.out.print("Informe qual piso deseja ver as vagas: ");
            opcao = leitor.nextInt();
            if (opcao < 0 || opcao >= pisos.size()) {
                System.out.println("Piso inválido!");
                return;
            }
            pisos.get(opcao).mostrarVagasLivres();
        } catch (InputMismatchException e) {
            System.out.println("\nValor informado não é um número!");
            leitor.nextLine();
        }
    }
}
