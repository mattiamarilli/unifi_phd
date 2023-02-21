package thesisapprovation.server;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ThesisApprovationServiceTest {

    //TODO: errore nei costruttori, sono ricorsivi e quindi va in stack overflow

    private ThesisApprovationService taService = new ThesisApprovationService();

    @Test
    void insertStudentToThesisApprovation() {
    }

    @Test
    void getStudentsByReviewer() throws SQLException {
    }
}