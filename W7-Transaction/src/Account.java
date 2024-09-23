import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;

    private List<Transaction> transactions;

    /**
     * Constructor.
     */
    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

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

        transactions.add(newTransaction);
    }

    /**
     * Print list of transactions.
     */
    public void printTransaction() {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction currentTransaction = transactions.get(i);
            String currentOperation = currentTransaction.getOperation();
            double currentAmount = currentTransaction.getAmount();
            double currentBalance = currentTransaction.getBalance();

            System.out.print("Giao dich " + (i + 1) + ": ");
            if (currentOperation.equals(Transaction.DEPOSIT)) {
                System.out.print("Nap tien ");
            } else if (currentOperation.equals(Transaction.WITHDRAW)) {
                System.out.print("Rut tien ");
            }
            System.out.print("$" + String.format("%.2f", currentAmount) + ". ");
            System.out.println("So du luc nay: " + String.format("%.2f", currentBalance) + ".");
        }
        System.out.println();
    }

    /**
     * Main.
     *
     * @param args for commandline arguments.
     */
    public static void main(String[] args) {
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
