import java.util.Scanner;

public class ATM {
    private double balance;
    private final String pin;

    public ATM(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean authenticate(String enteredPin) {
        return enteredPin.equals(pin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(500.00, "1234");  // Set initial balance to $500 and pin to 1234

        System.out.println("Welcome to the ATM.");
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (!atm.authenticate(enteredPin)) {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        }
    }
}
