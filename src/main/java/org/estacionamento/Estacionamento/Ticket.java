package org.estacionamento.Estacionamento;

import org.estacionamento.Piso.Pisos;
import org.estacionamento.Veiculos.Veiculos;

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

    public void setVeiculo(Veiculos veiculo) throws IllegalArgumentException {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo.");
        }
        this.veiculo = veiculo;
    }

    public Pisos getPiso() {
        return piso;
    }

    public void setPiso(Pisos piso) throws IllegalArgumentException {
        if (piso == null) {
            throw new IllegalArgumentException("Piso não pode ser nulo.");
        }
        this.piso = piso;
    }
}
