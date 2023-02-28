package emulation;

import didacticoffer.AppealParticipation;
import didacticoffer.Professor;
import org.junit.jupiter.api.Test;
import organizationchart.Student;
import organizationchart.server.*;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.sql.SQLException;
import java.util.List;

public class ProfessorEmulation {
    DidacticOfferService dos = new DidacticOfferService();
    @Test
    void viewEnrolledStudents() throws SQLException {
        Professor p = dos.getAllProfessors().get(2);
        assertEquals(2,dos.getAllStudentsByProfessor(p.getFreshman()).size());
    }

    @Test
    void insertVote() throws SQLException {
        Professor p = dos.getAllProfessors().get(2);
        List<Student> s = dos.getAllStudentsByProfessor(p.getFreshman());
        List<AppealParticipation> ap = dos.getAppealParticipationByStudent(s.get(1).getFreshman());
        assertEquals(true,dos.updateVote(102829,7,"20"));
    }
}
