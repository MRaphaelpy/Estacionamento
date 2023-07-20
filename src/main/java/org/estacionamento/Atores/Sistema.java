package org.estacionamento.Atores;

import org.estacionamento.Estacionamento.Ticket;

public class Sistema {
    public void adicionarVeiculo(Ticket ticket){
        ticket.getPiso().estacionarVeiculo(ticket.getVeiculo());
    }
    public void removerVeiculo(Ticket ticket){
        ticket.getPiso().sairEstacionamento(ticket.getVeiculo());
    }
}
