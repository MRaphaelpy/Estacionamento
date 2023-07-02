package org.estacionamento.Atores;
import org.estacionamento.Actions.AccountImplementation;
import org.estacionamento.Pagamento.Pagamento;

import java.util.ArrayList;

public class Atendente extends AccountImplementation {
    public Object getUser;
    private Pagamento pagamentos;

    public Atendente(String usuario, String senha) {
        this.username = usuario;
        this.password = senha;
    }

    public Atendente(ArrayList<Atendente> funcionarios) {
    }

    public String getUser() {
        return this.username;
    }

    //
    public boolean receberPagamento(Cliente cliente) {
        double valorTotal = pagamentos.precoTicket(cliente);
        if (valorTotal >= 0) {
            System.out.println("Pagamento realizado com sucesso!");
            return true;
        } else {
            System.out.println("Pagamento não realizado!");
            return false;
        }

    }
}
