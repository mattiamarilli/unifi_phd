package organizationchart.server;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSInput;
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
    void getStudentsByCycle() throws SQLException{
        List<Student> students = new ArrayList<Student>();

        Cycle c = new Cycle("XXVI", 2019, "Information Technology, Systems and Telecommunications");
        students.add(new Student(3820392, "Alessandro", "Danieli", "alessandro.danieli@unifi.it", "", c, 4, null));
        students.add(new Student(3923920, "Alessandro", "Betti", "alessandro.betti@unifi.it", "", c, 4, null));
        students.add(new Student(4728103, "Enrico", "Meloni", "enrico.meloni@unifi.it", "Machine Learning and Explainable AI", c, 4, null));

        assertEquals(students, ocService.getStudentsByCycle("XXVI"));

        //error cycle number
        List<Student> students_empty = new ArrayList<Student>();
        assertEquals(students_empty, ocService.getStudentsByCycle("X"));
    }

    @Test
    void getAllCycles() throws SQLException{
        List<Cycle> cycles = new ArrayList<Cycle>();

        cycles.add(new Cycle("XXIX", 2022, "Telematics and information society"));
        cycles.add(new Cycle("XXVI", 2019, "Information Technology, Systems and Telecommunications"));
        cycles.add(new Cycle("XXVII", 2020, "IComputer and automation engineering"));
        cycles.add(new Cycle("XXVIII", 2021, "Automatic and Optimization"));

        assertEquals(cycles, ocService.getAllCycles());
    }

    @Test
    void insertStudent() throws SQLException {
        assertEquals(true, ocService.insertStudent(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Password Test", "Topics Test", "XXVII" ));
        //error insert students
        assertEquals(false, ocService.insertStudent(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Password Test", "Topics Test", "XXVII" ));
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
    void getStudentByFreshman() throws SQLException{
        Cycle c1 = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a1 = new FacultyMember(5749249, "Franco", "Scarselli", "franco.scarselli@unisi.it", "Machine Learning; Artificial neural networks", "University of Siena", c1);
        Student s = new Student(102829, "Tommaso", "Aldinucci", "tommaso.aldinucci@unifi.it", "TBD", c1, 3, a1);
        assertEquals(s, ocService.getStudentByFreshman(102829));
        //error student freshman
        assertNull(ocService.getStudentByFreshman(0));
    }

    @Test
    void getStudentsByYear() throws SQLException{
        List<Student> students = new ArrayList<Student>();

        Cycle c1 = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a1 = new FacultyMember(5749249, "Franco", "Scarselli", "franco.scarselli@unisi.it", "Machine Learning; Artificial neural networks", "University of Siena", c1);
        students.add(new Student(102829, "Tommaso", "Aldinucci", "tommaso.aldinucci@unifi.it", "TBD", c1, 3, a1));

        FacultyMember a2 = new FacultyMember(281392, "Marco", "Gori", "marco.gori@unisi.it", "Machine Learning; Computer Vision", "University of Siena", c1);
        students.add(new Student(3920391, "Lorenzo", "Agnolucci", "lorenzo.agnolucci@unifi.it", "", c1, 3, a2));

        students.add(new Student(7028492, "Matteo", "Barbetti", "matteo.barbetti@unifi.it", "Smart Computing Techniques applied to Medical Physics, Nuclear Physics and Particle Physics", c1, 3, a2));

        assertEquals(students, ocService.getStudentsByYear(3));

        //error year
        List<Student> students_empty = new ArrayList<Student>();
        assertEquals(students_empty, ocService.getStudentsByYear(0));
    }


    @Test
    void getStudentsByAdvisor() throws SQLException{
        List<Student> students = new ArrayList<Student>();

        Cycle c = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a = new FacultyMember(281392);
        students.add(new Student(7028492, "Matteo", "Barbetti", "matteo.barbetti@unifi.it", "Smart Computing Techniques applied to Medical Physics, Nuclear Physics and Particle Physics", c, 3, a));
        assertEquals(students, ocService.getStudentsByAdvisor(281392));
    }

    @Test
    void insertCycle() throws SQLException{
        assertEquals(true, ocService.insertCycle("X", 2010, "Cycle test"));
        //error insert cycle (already exists)
        assertEquals(false, ocService.insertCycle("XXVI", 2019, "Description test"));
    }

    @Test
    void updateCycle() throws SQLException{
        assertEquals(true, ocService.updateCycle("XXVIII", 2021, "Automatic and Optimization (update)"));
        //error update (cycle doesn't exist)
        assertEquals(false, ocService.updateCycle("", 2010, "Description test update"));
    }

    @Test
    void deleteCycle() throws SQLException{
        assertEquals(true, ocService.deleteCycle("XXX"));
        //error delete cycle (doesn't exist)
        assertEquals(false, ocService.deleteCycle(""));
    }

    @Test
    void insertFacultyMember() throws SQLException{
        assertEquals(true, ocService.insertFacultyMember(1111111, "Name test", "Surname test", "test@test.it", "Password test", "Specialization test", "Institution test", "XXVI"));
        //error insert faculty member (already exists)
        assertEquals(false, ocService.insertFacultyMember(593183, "Name test", "Surname test", "test@test.it", "Password test", "Specialization test", "Institution test", "XXVI"));
    }

    @Test
    void updateFacultyMember() throws SQLException{
        assertEquals(true, ocService.updateFacultyMember(3840149, "Paolo (update)", "Fresconi (update)", "paolo.fresconi@unifi.it", "Machine Learning; Bioinformatics (update)", "University of Florence", "XXVIII"));
        //error update (doesn't exist faculty member)
        assertEquals(false, ocService.updateFacultyMember(0, "Paolo (update)", "Fresconi (update)", "paolo.fresconi@unifi.it", "Machine Learning; Bioinformatics (update)", "University of Florence", "XXVIII"));
    }

    @Test
    void updateFacultyMemberPassword() throws SQLException{
        assertEquals(true, ocService.updateFacultyMemberPassword(5849204, "Password update"));
        //error password update
        assertEquals(false, ocService.updateFacultyMemberPassword(0, "Password update"));
    }

    @Test
    void deleteFacultyMember() throws SQLException{
        assertEquals(true, ocService.deleteFacultyMember(427190));
        //error delete faculty member
        assertEquals(false, ocService.deleteFacultyMember(0));
    }

}