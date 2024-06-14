public class MainApp {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl"; // Change as per your database configuration
        String jdbcUsername = "your_username";
        String jdbcPassword = "your_password";

        StudentDAO studentDAO = new StudentDAO(jdbcURL, jdbcUsername, jdbcPassword);

        try {
            // Create a new student
            Student newStudent = new Student(1, "John Doe", 20);
            studentDAO.insertStudent(newStudent);
            System.out.println("Inserted Student: " + newStudent);

            // Read all students
            List<Student> students = studentDAO.listAllStudents();
            System.out.println("List of all students:");
            for (Student student : students) {
                System.out.println(student);
            }

            // Update a student
            Student existingStudent = new Student(1, "John Smith", 21);
            studentDAO.updateStudent(existingStudent);
            System.out.println("Updated Student: " + existingStudent);

            // Find a student by id
            Student retrievedStudent = studentDAO.getStudent(1);
            System.out.println("Retrieved Student: " + retrievedStudent);

            // Delete a student
            studentDAO.deleteStudent(retrievedStudent);
            System.out.println("Deleted Student with ID 1");

            // Verify deletion
            students = studentDAO.listAllStudents();
            System.out.println("List of all students after deletion:");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
