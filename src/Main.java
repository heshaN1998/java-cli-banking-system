import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        while (running) {
            System.out.println("\n**** Banking System CLI ****");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Check Balance");
            System.out.println("7. View Transaction History");
            System.out.println("8. Show All Accounts");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        createSavingsAccount(scanner, bank);
                        break;
                    case 2:
                        createCurrentAccount(scanner, bank);
                        break;
                    case 3:
                        deposit(scanner, bank);
                        break;
                    case 4:
                        withdraw(scanner, bank);
                        break;
                    case 5:
                        transfer(scanner, bank);
                        break;
                    case 6:
                        checkBalance(scanner, bank);
                        break;
                    case 7:
                        viewTransactionHistory(scanner, bank);
                        break;
                    case 8:
                        bank.showAllAccounts();
                        break;
                    case 9:
                        running = false;
                        System.out.println("Thank you for using Banking System CLI.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void createSavingsAccount(Scanner scanner, Bank bank) {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter minimum balance: ");
        double minimumBalance = Double.parseDouble(scanner.nextLine());

        BankAccount account = bank.createSavingsAccount(name, minimumBalance);
        System.out.println("Savings account created successfully.");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    private static void createCurrentAccount(Scanner scanner, Bank bank) {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter overdraft limit: ");
        double overdraftLimit = Double.parseDouble(scanner.nextLine());

        BankAccount account = bank.createCurrentAccount(name, overdraftLimit);
        System.out.println("Current account created successfully.");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    private static void deposit(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        bank.depositToAccount(accountNumber, amount);
        System.out.println("Deposit successful.");
    }

    private static void withdraw(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter withdrawal amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        bank.withdrawFromAccount(accountNumber, amount);
        System.out.println("Withdrawal successful.");
    }

    private static void transfer(Scanner scanner, Bank bank) {
        System.out.print("Enter sender account number: ");
        String fromAccount = scanner.nextLine();

        System.out.print("Enter receiver account number: ");
        String toAccount = scanner.nextLine();

        System.out.print("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        bank.transferBetweenAccounts(fromAccount, toAccount, amount);
        System.out.println("Transfer successful.");
    }

    private static void checkBalance(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Current Balance: " + account.getBalance());
    }

    private static void viewTransactionHistory(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.printTransactionHistory();
    }
}