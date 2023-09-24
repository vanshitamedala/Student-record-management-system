import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private String dateOfBirth;
    private String contactDetails;
    private String enrollmentDate;

    public Student(String name, String dateOfBirth, String contactDetails, String enrollmentDate) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactDetails = contactDetails;
        this.enrollmentDate = enrollmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDate of Birth: " + dateOfBirth + "\nContact Details: " + contactDetails + "\nEnrollment Date: " + enrollmentDate;
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Student Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Records");
            System.out.println("4. Search Students");
            System.out.println("5. Generate Reports");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Adding a new student:");
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Enter Contact Details: ");
                    String contactDetails = scanner.nextLine();
                    System.out.print("Enter Enrollment Date: ");
                    String enrollmentDate = scanner.nextLine();

                    Student newStudent = new Student(name, dateOfBirth, contactDetails, enrollmentDate);
                    students.add(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.println("Updating student information:");
                    System.out.print("Enter the name of the student to update: ");
                    String studentName = scanner.nextLine();

                    for (Student student : students) {
                        if (student.getName().equals(studentName)) {
                            System.out.print("Enter new Name: ");
                            student.setName(scanner.nextLine());
                            System.out.print("Enter new Date of Birth: ");
                            student.setDateOfBirth(scanner.nextLine());
                            System.out.print("Enter new Contact Details: ");
                            student.setContactDetails(scanner.nextLine());
                            System.out.print("Enter new Enrollment Date: ");
                            student.setEnrollmentDate(scanner.nextLine());
                            System.out.println("Student information updated successfully.");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Viewing student records:");
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 4:
                    System.out.println("Searching for students:");
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;

                    for (Student student : students) {
                        if (student.getName().equals(searchName)) {
                            System.out.println("Student Found:\n" + student);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Generating reports:");
                    // Implement code to generate reports here
                    break;

                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
