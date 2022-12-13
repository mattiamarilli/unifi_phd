package organizationchart.data_access;

import organizationchart.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();
    Student getStudent(int id);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);


}
