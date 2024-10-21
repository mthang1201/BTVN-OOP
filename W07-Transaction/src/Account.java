import java.util.ArrayList;

public class Account {
    private double balance;

    private ArrayList<Transaction> transitionList;

    /**
     * Constructor.
     */
    public Account() {
        this.balance = 0;
        this.transitionList = new ArrayList<>();
    }

    /**
     * deposit.
     *
     * @param amount account.
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * withdraw.
     *
     * @param amount account.
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * Add new transaction.
     *
     * @param amount of the new transaction.
     * @param operation of the new transaction.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }

        Transaction newTransaction = new Transaction(operation, amount, this.balance);

        transitionList.add(newTransaction);
    }

    /**
     * Print list of transactions.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");

            Transaction currentTransaction = transitionList.get(i);

            String currentOperation = currentTransaction.getOperation();
            if (currentOperation.equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien ");
            } else if (currentOperation.equals(Transaction.WITHDRAW)) {
                System.out.print("Rut tien ");
            }

            double currentAmount = currentTransaction.getAmount();
            System.out.print("$" + String.format("%.2f", currentAmount) + ". ");

            System.out.print("So du luc nay: " + "$");

            double currentBalance = currentTransaction.getBalance();
            System.out.println(String.format("%.2f", currentBalance) + ".");
        }
        System.out.println();
    }
}
 
