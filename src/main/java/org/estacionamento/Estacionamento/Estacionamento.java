package org.estacionamento.Estacionamento;

public class Estacionamento {
    private String nome;
    private String endereco;

    public Estacionamento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void exibirInformacoes() {
        System.out.println("Estacionamento: " + this.nome);
        System.out.println("Endereço: " + this.endereco);
    }

    public void mensagemBoasVindas() {
        System.out.println("\033[H\033[2J");
        System.out.println("=============================================");
        System.out.println("     Bem-vindo ao Estacionamento " + this.nome);
        System.out.println("=============================================");
        System.out.println();
    }
}
