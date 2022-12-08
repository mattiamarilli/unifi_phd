package organizationchart.data_access;

import organizationchart.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllFacultyMember();
    Student getFacultyMember(int id);
    void updateCycle(Student facultyMember);
    void deleteStudent(Student facultyMember);
}
