package org.estacionamento;

import org.estacionamento.Actions.ClientActions;
import org.estacionamento.Atores.Admin;
import org.estacionamento.Atores.Atendente;
import org.estacionamento.Atores.Cliente;
import org.estacionamento.Piso.Pisos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerInicial {
    private ClientActions clientActions;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Pisos> pisos = new ArrayList<Pisos>();
    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<Atendente> atendentes = new ArrayList<Atendente>();

    public ControllerInicial() {
        scanner = new Scanner(System.in);
        clientActions = new ClientActions(this.pisos, this.atendentes, this.clientes);
        Admin adminInicial = new Admin(this.pisos, this.admins, this.atendentes, "admin", "admin");
        admins.add(adminInicial);
    }

    public void escolhasIniciais() {
        boolean condicao = true;
        while (condicao) {
            System.out.println("Como deseja prosseguir?");
            System.out.println("1 - Cliente");
            System.out.println("2 - Administrador");
            System.out.println("3 - Encerrar Programa");
            System.out.print("Escolha uma opção: ");
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Cadastrar cliente");
                        clientInitState();
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Administrador");
                        initAdmin();
                        break;

                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("See you :)");
                        condicao = false;
                        break;
                    default:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, digite um número válido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void initAdmin() {
        System.out.println("Digite o nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        try {
            for (Admin admin : admins) {
                if (admin.getUser().equals(usuario) && admin.getPass().equals(senha)) {
                    System.out.println("Bem-vindo " + admin.getUser());
                    admin.adminFunc();
                    return;
                }
            }
            System.out.println("Usuário ou senha incorretos");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Admin: " + e.getMessage());
        }
    }

//    private void initAtendente() {
//        System.out.println("Digite o nome de usuário: ");
//        String usuario = scanner.nextLine();
//        System.out.println("Digite a senha: ");
//        String senha = scanner.nextLine();
//
//        try {
//            for (Atendente atendente : atendentes) {
//                if (atendente.getUser().equals(usuario) && atendente.getPass().equals(senha)) {
//                    System.out.println("Bem-vindo " + atendente.getUser());
//                   atendente.atendenteFunc(this.clientes);
//                    return;
//                }
//            }
//            System.out.println("Usuário ou senha incorretos");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Erro ao criar Atendente: " + e.getMessage());
//        }
//    }

    private void clientInitState() {
        clientActions.clientInit();
    }
}
