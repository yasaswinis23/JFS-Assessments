import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentManager {
    private Map<Integer, Student> studentsMap;

    public StudentManager() {
        this.studentsMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentsMap.put(student.getId(), student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentsMap.values());
    }

    public Student getStudentById(int id) {
        return studentsMap.get(id);
    }

    public void updateStudent(int id, String name, int age) {
        if (studentsMap.containsKey(id)) {
            Student student = studentsMap.get(id);
            student.setName(name);
            student.setAge(age);
        }
    }

    public void deleteStudent(int id) {
        studentsMap.remove(id);
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();

        // Add students
        studentManager.addStudent(new Student(1, "Alice", 20));
        studentManager.addStudent(new Student(2, "Bob", 21));
        studentManager.addStudent(new Student(3, "Charlie", 22));

        // Print all students
        System.out.println("All students:");
        studentManager.getAllStudents().forEach(System.out::println);

        // Find student by id
        System.out.println("\nStudent with id=2:");
        System.out.println(studentManager.getStudentById(2));

        // Update student
        studentManager.updateStudent(2, "Bobby", 22);
        System.out.println("\nUpdated student with id=2:");
        System.out.println(studentManager.getStudentById(2));

        // Delete student
        studentManager.deleteStudent(1);
        System.out.println("\nAfter deleting student with id=1:");
        studentManager.getAllStudents().forEach(System.out::println);
    }
}
