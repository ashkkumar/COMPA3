import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        students s = new students();
        s.getAllStudents(); // Getting all students from initial example
        System.out.print("\n");


        // Adding a student
        //s.addStudent("Ash", "Kumar", "ash.kumar@example.com", "2024-03-15");
        //s.getAllStudents();
        //System.out.print("\n");

        // Updating the new students email
        //s.updateStudentEmail(13, "ashkuma@cmail.com");
        //s.getAllStudents();
        //System.out.print("\n");

        // Removing the new student
        s.deleteStudent(13);
        s.getAllStudents();
    }


}