/**
 * Created by CCNE on 20/09/2024.
 */
public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setId(String n) {
        this.id = n;
    }

    public void setGroup(String n) {
        this.group = n;
    }

    public void setEmail(String n) {
        this.email = n;
    }

    String getInfo() {
        return name + " - " + id + " - " + group + " - " + email;
    }

    /**
     * Constructor 1.
     */
    public Student() {
        this.name = "Student";
        this.id = "000";
        this.group = "K62CB";
        this.email = "uet@vnu.edu.vn";
    }

    /**
     * Constructor 2.
     *
     * @param name student's name.
     * @param id student's id.
     * @param email student's email.
     */
    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.group = "K62CB";
        this.email = email;
    }

    /**
     * Constructor 3.
     *
     * @param s for students.
     */
    public Student(Student s) {
        this.name = s.getName();
        this.id = s.getId();
        this.group = s.getGroup();
        this.email = s.getEmail();
    }
}