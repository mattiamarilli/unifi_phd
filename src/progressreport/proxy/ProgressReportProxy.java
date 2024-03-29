package progressreport.proxy;
import organizationchart.Student;
import organizationchart.server.OrganizationChartService;

import java.sql.SQLException;

public class ProgressReportProxy {

    private OrganizationChartService ocService;
    public ProgressReportProxy() {}

    public Student getStudentsInformation(Integer idStudent) throws SQLException, InterruptedException {
        this.ocService = OrganizationChartService.getInstance();
        return ocService.getStudentByFreshman(idStudent);
    }

}
