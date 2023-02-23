package thesisapprovation.server;

import org.junit.jupiter.api.Test;
import organizationchart.Cycle;
import organizationchart.FacultyMember;
import organizationchart.Student;
import thesisapprovation.EvaluationCommittee;
import thesisapprovation.Review;
import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;

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
        assertEquals(true, taService.updateLoadedThesis(2, "Not_load"));
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

        //list empty
        List<Reviewer> reviewers_ = new ArrayList<Reviewer>();
        assertEquals(reviewers_, taService.getReviewersByStudent(0));
    }

    @Test
    void getReviewByStudentReviewer() throws SQLException{
        Thesis t = new Thesis(2, "Design and development of Augmented Reality Apps", "Thesis description", "thesisRealityApp.pdf", 7028492, "Not_approved", "Not_load");
        Reviewer r = new Reviewer(3485395, "Franco", "Scarselli", "franco.scarselli@unifi.it", "Machine Learning; Artificial neural networks");
        EvaluationCommittee ec = new EvaluationCommittee(t, r);
        Review review = new Review(3, "Correction Thesis Reality Apps", "Comment", ec);

        assertEquals(review, taService.getReviewByStudentReviewer(7028492, 3485395));

        //object null
        assertNull(taService.getReviewByStudentReviewer(0, 3485395));
    }

    @Test
    void getThesisById() throws SQLException{
        Thesis t = new Thesis(5, "Deep Learning Methods for Document Image Understanding", "Thesis description", "thesisDeepLearning.pdf", 3923920, "Approved", "Load");
        assertEquals(t, taService.getThesisById(5));

        //error id
        assertNull(taService.getThesisById(0));
    }

    @Test
    void insertEvaluationCommittee() throws SQLException{
        assertEquals(true, taService.insertEvaluationCommittee(1, 8420391));
        //error (already exist)
        assertEquals(false, taService.insertEvaluationCommittee(1, 8420391));
    }

    @Test
    void getThesisByStudent() throws SQLException{
        Thesis t = new Thesis(5, "Deep Learning Methods for Document Image Understanding", "Thesis description", "thesisDeepLearning.pdf", 3923920, "Approved", "Load");
        assertEquals(t, taService.getThesisByStudent(3923920));
        //thesis not load
        assertNull(taService.getThesisByStudent(7028492));
    }

    @Test
    void insertReviewer() throws SQLException{
        assertEquals(true, taService.insertReviewer(3920384, "Name Test", "Surname Test", "Password Test", "test@test.it", "Description reviewer test"));
        //error insert (freshman already exists)
        assertEquals(false,taService.insertReviewer(3920384, "Name Test", "Surname Test", "Password Test", "test@test.it", "Description reviewer test") );
    }

    @Test
    void deleteReviewer() throws SQLException{
        assertEquals(true, taService.deleteReviewer(8420391));
        //error delete (doesn't exist)
        assertEquals(false, taService.deleteReviewer(0));
    }

    @Test
    void updateReviewer() throws SQLException{
        assertEquals(true, taService.updateReviewer(5940249, "Roberto update", "Giorgi update", "robaerto.giorgi@iid.unisi.it", "Computer Architecture; Parallel and Distributed Computing Update"));
        //error update (doesn't exist reviewer)
        assertEquals(false, taService.updateReviewer(940249, "Roberto update", "Giorgi update", "robaerto.giorgi@iid.unisi.it", "Computer Architecture; Parallel and Distributed Computing Update"));
    }

    @Test
    void updatePasswordReviewer() throws SQLException {
        assertEquals(true, taService.updatePasswordReviewer(7389203, "Password update"));
        //error update password (doesn't exist reviewer)
        assertEquals(false, taService.updatePasswordReviewer(0, "Password update"));
    }

    @Test
    void getStudentsByReviewer() throws SQLException{
        List<Student> students = new ArrayList<Student>();

        Cycle c1 = new Cycle("XXVII", 2020, "IComputer and automation engineering");
        FacultyMember a1 = new FacultyMember(281392, "Marco", "Gori", "marco.gori@unisi.it", "Machine Learning; Computer Vision", "University of Siena", c1);
        students.add(new Student(7028492, "Matteo", "Barbetti", "matteo.barbetti@unifi.it", "Smart Computing Techniques applied to Medical Physics, Nuclear Physics and Particle Physics", c1, 3, a1));

        Cycle c2 = new Cycle("XXVI", 2019, "Information Technology, Systems and Telecommunications");
        students.add(new Student(3923920, "Alessandro", "Betti", "alessandro.betti@unifi.it", "", c2, 4, null));

        students.add(new Student(4728103, "Enrico", "Meloni", "enrico.meloni@unifi.it", "Machine Learning and Explainable AI", c2, 4, null));

        assertEquals(students, taService.getStudentsByReviewer(3485395));

        //error reviewer, list empty
        List<Student> students_empty = new ArrayList<>();
        assertEquals(students_empty, taService.getStudentsByReviewer(0));

    }

    @Test
    void insertReview() throws SQLException{
        assertEquals(true, taService.insertReview(2, 	3485395,"test", "comment test"));
        //error insert (reviewer doesn't exist)
        assertEquals(false, taService.insertReview(2, 102829,  "test", "comment test"));
    }

    @Test
    void updateReview() throws SQLException{
        assertEquals(true, taService.updateReview(2, "Title update", "Comment update"));
        //error id thesis
        assertEquals(false, taService.updateReview(0, "Title update", "Comment update"));

    }

    @Test
    void deleteReview() throws SQLException {
        assertEquals(true, taService.deleteReview(7));
        //error id review
        assertEquals(false, taService.deleteReview(0));
    }
}