import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accounts;
    private int accountCounter;

    public Bank() {
        accounts = new HashMap<>();
        accountCounter = 1001000;
    }

    public BankAccount createSavingsAccount(String holderName, double minimumBalance) {
        String accountNumber = String.valueOf(accountCounter++);
        BankAccount account = new SavingsBankAccount(accountNumber, holderName, minimumBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public BankAccount createCurrentAccount(String holderName, double overdraftLimit) {
        String accountNumber = String.valueOf(accountCounter++);
        BankAccount account = new CurrentAccount(accountNumber, holderName, overdraftLimit);
        accounts.put(accountNumber, account);
        return account;
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void depositToAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }
        account.deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }
        account.withdraw(amount);
    }

    public void transferBetweenAccounts(String fromAccount, String toAccount, double amount) {
        BankAccount sender = findAccount(fromAccount);
        BankAccount receiver = findAccount(toAccount);

        if (sender == null) {
            throw new IllegalArgumentException("Sender account not found.");
        }

        if (receiver == null) {
            throw new IllegalArgumentException("Receiver account not found.");
        }

        sender.transfer(receiver, amount);
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("\n--- All Bank Accounts ---");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
}