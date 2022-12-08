package organizationchart.data_access;

import organizationchart.FacultyMember;
import java.util.List;

public interface FacultyMemberDao {
    List<FacultyMember> getAllFacultyMember();
    FacultyMember getFacultyMember(int id);
    void updateCycle(FacultyMember facultyMember);
    void deleteStudent(FacultyMember facultyMember);
}
