import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        while (running) {
            System.out.println("\n**** CLI Banking ****");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Show All Accounts");
            System.out.println("8. Exit");
            System.out.println("ENTER YOUR CHOICE: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        createAccount(scanner, bank);
                        break;
                    case 2:
                        deposit(scanner, bank);
                        break;
                    case 3:
                        withdraw(scanner, bank);
                        break;
                    case 4:
                        transfer(scanner, bank);
                        break;
                    case 5:
                        checkBalance(scanner, bank);
                        break;
                    case 6:
                        viewTransactionHistory(scanner, bank);
                        break;
                    case 7:
                        bank.showAllAccounts();
                        break;
                    case 8:
                        running = false;
                        System.out.println("THANK YOU FOR USING SYSTEM");
                        break;
                    default:
                        System.out.println("INVALID CHOICE.PLEASE ENTER NUMBER BETWEEN 1 AND 8");

                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT.PLEASE ENTER A VALID NUMBER");
            } catch (IllegalArgumentException e) {
                System.out.println(" ERROR: " + e.getMessage());
            }
        }
        scanner.close();

    }

    private static void createAccount(Scanner scanner, Bank bank) {
        System.out.println("Enter account holder name:");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Account holder name cannot be empty ");
            return;
        }
        BankAccount newAccount = bank.createAccount(name);
        System.out.println("Account created successfully ");
        System.out.println("Account Number: " + newAccount.getAccountNumber());
        System.out.println("Account Holder: " + newAccount.getAccountHolderName());
    }

    private static void deposit(Scanner scanner, Bank bank) {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        bank.depositToAccount(accountNumber, amount);
        System.out.println("Deposit successful ");
    }

    private static void withdraw(Scanner scanner, Bank bank) {
        System.out.println("Enter account number");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter withdrawal amount");
        double amount = Double.parseDouble(scanner.nextLine());


        bank.withdrwFromAccount(accountNumber, amount);
        System.out.println("Withdrawal successfully");
    }

    private static void transfer(Scanner scanner, Bank bank) {
        System.out.println("Enter sender account number: ");
        String fromAccount = scanner.nextLine();

        System.out.println("Enter receiver account number: ");
        String toAccount = scanner.nextLine();

        System.out.println("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        bank.transferBetweenAccount(fromAccount, toAccount, amount);
        System.out.println("Transfer successful. ");

    }

    private static void checkBalance(Scanner scanner,Bank bank){
        System.out.println("check balance");
    }

    private static void viewTransactionHistory(Scanner scanner,Bank bank){
        System.out.println("view transaction history");
    }

}




