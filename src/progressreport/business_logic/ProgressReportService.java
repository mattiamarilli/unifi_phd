package progressreport.business_logic;

import progressreport.ProgressReport;
import progressreport.data_access.*;
import progressreport.proxy.Proxy;
import thesisapprovation.data_access.ReviewDao;

import java.sql.SQLException;



public class ProgressReportService {

    private ProgressReportDao progressReportDao;
    private ReviewDao reviewDao;
    private ScientistDao scientistDao;

    private Proxy proxy;
    public ProgressReportService() {
            progressReportDao = new ProgressReportDao();
            reviewDao = new ReviewDao();
            scientistDao = new ScientistDao();
    }

    public void insertProgressReport(String title, String description, String url,String state, Integer freshman) throws SQLException {
        ProgressReport pr = new ProgressReport(title,description,url,state,freshman);
        progressReportDao.insert(pr);
    }


}
