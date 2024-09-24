/**
 * Staff.
 */
public class Staff extends Person {
    private String school;

    private double pay;

    /**
     *
     * @param name
     * @param address
     * @param school
     * @param pay
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "Staff{" +
                "school='" + school + '\'' +
                ", pay=" + pay +
                '}';
    }
}
