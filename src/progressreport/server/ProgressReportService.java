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

    //METODI DI ProgressReportDao

    //inserimento studente nel microservizio del progress report
    public Boolean insertStudentToProgressReport(Integer studentFreshman) throws SQLException{
        ProgressReport pr = new ProgressReport(studentFreshman);
        return progressReportDao.insert(pr);
    }

    //inserimento/modifica del progress report in bozza, ovvero ancora non è stato consegnato (da parte dello studente)
    public Boolean updateProgressReport(Integer id, String title, String description, String urlDocument) throws SQLException {
        ProgressReport pr = new ProgressReport(id, title, description, urlDocument);
        return progressReportDao.update(pr);
    }

    //modifica state progress report (usato quando viene consegnato il progress report oppure quando viene ritirato dalla consegna)
    public Boolean updateStateProgressReport(Integer studentFreshman, String state) throws SQLException {
        return progressReportDao.updateState(studentFreshman, state);
    }

    //elimina progress report
    public Boolean deleteProgressReport(Integer id) throws SQLException{
        return progressReportDao.delete(id);
    }

    //delete progress report by student freshman
    public Boolean deleteProgressReportByStudent(Integer studentFreshman) throws SQLException{
        return progressReportDao.deleteProgressReportByStudent(studentFreshman);
    }

    //get progress report tramite la matricola studente
    public ProgressReport getProgressReportByStudent(Integer freshman) throws SQLException {
        return progressReportDao.findByKey(freshman);
    }

    //get scienziati tramite matricola studente
    public List<Scientist> getScientistsByStudent(Integer studentFreshman) throws SQLException{
        return progressReportDao.getScientists(studentFreshman);
    }

    //inserimento SupervisoryCommittee
    public Boolean insertSupervisoryCommittee(Integer idProgressReport, Integer idScientist) throws SQLException{
        return progressReportDao.insertSupervisory(idProgressReport, idScientist);
    }


    //PARTE METODI ScientistDao

    //inserimento scienziato
    public Boolean insertScientist(Integer freshman, String name, String surname, String password, String email, String description) throws SQLException {
        Scientist s = new Scientist(freshman, name, surname, password, email, description);
        return scientistDao.insert(s);
    }

    //update scientist
    public Boolean updateScientist(Integer idScientist, String name, String surname, String email, String description) throws SQLException{
        Scientist s = new Scientist(idScientist, name, surname, email, description);
        return scientistDao.update(s);
    }

    //update password scientist
    public Boolean updatePasswordScientist(Integer idScientist, String password) throws SQLException{
        return scientistDao.updatePassword(idScientist, password);
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
    public Boolean deleteScientist(Integer idScientist) throws SQLException{
        return scientistDao.delete(idScientist);
    }

}
