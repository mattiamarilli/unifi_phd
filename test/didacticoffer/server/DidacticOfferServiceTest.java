package didacticoffer.server;

import didacticoffer.Course;
import didacticoffer.Professor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DidacticOfferServiceTest {

    private DidacticOfferService doService = new DidacticOfferService();

    @Test
    void getAllProfessors() throws SQLException {
//        List<Professor> professors = new ArrayList<Professor>();
//
//        Course c2 = new Course("B037592", "Genetic Algorithms", "Description course", 2, 2022);
//        Professor p2 = new Professor(1129371, "Giorgio", "Battistelli", "Control Systems; Sensor networks", "University of Florence", "giorgio.battistelli@unifi.it", "Password", c2);
//        professors.add(p2);

        //assertEquals(professors,doService.getAllProfessors());
    }

    @Test
    void insertProfessor() throws SQLException {
        assertEquals(true,doService.insertProfessor(9999999,"Name Test","Surname Test","Test Specialization","Test University","test@unifi.it","testpassword"));
        assertEquals(false,doService.insertProfessor(9999999,"Name Test","Surname Test","Test Specialization","Test University","test@unifi.it","testpassword"));
    }

    @Test
    void updateCodeCourseProfessor() {
        //perchè dovremmo cambiare il codice del corso a un docente?
    }

    @Test
    void updateProfessor() throws SQLException {
        assertEquals(true,doService.updateProfessor(1029371,"Franchesco (update)", "Chiti (update)","Statistical signal processing; Remote sensing (update)","University of Florence (update)","francesco.chiti@unifi.it (update)", "B032592"));
        assertEquals(false,doService.updateProfessor(0,"Franchesco (update)", "Chiti (update)","Statistical signal processing; Remote sensing (update)","University of Florence (update)","francesco.chiti@unifi.it (update)", "B032592"));

    }

    @Test
    void updatePasswordProfessor() throws SQLException {
        assertEquals(true,doService.updatePasswordProfessor(1329371,"Password update"));
        assertEquals(false,doService.updatePasswordProfessor(1,"Password update"));
    }

    @Test
    void deleteProfessor() throws SQLException {
        assertEquals(true,doService.deleteProfessor(1229371));
        assertEquals(false,doService.deleteProfessor(0));
    }



    @Test
    void getAllStudentsByProfessor() {
    }

    @Test
    void insertCourse() throws SQLException {
        assertEquals(true,doService.insertCourse("B00001", "Title Test", "Description Test", 2, 2022));
        assertEquals(false,doService.insertCourse("B00001", "Title Test", "Description Test", 2, 2022));
    }

    @Test
    void updateCourse() throws SQLException {
        assertEquals(true,doService.updateCourse("B037592","Genetic Algorithms (update)", "Description course (Update)", 2, 2022));
        assertEquals(false,doService.updateCourse("0","Genetic Algorithms (update)", "Description course (Update)", 2, 2022));
    }

    @Test
    void deleteCourse() throws SQLException {
        assertEquals(true,doService.deleteCourse("B002352"));
        assertEquals(false,doService.deleteCourse("0"));

    }

    @Test
    void updateStateStudyPlan() throws SQLException {
        assertEquals(true,doService.updateStateStudyPlan("B032592","Attended"));
        assertEquals(false,doService.updateStateStudyPlan("9999999","Attended"));
    }

    @Test
    void insertLesson() throws ParseException {
        //TODO: comprendere questione date e time, perchè sono sql objects??
//        String date_string = "26-09-1989";
//        //Instantiating the SimpleDateFormat class
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM--dd");
//        //Parsing the given String to Date object
//        Date date = formatter.parse(date_string);
//        assertEquals(true,doService.insertLesson((d, "8:30", "10:30", 002, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592"));
    }

    @Test
    void updateLesson() {
        //TODO: comprendere questione date e time, perchè sono sql objects??
    }

    @Test
    void deleteLesson() {
        //TODO: comprendere questione date e time, perchè sono sql objects??

    }

    @Test
    void insertAppeal() {
        //TODO: comprendere questione date e time, perchè sono sql objects??

    }

    @Test
    void updateAppeal() {
        //TODO: comprendere questione date e time, perchè sono sql objects??

    }

    @Test
    void deleteAppeal() {
        //TODO: comprendere questione date e time, perchè sono sql objects??

    }

    @Test
    void acceptVoteByStudent() throws SQLException {
        assertEquals(true,doService.acceptVoteByStudent(7028492,7));
        assertEquals(false,doService.acceptVoteByStudent(7028492,212121));
        assertEquals(false,doService.acceptVoteByStudent(3333,7));
    }

    @Test
    void updateVote() {
    }

    @Test
    void getAppealsByCourseCode() {
    }

    @Test
    void insertStudentCareer() {
    }

    @Test
    void deleteStudentCareer() {
    }

    @Test
    void insertAppealParticipation() {
    }

    @Test
    void deleteAppealParticipationByStudent() {
    }

    @Test
    void insertStudyPlan() {
    }

    @Test
    void deleteStudyPlan() {
    }

    @Test
    void getCoursesByStudentFreshman() {
    }

    @Test
    void getCoursesAccreditedByStudentFreshman() {
    }

    @Test
    void getAppealParticipationByStudent() {
    }
}