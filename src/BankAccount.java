import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private final List<Transaction> transactions;

    public BankAccount(String accountNumber,String accountHolderName){
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=0.0;
        this.transactions=new ArrayList<>();
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if (amount<=0){
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }
        balance=balance+amount;
        transactions.add(new Transaction("Deposit",amount,"Amount deposited"));
    }

    public void withdraw(double amount){
        if (amount<=0){
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
        if(amount>balance){
            throw new IllegalArgumentException("you cannot withdraw this much");
        }
        balance=balance-amount;
        transactions.add(new Transaction("WITHDRAW",amount,"amoun withdrawn"));
    }


}
