package organizationchart.data_access;

import organizationchart.FacultyMember;
import java.util.List;

public interface FacultyMemberDao {
    List<FacultyMember> getAllFacultyMember();
    FacultyMember getFacultyMember(int id);
    void updateFacultyMember(FacultyMember facultyMember);
    void deleteFacultyMember(FacultyMember facultyMember);
}
