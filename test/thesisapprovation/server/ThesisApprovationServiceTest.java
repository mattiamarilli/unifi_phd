package thesisapprovation.server;

import org.junit.jupiter.api.Test;
import thesisapprovation.Reviewer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThesisApprovationServiceTest {

    private ThesisApprovationService taService = new ThesisApprovationService();

    @Test
    void insertStudentToThesisApprovation() throws SQLException{
        assertEquals(true, taService.insertStudentToThesisApprovation(3840291));
        //error student freshman (already exists)
        assertEquals(false, taService.insertStudentToThesisApprovation(7028492));
    }

    @Test
    void updateThesis() throws SQLException{
        assertEquals(true, taService.updateThesis(1, "Analysis and comparison between the new file proposals of the different operating systems (update)", "Thesis description (update)", "thesisSystemOperativeUpdate.pdf", 102829));
        //error id
        assertEquals(false, taService.updateThesis(0, "Analysis and comparison between the new file proposals of the different operating systems (update)", "Thesis description (update)", "thesisSystemOperativeUpdate.pdf", 102829));
    }

    @Test
    void updateStateThesis() throws SQLException{
        assertEquals(true, taService.updateStateThesis(7028492, "Approved"));
        //error student freshman
        assertEquals(false, taService.updateStateThesis(0, "Approved"));
    }

    @Test
    void updateLoadedThesis() throws SQLException{
        assertEquals(true, taService.updateLoadedThesis(1, "Not_load"));
        //error id thesis
        assertEquals(false, taService.updateLoadedThesis(0, "Load"));
    }

    @Test
    void deleteThesis() throws SQLException {
        assertEquals(true, taService.deleteThesis(1));
        //error id thesis
        assertEquals(false, taService.deleteThesis(0));
    }

    @Test
    void deleteThesisByStudent() throws SQLException{
        assertEquals(true, taService.deleteThesisByStudent(3820392));
        //error student freshman
        assertEquals(false, taService.deleteThesisByStudent(0));
    }

    @Test
    void getReviewersByStudent() throws SQLException{
        List<Reviewer> reviewers = new ArrayList<Reviewer>();
        reviewers.add(new Reviewer(3485395, "Franco", "Scarselli", "franco.scarselli@unifi.it", "Machine Learning; Artificial neural networks"));
        reviewers.add(new Reviewer(5940249, "Roberto", "Giorgi", "roberto.giorgi@iid.unisi.it", "Computer Architecture; Parallel and Distributed Computing"));

        assertEquals(reviewers, taService.getReviewersByStudent(7028492));
    }

    @Test
    void getReviewByStudentReviewer() {
    }

    @Test
    void getThesisById() {
    }

    @Test
    void insertEvaluationCommittee() {
    }

    @Test
    void getThesisByStudent() {
    }

    @Test
    void insertReviewer() {
    }

    @Test
    void deleteReviewer() {
    }

    @Test
    void updateReviewer() {
    }

    @Test
    void updatePasswordReviewer() {
    }

    @Test
    void getStudentsByReviewer() {
    }

    @Test
    void insertReview() {
    }

    @Test
    void updateReview() {
    }

    @Test
    void deleteReview() {
    }
}