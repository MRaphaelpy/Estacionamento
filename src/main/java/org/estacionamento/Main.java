package org.estacionamento;

import org.estacionamento.Animations.Animations;
import org.estacionamento.Estacionamento.Estacionamento;

class Main {
    
    public static void main(String[] args) {
        Animations animations = new Animations();
        System.out.print("\033[H\033[2J");
        animations.carregamento();
        System.out.print("\033[H\033[2J");
        System.out.print("\033[H\033[2J");
        Estacionamento estacionamento = new Estacionamento("Atores.Estacionamento do Zé",
                "Rua do Zé");
        estacionamento.mensagemBoasVindas();
        ControllerInicial controllerInicial = new ControllerInicial();
        controllerInicial.escolhasIniciais();

    }
}
