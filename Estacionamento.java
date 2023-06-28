public class Estacionamento {
    String nome;
    String endereco;

    public Estacionamento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void mensagemBoasVindas() {
        System.out.println("Bem vindo ao estacionamento " + this.nome);
    }
}
