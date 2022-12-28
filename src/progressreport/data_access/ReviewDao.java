package progressreport.data_access;

import progressreport.Review;

import java.sql.SQLException;
import java.util.List;

//TODO: finish implementation
public class ReviewDao implements GenericDao<Review, Integer> {

    @Override
    public List<Review> getAll() throws SQLException {
        return null;
    }

    @Override
    public Review findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public Boolean insert(Review review) throws SQLException {
        return false;
    }

    @Override
    public Boolean update(Review review) throws SQLException {
        return false;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return false;
    }
}
