import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();
        MarksManager marksManager = new MarksManager();
        AttendanceManager attendanceManager = new AttendanceManager();
        ReportManager reportManager = new ReportManager();
        DashboardManager dashboardManager = new DashboardManager();
        FileManager fileManager = new FileManager();

        ArrayList<Student> savedStudents = fileManager.loadStudents();

        for (Student savedStudent : savedStudents) {
            manager.loadStudent(savedStudent);
        }

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("   STUDENT PERFORMANCE MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Marks");
            System.out.println("7. View Performance");
            System.out.println("8. Record Attendance");
            System.out.println("9. View Attendance");
            System.out.println("10. Generate Performance Report");
            System.out.println("11. Class Performance Dashboard");
            System.out.println("0. Exit");
            System.out.println("========================================");

            int choice = InputValidator.getIntInRange(
                    scanner,
                    "Enter your choice: ",
                    0,
                    11
            );

            switch (choice) {

                case 1:

                    String name = InputValidator.getNonEmptyString(
                            scanner,
                            "Enter student name: "
                    );

                    int rollNumber = InputValidator.getIntInRange(
                            scanner,
                            "Enter roll number: ",
                            1,
                            100000
                    );

                    if (manager.findStudent(rollNumber) != null) {
                        System.out.println("Error: Roll number already exists.");
                        break;
                    }

                    int age = InputValidator.getIntInRange(
                            scanner,
                            "Enter age: ",
                            1,
                            100
                    );

                    Student student = new Student(
                            name,
                            rollNumber,
                            age
                    );

                    boolean added = manager.addStudent(student);

                    if (added) {
                        fileManager.saveAllStudents(
                                manager.getStudents()
                        );
                    }

                    break;

                case 2:

                    manager.displayStudents();

                    break;

                case 3:

                    int searchRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter roll number to search: ",
                            1,
                            100000
                    );

                    manager.searchStudent(searchRoll);

                    break;

                case 4:

                    int updateRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter roll number to update: ",
                            1,
                            100000
                    );

                    Student studentToUpdate =
                            manager.findStudent(updateRoll);

                    if (studentToUpdate == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    String newName = InputValidator.getNonEmptyString(
                            scanner,
                            "Enter new name: "
                    );

                    int newAge = InputValidator.getIntInRange(
                            scanner,
                            "Enter new age: ",
                            1,
                            100
                    );

                    boolean updated = manager.updateStudent(
                            updateRoll,
                            newName,
                            newAge
                    );

                    if (updated) {
                        fileManager.saveAllStudents(
                                manager.getStudents()
                        );
                    }

                    break;

                case 5:

                    int deleteRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter roll number to delete: ",
                            1,
                            100000
                    );

                    boolean deleted = manager.deleteStudent(deleteRoll);

                    if (deleted) {
                        fileManager.saveAllStudents(
                                manager.getStudents()
                        );
                    }

                    break;

                case 6:

                    int marksRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter student roll number: ",
                            1,
                            100000
                    );

                    Student marksStudent =
                            manager.findStudent(marksRoll);

                    if (marksStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    int javaMarks = InputValidator.getIntInRange(
                            scanner,
                            "Enter Java marks: ",
                            0,
                            100
                    );

                    int mathMarks = InputValidator.getIntInRange(
                            scanner,
                            "Enter Mathematics marks: ",
                            0,
                            100
                    );

                    int englishMarks = InputValidator.getIntInRange(
                            scanner,
                            "Enter English marks: ",
                            0,
                            100
                    );

                    boolean marksAdded = marksManager.addMarks(
                            marksStudent,
                            javaMarks,
                            mathMarks,
                            englishMarks
                    );

                    if (marksAdded) {
                        fileManager.saveAllStudents(
                                manager.getStudents()
                        );
                    }

                    break;

                case 7:

                    int performanceRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter student roll number: ",
                            1,
                            100000
                    );

                    Student performanceStudent =
                            manager.findStudent(performanceRoll);

                    if (performanceStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    marksManager.displayPerformance(
                            performanceStudent
                    );

                    break;

                case 8:

                    int attendanceRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter student roll number: ",
                            1,
                            100000
                    );

                    Student attendanceStudent =
                            manager.findStudent(attendanceRoll);

                    if (attendanceStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    int classesHeld = InputValidator.getIntInRange(
                            scanner,
                            "Enter total classes held: ",
                            1,
                            10000
                    );

                    int classesAttended = InputValidator.getIntInRange(
                            scanner,
                            "Enter classes attended: ",
                            0,
                            classesHeld
                    );

                    boolean attendanceRecorded =
                            attendanceManager.recordAttendance(
                                    attendanceStudent,
                                    classesHeld,
                                    classesAttended
                            );

                    if (attendanceRecorded) {
                        fileManager.saveAllStudents(
                                manager.getStudents()
                        );
                    }

                    break;

                case 9:

                    int viewAttendanceRoll =
                            InputValidator.getIntInRange(
                                    scanner,
                                    "Enter student roll number: ",
                                    1,
                                    100000
                            );

                    Student attendanceViewStudent =
                            manager.findStudent(
                                    viewAttendanceRoll
                            );

                    if (attendanceViewStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    attendanceManager.displayAttendance(
                            attendanceViewStudent
                    );

                    break;

                case 10:

                    int reportRoll = InputValidator.getIntInRange(
                            scanner,
                            "Enter student roll number: ",
                            1,
                            100000
                    );

                    Student reportStudent =
                            manager.findStudent(reportRoll);

                    if (reportStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    reportManager.generateReport(
                            reportStudent
                    );

                    break;

                case 11:

                    dashboardManager.displayDashboard(
                            manager.getStudents()
                    );

                    break;

                case 0:

                    running = false;

                    System.out.println(
                            "Thank you for using the system."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}