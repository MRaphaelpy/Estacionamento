package org.estacionamento.Actions;

import org.estacionamento.Atores.Atendente;

import java.util.ArrayList;
import java.util.Scanner;

public class AtendenteManager {
    private ArrayList<Atendente> funcionarioList;
    private Scanner scanner = new Scanner(System.in);

    public AtendenteManager(ArrayList<Atendente> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public void AtendenteManager() {
        clearConsole();
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Funcionario");
        System.out.println("2 - Modificar Funcionario");
        System.out.println("3 - Remover Funcionario");
        System.out.println("4 - Sair");

        int opcao = getInputAsInteger();

        switch (opcao) {
            case 1:
                addFuncionario();
                AtendenteManager();
                break;
            case 2:
                modifyFuncionario();
                AtendenteManager();
                break;
            case 3:
                removeFuncionario();
                AtendenteManager();
                break;
            case 4:
                System.out.println("See you :)");
                break;
            default:
                System.out.println("Opção inválida");
                AtendenteManager();
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

    private int getInputAsInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número válido.");
            }
        }
    }

    private boolean verifyExistence(ArrayList<Atendente> funcionarioList, Atendente newFuncionario) {
        for (Atendente funcionario : funcionarioList) {
            if (funcionario.getUser().equals(newFuncionario.getUser())) {
                return true;
            }
        }
        return false;
    }

    public void addFuncionario() {
        System.out.println("Digite o usuario do Funcionario: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do Funcionario: ");
        String senha = scanner.nextLine();
        Atendente newFuncionario = new Atendente(usuario, senha);

        if (!verifyExistence(funcionarioList, newFuncionario)) {
            funcionarioList.add(newFuncionario);
            System.out.println("Funcionario adicionado com sucesso");
        } else {
            System.out.println("Funcionario já existe");
        }
    }

    public void modifyFuncionario() {
        System.out.println("Digite o usuario do Funcionario: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do Funcionario: ");
        String senha = scanner.nextLine();

        Atendente newFuncionario = new Atendente(usuario, senha);

        if (verifyExistence(funcionarioList, newFuncionario)) {
            funcionarioList.removeIf(funcionario -> funcionario.getUser().equals(newFuncionario.getUser()));
            funcionarioList.add(newFuncionario);
            System.out.println("Funcionario modificado com sucesso");
        } else {
            System.out.println("Funcionario não existe");
        }
    }

    public void removeFuncionario() {
        System.out.println("Digite o usuario do Funcionario: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do Funcionario: ");
        String senha = scanner.nextLine();

        Atendente newFuncionario = new Atendente(usuario, senha);

        if (verifyExistence(funcionarioList, newFuncionario)) {
            funcionarioList.removeIf(funcionario -> funcionario.getUser().equals(newFuncionario.getUser()));
            System.out.println("Funcionario removido com sucesso");
        } else {
            System.out.println("Funcionario não existe");
        }
    }
}
