package org.estacionamento.Piso.Vaga;



import org.estacionamento.Veiculos.*;

public class VagaController {
    private Vaga vaga;

    public VagaController(int quantidadeCarros, int quantidadeMotos, int quantidadeEletricos, int quantidadeCaminhoes) {
        vaga = new Vaga(quantidadeCarros, quantidadeMotos, quantidadeEletricos, quantidadeCaminhoes);
    }

    public void adicionarCarro(Carro carro) {
        vaga.adicionarCarro(carro);
    }

    public void adicionarMoto(Moto moto) {
        vaga.adicionarMoto(moto);
    }

    public void adicionarEletrico(Eletrico eletrico) {
        vaga.adicionarEletrico(eletrico);
    }

    public void adicionarCaminhao(Veiculos caminhao) {
        vaga.adicionarCaminhao(caminhao);
    }

    public void removerCarro(Carro carro) {
        vaga.removerCarro(carro);
    }

    public void removerMoto(Moto moto) {
        vaga.removerMoto(moto);
    }

    public void removerEletrico(Eletrico eletrico) {
        vaga.removerEletrico(eletrico);
    }

    public void removerCaminhao(Veiculos caminhao) {
        vaga.removerCaminhao(caminhao);
    }

    public int getQuantidadeCarrosDisponiveis() {
        return vaga.getQuantidadeCarrosDisponiveis();
    }

    public int getQuantidadeMotosDisponiveis() {
        return vaga.getQuantidadeMotosDisponiveis();
    }

    public int getQuantidadeEletricosDisponiveis() {
        return vaga.getQuantidadeEletricosDisponiveis();
    }

    public int getQuantidadeCaminhoesDisponiveis() {
        return vaga.getQuantidadeCaminhoesDisponiveis();
    }
}

