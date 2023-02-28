package emulation;
import didacticoffer.Appeal;
import didacticoffer.Course;
import org.junit.jupiter.api.Test;
import organizationchart.FacultyMember;
import organizationchart.Student;
import organizationchart.server.*;
import progressreport.ProgressReport;
import progressreport.Scientist;
import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentEmulation {

    OrganizationChartService ocs = new OrganizationChartService();
    DidacticOfferService dos = new DidacticOfferService();
    ProgressReportService prs = new ProgressReportService();
    ThesisApprovationService tas = new ThesisApprovationService();

    //test that emulate student registration to a course appeal
    @Test
    void appealRegistration() throws SQLException {
        List<Student> students = ocs.getAllStudents();
        Integer studentFreshman = students.get(5).getFreshman();
        List<Course> courses = dos.getAllCourses();
        List<Appeal> appeals = dos.getAppealsByCourseCode(courses.get(0).getCode());

        assertEquals(true,dos.insertAppealParticipation(studentFreshman,appeals.get(0).getId()));
    }

    //test that emulate student looking up for his scientist info (member of the supervisory)
    @Test
    void viewScientistProfile() throws SQLException {
        List<Student> students = ocs.getAllStudents();
        Integer studentFreshman = students.get(2).getFreshman();
        List<Scientist> scientists = prs.getScientistsByStudent(studentFreshman);
        assertEquals(scientists.get(0).getFreshman(),49281);
    }

    @Test
    void viewReviewerProfile() throws SQLException {
        List<Student> students = ocs.getAllStudents();
        Integer studentFreshman = students.get(2).getFreshman();
        System.out.println(students.get(2).getFreshman());
        List<Reviewer> reviewers = tas.getReviewersByStudent(studentFreshman);
        assertEquals(reviewers.get(1).getFreshman(),9874328);
    }
}
