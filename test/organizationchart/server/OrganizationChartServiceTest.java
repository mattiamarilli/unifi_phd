package organizationchart.server;

import org.junit.jupiter.api.Test;
import organizationchart.Cycle;
import organizationchart.FacultyMember;
import organizationchart.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationChartServiceTest {

    private OrganizationChartService ocService = new OrganizationChartService();

    @Test
    void insertStudent() throws SQLException {
        assertEquals(true, ocService.insertStudent(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Password Test", "Topics Test", "XXX" ));
        //error insert students
        assertEquals(false, ocService.insertStudent(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Password Test", "Topics Test", "XXX" ));
    }

    @Test
    void updateStudent() throws SQLException{
        assertEquals(true, ocService.updateStudent(4728103, "Enrico (update)", "Meloni (update)", "enrico.meloni@unifi.it (update)", "topics update"));
        //error student freshman (doesn't exist student)
        assertEquals(false, ocService.updateStudent(0, "Enrico (update)", "Meloni (update)", "enrico.meloni@unifi.it (update)", "topics update"));
    }

    @Test
    void updateStudentPassword() throws SQLException{
        assertEquals(true, ocService.updateStudentPassword(3923920, "Password update"));
        //error student freshman (doesn't exist)
        assertEquals(false, ocService.updateStudentPassword(0, "Password update"));

    }

    @Test
    void updateStudentAdvisor() throws SQLException{
        assertEquals(true, ocService.updateStudentAdvisor(3920391, 5749249));
        //error student freshman
        assertEquals(false, ocService.updateStudentAdvisor(0, 5749249));
        //error advisor freshman
        assertEquals(false, ocService.updateStudentAdvisor(3920391, 0));
    }

    @Test
    void updateStudentYear() throws SQLException{
        assertEquals(true, ocService.updateStudentYear(9302912, 3));
        //error student freshman
        assertEquals(false, ocService.updateStudentYear(0, 3));
    }

    @Test
    void deleteStudent() throws SQLException{
        assertEquals(true, ocService.deleteStudent(7328102));
        //error student freshman (doesn't exist)
        assertEquals(false, ocService.deleteStudent(0));
    }

    @Test
    void getAllStudents() throws SQLException{
        List<Student> students = new ArrayList<Student>();

        Cycle c2 = new Cycle("XXVI", 2019, "Information Technology, Systems and Telecommunications");
        students.add(new Student(3820392, "Alessandro", "Danieli", "alessandro.danieli@unifi.it", "", c2, 4, null));

        students.add(new Student(3923920, "Alessandro", "Betti", "alessandro.betti@unifi.it", "", c2, 4, null));

        students.add(new Student(4728103, "Enrico (update)", "Meloni (update)", "enrico.meloni@unifi.it (update)", "topics update", c2, 4, null));

        Cycle c1 = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a1 = new FacultyMember(5749249, "Franco", "Scarselli", "franco.scarselli@unisi.it", "Machine Learning; Artificial neural networks", "University of Siena", c1);
        students.add(new Student(102829, "Tommaso", "Aldinucci", "tommaso.aldinucci@unifi.it", "TBD", c1, 3, a1));

        students.add(new Student(3920391, "Lorenzo", "Agnolucci", "lorenzo.agnolucci@unifi.it", "", c1, 3, a1));

        FacultyMember a2 = new FacultyMember(281392, "Marco", "Gori", "marco.gori@unisi.it", "Machine Learning; Computer Vision", "University of Siena", c1);
        students.add(new Student(7028492, "Matteo", "Barbetti", "matteo.barbetti@unifi.it", "Smart Computing Techniques applied to Medical Physics, Nuclear Physics and Particle Physics", c1, 3, a2));

        Cycle c3 = new Cycle("XXVIII", 2021, "Automatic and Optimization");
        FacultyMember a3 = new FacultyMember(5739219, "Witold", "Pedrycz", "witold.pedrycz@gmail.com", "Computational Intelligence, fuzzy modeling, Granular Computing, knowledge discovery", "University of Alberta", c3);
        students.add(new Student(9302912, "Federico", "Nocentini", "federico.nocentini@unifi.it", "", c3, 3, a3 ));

        Cycle c4 = new Cycle("XXX", 2023, "Electronics and electromagnetism");
        students.add(new Student(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Topics Test", c4, 1, null));

        assertEquals(students, ocService.getAllStudents());
    }

    @Test
    void getStudentByFreshman() throws SQLException{
        Cycle c1 = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a1 = new FacultyMember(5749249, "Franco", "Scarselli", "franco.scarselli@unisi.it", "Machine Learning; Artificial neural networks", "University of Siena", c1);
        Student s = new Student(3920391, "Lorenzo", "Agnolucci", "lorenzo.agnolucci@unifi.it", "", c1, 3, a1);
        assertEquals(s, ocService.getStudentByFreshman(3920391));
        //error student freshman
        assertNull(ocService.getStudentByFreshman(0));
    }

    @Test
    void getStudentsByYear() throws SQLException{
        List<Student> students = new ArrayList<Student>();

        Cycle c1 = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a1 = new FacultyMember(5749249, "Franco", "Scarselli", "franco.scarselli@unisi.it", "Machine Learning; Artificial neural networks", "University of Siena", c1);
        students.add(new Student(102829, "Tommaso", "Aldinucci", "tommaso.aldinucci@unifi.it", "TBD", c1, 3, a1));

        students.add(new Student(3920391, "Lorenzo", "Agnolucci", "lorenzo.agnolucci@unifi.it", "", c1, 3, a1));

        FacultyMember a2 = new FacultyMember(281392, "Marco", "Gori", "marco.gori@unisi.it", "Machine Learning; Computer Vision", "University of Siena", c1);
        students.add(new Student(7028492, "Matteo", "Barbetti", "matteo.barbetti@unifi.it", "Smart Computing Techniques applied to Medical Physics, Nuclear Physics and Particle Physics", c1, 3, a2));

        Cycle c3 = new Cycle("XXVIII", 2021, "Automatic and Optimization");
        FacultyMember a3 = new FacultyMember(5739219, "Witold", "Pedrycz", "witold.pedrycz@gmail.com", "Computational Intelligence, fuzzy modeling, Granular Computing, knowledge discovery", "University of Alberta", c3);
        students.add(new Student(9302912, "Federico", "Nocentini", "federico.nocentini@unifi.it", "", c3, 3, a3 ));

        assertEquals(students, ocService.getStudentsByYear(3));

        //error year
        List<Student> students_empty = new ArrayList<Student>();
        assertEquals(students_empty, ocService.getStudentsByYear(0));
    }

    @Test
    void getStudentsByCycle() throws SQLException{

    }

    @Test
    void getStudentsByAdvisor() {
    }

    @Test
    void insertCycle() {
    }

    @Test
    void updateCycle() {
    }

    @Test
    void deleteCycle() {
    }

    @Test
    void getAllCycles() {
    }

    @Test
    void insertFacultyMember() {
    }

    @Test
    void updateFacultyMember() {
    }

    @Test
    void updateFacultyMemberPassword() {
    }

    @Test
    void deleteFacultyMember() {
    }

    @Test
    void getAllFacultyMembers() {
    }
}