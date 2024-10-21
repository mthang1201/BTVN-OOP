import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Account.
 */
public abstract class Account {
    public static final String CHECKING = "CHECKING";

    public static final String SAVINGS = "SAVINGS";

    private long accountNumber;

    private double balance;

    protected List<Transaction> transactionList;

    /**
     * Constructor1.
     */
    public Account() {
        this.accountNumber = 0;
        this.balance = 0.0;
        this.transactionList = new ArrayList<>();
    }

    /**
     * Constructor2.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * doWithdrawing.
     *
     * @param amount of the account.
     * @throws InsufficientFundsException error.
     * @throws InvalidFundingAmountException error.
     */
    public void doWithdrawing(double amount) throws InsufficientFundsException,
            InvalidFundingAmountException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException(amount);
        }

        this.balance -= amount;
    }

    /**
     * doDepositing.
     *
     * @param amount of the account.
     * @throws InvalidFundingAmountException error.
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }

        this.balance += amount;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * getTransactionHistory.
     *
     * @return transaction history.
     */
    public String getTransactionHistory() {
        StringBuilder builder = new StringBuilder();
        builder.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":");
        for (Transaction transaction : transactionList) {
            builder.append("\n").append(transaction.getTransactionSummary());
        }
        return builder.toString();
    }

    /**
     * addTransaction.
     *
     * @param transaction of the account.
     */
    public void addTransaction(Transaction transaction) {
        if (!transactionList.contains(transaction)) {
            transactionList.add(transaction);
        }
    }

    /**
     * equals.
     *
     * @param obj other.
     * @return whether it's equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        Account account = (Account) obj;
        return Objects.equals(this.accountNumber, account.accountNumber);
    }
}
