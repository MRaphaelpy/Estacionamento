package Account;

public class AccountImplementation {
    public String username;
    public String password;

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
}
