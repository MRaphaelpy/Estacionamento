package org.estacionamento.Interfaces;

import org.estacionamento.Veiculos.Veiculos;

public interface IPisos {
    int getEntradas();
    int setEntradas(int entrada);
    int getSaidas();
    int setSaidas(int saida);
    int getAndar();
    int setAndar(int andar);
    void mostrarVagasLivres();
    void estacionarVeiculo(Veiculos veiculo);
    void sairEstacionamento(Veiculos veiculo);
}
