package org.estacionamento.Atores;

import org.estacionamento.Estacionamento.Ticket;

public class Sistema {
    public boolean adicionarVeiculo(Ticket ticket){
        if(ticket.getPiso().estacionarVeiculo(ticket.getVeiculo())){
            return true;
        }
        return false;
    }
    public void removerVeiculo(Ticket ticket){
        ticket.getPiso().sairEstacionamento(ticket.getVeiculo());
    }
}
