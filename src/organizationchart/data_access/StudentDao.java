package organizationchart.data_access;

import organizationchart.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();
    Student getStudent(Integer freshman);
    boolean saveStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Integer freshman);


}
