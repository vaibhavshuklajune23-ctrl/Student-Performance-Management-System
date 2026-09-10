public class ReportManager {

    public void generateReport(Student student) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       STUDENT PERFORMANCE REPORT");
        System.out.println("========================================");

        System.out.println("Name       : " + student.name);
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Age        : " + student.age);

        System.out.println();
        System.out.println("------ Academic Performance ------");

        if (student.javaMarks == -1) {

            System.out.println("Marks have not been entered.");

        } else {

            System.out.println(
                "Java       : " + student.javaMarks
            );

            System.out.println(
                "Mathematics: " + student.mathMarks
            );

            System.out.println(
                "English    : " + student.englishMarks
            );

            System.out.println("----------------------------------");

            System.out.println(
                "Total      : " + student.calculateTotal()
            );

            System.out.printf(
                "Average    : %.2f%n",
                student.calculateAverage()
            );

            System.out.println(
                "Grade      : " + student.calculateGrade()
            );
        }

        System.out.println();
        System.out.println("------ Attendance ------");

        if (student.classesHeld == -1) {

            System.out.println(
                "Attendance has not been recorded."
            );

        } else {

            double attendancePercentage =
                (student.classesAttended * 100.0)
                / student.classesHeld;

            System.out.printf(
                "Attendance : %.2f%%%n",
                attendancePercentage
            );

            if (attendancePercentage >= 75) {
                System.out.println("Status     : ELIGIBLE");
            } else {
                System.out.println(
                    "Status     : LOW ATTENDANCE"
                );
            }
        }

        System.out.println();
        System.out.println("------ Overall Assessment ------");

        if (student.javaMarks == -1 ||
            student.classesHeld == -1) {

            System.out.println(
                "Complete marks and attendance data first."
            );

        } else {

            double average = student.calculateAverage();

            double attendance =
                (student.classesAttended * 100.0)
                / student.classesHeld;

            if (average >= 80 && attendance >= 75) {

                System.out.println(
                    "Performance: EXCELLENT"
                );

            } else if (average >= 60 && attendance >= 75) {

                System.out.println(
                    "Performance: GOOD"
                );

            } else if (average >= 50) {

                System.out.println(
                    "Performance: AVERAGE"
                );

            } else {

                System.out.println(
                    "Performance: NEEDS IMPROVEMENT"
                );
            }
        }

        System.out.println("========================================");
    }
}