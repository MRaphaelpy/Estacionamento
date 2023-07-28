package org.estacionamento.Interfaces;


import org.estacionamento.Veiculos.Carro;
import org.estacionamento.Veiculos.Moto;
import org.estacionamento.Veiculos.Eletrico;
import org.estacionamento.Veiculos.Veiculos;

public interface IVaga {
    void adicionarCarro(Carro carro);

    void adicionarMoto(Moto moto);

    void adicionarEletrico(Eletrico eletrico);

    void adicionarCaminhao(Veiculos caminhao);

    void removerCarro(Carro carro);

    void removerMoto(Moto moto);

    void removerEletrico(Eletrico eletrico);

    void removerCaminhao(Veiculos caminhao);

    // Outros métodos que você desejar adicionar à interface
}

