/**
 * Person.
 */
public class Person implements Comparable<Person> {
    protected String name;

    protected int age;

    protected String address;

    /**
     * Person.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    /**
     * Person.
     *
     * @param name Person.
     * @param age Person.
     * @param address Person.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Person.
     *
     * @param p Person.
     * @return Person.
     */
    @Override
    public int compareTo(Person p) {
        int nameCompare = this.name.compareTo(p.getName());

        if (nameCompare == 0) {
            return Integer.compare(this.age, p.getAge());
        }

        return nameCompare;
    }
}
