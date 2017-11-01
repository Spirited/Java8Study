package stepik.exersices;

public class User {
    private String login;
    private BaseAccount account;

    public User(String login,  BaseAccount account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public BaseAccount getAccount() {
        return account;
    }
}