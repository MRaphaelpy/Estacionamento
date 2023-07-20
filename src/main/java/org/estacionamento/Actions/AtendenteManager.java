package org.estacionamento.Actions;
import org.estacionamento.Atores.Atendente;
import org.estacionamento.ControllerInicial;

import java.util.ArrayList;
import java.util.Scanner;

public class AtendenteManager {
    private ArrayList<Atendente> funcionarioList;
    private Scanner scanner = new Scanner(System.in);
    private ControllerInicial controllerInicial = new ControllerInicial();

    public AtendenteManager() {
        funcionarioList = new ArrayList<>();

    }

    public void AtendenteManager() {
        System.out.print("\033[H\033[2J");
        System.out.println("Escollha uma opção:");
        System.out.println("1-Adicionar Funcionario");
        System.out.println("2-Modificar Funcionario");
        System.out.println("3-Remover Funcionario");
        System.out.println("4-Sair");

        var opcao = new Scanner(System.in);

        switch (opcao.nextInt()) {
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
                //opcao.close();
                break;
            default:
                System.out.println("Opção inválida");

        }
    }

    private boolean veriffyExistence(ArrayList<Atendente> funcionarioList, Atendente newFuncionario) {

        for (Atendente funcionario : funcionarioList) {
            if (funcionario.getUser().equals(newFuncionario.getUser())) {
                return true;
            }
        }
        return false;

    }

    public void addFuncionario() {
        System.out.println("Digite o usuario do Funcionario: ");
        var usuario = scanner.nextLine();
        System.out.println("Digite a senha do Funcionario: ");
        var senha = scanner.nextLine();
        Atendente newFuncionario = new Atendente(usuario, senha);


         if (!veriffyExistence(funcionarioList, newFuncionario)) {

         funcionarioList.add(newFuncionario);
         System.out.println("Funcionario adicionado com sucesso");
         controllerInicial = new ControllerInicial(funcionarioList);
         } else {
         System.out.println("Funcionario já existe");
         }
       // funcionarioList.add(newFuncionario);
    }

    public void modifyFuncionario() {
        System.out.println("Digite o usuario do Funcionario: ");
        var usuario = new Scanner(System.in);
        System.out.println("Digite a senha do Funcionario: ");
        var senha = new Scanner(System.in);

        Atendente newFuncionario = new Atendente(usuario.nextLine(), senha.nextLine());

        if (veriffyExistence(funcionarioList, newFuncionario)) {
            funcionarioList.remove(newFuncionario);
            funcionarioList.add(newFuncionario);
            System.out.println("Funcionario modificado com sucesso");
        } else {
            System.out.println("Funcionario não existe");
        }
    }

    public void removeFuncionario() {
        System.out.println("Digite o usuario do Funcionario: ");
        var usuario = new Scanner(System.in);
        System.out.println("Digite a senha do Funcionario: ");
        var senha = new Scanner(System.in);

        Atendente newFuncionario = new Atendente(usuario.nextLine(), senha.nextLine());

        if (veriffyExistence(funcionarioList, newFuncionario)) {
            funcionarioList.remove(newFuncionario);
            System.out.println("Funcionario removido com sucesso");
        } else {
            System.out.println("Funcionario não existe");
        }
    }
}
