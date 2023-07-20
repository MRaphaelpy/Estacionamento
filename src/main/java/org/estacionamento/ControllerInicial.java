package org.estacionamento;
import org.estacionamento.Actions.ClientActions;
import org.estacionamento.Animations.Animations;
import org.estacionamento.Atores.Admin;
import org.estacionamento.Atores.Atendente;
import org.estacionamento.Atores.Cliente;
import org.estacionamento.Piso.Pisos;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerInicial {
    private ClientActions clientActions;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Pisos> pisos = new ArrayList<Pisos>();
    private ArrayList<Admin> admin = new ArrayList<Admin>();
    private ArrayList<Atendente> funcionario = new ArrayList<Atendente>();
   private Animations animations = new Animations();

    public ControllerInicial() {
        scanner = new Scanner(System.in);
        clientActions = new ClientActions(this.pisos, this.funcionario, this.clientes);
        Admin adminInicial = new Admin(this.pisos, this.admin, this.funcionario, "admin", "admin");
        admin.add(adminInicial);
    }

    public void escolhasIniciais() {
        var condicao = true;
        while (condicao) {
            if (condicao) {
                // System.out.print("\033[H\033[2J");
                System.out.println("Como deseja prosseguir?");
                System.out.println("1 - Cliente");
                System.out.println("2 - Admnistrador");
                System.out.println("4 - Encerrar Programa");
                System.out.print("Escolha uma opção: ");
                var opcao = new Scanner(System.in);

                switch (opcao.nextInt()) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Cadastrar cliente");
                        clientInitState();
                        // condicao = false;
                        // opcao.close();
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Admnistrador");
                        initAdmin();

                        // condicao = false;
                        // opcao.close();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        // animationFinal();
                        //Animations.TerminalAnimation.encerramento();
                        System.out.println("See you :)");
                        condicao = false;

                        break;
                    default:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }
    }

    private void initAdmin() {
        System.out.println("Digite o nome o Usuario: ");
        var usuario = scanner.nextLine();
        System.out.println("Digite a senha: ");
        var senha = scanner.nextLine();
        Admin adminInit = new Admin(this.pisos, this.admin, this.funcionario, usuario, senha);
        for (int i = 0; i < admin.size(); i++) {
            if (this.admin.get(i).getUser().equals(usuario)) {
                System.out.println("Bem vindo " + this.admin.get(i).getUser());
                admin.get(i).adminFunc();

            } else {
                System.out.println("Usuario ou senha incorretos");
            }
        }
    }

    private void clientInitState() {
        clientActions.clientInit();
    }
}
