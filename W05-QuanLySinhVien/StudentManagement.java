/**
 * Created by CCNE on 20/09/2024.
 */
public class StudentManagement {
    Student[] students;

    /**
     * Initiate.
     */
    public StudentManagement() {
        this.students = new Student[100];
    }

    /**
     * Add Student.
     *
     * @param newStudent the new student
     */
    public void addStudent(Student newStudent) {
        for (int i = 0; i < students.length; ++i) {
            if (students[i] == null) {
                students[i] = newStudent;
                return;
            }
        }
    }

    /**
     * Remove Student.
     *
     * @param id student's id
     */
    public void removeStudent(String id) {
        for (int i = 0; i < students.length; ++i) {
            if (students[i] == null) {
                continue;
            }

            if (students[i].getId().equals(id)) {
                for (int k = i; k < students.length - 1; ++k) {
                    students[k] = students[k + 1];
                }
            }
        }

        students[students.length - 1] = null;
    }

    /**
     * Get String students by group.
     *
     * @return student by group.
     */
    public String studentsByGroup() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < students.length; ++i) {
            if (students[i] == null) {
                continue;
            }

            if (i == 0 || !(students[i].getGroup().equals(students[i - 1].getGroup()))) {
                res.append(students[i].getGroup()).append("\n");
            }

            res.append(students[i].getInfo()).append("\n");
        }

        return res.toString();
    }

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Main.
     *
     * @param args for arguments in commandline.
     */
    public static void main(String[] args) {
        // Create an instance of StudentManagement
        StudentManagement studentManagement = new StudentManagement();

        // Create some students
        Student student1 = new Student("Alice", "001", "alice@example.com");
        Student student2 = new Student("Bob", "002", "bob@example.com");
        Student student3 = new Student("Charlie", "003", "charlie@example.com");

        // Add students to management
        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);
        studentManagement.addStudent(student3);

        // Test: Display all students by group
        System.out.println("Students by group:");
        System.out.println(studentManagement.studentsByGroup());

        // Test: Remove a student and display the result
        System.out.println("Removing student with ID 002...");
        studentManagement.removeStudent("002");

        // Display all students again
        System.out.println("Students by group after removal:");
        System.out.println(studentManagement.studentsByGroup());

        // Test: Check that student with ID 002 is removed
        System.out.println("Expected: 2 students remaining");
        System.out.println("Actual count: " + studentManagement.students.length);

        // Test: Add a duplicate student and display result
        System.out.println("Trying to add a duplicate student with ID 001...");
        studentManagement.addStudent(student1); // should not add

        // Display all students again to confirm no duplicate added
        System.out.println("Students by group after trying to add a duplicate:");
        System.out.println(studentManagement.studentsByGroup());

        // Test: Remove a non-existent student
        System.out.println("Removing student with ID 999 (non-existent)...");
        studentManagement.removeStudent("999"); // should do nothing

        // Display all students again
        System.out.println("Students by group after trying to remove non-existent:");
        System.out.println(studentManagement.studentsByGroup());

        // Create another student to demonstrate copy constructor
        Student student4 = new Student(student1); // Copying student1
        System.out.println("Copied student info:");
        System.out.println(student4.getInfo());
//        // Create an instance of StudentManagement
//        StudentManagement studentManagement = new StudentManagement();
//
//        // Create some students
//        Student student1 = new Student("Alice", "001", "alice@example.com");
//        Student student2 = new Student("Bob", "002", "bob@example.com");
//        Student student3 = new Student("Charlie", "003", "charlie@example.com");
//
//        // Add students to management
//        studentManagement.addStudent(student1);
//        studentManagement.addStudent(student2);
//        studentManagement.addStudent(student3);
//
//        // Display all students by group
//        System.out.println("Students by group:");
//        System.out.println(studentManagement.studentsByGroup());
//
//        // Remove a student
//        System.out.println("Removing student with ID 002...");
//        studentManagement.removeStudent("002");
//
//        // Display all students again
//        System.out.println("Students by group after removal:");
//        System.out.println(studentManagement.studentsByGroup());
//
//        // Create another student to demonstrate copy constructor
//        Student student4 = new Student(student1); // Copying student1
//        System.out.println("Copied student info:");
//        System.out.println(student4.getInfo());
    }
}
