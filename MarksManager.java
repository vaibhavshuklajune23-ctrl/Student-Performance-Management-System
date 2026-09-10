public class MarksManager {

    public boolean addMarks(
            Student student,
            int javaMarks,
            int mathMarks,
            int englishMarks) {

        if (!validMarks(javaMarks)
                || !validMarks(mathMarks)
                || !validMarks(englishMarks)) {

            System.out.println(
                    "Invalid marks. Marks must be between 0 and 100."
            );

            return false;
        }

        student.javaMarks = javaMarks;
        student.mathMarks = mathMarks;
        student.englishMarks = englishMarks;

        System.out.println("Marks added successfully.");
        return true;
    }

    public void displayPerformance(Student student) {

        if (!hasCompleteMarks(student)) {
            System.out.println(
                    "Complete marks have not been entered yet."
            );
            return;
        }

        System.out.println();
        System.out.println("========== PERFORMANCE ==========");

        System.out.println("Student: " + student.name);
        System.out.println("Roll Number: " + student.rollNumber);

        student.displayMarks();

        System.out.println("---------------------------------");

        System.out.println(
                "Total: " + student.calculateTotal()
        );

        System.out.printf(
                "Average: %.2f%n",
                student.calculateAverage()
        );

        System.out.println(
                "Grade: " + student.calculateGrade()
        );

        System.out.println("=================================");
    }

    private boolean validMarks(int marks) {
        return marks >= 0 && marks <= 100;
    }

    private boolean hasCompleteMarks(Student student) {
        return student.javaMarks != -1
                && student.mathMarks != -1
                && student.englishMarks != -1;
    }
}