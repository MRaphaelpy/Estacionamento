package Atores.Atendente;

import Account.AccountImplementation;

public class Atendente extends AccountImplementation {
    public Atendente(String usuario, String senha) {
        this.username = usuario;
        this.password = senha;
    }

    public String getUser() {
        return this.username;
    }

    public void pagarTicket(float pagamento) {
        if (pagamento > 0) {
            System.out.println("Pagamento realizado com sucesso!");
        }
        else{
            System.out.println("Pagamento não realizado! Valor inválido!");
        }
    }
}
