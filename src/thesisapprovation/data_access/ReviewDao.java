package thesisapprovation.data_access;

import thesisapprovation.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> getAllReviews();

    Review getReview(int id);

    void insertReview(Review review);

    void updateReview(Review review);

    void deleteReview(Review review);
}
