package didacticoffer.proxy;

import organizationchart.Student;
import organizationchart.server.OrganizationChartService;

import java.sql.SQLException;

public class DidacticOfferProxy {
    private OrganizationChartService ocService;

    public DidacticOfferProxy() { this.ocService = new OrganizationChartService(); }

    public Student getStudentsInformation(Integer idStudent) throws SQLException, InterruptedException {
        return ocService.getStudentByFreshman(idStudent);
    }
}
