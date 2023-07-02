package org.estacionamento.Piso;
import org.estacionamento.Piso.Pisos;

import java.util.ArrayList;
import java.util.Scanner;

public class PisosOptions {
    private ArrayList<Pisos> pisosList;

    public PisosOptions(ArrayList<Pisos> pisos) {
        this.pisosList = pisos;
    }

    public void Piso() {

        System.out.println("Escolha uma opção:");
        System.out.println("1-Adicionar Piso");
        System.out.println("2-Modificar Piso");
        System.out.println("3-Remover Piso");
        System.out.println("4-Mostrar quantidade de pisos");
        System.out.println("5-Sair");

        var opcao = new Scanner(System.in);

        switch (opcao.nextInt()) {
            case 1:
                addPiso();
                Piso();
                break;
            case 2:
                modifyPiso();
                Piso();
                break;
            case 3:
                removePiso();
                Piso();
                break;
            case 4:
                quantidadePisos();
                Piso();
                break;
            case 5:
                System.out.println("See you :)");
                break;
            default:
                System.out.println("Opção inválida");

        }

    }

    public void addPiso() {
        System.out.println("Digite a quantidade de Entradas: ");
        int quantidadeEntradas = new Scanner(System.in).nextInt();
        System.out.println("Digite a quantidade de Saidas: ");
        int quantidadeSaidas = new Scanner(System.in).nextInt();
        Pisos newPiso = new Pisos();
        newPiso.Pisos(Pisos.totalPisos, quantidadeEntradas, quantidadeSaidas);
        this.pisosList.add(newPiso);
        quantidadePisos();
    }

    public void modifyPiso() {
        if (this.pisosList.isEmpty()) {
            System.out.println("Não há pisos cadastrados");
            return;
        } else {
            try {
                System.out.println("Digite o numero do Piso que deseja modificar: ");
                int numeroPiso = new Scanner(System.in).nextInt();
                System.out.println("Digite a quantidade de Entradas: ");
                int quantidadeEntradas = new Scanner(System.in).nextInt();
                System.out.println("Digite a quantidade de Saidas: ");
                int quantidadeSaidas = new Scanner(System.in).nextInt();
                Pisos newPiso = new Pisos();
                newPiso.Pisos(numeroPiso, quantidadeEntradas, quantidadeSaidas);
                this.pisosList.set(numeroPiso, newPiso);
                quantidadePisos();
            } catch (Exception e) {
                System.out.println("Piso não encontrado ou não existe");
            }
        }
    }

    public void removePiso() {
        if (this.pisosList.isEmpty()) {
            System.out.println("Não há pisos cadastrados");
            return;
        } else {
            try {
                System.out.println("Digite o numero do Piso que deseja remover: ");
                int numeroPiso = new Scanner(System.in).nextInt();
                this.pisosList.remove(numeroPiso);
                quantidadePisos();
            } catch (Exception e) {
                System.out.println("Piso não encontrado ou não existe");
            }
        }
    }

    public void quantidadePisos() {
        if (this.pisosList.isEmpty()) {
            System.out.println("Não há pisos cadastrados");
            return;
        } else {
            System.out.println("Quantidade de pisos: " + this.pisosList.size());
        }
    }
}
