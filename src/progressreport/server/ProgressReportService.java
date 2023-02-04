package progressreport.server;

import organizationchart.Student;
import progressreport.ProgressReport;
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

    private ProgressReportProxy proxy;
    public ProgressReportService() {
        progressReportDao = new ProgressReportDao();
        reviewDao = new ReviewDao();
        scientistDao = new ScientistDao();
    }

    public void insertProgressReport(String title, String description, String url,String state, Integer freshman) throws SQLException {
        ProgressReport pr = new ProgressReport(title,description,url,state,freshman);
        progressReportDao.insert(pr);
    }

    public ProgressReport getProgressReportByStudent(Integer freshman) throws SQLException {
        return progressReportDao.findByKey(freshman);
    }

    public List<Student> getStudentSupervisored(Integer scientistFreshman) throws SQLException {
        List<Integer> idStudents = scientistDao.getStudents(scientistFreshman);
        List<Student> students = new ArrayList<Student>();

        for(Integer i: idStudents){
            Student s = proxy.getStudentsInformation(i);
            students.add(s);
        }

        return students;
    }











}
