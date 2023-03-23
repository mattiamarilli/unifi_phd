package emulation;

import didacticoffer.Appeal;
import didacticoffer.AppealParticipation;
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


//test class made for emulating usage scenarios of the application
public class Emulation {

    OrganizationChartService ocs = new OrganizationChartService();
    ProgressReportService prs = new ProgressReportService();

    ThesisApprovationService tas = new ThesisApprovationService();
    DidacticOfferService dos = new DidacticOfferService();

    //admin
    @Test
    void assignAdvisor() throws SQLException, InterruptedException {

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
    void promotesStudent() throws SQLException, InterruptedException {
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
    void insertEvaluationCommittee() throws SQLException, InterruptedException {
        List<Student> students = ocs.getAllStudents();
        List<Reviewer> reviewers = tas.getAllReviewers();
        Thesis t = tas.getThesisByStudent(students.get(1).getFreshman());
        tas.insertEvaluationCommittee(t.getId(),reviewers.get(3).getFreshman());
        assertEquals(tas.getReviewersByStudent(students.get(1).getFreshman()).get(2).getFreshman(),reviewers.get(3).getFreshman());
    }


    @Test
    void insertSupervisoryCommittee() throws SQLException, InterruptedException {
        List<Student> students = ocs.getAllStudents();
        List<Scientist> scientists = prs.getAllScientists();
        ProgressReport p = prs.getProgressReportByStudent(students.get(1).getFreshman());
        prs.insertSupervisoryCommittee(p.getId(),scientists.get(3).getFreshman());
        assertEquals(prs.getScientistsByStudent(students.get(1).getFreshman()).get(0).getFreshman(),scientists.get(3).getFreshman());
    }

    //Professor
    @Test
    void viewEnrolledStudents() throws SQLException, InterruptedException {
        Professor p = dos.getAllProfessors().get(2);
        assertEquals(2,dos.getAllStudentsByProfessor(p.getFreshman()).size());
    }

    @Test
    void insertVote() throws SQLException, InterruptedException {
        Professor p = dos.getAllProfessors().get(2);
        List<Student> s = dos.getAllStudentsByProfessor(p.getFreshman());
        List<AppealParticipation> ap = dos.getAppealParticipationByStudent(s.get(1).getFreshman());
        assertEquals(true,dos.updateVote(102829,7,"20"));
    }

    //Reviewer
    @Test
    void viewStudentProfileReviewer() throws SQLException {
        List<Reviewer> reviewers = tas.getAllReviewers();
        assertEquals(2,tas.getStudentsByReviewer(reviewers.get(0).getFreshman()).size());
    }

    //Scientist

    @Test
    void viewStudentProfileScientist() throws SQLException {
        List<Scientist> scientists = prs.getAllScientists();
        assertEquals(2,prs.getStudentBySupervisory(scientists.get(1).getFreshman()).size());
    }


    //Student

    @Test
    void appealRegistration() throws SQLException, InterruptedException {
        List<Student> students = ocs.getAllStudents();
        Integer studentFreshman = students.get(5).getFreshman();
        List<Course> courses = dos.getAllCourses();
        List<Appeal> appeals = dos.getAppealsByCourseCode(courses.get(0).getCode());

        assertEquals(true,dos.insertAppealParticipation(studentFreshman,appeals.get(0).getId()));
    }


    @Test
    void viewScientistProfile() throws SQLException, InterruptedException {
        List<Student> students = ocs.getAllStudents();
        Integer studentFreshman = students.get(2).getFreshman();
        List<Scientist> scientists = prs.getScientistsByStudent(studentFreshman);
        assertEquals(scientists.get(0).getFreshman(),49281);
    }

    @Test
    void viewReviewerProfile() throws SQLException, InterruptedException {
        List<Student> students = ocs.getAllStudents();
        Integer studentFreshman = students.get(2).getFreshman();
        System.out.println(students.get(2).getFreshman());
        List<Reviewer> reviewers = tas.getReviewersByStudent(studentFreshman);
        assertEquals(reviewers.get(1).getFreshman(),9874328);
    }

    //FacultyMember

    @Test
    void advisoredStudentCarrear() throws SQLException, InterruptedException {
        List<FacultyMember> facultyMembers = ocs.getAllFacultyMembers();
        List<Student> studentsAdivsored = ocs.getStudentsByAdvisor(facultyMembers.get(1).getFreshman());
        assertEquals(2,dos.getCoursesByStudentFreshman(studentsAdivsored.get(0).getFreshman()).size());
    }

}
