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
     *
     * @param amount of the account.
     */
    public void withdraw(double amount) {
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
