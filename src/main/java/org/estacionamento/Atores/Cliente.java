package org.estacionamento.Atores;

import org.estacionamento.Estacionamento.Ticket;

public class Cliente {
    private Ticket ticket;

    public Cliente(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket não pode ser nulo.");
        }
        this.ticket = ticket;
    }
}
