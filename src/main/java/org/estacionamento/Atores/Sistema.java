package org.estacionamento.Atores;

import org.estacionamento.Estacionamento.Ticket;

public class Sistema {
    public void adicionarVeiculo(Ticket ticket) {
        if (ticket == null) {
            System.out.println("Ticket inválido. Não é possível adicionar o veículo.");
            return;
        }

        try {
            ticket.getPiso().estacionarVeiculo(ticket.getVeiculo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }
    }

    public void removerVeiculo(Ticket ticket) {
        if (ticket == null) {
            System.out.println("Ticket inválido. Não é possível remover o veículo.");
            return;
        }

        try {
            ticket.getPiso().sairEstacionamento(ticket.getVeiculo());
        } catch (Exception e) {
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }
    }
}
