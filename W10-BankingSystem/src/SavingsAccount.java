/**
 * SavingsAccount.
 */
public class SavingsAccount extends Account {
    /**
     * Constructor.
     */
    SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * withdraw.
     *
     * @param amount of the account.
     */
    public void withdraw(double amount) {
        if (amount > 1000) {
            System.out.println("You can't withdraw more than $1000.");
            return;
        }
        if (getBalance() < 5000) {
            System.out.println("You can't withdraw when your balance is less than $5000.");
            return;
        }

        double initialBalance = this.getBalance();

        try {
            doWithdrawing(amount);
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
            return;
        }

        double finalBalance = this.getBalance();

        this.transactionList.add(new Transaction(
                Transaction.TYPE_WITHDRAW_SAVINGS,
                amount,
                initialBalance,
                finalBalance
        ));
    }

    /**
     * deposit.
     *
     * @param amount of the account.
     */
    public void deposit(double amount) {
        double initialBalance = this.getBalance();

        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
            return;
        }

        double finalBalance = this.getBalance();

        this.transactionList.add(new Transaction(
                Transaction.TYPE_DEPOSIT_SAVINGS,
                amount,
                initialBalance,
                finalBalance
        ));
    }
}
