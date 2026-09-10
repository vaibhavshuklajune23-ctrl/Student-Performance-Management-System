import java.util.ArrayList;

public class DashboardManager {

    public void displayDashboard(ArrayList<Student> students) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       CLASS PERFORMANCE DASHBOARD");
        System.out.println("========================================");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            System.out.println("========================================");
            return;
        }

        int totalStudents = students.size();

        int studentsWithMarks = 0;
        int studentsWithAttendance = 0;
        int lowAttendanceStudents = 0;

        double totalMarksAverage = 0;
        double totalAttendance = 0;

        double highestAverage = -1;
        String topStudent = "N/A";

        int excellent = 0;
        int good = 0;
        int average = 0;
        int needsImprovement = 0;

        for (Student student : students) {

            // Academic performance
            if (student.javaMarks != -1) {

                studentsWithMarks++;

                double studentAverage =
                        student.calculateAverage();

                totalMarksAverage += studentAverage;

                if (studentAverage > highestAverage) {

                    highestAverage = studentAverage;
                    topStudent = student.name;
                }

                if (studentAverage >= 80) {
                    excellent++;
                } else if (studentAverage >= 60) {
                    good++;
                } else if (studentAverage >= 50) {
                    average++;
                } else {
                    needsImprovement++;
                }
            }

            // Attendance
            if (student.classesHeld != -1) {

                studentsWithAttendance++;

                double attendancePercentage =
                        (student.classesAttended * 100.0)
                        / student.classesHeld;

                totalAttendance += attendancePercentage;

                if (attendancePercentage < 75) {
                    lowAttendanceStudents++;
                }
            }
        }

        double classAverage = 0;

        if (studentsWithMarks > 0) {
            classAverage =
                    totalMarksAverage / studentsWithMarks;
        }

        double averageAttendance = 0;

        if (studentsWithAttendance > 0) {
            averageAttendance =
                    totalAttendance / studentsWithAttendance;
        }

        System.out.println();
        System.out.println("Total Students       : "
                + totalStudents);

        System.out.println("Students with Marks  : "
                + studentsWithMarks);

        System.out.printf(
                "Class Average        : %.2f%%%n",
                classAverage
        );

        if (studentsWithMarks > 0) {

            System.out.printf(
                    "Highest Average      : %.2f%%%n",
                    highestAverage
            );

            System.out.println(
                    "Top Student          : " + topStudent
            );

        } else {

            System.out.println(
                    "Highest Average      : N/A"
            );

            System.out.println(
                    "Top Student          : N/A"
            );
        }

        System.out.println();
        System.out.println("------ Attendance Overview ------");

        System.out.printf(
                "Average Attendance   : %.2f%%%n",
                averageAttendance
        );

        System.out.println(
                "Low Attendance       : "
                        + lowAttendanceStudents
        );

        System.out.println();
        System.out.println("------ Performance Summary ------");

        System.out.println(
                "Excellent            : " + excellent
        );

        System.out.println(
                "Good                 : " + good
        );

        System.out.println(
                "Average              : " + average
        );

        System.out.println(
                "Needs Improvement    : "
                        + needsImprovement
        );

        System.out.println(
                "========================================"
        );
    }
}