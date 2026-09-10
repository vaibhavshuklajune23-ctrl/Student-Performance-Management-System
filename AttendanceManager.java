public class AttendanceManager {

    public boolean recordAttendance(
            Student student,
            int classesHeld,
            int classesAttended) {

        if (classesHeld <= 0) {

            System.out.println(
                    "Classes held must be greater than 0."
            );

            return false;
        }

        if (classesAttended < 0
                || classesAttended > classesHeld) {

            System.out.println(
                    "Invalid attendance data."
            );

            return false;
        }

        student.classesHeld = classesHeld;
        student.classesAttended = classesAttended;

        System.out.println(
                "Attendance recorded successfully."
        );

        return true;
    }

    public void displayAttendance(Student student) {

        if (student.classesHeld == -1) {

            System.out.println(
                    "Attendance has not been recorded yet."
            );

            return;
        }

        double percentage =
                (student.classesAttended * 100.0)
                        / student.classesHeld;

        System.out.println();
        System.out.println("========== ATTENDANCE ==========");

        System.out.println(
                "Student: " + student.name
        );

        System.out.println(
                "Roll Number: " + student.rollNumber
        );

        System.out.println(
                "Classes Held: " + student.classesHeld
        );

        System.out.println(
                "Classes Attended: "
                        + student.classesAttended
        );

        System.out.printf(
                "Attendance: %.2f%%%n",
                percentage
        );

        if (percentage >= 75) {
            System.out.println("Status: ELIGIBLE");
        } else {
            System.out.println("Status: LOW ATTENDANCE");
        }

        System.out.println("================================");
    }
}