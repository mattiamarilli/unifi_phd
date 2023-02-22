package organizationchart.proxy;


import didacticoffer.server.DidacticOfferService;
import progressreport.server.ProgressReportService;
import thesisapprovation.server.ThesisApprovationService;

import java.sql.SQLException;

public class OrganizationChartProxy {
    private ProgressReportService prService;
    private ThesisApprovationService taService;
    private DidacticOfferService doService;

    public OrganizationChartProxy(){}

    public void insertStudentToProgressReport(Integer studentFreshman) throws SQLException {
        this.prService = new ProgressReportService();
        prService.insertStudentToProgressReport(studentFreshman);
    }

    public void insertStudentToThesisApprovation(Integer studentFreshman) throws SQLException{
        this.taService = new ThesisApprovationService();
        taService.insertStudentToThesisApprovation(studentFreshman);
    }

    public void insertStudentToDidacticOffer(Integer studentFreshman) throws SQLException{
        this.doService = new DidacticOfferService();
        doService.insertStudentCareer(studentFreshman);
    }

    public void deleteStudentProgressReport(Integer studentFreshman) throws SQLException{
        this.prService = new ProgressReportService();
        prService.deleteProgressReportByStudent(studentFreshman);
    }

    public void deleteStudentThesisApprovation(Integer studentFreshman) throws SQLException{
        this.taService = new ThesisApprovationService();
        taService.deleteThesisByStudent(studentFreshman);
    }

    public void deleteStudentDidacticOffer(Integer studentFreshman) throws SQLException{
        this.doService = new DidacticOfferService();
        doService.deleteStudentCareer(studentFreshman);
    }

}
