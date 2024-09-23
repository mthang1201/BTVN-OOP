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

        try {
            doWithdrawing(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param amount of the account.
     */
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
