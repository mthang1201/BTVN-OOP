import java.util.ArrayList;
import java.util.List;

/**
 * Customer.
 */
public class Customer {
    private List<Account> accountList;

    private long idNumber;

    private String fullName;

    /**
     * Constructor1.
     */
    public Customer() {
        this.idNumber = 0;
        this.fullName = "";
        this.accountList = new ArrayList<>();
    }

    /**
     * Constructor2.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.accountList = new ArrayList<>();
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
    }

    /**
     *
     * @param account of the customer.
     */
    public void addAccount(Account account) {
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    /**
     *
     * @param account of the customer.
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
