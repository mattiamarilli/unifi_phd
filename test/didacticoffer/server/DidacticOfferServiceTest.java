package didacticoffer.server;

import didacticoffer.Course;
import didacticoffer.Professor;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DidacticOfferServiceTest {



    private DidacticOfferService doService = new DidacticOfferService();

    @Test
    void insertProfessor() throws SQLException, IOException, InterruptedException {
        assertEquals(true,doService.insertProfessor(9999999,"Name Test","Surname Test","Test Specialization","Test University","test@unifi.it","testpassword"));
        assertEquals(false,doService.insertProfessor(9999999,"Name Test","Surname Test","Test Specialization","Test University","test@unifi.it","testpassword"));
    }

    @Test
    void updateCodeCourseProfessor() throws SQLException, InterruptedException {
        assertEquals(true,doService.updateCodeCourseProfessor(9876583,"B184721"));
        assertEquals(false,doService.updateCodeCourseProfessor(000,"B184721"));
    }

    @Test
    void updateProfessor() throws SQLException, InterruptedException {
        assertEquals(true,doService.updateProfessor(1029371,"Franchesco (update)", "Chiti (update)","Statistical signal processing; Remote sensing (update)","University of Florence (update)","francesco.chiti@unifi.it (update)"));
        assertEquals(false,doService.updateProfessor(0,"Franchesco (update)", "Chiti (update)","Statistical signal processing; Remote sensing (update)","University of Florence (update)","francesco.chiti@unifi.it (update)"));

    }

    @Test
    void updatePasswordProfessor() throws SQLException, InterruptedException {
        assertEquals(true,doService.updatePasswordProfessor(1329371,"Password update"));
        assertEquals(false,doService.updatePasswordProfessor(1,"Password update"));
    }

    @Test
    void deleteProfessor() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteProfessor(1229371));
        assertEquals(false,doService.deleteProfessor(0));
    }


    @Test
    void insertCourse() throws SQLException, InterruptedException {
        assertEquals(true,doService.insertCourse("B00001", "Title Test", "Description Test", 2, 2022));
        assertEquals(false,doService.insertCourse("B00001", "Title Test", "Description Test", 2, 2022));
    }

    @Test
    void updateCourse() throws SQLException, InterruptedException {
        assertEquals(true,doService.updateCourse("B037592","Genetic Algorithms (update)", "Description course (Update)", 2, 2022));
        assertEquals(false,doService.updateCourse("0","Genetic Algorithms (update)", "Description course (Update)", 2, 2022));
    }

    @Test
    void deleteCourse() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteCourse("B002352"));
        assertEquals(false,doService.deleteCourse("0"));

    }

    @Test
    void updateStateStudyPlan() throws SQLException, InterruptedException {
        assertEquals(true,doService.updateStateStudyPlan("B032592","Attended"));
        assertEquals(false,doService.updateStateStudyPlan("9999999","Attended"));
    }

    @Test
    void insertLesson() throws ParseException, SQLException, InterruptedException {
        Date d = new Date(10000);
        Time t = new Time(1000);
        assertEquals(true,doService.insertLesson(d, t, t, 002, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592"));
        assertEquals(false,doService.insertLesson(d, t, t, 002, "Centro Didattico Morgagni", "University of Florence", "Presence", "e032"));

    }

    @Test
    void updateLesson() throws SQLException, InterruptedException {
        Date d = new Date(10000);
        Time t = new Time(1000);
        assertEquals(true,doService.updateLesson(1,d, t, t, 001, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592"));
        assertEquals(false,doService.updateLesson(9888,d, t, t, 001, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592"));
    }

    @Test
    void deleteLesson() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteLesson(9));
        assertEquals(false,doService.deleteLesson(282828));
    }

    @Test
    void insertAppeal() throws SQLException, InterruptedException {
        Date d = new Date(10000);
        Time t = new Time(1000);
        assertEquals(true,doService.insertAppeal(d,t,002,"Centro Didattico Morgagni", "University of Florence","note", "Presence", "B032592"));
        assertEquals(false,doService.insertAppeal(d,t,002,"Centro Didattico Morgagni", "University of Florence","note", "Presence", "wee2"));
    }

    @Test
    void updateAppeal() throws SQLException, InterruptedException {
        Date d = new Date(10000);
        Time t = new Time(1000);
        assertEquals(true,doService.updateAppeal(1,d, t, 001, "Centro Didattico Morgagni", "University of Florence","note", "Presence", "B032592"));
        assertEquals(false,doService.updateAppeal(9888,d, t, 001, "Centro Didattico Morgagni", "University of Florence","note" ,"Presence", "dadc2"));
    }

    @Test
    void deleteAppeal() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteAppeal(9));
        assertEquals(false,doService.deleteAppeal(282828));
    }

    @Test
    void acceptVoteByStudent() throws SQLException, InterruptedException {
        assertEquals(true,doService.acceptVoteByStudent(7028492,7));
        assertEquals(false,doService.acceptVoteByStudent(7028492,212121));
        assertEquals(false,doService.acceptVoteByStudent(3333,7));
    }

    @Test
    void updateVote() throws SQLException, InterruptedException {
        assertEquals(true,doService.updateVote(9302912,6,"30 e lode"));
        assertEquals(false,doService.updateVote(9302912,7,"30 e lode"));
        assertEquals(false,doService.updateVote(3333,7,"30 e lode"));
    }

    @Test
    void insertStudentCareer() throws SQLException, InterruptedException {
        assertEquals(true,doService.insertStudentCareer(8967222));
        assertEquals(false,doService.insertStudentCareer(8967222));
    }

    @Test
    void deleteStudentCareer() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteStudentCareer(102829));
        assertEquals(false,doService.deleteStudentCareer(3333233));
    }

    @Test
    void insertAppealParticipation() throws SQLException, InterruptedException {
        assertEquals(true,doService.insertAppealParticipation(7028492,21));
        assertEquals(false,doService.insertAppealParticipation(3333333,21));
    }

    @Test
    void deleteAppealParticipationByStudent() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteAppealParticipationByStudent(102829,22));
        assertEquals(false,doService.deleteAppealParticipationByStudent(300232,22));
        assertEquals(false,doService.deleteAppealParticipationByStudent(102829,11));
    }

    @Test
    void insertStudyPlan() throws SQLException, InterruptedException {
        Date d = new Date(100000);
        assertEquals(true,doService.insertStudyPlan(7328102,"A009381",d));
        assertEquals(false,doService.insertStudyPlan(929299,"A232323232",d));
    }

    @Test
    void deleteStudyPlan() throws SQLException, InterruptedException {
        assertEquals(true,doService.deleteStudyPlan(4728103,"A009381"));
        assertEquals(false,doService.deleteStudyPlan(93829211,"232322"));
    }

    @Test
    void getCoursesByStudentFreshman() throws SQLException, InterruptedException {
        Integer size = doService.getCoursesByStudentFreshman(5849204).size();
        assertEquals(0,size);
    }

    @Test
    void getCoursesAccreditedByStudentFreshman() throws SQLException, InterruptedException {
        Integer size = doService.getCoursesAccreditedByStudentFreshman(4728103).size();
        assertEquals(3,size);
    }

    @Test
    void getAppealParticipationByStudent() throws SQLException, InterruptedException {
        Integer size = doService.getAppealParticipationByStudent(4728103).size();
        assertEquals(3,size);
    }

    @Test
    void getAllProfessors() throws SQLException, InterruptedException {
        Integer size = doService.getAllProfessors().size();
        assertEquals(13,size);
    }

    @Test
    void getAppealsByCourseCode() throws SQLException, InterruptedException {
        Integer size = doService.getAppealsByCourseCode("B032592").size();
        assertEquals(2,size);
    }

    @Test
    void getAllStudentsByProfessor() throws SQLException, InterruptedException {
        Integer size = doService.getAllStudentsByProfessor(1029371).size();
        assertEquals(1,size);
    }
}