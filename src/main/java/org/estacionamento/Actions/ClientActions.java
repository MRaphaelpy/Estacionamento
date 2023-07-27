package org.estacionamento.Actions;
import org.estacionamento.Atores.Atendente;
import org.estacionamento.Atores.Cliente;
import org.estacionamento.Atores.Sistema;
import org.estacionamento.Estacionamento.Ticket;
import org.estacionamento.Interfaces.IPisos;
import org.estacionamento.Pagamento.Pagamento;
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
        // System.out.print("\033[H\033[2J");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Estacionar");
        System.out.println("2 - Sair");
        System.out.println("3 - Mostrar Vagas Livres em um Piso");
        System.out.println("4 - Voltar");
        System.out.print("Digite sua opção: ");
        String opcao = leitor.next();

        switch (opcao) {
            case "1":
                estacionarVeiculo();
                clientInit();
                break;
            case "2":
                retirarVeiculo();
                clientInit();
                break;
            case "3":
                mostrarVagasLivres();
                clientInit();
                break;
            case "4":
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção escolhida não é válida");
                clientInit();
        }
    }

    private void estacionarVeiculo() {
        if (pisos.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\nSem Pisos");

        }else{
            Veiculos veiculo = criarVeiculo();

            if (this.verifyVehicleExists(clientes, veiculo)) {
                System.out.println("\nVeículo já está estacionado!");
            }

            System.out.println("\n\nEm qual piso deseja estacionar?");

            for (int i = 0; i < pisos.size(); i++) {
                System.out.println("Piso " + i);
            }
            System.out.print("Digite o número do piso: ");
            int andar = leitor.nextInt();

            if (andar < 0 || andar >= pisos.size()) {
                System.out.println("Piso inválido!");
            }
                Ticket ticket = new Ticket(veiculo, pisos.get(andar));
                Cliente cliente = new Cliente(ticket);
                clientes.add(cliente);
                sistema.adicionarVeiculo(ticket);

        }
    }

    private boolean verifyVehicleExists(ArrayList<Cliente> clientes, Veiculos novoVeiculo) {
        for (Cliente cliente : clientes) {
            if (cliente.ticket.getVeiculo().equals(novoVeiculo)) {



                return true;
            }
        }
        return false;
    }

    private Veiculos criarVeiculo() {
        System.out.print("\n\nInforme a placa do seu Veículo: ");
        String placa = leitor.next();

        System.out.println("\nQual é o seu Veículo?");
        System.out.println("1 - Caminhão");
        System.out.println("2 - Van");
        System.out.println("3 - Carro");
        System.out.println("4 - Carro Elétrico");
        System.out.println("5 - Motocicleta");

        Veiculos veiculo = null;
        while (veiculo == null) {
            System.out.print("Digite sua opção: ");
            String opcao = leitor.next();

            switch (opcao) {
                case "1" -> veiculo = new Caminhao(placa);
                case "2" -> veiculo = new Van(placa);
                case "3" -> veiculo = new Carro(placa);
                case "4" -> veiculo = new Eletrico(placa);
                case "5" -> veiculo = new Moto(placa);
                default -> System.out.println("Opção escolhida não é válida, tente novamente!");
            }
        }
        return veiculo;
    }

    private boolean retirarVeiculo() {
        System.out.println("Quantidade de Atendente: "+atendentesList.size());
        if (atendentesList.isEmpty()) {
            System.out.println("\nPelo visto todos os Atendentes estao Ocupados no Momento!");
            return false;
        }
        else{
            Cliente cliente = procurarCliente();

          if(cliente != null){
              System.out.print("Deseja fazer o pagamento agora? 1 Sim 2 Nao: ");
              int opcao = leitor.nextInt();
              if (opcao == 1) {
                  Random gerador = new Random();
                  Atendente atendente = atendentesList.get(gerador.nextInt(atendentesList.size()));
                  boolean condition = atendente.receberPagamento(cliente);
                  if (condition) {
                      sistema.removerVeiculo(cliente.ticket);
                  }


              } else {
                  System.out.println("Pagamento não realizado!");
              }
          }
          else{
              System.out.printf("Clinetes vazios????");
              return false;
          }
        }
        return true;
    }

    private Cliente procurarCliente() {
    System.out.print("\n\nInforme a placa do seu Veículo: ");
            String placa = leitor.next();

            for (Cliente cliente : clientes) {
                if (cliente.ticket.getVeiculo().getPlaca().equals(placa)) {
                    return cliente;
                }
            }
            System.out.println("Veículo não encontrado!");
            return null;
    }

    private Ticket obterTicket(Veiculos veiculo, Pisos piso) {
        return new Ticket(veiculo, piso);
    }

    private void mostrarVagasLivres() {
        if (pisos.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\nSem pisos cadastrados!");
        }

        System.out.println("PISOS");
        for (int i = 0; i < pisos.size(); i++) {
            System.out.println(i + " - Piso Andar: " + pisos.get(i).getAndar());
        }

        System.out.print("Informe qual piso deseja ver as vagas: ");
        int opcao;
        try {
            opcao = leitor.nextInt();
            if (opcao >= pisos.size()) {
                System.out.println("Piso inválido!");
            }

            // Pisos piso = pisos.get(opcao);
            pisos.get(opcao).mostrarVagasLivres();
        } catch (InputMismatchException e) {
            System.out.println("\nValor informado não é um número!");

        }
    }
}
