package bank;

import java.util.Scanner;
import java.util.ArrayList;

public class ATMBooth {

    private String name;
    private ArrayList<BankAccount> account = new ArrayList<>();
    private int numOfLogins = 0;

    public void login() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("ATM " + this.name);
        System.out.print("Account ID : ");
        String userId = userInput.next();
        for (int i = 0; i < this.account.size(); i++) {
            if (userId.equals(this.account.get(i).getAccountId())) {
                System.out.print("Account Password : ");
                String userPassword = userInput.next();
                if (userPassword.equals(this.account.get(i).getPassword())) {
                    System.out.println("logged in successfully");
                    this.numOfLogins = 0;
                    this.showServiceMenu(this.account.get(i));
                    break;
                } else {
                    System.out.println("Unable to login due to wrong password.");
                    this.numOfLogins++;
                    if (this.numOfLogins >= 3) {
                        System.out.println("You have entered the wrong password more than 3 times. Log out.");
                        System.exit(0);
                    } else {
                        this.login();
                    }
                }
            }
        }
        System.out.println("This account id was not found in the system.");
        this.login();
    }

    public void showServiceMenu(BankAccount accountDetail) {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("ATM " + this.name);
            System.out.println("Account ID : " + accountDetail.getAccountId());
            System.out.println("Menu Service");
            System.out.println("1. Account Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Choose : ");
            String choice = userInput.next();
            switch (choice) {
                case "1" ->
                    this.checkBalance(accountDetail);
                case "2" -> {
                    System.out.println("*********************************");
                    System.out.println("Account ID : " + accountDetail.getAccountId());
                    System.out.print("Enter the amount you want to withdraw : ");
                    int cash = userInput.nextInt();
                    System.out.println("*********************************");
                    this.withdraw(cash, accountDetail);
                }
                case "3" ->
                    this.login();
                default ->
                    System.out.println("something went wrong!!!");
            }
        }
    }

    private void checkBalance(BankAccount accountDetail) {
        System.out.println("*********************************");
        System.out.println("Account ID : " + accountDetail.getAccountId());
        System.out.println("Account Balance " + accountDetail.getBalance() + " bath");
        System.out.println("*********************************\n");
    }

    private void withdraw(int cash, BankAccount accountDetail) {
        System.out.println("*********************************");
        System.out.println("Account ID : " + accountDetail.getAccountId());
        System.out.println("Account withdrawal " + cash + " bath");
        if (cash > accountDetail.getBalance()) {
            System.out.println("Unable to withdraw money");
            System.out.println("Account Balance " + accountDetail.getBalance() + " bath");
            System.out.println("*********************************\n");
        } else {
            accountDetail.setBalance(accountDetail.getBalance() - cash);
            System.out.println("Account Balance " + accountDetail.getBalance() + " bath");
            System.out.println("*********************************\n");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BankAccount> getAccount() {
        return account;
    }

    public void setAccount(ArrayList<BankAccount> account) {
        this.account = account;
    }
}
