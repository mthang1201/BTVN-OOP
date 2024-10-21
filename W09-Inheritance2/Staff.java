/**
 * Staff.
 */
public class Staff extends Person {
    private String school;

    private double pay;

    /**
     * Constructor.
     *
     * @param name Staff.
     * @param address Staff.
     * @param school Staff.
     * @param pay Staff.
     */
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    /**
     * toString.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "Staff["
                + super.toString()
                + ",school="
                + school
                + ",pay="
                + pay
                + ']';
    }
}
 
