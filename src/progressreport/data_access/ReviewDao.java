package progressreport.data_access;

import progressreport.Review;

import java.sql.SQLException;
import java.util.List;

//TODO: finish implementation
public class ReviewDao implements GenericProgressReportDao<Review, Integer> {

    @Override
    public List<Review> getAll() throws SQLException {
        return null;
    }

    @Override
    public Review findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void insert(Review review) throws SQLException {

    }

    @Override
    public void update(Review review) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }
}
