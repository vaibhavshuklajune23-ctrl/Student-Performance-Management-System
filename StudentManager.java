import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {

        if (findStudent(student.rollNumber) != null) {
            System.out.println("Error: Roll number already exists.");
            return false;
        }

        students.add(student);
        System.out.println("Student added successfully.");
        return true;
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println();
        System.out.println("========== STUDENT LIST ==========");

        for (Student student : students) {
            student.displayStudent();
            System.out.println("----------------------------------");
        }
    }

    public void searchStudent(int rollNumber) {

        Student student = findStudent(rollNumber);

        if (student != null) {
            System.out.println();
            System.out.println("Student Found:");
            student.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student findStudent(int rollNumber) {

        for (Student student : students) {

            if (student.rollNumber == rollNumber) {
                return student;
            }
        }

        return null;
    }

    public boolean updateStudent(
            int rollNumber,
            String newName,
            int newAge) {

        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        student.name = newName;
        student.age = newAge;

        System.out.println("Student updated successfully.");
        return true;
    }

    public boolean deleteStudent(int rollNumber) {

        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        students.remove(student);

        System.out.println("Student deleted successfully.");
        return true;
    }

    public void loadStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}