package Ticket;

import Veiculos.Veiculos;

public class Ticket {
    private Veiculos veiculo;
    private Pisos piso;


    public Ticket(Veiculos veiculo, Pisos piso) {
        this.veiculo = veiculo;
        this.piso = piso;
    }
    public Veiculos getVeiculo() {
        return veiculo;
    }
    public Pisos getPiso() {
        return this.piso;
    }
}
