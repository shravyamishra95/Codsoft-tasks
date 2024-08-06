import java.util.Scanner;

// BankAccount class to represent user's account
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// ATM class to represent the ATM interface
public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== ATM Interface =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    private void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("$" + amount + " deposited successfully.");
            System.out.println("Current Balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0) {
            if (bankAccount.withdraw(amount)) {
                System.out.println("$" + amount + " withdrawn successfully.");
                System.out.println("Current Balance: $" + bankAccount.getBalance());
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    public static void main(String[] args) {
        // Initialize bank account with an initial balance
        BankAccount bankAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(bankAccount);
        atm.run();
    }
}
