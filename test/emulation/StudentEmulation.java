package emulation;
import org.junit.jupiter.api.Test;
import organizationchart.FacultyMember;
import organizationchart.Student;
import organizationchart.server.*;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentEmulation {

    OrganizationChartService ocs = new OrganizationChartService();
    @Test
    void assignAdvisor() throws SQLException {
        List<Student> students = ocs.getAllStudents();
        List<FacultyMember> facultyMembers = ocs.getAllFacultyMembers();
    }
}
