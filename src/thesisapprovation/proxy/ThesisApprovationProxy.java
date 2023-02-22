package thesisapprovation.proxy;

import organizationchart.Student;
import organizationchart.server.OrganizationChartService;
import thesisapprovation.server.ThesisApprovationService;

import java.sql.SQLException;

public class ThesisApprovationProxy {
    private OrganizationChartService ocService;
    public ThesisApprovationProxy() {}

    public Student getStudentsInformation(Integer idStudent) throws SQLException {
        this.ocService = new OrganizationChartService();
        return ocService.getStudentByFreshman(idStudent);
    }
}
