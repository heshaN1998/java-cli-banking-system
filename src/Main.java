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
                        bank.showAllAccount();
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
}