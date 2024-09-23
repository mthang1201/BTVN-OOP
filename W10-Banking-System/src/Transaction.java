/**
 * Transaction.
 */
public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;

    public static final int TYPE_WITHDRAW_CHECKING = 1;

    public static final int TYPE_DEPOSIT_SAVINGS = 2;

    public static final int TYPE_WITHDRAW_SAVINGS = 3;

    private int type;

    private double amount;

    private double initialBalance;

    private double finalBalance;

    /**
     * Constructor.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     *
     * @return transaction type in string format.
     */
    public String getTransactionTypeString() {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
        }
        return "";
    }

    /**
     *
     * @return transaction summary.
     */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString() +
               ". Số dư ban đầu: $" + String.format("%.2f", initialBalance) +
               ". Số tiền: $" + String.format("%.2f", amount) +
               ". Số dư cuối: $" + String.format("%.2f", finalBalance) +".";
    }
}
