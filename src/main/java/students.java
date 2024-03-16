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

                System.out.println("student_id: " + id + ", first_name: " + fname +
                        ", last_name: " + lname + ", email: " + email +
                        ", enrollment_date: " + date);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {

        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        Date date = Date.valueOf(enrollment_date);

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, email);
            statement.setDate(4, date);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updateStudentEmail(int id, String email){

        String insertSQL = "UPDATE students SET email = ? WHERE student_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, email);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteStudent(int id){

        String insertSQL = "DELETE FROM students WHERE student_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setInt(1, id);
            int rowsRemoved = statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}




