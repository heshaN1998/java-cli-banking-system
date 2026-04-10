import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    protected double balance;
    private final List<Transaction> transactions;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Account No: " + accountNumber + " | Name: " + accountHolderName + " | Type: "+this.getClass().getSimpleName()+" | Balance: " + balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }
        balance = balance + amount;
        addTransaction("DEPOSIT", amount, "Amount deposited");

    }

    public  abstract void withdraw(double amount);


    public void transfer(BankAccount receiver, double amount) {
        if (receiver == null) {
            throw new IllegalArgumentException("Reciever amount not found");
        }
        if (this.accountNumber.equals(receiver.accountNumber)) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        this.withdraw(amount);
        receiver.balance = receiver.balance + amount;

        addTransaction("TransferOut",amount,"Transferred to aacoount"+receiver.getAccountNumber());
        receiver.addTransaction("Transfer in",amount,"Recieved account from"+this.getAccountNumber());

    }
    protected void addTransaction(String type,double amount,String note){
        transactions.add(new Transaction(type,amount,note));
    }

    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transaction found");
            return;
        }
        System.out.println("\n Transaction history for account: " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

    }

}
