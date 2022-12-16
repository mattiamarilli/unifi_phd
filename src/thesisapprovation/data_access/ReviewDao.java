package thesisapprovation.data_access;

import thesisapprovation.Review;

import java.sql.SQLException;
import java.util.List;

public interface ReviewDao {

    List<Review> getAllReviews() throws SQLException;

    Review getReviewById(int id) throws SQLException;

    void insertReview(Review review);

    void updateReview(Review review);

    void deleteReview(Review review);
}
