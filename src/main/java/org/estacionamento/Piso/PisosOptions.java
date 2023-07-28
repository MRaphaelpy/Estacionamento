package org.estacionamento.Piso;
import org.estacionamento.Piso.Pisos;

import java.util.ArrayList;
import java.util.Scanner;

public class PisosOptions {
    private ArrayList<Pisos> pisosList;

    public PisosOptions(ArrayList<Pisos> pisos) {
        this.pisosList = pisos;
    }

    public void piso() {
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
                piso();
                break;
            case 2:
                modifyPiso();
                piso();
                break;
            case 3:
                removePiso();
                piso();
                break;
            case 4:
                quantidadePisos();
                piso();
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
        newPiso.setEntradas(quantidadeEntradas);
        newPiso.setSaidas(quantidadeSaidas);
        newPiso.setAndar(Pisos.totalPisos);
        this.pisosList.add(newPiso);
        newPiso.adicionarNumeroDeVagas();
        quantidadePisos();
    }

    private void modifyPiso() {
        if (this.pisosList.isEmpty()) {
            System.out.println("Não há pisos cadastrados");
            return;
        } else {
            try {
                System.out.println("Digite o número do Piso que deseja modificar: ");
                int numeroPiso = new Scanner(System.in).nextInt();
                if (numeroPiso >= 0 && numeroPiso < this.pisosList.size()) {
                    System.out.println("Digite a quantidade de Entradas: ");
                    int quantidadeEntradas = new Scanner(System.in).nextInt();
                    System.out.println("Digite a quantidade de Saidas: ");
                    int quantidadeSaidas = new Scanner(System.in).nextInt();
                    Pisos piso = this.pisosList.get(numeroPiso);
                    piso.setAndar(numeroPiso);
                    piso.setEntradas(quantidadeEntradas);
                    piso.setSaidas(quantidadeSaidas);
                    piso.adicionarNumeroDeVagas();
                    quantidadePisos();
                } else {
                    System.out.println("Piso não encontrado ou não existe");
                }
            } catch (Exception e) {
                System.out.println("Valor inválido");
            }
        }
    }

    private void removePiso() {
        if (this.pisosList.isEmpty()) {
            System.out.println("Não há pisos cadastrados");
        } else {
            try {
                System.out.println("Digite o número do Piso que deseja remover: ");
                int numeroPiso = new Scanner(System.in).nextInt();
                if (numeroPiso >= 0 && numeroPiso < this.pisosList.size()) {
                    this.pisosList.remove(numeroPiso);
                    quantidadePisos();
                } else {
                    System.out.println("Piso não encontrado ou não existe");
                }
            } catch (Exception e) {
                System.out.println("Valor inválido");
            }
        }
    }

    private void quantidadePisos() {
        if (this.pisosList.isEmpty()) {
            System.out.println("Não há pisos cadastrados");
        } else {
            System.out.println("Quantidade de pisos: " + this.pisosList.size());
        }
    }
}
