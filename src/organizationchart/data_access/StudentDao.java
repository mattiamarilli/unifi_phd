package organizationchart.data_access;

import organizationchart.FacultyMember;
import organizationchart.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent() throws SQLException;
    Student getStudentByFreshman(Integer freshman) throws SQLException;
    List<FacultyMember> getAdvisors(Integer freshman) throws SQLException;
    boolean insertStudent(Student student) throws SQLException;
    boolean updateStudent(Student student) throws SQLException;
    boolean deleteStudent(Integer freshman) throws SQLException;

}
