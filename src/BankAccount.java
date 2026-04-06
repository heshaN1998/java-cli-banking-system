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
    @Override
    public String toString(){
        return "Account No: "+accountNumber +" | Name: "+accountHolderName+" | Balance: "+balance;
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

    public void transfer(BankAccount reciever,double amount){
        if(reciever==null){
            throw new IllegalArgumentException("Reciever amount not found");
        }
        if (reciever.getAccountNumber().equals(this.accountNumber)){
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }
        if (amount<=0){
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient balance for transfer");
        }
        this.balance=this.balance-amount;
        reciever.balance= reciever.balance+amount;

        this.transactions.add(new Transaction(
                "Transfer_out",amount,"Transfered to account"+reciever.getAccountNumber()

        ));

        reciever.transactions.add(new Transaction(
                "Transfer_in",amount,"Recived from account"+this.accountNumber
        ));
    }
public void printTransactionHistory(){
        if (transactions.isEmpty()){
            System.out.println("No transaction found");
            return;
        }
    System.out.println("\n Transaction history for account: "+accountNumber);
        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }

}

}
