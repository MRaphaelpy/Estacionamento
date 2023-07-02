package org.estacionamento.Interfaces;

import org.estacionamento.Veiculos.Veiculos;

public interface IPisos {

    void Pisos(int andar, int entrada, int saida);

    int getEntradas();

    int setEntradas(int entrada);

    int getSaidas();

    int setSaidas(int saida);

    int getAndar();

    int setAndar(int andar);

    void mostrarVagasLivres();

    boolean estacionarVeiculo(Veiculos veiculo);

    boolean sairEstacionamento(Veiculos veiculo);

}