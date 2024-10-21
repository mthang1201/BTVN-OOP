/**
 * CheckingAccount.
 */
public class CheckingAccount extends Account {
    /**
     * Constructor.
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * withdraw.
     *
     * @param amount of the account.
     */
    public void withdraw(double amount) {
        double initialBalance = getBalance();

        try {
            doWithdrawing(amount);
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
            return;
        }

        double finalBalance = this.getBalance();

        this.transactionList.add(new Transaction(
                Transaction.TYPE_WITHDRAW_CHECKING,
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
        double initialBalance = getBalance();

        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
            return;
        }

        double finalBalance = this.getBalance();

        this.transactionList.add(new Transaction(
                Transaction.TYPE_DEPOSIT_CHECKING,
                amount,
                initialBalance,
                finalBalance
        ));
    }
}
