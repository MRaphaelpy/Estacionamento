package org.estacionamento.Atores;

import org.estacionamento.AbstractClass.Account;
import org.estacionamento.Actions.AdminManager;
import org.estacionamento.Actions.AtendenteManager;
import org.estacionamento.Piso.Pisos;
import org.estacionamento.Piso.PisosOptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Account {
    private Scanner opcao;
    private ArrayList<Pisos> pisosList;
    private ArrayList<Admin> adminsList;
    private ArrayList<Atendente> funcionariosList;
    private PisosOptions gerenciarPisos;
    private AdminManager gerenciarAdmins;
    private AtendenteManager gerenciarFuncionario;

    public Admin(ArrayList<Pisos> pisos, ArrayList<Admin> admins, ArrayList<Atendente> funcionarios, String usuario,
                 String senha) {
        super(usuario, senha);
        this.opcao = new Scanner(System.in);
        this.pisosList = pisos;
        this.adminsList = admins;
        this.funcionariosList = funcionarios;

        this.gerenciarPisos = new PisosOptions(this.pisosList);
        this.gerenciarAdmins = new AdminManager(admins, funcionarios, pisos);
        this.gerenciarFuncionario = new AtendenteManager(this.funcionariosList);
    }

    public void adminFunc() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Alterar Pisos");
            System.out.println("2 - Alterar Funcionarios");
            System.out.println("3 - Alterar Admins");
            System.out.println("4 - Sair");

            try {
                int escolha = opcao.nextInt();
                switch (escolha) {
                    case 1:
                        gerenciarPisos.piso();
                        break;
                    case 2:
                        gerenciarFuncionario.AtendenteManager();
                        break;
                    case 3:
                        gerenciarAdmins.adminOptions();
                        break;
                    case 4:
                        System.out.println("See you :)");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número válido.");
                opcao.next();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }
}
