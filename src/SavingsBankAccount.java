public class SavingsBankAccount extends BankAccount {
    private final double minimumBalance;

    public SavingsBankAccount(String accountNumber, String accountHolderName, double minimumBalance) {
        super(accountNumber, accountHolderName);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        if ((balance - amount) < minimumBalance) {
            throw new IllegalArgumentException(
                    "Cannot withdraw. Minimum balance of " + minimumBalance + " must be maintained."
            );
        }

        balance -= amount;
        addTransaction("WITHDRAW", amount, "Withdrawn from savings account");
    }
}