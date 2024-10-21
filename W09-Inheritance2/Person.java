/**
 * Person.
 */
public class Person {
    private String name;

    private String address;

    /**
     * Constructor.
     *
     * @param name Person.
     * @param address Person.
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * toString.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "Person["
                + "name="
                + name
                + ",address="
                + address
                + ']';
    }
}
