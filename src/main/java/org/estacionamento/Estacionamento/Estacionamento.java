package org.estacionamento.Estacionamento;

public class Estacionamento {
    String nome;
    String endereco;

    public Estacionamento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void mensagemBoasVindas() {
        System.out.print("\033[H\033[2J");
        System.out.println("Bem vindo ao estacionamento " + this.nome);
    }
}
