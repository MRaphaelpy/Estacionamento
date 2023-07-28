package org.estacionamento.AbstractClass;

public abstract class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUser() {
        return this.username;
    }

    public String getPass() {
        return this.password;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public void setPass(String password) {
        this.password = password;
    }

    public boolean equals(Account account) {
        if (this.username.equals(account.getUser()) && this.password.equals(account.getPass())) {
            return true;
        } else {
            return false;
        }
    }
}
