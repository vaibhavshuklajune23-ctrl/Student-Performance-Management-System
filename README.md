# Student Performance Management System

## 1. Project Overview

The Student Performance Management System is a console-based Java application designed to manage student information, academic marks, attendance, and performance reports.

The system allows users to add, view, search, update, and delete student records. It also provides marks management, attendance tracking, individual performance reports, and a class performance dashboard.

The application stores student data in a local text file so that information remains available after restarting the program.

## 2. Features

### Student Management

* Add student
* View all students
* Search student by roll number
* Update student information
* Delete student
* Prevent duplicate roll numbers

### Marks Management

* Enter marks for Java, Mathematics, and English
* Calculate total marks
* Calculate average marks
* Calculate grade
* Validate marks between 0 and 100

### Attendance Management

* Record total classes
* Record attended classes
* Calculate attendance percentage
* Determine attendance eligibility
* Validate attendance values

### Reports and Dashboard

* Generate individual student performance report
* Generate class performance dashboard
* Display class average
* Identify highest-performing student
* Display attendance statistics
* Display performance categories

### Data Management

* Save student information to a local file
* Load saved information when the program starts
* Handle invalid input without crashing

## 3. Technologies Used

* Java
* Java Collections Framework
* ArrayList
* File Handling
* Exception Handling
* Object-Oriented Programming
* Visual Studio Code
* Git and GitHub

## 4. Project Structure

```text
StudentPerformanceManagementSystem/
│
├── Main.java
├── Student.java
├── StudentManager.java
├── MarksManager.java
├── AttendanceManager.java
├── FileManager.java
├── InputValidator.java
├── ReportManager.java
├── DashboardManager.java
├── students.txt
├── .gitignore
│
└── tests/
    └── TestCases.md
```

## 5. Requirements

To run this project, you need:

* Java Development Kit (JDK)
* A terminal or command prompt

The project uses standard Java features and does not require any external libraries.

## 6. How to Run

### Step 1: Open the project folder

Open a terminal inside the project folder.

### Step 2: Compile the Java files

Run:

```text
javac Main.java Student.java StudentManager.java MarksManager.java AttendanceManager.java FileManager.java InputValidator.java ReportManager.java DashboardManager.java
```

### Step 3: Run the application

Run:

```text
java Main
```

### Step 4: Use the menu

The application provides options for:

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Add Marks
7. View Performance
8. Record Attendance
9. View Attendance
10. Generate Performance Report
11. Class Performance Dashboard
12. Exit

## 7. Data Storage

Student information is stored in:

```text
students.txt
```

The file stores student information, marks, and attendance data.

The application automatically loads the saved records when it starts.

## 8. Testing

Test cases are documented in:

```text
tests/TestCases.md
```

Testing includes:

* Student creation
* Duplicate roll number validation
* Search
* Update
* Delete
* Marks validation
* Attendance validation
* Performance calculations
* Report generation
* Dashboard
* Data persistence
* Invalid input handling

## 9. Error Handling

The application validates user input and prevents invalid values such as:

* Non-numeric values where numbers are required
* Marks outside the range 0–100
* Negative attendance values
* Attendance greater than classes held
* Empty student names
* Duplicate roll numbers

## 10. Future Enhancements

Possible future improvements include:

* Graphical user interface
* Database integration
* Login and authentication
* More subjects
* Export reports to PDF
* Monthly attendance tracking
* More advanced analytics

## 11. Author

Student Performance Management System developed as an academic Java project.
