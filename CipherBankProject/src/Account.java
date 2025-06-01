import java.util.*;

public class Account {
    private String name;
    private String accountNumber;
    private int pin;
    private double balance;
    private List<String> transactions;
    private int transfersToday;

    private static final int DAILY_LIMIT = 3;

    public Account(String name, String accountNumber, int pin) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.transfersToday = 0;
    }

    public int getPin() {
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            transactions.add("Withdraw ₹" + amt);
            return true;
        }
        return false;
    }

    public void deposit(double amt) {
        balance += amt;
        transactions.add("Deposit ₹" + amt);
    }

    public boolean transfer(double amt, Account receiver) {
        if (amt <= balance && transfersToday < DAILY_LIMIT) {
            balance -= amt;
            receiver.deposit(amt);
            transactions.add("Transfer to " + receiver.accountNumber + " ₹" + amt);
            transfersToday++;
            return true;
        }
        return false;
    }

    public void printMiniStatement() {
        System.out.println("Mini Statement:");
        int start = Math.max(0, transactions.size() - 5);
        for (int i = start; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    public boolean canTransferToday() {
        return transfersToday < DAILY_LIMIT;
    }

    // Save to file as a single line
    public String toFileString() {
        return name + "," + accountNumber + "," + pin + "," + balance;
    }

    // Create object from file line
    public static Account fromFileString(String line) {
        String[] parts = line.split(",");
        String name = parts[0];
        String accNum = parts[1];
        int pin = Integer.parseInt(parts[2]);
        double balance = Double.parseDouble(parts[3]);

        Account acc = new Account(name, accNum, pin);
        acc.balance = balance;
        return acc;
    }
}