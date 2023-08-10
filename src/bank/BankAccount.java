package bank;

public class BankAccount {

    private String accountName;
    private String accountId;
    private String password;
    private int balance;

    public BankAccount(String name, String id, String password, String balance) {
        this.accountName = name;
        this.accountId = id;
        this.password = password;
        this.balance = Integer.parseInt(balance);
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
