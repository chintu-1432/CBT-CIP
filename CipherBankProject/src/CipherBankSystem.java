import java.io.*;
import java.util.*;

public class CipherBankSystem {
    private final Map<String, Account> accounts = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "data.txt";

    public void createNewAccount() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Set 4-digit PIN: ");
        int pin = sc.nextInt();

        String accNum = Utils.generateAccountNumber();
        Account acc = new Account(name, accNum, pin);
        accounts.put(accNum, acc);
        System.out.println("Account created! Account Number: " + accNum);
        saveAccountsToFile(); // Save after creating
    }

    public Account authenticate() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.next();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        Account acc = accounts.get(accNum);
        if (acc != null && acc.getPin() == pin) {
            return acc;
        } else {
            System.out.println("Authentication failed.");
            return null;
        }
    }

    public void checkBalance() {
        Account acc = authenticate();
        if (acc != null) {
            System.out.println("Balance: ₹" + acc.getBalance());
        }
    }

    public void depositAmount() {
        Account acc = authenticate();
        if (acc != null) {
            System.out.print("Enter deposit amount: ₹");
            double amt = sc.nextDouble();
            acc.deposit(amt);
            saveAccountsToFile();
            System.out.println("Deposit successful.");
        }
    }

    public void withdrawAmount() {
        Account acc = authenticate();
        if (acc != null) {
            System.out.print("Enter withdrawal amount: ₹");
            double amt = sc.nextDouble();
            if (acc.withdraw(amt)) {
                saveAccountsToFile();
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }

    public void transferAmount() {
        System.out.print("Sender ");
        Account sender = authenticate();
        if (sender == null) return;

        if (!sender.canTransferToday()) {
            System.out.println("Daily transfer limit reached.");
            return;
        }

        System.out.print("Enter recipient account number: ");
        String recAccNum = sc.next();
        Account receiver = accounts.get(recAccNum);

        if (receiver == null) {
            System.out.println("Recipient not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ₹");
        double amt = sc.nextDouble();

        if (sender.transfer(amt, receiver)) {
            saveAccountsToFile();
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public void showMiniStatement() {
        Account acc = authenticate();
        if (acc != null) {
            acc.printMiniStatement();
        }
    }

    public void saveAccountsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts.values()) {
                bw.write(acc.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public void loadAccountsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Account acc = Account.fromFileString(line);
                accounts.put(acc.getAccountNumber(), acc);
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}