package progressreport.server;

import didacticoffer.Professor;
import didacticoffer.server.DidacticOfferService;
import organizationchart.Student;
import progressreport.ProgressReport;
import progressreport.Scientist;
import progressreport.data_access.ProgressReportDao;
import progressreport.data_access.ScientistDao;
import progressreport.proxy.ProgressReportProxy;
import thesisapprovation.data_access.ReviewDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProgressReportService {

    private static ProgressReportService prs;
    public int getLag() {
        return lag;
    }

    public void setLag(int lag) {
        this.lag = lag;
    }

    private int lag = 0;
    final int millisecondsDelay = 5000;
    private  Boolean available = true;
    private ProgressReportDao progressReportDao;
    private ReviewDao reviewDao;
    private ScientistDao scientistDao;
    private ProgressReportProxy progressReportProxy;

    private ProgressReportService() {
        progressReportDao = new ProgressReportDao();
        reviewDao = new ReviewDao();
        scientistDao = new ScientistDao();
    }

    public static ProgressReportService getInstance() {
        return prs == null ?
                prs = new ProgressReportService() :
                prs;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void emulateDelay() throws InterruptedException {
        if(this.lag == 0)
        {
            Random random = new Random();
            int number = random.nextInt(100);

            if(number <= 95)
                Thread.sleep(random.nextInt(7) + 3);
            else
                Thread.sleep(random.nextInt(20) + 20);
        }
        else
            Thread.sleep(this.lag);
    }

    //METODI DI ProgressReportDao

    //inserimento studente nel microservizio del progress report
    public synchronized Boolean insertStudentToProgressReport(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            ProgressReport pr = new ProgressReport(studentFreshman);
            emulateDelay();
            return progressReportDao.insert(pr);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //inserimento/modifica del progress report in bozza, ovvero ancora non è stato consegnato (da parte dello studente)
    public synchronized Boolean updateProgressReport(Integer id, String title, String description, String urlDocument) throws SQLException, InterruptedException {
        if (available) {
            ProgressReport pr = new ProgressReport(id, title, description, urlDocument);
            emulateDelay();
            return progressReportDao.update(pr);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //modifica state progress report (usato quando viene consegnato il progress report oppure quando viene ritirato dalla consegna)
    public synchronized Boolean updateStateProgressReport(Integer studentFreshman, String state) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.updateState(studentFreshman, state);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //elimina progress report
    public synchronized Boolean deleteProgressReport(Integer id) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.delete(id);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //delete progress report by student freshman
    public synchronized Boolean deleteProgressReportByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.deleteProgressReportByStudent(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //get progress report tramite la matricola studente
    public synchronized ProgressReport getProgressReportByStudent(Integer freshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.findByKey(freshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //get scienziati tramite matricola studente
    public synchronized List<Scientist> getScientistsByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.getScientists(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //inserimento SupervisoryCommittee
    public synchronized Boolean insertSupervisoryCommittee(Integer idProgressReport, Integer idScientist) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.insertSupervisory(idProgressReport, idScientist);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //get all progress reports
    public synchronized List<ProgressReport> getAllProgressReports() throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return progressReportDao.getAll();
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }


    //PARTE METODI ScientistDao

    public synchronized List<Scientist> getAllScientists() throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return scientistDao.getAll();
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }
    //inserimento scienziato
    public synchronized Boolean insertScientist(Integer freshman, String name, String surname, String password, String email, String description) throws SQLException, InterruptedException {
        if (available) {
            Scientist s = new Scientist(freshman, name, surname, password, email, description);
            emulateDelay();
            return scientistDao.insert(s);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update scientist
    public synchronized Boolean updateScientist(Integer idScientist, String name, String surname, String email, String description) throws SQLException, InterruptedException {
        if (available) {
            Scientist s = new Scientist(idScientist, name, surname, email, description);
            emulateDelay();
            return scientistDao.update(s);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //update password scientist
    public synchronized Boolean updatePasswordScientist(Integer idScientist, String password) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return scientistDao.updatePassword(idScientist, password);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get scientist by freshman
    public synchronized Scientist getScientistByFreshman(Integer scientistFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return scientistDao.findByKey(scientistFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //get studenti tramite la matricola del scientist
    public synchronized List<Student> getStudentBySupervisory(Integer scientistFreshman) throws SQLException, InterruptedException {
        if (available) {
            List<Integer> idStudents = scientistDao.getStudents(scientistFreshman);
            List<Student> students = new ArrayList<Student>();

            this.progressReportProxy = new ProgressReportProxy();
            for(Integer i: idStudents){
                Student s = progressReportProxy.getStudentsInformation(i);
                students.add(s);
            }
            emulateDelay();
            return students;
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get progress report by scientist and student (ovvero lo scienziato visualizza il progress report dello studente selezionato)
    public synchronized List<ProgressReport> getProgressReportByScientistStudent(Integer idScientist, Integer idStudent) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return scientistDao.getProgressReportByScientistStudent(idScientist, idStudent);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //delete scientist
    public synchronized Boolean deleteScientist(Integer idScientist) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return scientistDao.delete(idScientist);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

}
