public class Student {

    String name;
    int rollNumber;
    int age;

    int javaMarks;
    int mathMarks;
    int englishMarks;

    int classesHeld;
    int classesAttended;

    Student(String name, int rollNumber, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;

        javaMarks = -1;
        mathMarks = -1;
        englishMarks = -1;

        classesHeld = -1;
        classesAttended = -1;
    }

    void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Age: " + age);
    }

    void displayMarks() {
        System.out.println("Java: " + javaMarks);
        System.out.println("Mathematics: " + mathMarks);
        System.out.println("English: " + englishMarks);
    }

    int calculateTotal() {
        return javaMarks + mathMarks + englishMarks;
    }

    double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    String calculateGrade() {

        double average = calculateAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}