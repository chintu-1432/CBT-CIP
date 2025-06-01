import java.util.*;

public class CipherBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CipherBankSystem system = new CipherBankSystem();
        int choice;

        System.out.println("=== Welcome to CipherBank ===");

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. View Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Mini Statement");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    system.createNewAccount();
                    break;
                case 2:
                    system.checkBalance();
                    break;
                case 3:
                    system.depositAmount();
                    break;
                case 4:
                    system.withdrawAmount();
                    break;
                case 5:
                    system.transferAmount();
                    break;
                case 6:
                    system.showMiniStatement();
                    break;
                case 7:
                    System.out.println("Thank you for using CipherBank!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 7);
    }
}