package organizationchart.proxy;


import didacticoffer.server.DidacticOfferService;
import progressreport.server.ProgressReportService;
import thesisapprovation.server.ThesisApprovationService;

import java.sql.SQLException;

public class OrganizationChartProxy {
    private ProgressReportService prService;
    private ThesisApprovationService taService;
    private DidacticOfferService doService;

    public OrganizationChartProxy(){
        this.prService = new ProgressReportService();
        this.taService = new ThesisApprovationService();
        this.doService = new DidacticOfferService();
    }

    public void insertStudentToProgressReport(Integer studentFreshman) throws SQLException {
        prService.insertStudentToProgressReport(studentFreshman);
    }

    public void insertStudentToThesisApprovation(Integer studentFreshman) throws SQLException{
        taService.insertStudentToThesisApprovation(studentFreshman);
    }

    public void insertStudentToDidacticOffer(Integer studentFreshman) throws SQLException{
        doService.insertStudentCareer(studentFreshman);
    }

    public void deleteStudentProgressReport(Integer studentFreshman) throws SQLException{
        prService.deleteProgressReportByStudent(studentFreshman);
    }

    public void deleteStudentThesisApprovation(Integer studentFreshman) throws SQLException{
        taService.deleteThesisByStudent(studentFreshman);
    }

    public void deleteStudentDidacticOffer(Integer studentFreshman) throws SQLException{
        doService.deleteStudentCareer(studentFreshman);
    }

}
