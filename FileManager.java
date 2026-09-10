import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public void saveAllStudents(ArrayList<Student> students) {

        try {
            FileWriter writer = new FileWriter("students.txt");

            for (Student student : students) {

                writer.write(
                    student.name + "," +
                    student.rollNumber + "," +
                    student.age + "," +
                    student.javaMarks + "," +
                    student.mathMarks + "," +
                    student.englishMarks + "," +
                    student.classesHeld + "," +
                    student.classesAttended + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                "Error saving student data."
            );
        }
    }

    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                        new FileReader("students.txt")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length != 8) {
                    continue;
                }

                try {

                    String name = data[0];

                    int rollNumber =
                            Integer.parseInt(data[1]);

                    int age =
                            Integer.parseInt(data[2]);

                    Student student =
                            new Student(
                                name,
                                rollNumber,
                                age
                            );

                    student.javaMarks =
                            Integer.parseInt(data[3]);

                    student.mathMarks =
                            Integer.parseInt(data[4]);

                    student.englishMarks =
                            Integer.parseInt(data[5]);

                    student.classesHeld =
                            Integer.parseInt(data[6]);

                    student.classesAttended =
                            Integer.parseInt(data[7]);

                    students.add(student);

                } catch (NumberFormatException e) {

                    System.out.println(
                        "Skipping invalid student record."
                    );
                }
            }

            reader.close();

        } catch (IOException e) {

            // File may not exist during the first run.
        }

        return students;
    }
}