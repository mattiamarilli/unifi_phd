package progressreport.server;

import org.junit.jupiter.api.Test;
import organizationchart.Student;
import progressreport.ProgressReport;
import progressreport.Scientist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgressReportServiceTest {

    private ProgressReportService prService = new ProgressReportService();

    @Test
    void insertStudentToProgressReport() throws SQLException {
        assertEquals(true, prService.insertStudentToProgressReport(7032459));
    }

    @Test
    void updateProgressReport() throws SQLException{
        assertEquals(true, prService.updateProgressReport(1, "Progress Report end first year (update)", "Description progress report", "url1_2.pdf"));
        //error id
        assertEquals(false, prService.updateProgressReport(0, "Progress Report end first year", "Description progress report", "url1_2.pdf"));
    }

    @Test
    void updateStateProgressReport() throws SQLException{
        assertEquals(true, prService.updateStateProgressReport(4728520, "Load"));
        //error freshman
        assertEquals(false, prService.updateStateProgressReport(0, "Load"));
    }

    @Test
    void deleteProgressReport() throws SQLException{
        assertEquals(true, prService.deleteProgressReport(9));
        //error id
        assertEquals(false, prService.deleteProgressReport(0));
    }

    @Test
    void deleteProgressReportByStudent() throws SQLException{
        assertEquals(true, prService.deleteProgressReportByStudent(4728520));
        //error freshman
        assertEquals(false, prService.deleteProgressReportByStudent(0));
    }

    @Test
    void getProgressReportByStudent() throws SQLException{
        ProgressReport pr = new ProgressReport(2, "Progress Report end first year", "Description progress report", "url2.pdf", "Load", 3472126);
        assertEquals(pr.toString(), prService.getProgressReportByStudent(3472126).toString());
    }

    @Test
    void getScientistsByStudent() throws SQLException{
        List<Scientist> scientists = new ArrayList<Scientist>();
        scientists.add(new Scientist(5894375, "Tommaso", "Agnolucci", "tommaso.agnolucci@uniro.it", "Improving visual quality of videos and images with deep learning"));
        scientists.add(new Scientist(7637585, "Alessio", "Vecchio", "alessio.vecchio@unipi.it", "Pervasive and mobile computing"));

        assertEquals(scientists.toString(), prService.getScientistsByStudent(3820539).toString());
    }

    @Test
    void insertSupervisoryCommittee() throws SQLException{
        assertEquals(true, prService.insertSupervisoryCommittee(1, 7237583));
        //error progress report id
        assertEquals(false, prService.insertSupervisoryCommittee(0, 3820539));
        //error student freshman
        assertEquals(false, prService.insertSupervisoryCommittee(1, 0));
    }

    @Test
    void insertScientist() throws SQLException {
        assertEquals(true, prService.insertScientist(4802402, "Guido", "Gagliardi", "Password", "guido.gagliardi@unifi.it", "Machine learning"));
        //error scientist freshman (already exists)
        assertEquals(false, prService.insertScientist(9236583, "Guido", "Gagliardi", "Password", "guido.gagliardi@unifi.it", "Machine learning"));
    }

    @Test
    void updateScientist() throws SQLException{
        assertEquals(true, prService.updateScientist(7637585, "Alessio", "Vecchio", "alessio.vecchio@unipi.it", "Pervasive and mobile computing (update"));
        //error scientist freshman
        assertEquals(false, prService.updateScientist(7637586, "Alessio", "Vecchio", "alessio.vecchio@unipi.it", "Pervasive and mobile computing (update"));
    }

    @Test
    void updatePasswordScientist() throws SQLException{
        assertEquals(true, prService.updatePasswordScientist(5894375, "Password (update)"));
        //error scientist freshman
        assertEquals(false, prService.updatePasswordScientist(5894374, "Password (update)"));
    }

    @Test
    void getStudentBySupervisory() throws SQLException{
        //TODO: inserire per bene i dati per farlo
    }

    @Test
    void getProgressReportByScientistStudent() throws SQLException{
        ProgressReport pr = new ProgressReport(2, "Progress Report end first year", "Description progress report", "url2.pdf", "Load", 3472126);
        assertEquals(pr.toString(), prService.getProgressReportByScientistStudent(7237583, 3472126).toString());
        //error scientist freshman
        assertEquals(null, prService.getProgressReportByScientistStudent(0, 3472126));
        //error student freshman
        assertEquals(null, prService.getProgressReportByScientistStudent(7237583, 0));
    }

    @Test
    void deleteScientist() throws SQLException{
        assertEquals(true, prService.deleteScientist(9237583));
        //error scientist freshman
        assertEquals(false, prService.deleteScientist(0));
    }

    @Test
    void testJUnit() {
        assertEquals(true, prService.testJUnit());
    }

}