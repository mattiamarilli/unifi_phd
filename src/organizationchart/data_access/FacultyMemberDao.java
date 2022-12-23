package organizationchart.data_access;

import organizationchart.FacultyMember;

import java.sql.SQLException;
import java.util.List;

public interface FacultyMemberDao {
    List<FacultyMember> getAllFacultyMember() throws SQLException;
    FacultyMember getFacultyMember(int freshman) throws SQLException;
    Boolean insertFacultyMember(FacultyMember facultyMember) throws SQLException;
    Boolean updateFacultyMember(FacultyMember facultyMember) throws SQLException;
    Boolean deleteFacultyMember(FacultyMember facultyMember) throws SQLException;
}
