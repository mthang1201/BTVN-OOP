import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Bank.
 */
public class Bank {
    private List<Customer> customerList;

    /**
     * Constructor.
     */
    public Bank() {
        customerList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream("src/customers.txt")) {
            readCustomerList(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param inputStream input.
     */
    public void readCustomerList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer currentCustomer = null;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.contains("CHECKING") && !line.contains("SAVINGS")) {
                    String[] parts = line.split(" ");

                    String fullName = parts[0] + " " + parts[1] + " " + parts[2];
                    long idNumber = Long.parseLong(parts[3]);

                    currentCustomer = new Customer(idNumber, fullName);

                    customerList.add(currentCustomer);
                } else if (currentCustomer != null) {
                    String[] parts = line.split(" ");

                    long accountNumber = Long.parseLong(parts[0]);
                    String accountType = parts[1];
                    double balance = Double.parseDouble(parts[2]);

                    Account account;
                    if (accountType.equals(Account.CHECKING)) {
                        account = new CheckingAccount(accountNumber, balance);
                    } else if (accountType.equals(Account.SAVINGS)) {
                        account = new SavingsAccount(accountNumber, balance);
                    } else {
                        break;
                    }

                    currentCustomer.addAccount(account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return customer list in name order.
     */
    public String getCustomersInfoByNameOrder() {
        StringBuilder builder = new StringBuilder();

        List<Customer> currentList = getCustomerList();
        currentList.sort(Comparator.comparing(Customer::getFullName));

        for (Customer customer : currentList) {
            builder.append(customer.getCustomerInfo()).append("\n");
        }

        return builder.toString();
    }

    /**
     *
     * @return customer list in id order
     */
    public String getCustomersInfoByIdOrder() {
        StringBuilder builder = new StringBuilder();

        List<Customer> currentList = getCustomerList();
        currentList.sort(Comparator.comparingLong(Customer::getIdNumber));

        for (Customer customer : currentList) {
            builder.append(customer.getCustomerInfo()).append("\n");
        }

        return builder.toString();
    }

    /**
     *
     * @return customer list
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }
}
