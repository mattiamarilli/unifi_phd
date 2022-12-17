package thesisapprovation.data_access;

import thesisapprovation.Reviewer;

import java.sql.SQLException;
import java.util.List;

public interface ReviewerDao {

    List<Reviewer> getAllReviewers() throws SQLException;

    Reviewer getReviewerByFreshman(int f) throws SQLException;

    void insertReviewer(Reviewer reviewer) throws SQLException;

    void updateReviewer(Reviewer reviewer) throws SQLException;

    void deleteReviewer(int freshaman) throws SQLException;

}
