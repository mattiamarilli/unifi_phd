package progressreport.server;

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

public class ProgressReportService {
    private ProgressReportDao progressReportDao;
    private ReviewDao reviewDao;
    private ScientistDao scientistDao;

    private ProgressReportProxy progressReportProxy;
    public ProgressReportService() {
        progressReportDao = new ProgressReportDao();
        reviewDao = new ReviewDao();
        scientistDao = new ScientistDao();
    }

    //PARTE METODI ProgressReportDao

    //inserimento progress report (ovvero carica progress report)
    public void insertProgressReport(String title, String description, String url, Integer freshman) throws SQLException {
        ProgressReport pr = new ProgressReport(title, description, url, freshman);
        progressReportDao.insert(pr);
    }

    //modifica del progress report (da parte dello studente)
    public void updateProgressReport(Integer id, String title, String description, String urlDocument) throws SQLException {
        ProgressReport pr = new ProgressReport(id, title, description, urlDocument);
        progressReportDao.update(pr);
    }

    //modifica state progress report (usato quando viene consegnato il progress report oppure quando viene ritirato dalla consegna)
    public void updateStateProgressReport(Integer studentFreshman, String state) throws SQLException {
        progressReportDao.updateState(studentFreshman, state);
    }

    //elimina progress report
    public void deleteProgressReport(Integer id) throws SQLException{
        progressReportDao.delete(id);
    }

    //get progress report tramite la matricola studente
    public ProgressReport getProgressReportByStudent(Integer freshman) throws SQLException {
        return progressReportDao.findByKey(freshman);
    }

    //get scienziati tramite matricola studente
    public List<Scientist> getScientistsByStudent(Integer studentFreshman) throws SQLException{
        return progressReportDao.getScientists(studentFreshman);
    }


    //PARTE METODI ScientistDao

    //inserimento scienziato
    public void insertScientist(Integer freshman, String name, String surname, String password, String email, String description) throws SQLException {
        Scientist s = new Scientist(freshman, name, surname, password, email, description);
        scientistDao.insert(s);
    }

    //modifica scienziato
    public void updateScientist(Scientist s) throws SQLException{
        scientistDao.update(s);
    }

    //get studenti tramite la matricola del scientist
    public List<Student> getStudentBySupervisory(Integer scientistFreshman) throws SQLException {
        List<Integer> idStudents = scientistDao.getStudents(scientistFreshman);
        List<Student> students = new ArrayList<Student>();

        for(Integer i: idStudents){
            Student s = progressReportProxy.getStudentsInformation(i);
            students.add(s);
        }

        return students;
    }

    //get progress report by scientist and student (ovvero lo scienziato visualizza il progress report dello studente selezionato)
    public ProgressReport getProgressReportByScientistStudent(Integer idScientist, Integer idStudent) throws SQLException{
        return scientistDao.getProgressReportByScientistStudent(idScientist, idStudent);
    }

    //delete scientist
    public void deleteScientist(Integer idScientist) throws SQLException{
        scientistDao.delete(idScientist);
    }

    //update scientist
    public void updateScientist(Integer idScientist, String name, String surname, String email, String description) throws SQLException{
        Scientist s = new Scientist(idScientist, name, surname, email, description);
        scientistDao.update(s);
    }

    //update password scientist
    public void updatePasswordScientist(Integer idScientist, String password) throws SQLException{
        scientistDao.updatePassword(idScientist, password);
    }

    //METODI PER LA SupervisoryCommittee

    //inserimento SupervisoryCommittee
    public void insertSupervisoryCommittee(Integer idProgressReport, Integer idScientist) throws SQLException{
        progressReportDao.insertSupervisory(idProgressReport, idScientist);
    }



    public boolean testJUnit(){
        return true;
}









}
