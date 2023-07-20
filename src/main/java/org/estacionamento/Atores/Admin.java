
package org.estacionamento.Atores;
import org.estacionamento.Actions.AccountImplementation;
import org.estacionamento.Actions.AdminManager;
import org.estacionamento.Actions.AtendenteManager;
import org.estacionamento.Piso.Pisos;
import org.estacionamento.Piso.PisosOptions;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends AccountImplementation {
    private Scanner opcao;

    private ArrayList<Pisos> pisosList;
    private ArrayList<Admin> adminsList;
    private ArrayList<Atendente> funcionariosList;

    PisosOptions gerenciarPisos;
    AdminManager gerenciarAdmins;
    AtendenteManager gerenciarFuncionario;

    public Admin(ArrayList<Pisos> pisos, ArrayList<Admin> admins, ArrayList<Atendente> funcionarios, String usuario,
            String senha) {
        this.opcao = new Scanner(System.in);
        this.pisosList = pisos;
        this.adminsList = admins;
        this.funcionariosList = funcionarios;
        this.username = usuario;
        this.password = senha;

        this.gerenciarPisos = new PisosOptions(this.pisosList);
        this.gerenciarAdmins = new AdminManager(admins, funcionarios, pisos);
        this.gerenciarFuncionario = new AtendenteManager(this.funcionariosList);

        this.username = usuario;
        this.password = senha;

    }

    public void adminFunc() {
        System.out.println("Escollha uma opção:");
        System.out.println("1-Alterar Pisos");
        System.out.println("2-Alterar Funcionarios");
        System.out.println("3-Alterar Admins");
        System.out.println("4-Sair");
        Integer escolha = this.opcao.nextInt();
        switch (escolha.toString()) {
            case "1":
                gerenciarPisos.Piso();
                adminFunc();
                break;
            case "2":
                gerenciarFuncionario.AtendenteManager();
                adminFunc();
                break;
            case "3":
                gerenciarAdmins.adminOptions();
                adminFunc();
                break;
            case "4":
                System.out.println("See you :)");
                // ControllerInicial controllerInicial = new ControllerInicial();
                // controllerInicial.escolhasIniciais();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

}