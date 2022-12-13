package thesisapprovation.data_access;

import thesisapprovation.Reviewer;

import java.util.List;

public interface ReviewerDao {

    List<Reviewer> getAllReviewers();

    Reviewer getReviewer(int id);

    void insertReviewer(Reviewer reviewer);

    void updateReviewer(Reviewer reviewer);

    void deleteReviewer(Reviewer reviewer);

}
