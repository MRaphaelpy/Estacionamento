package org.estacionamento.Actions;

import org.estacionamento.Atores.Admin;
import org.estacionamento.Atores.Atendente;
import org.estacionamento.Piso.Pisos;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminManager {
    private ArrayList<Admin> adminsList;
    private ArrayList<Atendente> funcionariosList;
    private ArrayList<Pisos> pisosList;
    private Scanner scanner;

    public AdminManager(ArrayList<Admin> admins, ArrayList<Atendente> funcionarios, ArrayList<Pisos> pisos) {
        this.adminsList = admins;
        this.funcionariosList = funcionarios;
        this.pisosList = pisos;
        this.scanner = new Scanner(System.in);
    }

    public void adminOptions() {
        clearConsole();
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Admin");
        System.out.println("2 - Modificar Admin");
        System.out.println("3 - Remover Admin");
        System.out.println("4 - Sair");

        int opcao = getInputAsInteger();

        switch (opcao) {
            case 1:
                addAdmin();
                adminOptions();
                break;
            case 2:
                modifyAdmin();
                adminOptions();
                break;
            case 3:
                removeAdmin();
                adminOptions();
                break;
            case 4:
                System.out.println("See you :)");
                break;
            default:
                System.out.println("Opção inválida");
                adminOptions();
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

    public void addAdmin() {
        System.out.println("Digite o usuario do Admin: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do Admin: ");
        String senha = scanner.nextLine();

        Admin newAdmin = new Admin(pisosList, adminsList, funcionariosList, usuario, senha);

        if (!verifyExistence(adminsList, newAdmin)) {
            adminsList.add(newAdmin);
            System.out.println("Admin adicionado com sucesso");
        } else {
            System.out.println("Admin já existe");
        }
    }

    public void modifyAdmin() {
        System.out.println("Digite o usuario do Admin: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do Admin: ");
        String senha = scanner.nextLine();

        Admin newAdmin = new Admin(pisosList, adminsList, funcionariosList, usuario, senha);

        if (verifyExistence(adminsList, newAdmin)) {
            adminsList.removeIf(admin -> admin.getUser().equals(newAdmin.getUser()));
            adminsList.add(newAdmin);
            System.out.println("Admin modificado com sucesso");
        } else {
            System.out.println("Admin não existe");
        }
    }

    public void removeAdmin() {
        System.out.println("Digite o usuario do Admin: ");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do Admin: ");
        String senha = scanner.nextLine();

        Admin newAdmin = new Admin(pisosList, adminsList, funcionariosList, usuario, senha);

        if (verifyExistence(adminsList, newAdmin)) {
            adminsList.removeIf(admin -> admin.getUser().equals(newAdmin.getUser()));
            System.out.println("Admin removido com sucesso");
        } else {
            System.out.println("Admin não existe");
        }
    }

    public boolean verifyExistence(ArrayList<Admin> adminsList, Admin newAdmin) {
        for (Admin admin : adminsList) {
            if (admin.getUser().equals(newAdmin.getUser())) {
                return true;
            }
        }
        return false;
    }
}
