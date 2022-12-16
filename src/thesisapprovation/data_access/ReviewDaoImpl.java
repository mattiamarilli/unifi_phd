package thesisapprovation.data_access;

import thesisapprovation.Review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ReviewDaoImpl implements ReviewDao {

    private Connection conn;

    public ReviewDaoImpl(){}

    @Override
    public List<Review> getAllReviews() throws SQLException {
        conn = ConnectionDao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Reviews");

        //create empty list
        List<Review> reviews = new ArrayList<Review>();

        while(rs.next()){
            String title = rs.getString("Title");
            String comment = rs.getString("Comment");

            Review review = new Review(title, comment);

            reviews.add(review);

            //output review (for only testing)
            System.out.println(review.toString());
        }

        return reviews;
    }

    @Override
    public Review getReviewById(int id) throws SQLException {
        conn = ConnectionDao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Reviews WHERE Id=" + id);

        if(rs.next()) {
            Review r = new Review(rs.getString("Title"), rs.getString("Comment"));
            //output review only testing
            System.out.println(r.toString());
            return r;
        }

        System.out.println("there aren't Reviews with id=" + id);
        return null;
    }

    @Override
    public void insertReview(Review review) {

    }

    @Override
    public void updateReview(Review review) {

    }

    @Override
    public void deleteReview(Review review) {

    }
}
