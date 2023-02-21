package thesisapprovation.proxy;

import organizationchart.Student;
import organizationchart.server.OrganizationChartService;
import thesisapprovation.server.ThesisApprovationService;

import java.sql.SQLException;

public class ThesisApprovationProxy {
    private OrganizationChartService ocService;
    public ThesisApprovationProxy() {
        this.ocService = new OrganizationChartService();
    }

    public Student getStudentsInformation(Integer idStudent) throws SQLException {
        return ocService.getStudentByFreshman(idStudent);
    }
}
