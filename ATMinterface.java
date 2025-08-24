import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("✅ Deposited: ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }
}

// Class representing the ATM interface
 class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(5000.00); // starting balance

        System.out.println("===== Welcome to the ATM =====");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;

          
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next(); 
                continue;
            }

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("🔒 Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }
}