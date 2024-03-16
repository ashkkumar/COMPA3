import java.sql.*;

public class students {

    // Set up access
    String url = "jdbc:postgresql://localhost:5432/Students";
    String user = "postgres";
    String password = "admin";

    public void getAllStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password); // connect to db
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students"); // we want all values from table
            ResultSet result = statement.getResultSet(); // get result

            while (result.next()) {

                // get each attribute of the table
                int id = result.getInt("student_id");
                String fname = result.getString("first_name");
                String lname = result.getString("last_name");
                String email = result.getString("email");
                Date date = result.getDate("enrollment_date");

                // Printing out the table from the database
                System.out.println("student_id: " + id + ", first_name: " + fname +
                        ", last_name: " + lname + ", email: " + email +
                        ", enrollment_date: " + date);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {

        // Creating a string for the sql statement
        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        // Converting String to Date so that it matches datatype in the Database
        Date date = Date.valueOf(enrollment_date);

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password); // Connectint to db
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, first_name); // Setting first name
            statement.setString(2, last_name); // setting last name
            statement.setString(3, email); // setting email
            statement.setDate(4, date); // setting join date
            statement.executeUpdate(); // updating database
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void updateStudentEmail(int id, String email){

        // Creating a string for the sql statement
        String insertSQL = "UPDATE students SET email = ? WHERE student_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password); // connecting to db
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, email); // Setting email
            statement.setInt(2, id); // selecting student id which we are changing the email for
            statement.executeUpdate(); // updating db
            statement.close();
            connection.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteStudent(int id){

        // Creating a string for the sql statement
        String insertSQL = "DELETE FROM students WHERE student_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password); // connecting to db
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setInt(1, id); // selecting student we wish to remove
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("No student found with student_id: " + id);
            }
            statement.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}




