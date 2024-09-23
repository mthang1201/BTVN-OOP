import java.util.ArrayList;
import java.util.List;

/**
 * Main.
 */
public class Main {
    /**
     *
     * @param args for commandline arguments.
     */
    public static void main(String[] args) {
        /*{
            List<Customer> customers = new ArrayList<>();

            // Create customers and their accounts
            Customer customerA = new Customer(123456789, "Nguyễn Thị A");
            customerA.addAccount(new CheckingAccount(1234567890, 1000.0));
            customerA.addAccount(new SavingsAccount(1234567891, 3000.0));
            customers.add(customerA);

            Customer customerB = new Customer(123456788, "Lê Hoàng B");
            customerB.addAccount(new CheckingAccount(1234567892, 5000.0));
            customers.add(customerB);

            Customer customerC = new Customer(123456787, "Hoàng Văn C");
            Account c = new SavingsAccount(1234567891, 3000.0);
            customerC.removeAccount(c);
            customers.add(customerC);
        }*/

        Bank bank = new Bank();
        System.out.println(bank.getCustomersInfoByIdOrder());
    }
}