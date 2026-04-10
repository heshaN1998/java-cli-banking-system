import java.awt.font.FontRenderContext;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accounts;
    private int accuntCounter;

    public Bank() {
        this.accounts = new HashMap<>();
        this.accuntCounter = 1001000100;
    }

    public BankAccount createAccount(String accounHolderName) {
        String accountNumber = String.valueOf(accuntCounter++);
        BankAccount account = new BankAccount(accountNumber, accounHolderName);
        accounts.put(accountNumber, account);
        return account;
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void withdrawFromAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.withdraw(amount);
    }

    public void depositToAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.deposit(amount);
    }

    public void transferBetweenAccount(String fromAccountNumber, String toAccount, double amount) {
        BankAccount sender = findAccount(fromAccountNumber);
        BankAccount receiver = findAccount(toAccount);

        if (sender == null) {
            throw new IllegalArgumentException("sender account not found");
        }
        if (receiver == null) {
            throw new IllegalArgumentException("Receiver account not found");
        }
        sender.transfer(receiver, amount);
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No account available");
            return;
        }
        System.out.println("\n**** ALL BANK ACCOUNTS ****");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
}


