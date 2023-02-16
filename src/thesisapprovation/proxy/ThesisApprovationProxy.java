package thesisapprovation.proxy;

import organizationchart.Student;
import organizationchart.server.OrganizationChartService;

import java.sql.SQLException;

public class ThesisApprovationProxy {
    private OrganizationChartService ocService;
    public ThesisApprovationProxy() {
        ocService = new OrganizationChartService();
    }

    public Student getStudentsInformation(Integer idStudent) throws SQLException {
        return ocService.getStudentByFreshman(idStudent);
    }
}
