# COMPA3

# Students Management Application

This Java application connects to a PostgreSQL database and performs CRUD operations on a "students" table.

## Setup Instructions

### 1. Prerequisites
- Java Development Kit (JDK) installed
- PostgreSQL database installed and running
- JDBC driver for PostgreSQL (included in the project)

### 2. Database Setup
1. Create a database named 'StudentManagementSystem' in PostgreSQL.
2. Create a 'students' table using the following SQL query \
   CREATE TABLE students (\
       student_id SERIAL PRIMARY KEY,\
       first_name TEXT NOT NULL,\
       last_name TEXT NOT NULL,\
       email TEXT NOT NULL UNIQUE,\
       enrollment_date DATE\
   );
3. Add the initial data or any data you would like to use:
   INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES \
    ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),\
    ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),\
    ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

4. Compile and run the Java code using an IDE or the terminal

## Usages
The application provides the following functionality:
  getAllStudents(): Retrieves and displays all records from the students table.
  addStudent(first_name, last_name, email, enrollment_date): Inserts a new student record into the students table.
  updateStudentEmail(student_id, new_email): Updates the email of a student based on their student_id.
  deleteStudent(student_id): Deletes a student from the students table based on their student_id.

## Youtube Video Demonstration
Below is a link to a youtube video demonstration of the application in use:
  https://youtu.be/Ix0ZFik6lO0
