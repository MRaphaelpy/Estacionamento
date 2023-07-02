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

    public AdminManager(ArrayList<Admin> admins, ArrayList<Atendente> funcionarios, ArrayList<Pisos> pisos) {
        this.adminsList = admins;
        this.funcionariosList = funcionarios;
        this.pisosList = pisos;
    }

    public void adminOptions() {
        System.out.println("Escollha uma opção:");
        System.out.println("1-Adicionar Admin");
        System.out.println("2-Modificar Admin");
        System.out.println("3-Remover Admin");
        System.out.println("4-Sair");

        var opcao = new Scanner(System.in);

        switch (opcao.nextInt()) {
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
                // opcao.close();
                break;
            default:
                System.out.println("Opção inválida");
                adminOptions();

        }
    }

    public void addAdmin() {
        System.out.println("Digite o usuario do Admin: ");
        var usuario = new Scanner(System.in);
        System.out.println("Digite a senha do Admin: ");
        var senha = new Scanner(System.in);

        Admin newAdmin = new Admin(pisosList, adminsList, funcionariosList, usuario.nextLine(), senha.nextLine());

        if (veriffyExistence(adminsList, newAdmin) == false) {
            adminsList.add(newAdmin);
            System.out.println("Admin adicionado com sucesso");
        } else {
            System.out.println("Admin já existe");
        }

    }

    public void modifyAdmin() {
        System.out.println("Digite o usuario do Admin: ");
        var usuario = new Scanner(System.in);
        System.out.println("Digite a senha do Admin: ");
        var senha = new Scanner(System.in);

        Admin newAdmin = new Admin(pisosList, adminsList, funcionariosList, usuario.nextLine(), senha.nextLine());

        if (veriffyExistence(adminsList, newAdmin) == true) {
            adminsList.remove(newAdmin);
            adminsList.add(newAdmin);
            System.out.println("Admin modificado com sucesso");
        } else {
            System.out.println("Admin não existe");
        }
    }

    public void removeAdmin() {
        System.out.println("Digite o usuario do Admin: ");
        var usuario = new Scanner(System.in);
        System.out.println("Digite a senha do Admin: ");
        var senha = new Scanner(System.in);

        Admin newAdmin = new Admin(pisosList, adminsList, funcionariosList, usuario.nextLine(), senha.nextLine());

        if (veriffyExistence(adminsList, newAdmin) == true) {
            adminsList.remove(newAdmin);
            System.out.println("Admin removido com sucesso");
        } else {
            System.out.println("Admin não existe");
        }
    }

    public boolean veriffyExistence(ArrayList<Admin> adminsList, AccountImplementation admin) {
        for (int i = 0; i < adminsList.size(); i++) {
            if (adminsList.get(i).equals(admin)) {
                System.out.println("Admin já existe");

                return true;
            }
        }
        return false;
    }
}