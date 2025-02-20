import java.util.Scanner;

class Main extends ATM
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter pin: ");
        int pin = scanner.nextInt();

        Account user = atm.findAccount(accNumber, pin);
        if (user == null) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        System.out.println("Welcome, " + user.getAccountOwnerName());

        int choice;
        do {
            System.out.println("\n1. Savings Account");
            System.out.println("2. Change Pin");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleSavingsAccount(scanner, user);
                    break;
                case 2:
                    changePin(scanner, user);
                    break;
                case 0:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleSavingsAccount(Scanner scanner, Account user) {
        int action;
        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("0. Exit");
            System.out.print("Select action: ");
            action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Balance: " + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (user.withdrawBalance(withdrawAmount)) {
                        System.out.println("Withdrawal successful. New balance: " + user.getBalance());
                    } else {
                        System.out.println("Invalid amount or insufficient funds.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (user.depositBalance(depositAmount)) {
                        System.out.println("Deposit successful. New balance: " + user.getBalance());
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (action != 0);
    }

    private static void changePin(Scanner scanner, Account user) {
        System.out.print("Enter new pin: ");
        int newPin = scanner.nextInt();
        if (user.setPin(newPin)) {
            System.out.println("Pin changed successfully.");
        } else {
            System.out.println("New pin must be different from the current pin.");
        }
    }
}