public class CurrentAccount extends BankAccount {
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double overdraftLimit) {
        super(accountNumber, accountHolderName);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        if (amount > (balance + overdraftLimit)) {
            throw new IllegalArgumentException(
                    "Withdrawal exceeds overdraft limit."
            );
        }

        balance -= amount;
        addTransaction("WITHDRAW", amount, "Withdrawn from current account");
    }
}