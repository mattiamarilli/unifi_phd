package emulation;
import didacticoffer.Course;
import didacticoffer.Professor;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdminEmulation {
    OrganizationChartService ocs = new OrganizationChartService();
    ProgressReportService prs = new ProgressReportService();

    ThesisApprovationService tas = new ThesisApprovationService();
    DidacticOfferService dos = new DidacticOfferService();
    @Test
    void assignAdvisor() throws SQLException {

        //get all the students and faculty members
        List<Student> students = ocs.getAllStudents();
        List<FacultyMember> facultyMembers = ocs.getAllFacultyMembers();

        //assign advisor after the selection of the advisor
        ocs.updateStudentAdvisor(students.get(2).getFreshman(),facultyMembers.get(3).getFreshman());

        //check the assignment
        Student s = ocs.getStudentByFreshman(students.get(2).getFreshman());
        assertEquals(facultyMembers.get(3).getFreshman(),s.getAdvisor().getFreshman());

    }

    @Test
    void promotesStudent() throws SQLException {
        //get all student
        List<Student> students = ocs.getAllStudents();

        //check if the progressreport is loaded
        assertEquals("Load",prs.getProgressReportByStudent(students.get(2).getFreshman()).getState());

        //promote student
        ocs.updateStudentYear(students.get(2).getFreshman(),2);
        List<Student> studentsAfter = ocs.getAllStudents();
        assertEquals(2,studentsAfter.get(2).getYear());

    }

    @Test
    void assignCourse() throws SQLException {
        List<Professor> professors = dos.getAllProfessors();
        List<Course> courses = dos.getAllCourses();

        dos.updateCodeCourseProfessor(professors.get(2).getFreshman(),courses.get(3).getCode());

        List<Professor> professorsAfter = dos.getAllProfessors();

        assertEquals(professorsAfter.get(2).getCourse().getCode(),courses.get(3).getCode());
    }

    @Test
    void insertEvaluationCommittee() throws SQLException {
        List<Student> students = ocs.getAllStudents();
        List<Reviewer> reviewers = tas.getAllReviewer();
        Thesis t = tas.getThesisByStudent(students.get(1).getFreshman());
        tas.insertEvaluationCommittee(t.getId(),reviewers.get(3).getFreshman());
        assertEquals(tas.getReviewersByStudent(students.get(1).getFreshman()).get(2).getFreshman(),reviewers.get(3).getFreshman());
    }


    @Test
    void insertSupervisoryCommitte() throws SQLException {
        List<Student> students = ocs.getAllStudents();
        List<Scientist> scientists = prs.getAllScientist();
        ProgressReport p = prs.getProgressReportByStudent(students.get(1).getFreshman());
        prs.insertSupervisoryCommittee(p.getId(),scientists.get(3).getFreshman());
        assertEquals(prs.getScientistsByStudent(students.get(1).getFreshman()).get(0).getFreshman(),scientists.get(3).getFreshman());
    }


}
