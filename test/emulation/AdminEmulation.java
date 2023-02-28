package emulation;
import didacticoffer.Course;
import didacticoffer.Professor;
import org.junit.jupiter.api.Test;
import organizationchart.FacultyMember;
import organizationchart.Student;
import organizationchart.server.*;
import progressreport.ProgressReport;
import progressreport.Scientist;
import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdminEmulation {
    OrganizationChartService ocs = new OrganizationChartService();
    ProgressReportService prs = new ProgressReportService();

    ThesisApprovationService tas = new ThesisApprovationService();
    DidacticOfferService dos = new DidacticOfferService();



}
