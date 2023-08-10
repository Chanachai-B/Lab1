package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private String bankName;
    private ATMBooth atm = new ATMBooth();
    private ArrayList<BankAccount> account = new ArrayList<>();

    public Bank(String name) {
        this.bankName = name;
        this.atm.setName(name);
        this.addAccount();
    }

    private void addAccount() {
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.print("Enter amount of all account = ");
            try {
                int num = userInput.nextInt();
                if (num >= 2) {
                    addDetail(num);
                    break;
                } else {
                    System.out.println("\nThe number of accounts must be more than 5 accounts.");
                    System.out.println("Menu");
                    System.out.println("1.Try again.");
                    System.out.println("2.Exit.");
                    System.out.print("Choose : ");
                    int choice = userInput.nextInt();
                    if (choice == 1) {
                        System.out.println();
                    } else {
                        System.out.println("Exit program.....");
                        break;
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("something went wrong!!!");
                this.addAccount();
            }
        }
        userInput.close();
    }

    private void addDetail(int number) {
        String id;
        ArrayList<String> acc = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the details of each account.");
        for (int i = 1; i <= number; i++) {
            System.out.println("No." + i);
            System.out.print("Account ID : ");
            id = userInput.next();
            if (id.length() != 13) {
                System.out.println("The number of account numbers must be equal to 13 digits.");
                i--;
                continue;
            }

            if (acc.contains(id)) {
                System.out.println("duplicate account name");
                i--;
                continue;
            }
            System.out.print("Account Name : ");
            String name = userInput.next();
            if (name.length() > 50) {
                System.out.println("The number of account names must not be more than 50 characters.");
                i--;
                continue;
            }
            System.out.print("Password : ");
            String pass = userInput.next();
            if (pass.length() != 4) {
                System.out.println("The number of passwords must be 4 digits.");
                i--;
                continue;
            }
            System.out.print("Balance : ");
            String balance = userInput.next();
            try {
                int balanceAmount = Integer.parseInt(balance);
                if (balanceAmount > 1000000) {
                    System.out.println("The balance must be less than 1,000,000 baht.");
                    i--;
                    continue;
                } else if (balanceAmount <= 0) {
                    System.out.println("The balance must be greater than 0 baht.");
                    i--;
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("something went wrong!!!");
                i--;
                continue;
            }

            this.account.add(new BankAccount(name, id, pass, balance));
            acc.add(id);
        }

        this.atm.setAccount(
                this.account);
        atm.login();
    }

    public String getBankName() {
        return bankName;
    }

    public ATMBooth getAtm() {
        return atm;
    }

    public ArrayList<BankAccount> getAccount() {
        return account;
    }

}
