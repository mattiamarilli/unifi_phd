package progressreport.proxy;
import organizationchart.Student;
import organizationchart.server.OrganizationChartService;

import java.sql.SQLException;

public class ProgressReportProxy {

    private OrganizationChartService ocService;
    public ProgressReportProxy() {
       ocService = new OrganizationChartService();
    }

    public Student getStudentsInformation(Integer idStudent) throws SQLException {
        return ocService.getStudentById(idStudent);
    }

}
