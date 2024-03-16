import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public String url = "jdbc:postgresql://localhost:5432/Students";
    public String user = "postgres";
    public String password = "admin";

    public static void main(String[] args) {

        students s = new students();
        s.getAllStudents();

        //s.addStudent("Ash", "Kumar", "ash.kumar@example.com", "2024-03-15");
        s.updateStudentEmail(4, "ashkuma@cmail.com");
        System.out.println("\n");
        s.getAllStudents();

        System.out.println("\n");
        s.deleteStudent(4);
        s.getAllStudents();
    }


}