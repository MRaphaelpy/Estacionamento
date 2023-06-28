import java.util.Scanner;

public class ControllerInicial {
    public void escolhasIniciais() {
        var condicao = true;
        while (condicao) {
            if (condicao) {
                System.out.println("Como deseja prosseguir?");
                System.out.println("1 - Cliente");
                System.out.println("2 - Admnistrador");
                System.out.println("3 - Funcionario");
                System.out.println("4 - Encerrar Programa");
                System.out.println("Escolha uma opção: ");
                var opcao = new Scanner(System.in);

                switch (opcao.nextInt()) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Cadastrar cliente");
                        condicao = false;
                        opcao.close();
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Admnistrador");
                        
                        condicao = false;
                        opcao.close();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Cadastrar cliente");
                        condicao = false;
                        opcao.close();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("See you :)");
                        condicao = false;
                        opcao.close();
                        break;
                    default:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }
    }
}
