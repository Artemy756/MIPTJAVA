package Bank;

public class Client {
    public String name;
    public String last_name;
    public int number;
    public Account account;

    public Client(String name, String last_name, int number) {
        this.name = name;
        this.last_name = last_name;
        this.number = number;

    }

    public Client(Client value) {
    }

    public void createAccount(Account account)
    {
        this.account = account;
    }


}
