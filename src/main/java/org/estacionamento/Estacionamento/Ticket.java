package org.estacionamento.Estacionamento;

import org.estacionamento.Interfaces.IPisos;
import org.estacionamento.Veiculos.Veiculos;

public class Ticket {
    private Veiculos veiculo;
    private IPisos piso;


    public Ticket(Veiculos veiculo, IPisos piso) {
        this.veiculo = veiculo;
        this.piso = piso;
    }
    public Veiculos getVeiculo() {
        return veiculo;
    }
    public IPisos getPiso() {
        return this.piso;
    }
}
