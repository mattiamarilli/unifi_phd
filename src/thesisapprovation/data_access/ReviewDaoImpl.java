package thesisapprovation.data_access;

import thesisapprovation.Review;

import java.sql.*;
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
            int id = rs.getInt("Id");
            int idReviewer = rs.getInt("IdReviewer");
            int idThesis = rs.getInt("IdThesis");

            Review review = new Review(id, title, comment, idReviewer, idThesis);

            reviews.add(review);

            //output review (for only testing)
            System.out.println(review.toString());
        }

        return reviews;
    }

    @Override
    public Review getReviewById(int idReview) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Reviews WHERE Id=" + idReview);

            if(rs.next()) {
                String title = rs.getString("Title");
                String comment = rs.getString("Comment");
                int id = rs.getInt("Id");
                int idReviewer = rs.getInt("IdReviewer");
                int idThesis = rs.getInt("IdThesis");
                Review r = new Review(id, title, comment, idReviewer, idThesis);
                //output review only testing
                System.out.println(r.toString());
                conn.close();
                return r;
            }
            System.out.println("there aren't Reviews with id=" + idReview);

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            conn.close();
            return null;
        }

    }

    @Override
    public void insertReview(Review review) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Reviewes (Title, Comment, IdThesis, IdReviewer) VALUES( ?, ?, ?, ?)");
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getIdThesis());
            ps.setInt(4, review.getIdReviewer());

            if(ps.executeUpdate() > 0)
                System.out.println("Insert successful");
            else
                System.out.println("Insert not successful");

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conn.close();
        }

    }

    @Override
    public void updateReview(Review review) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE Review SET Title = ?, Comment = ? IdThesis = ?, IdReviewer = ?");
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getIdThesis());
            ps.setInt(4, review.getIdReviewer());

            if(ps.executeUpdate() > 0)
                System.out.println("Update successful");
            else
                System.out.println("Update not successful");

        }catch(SQLException ex){

        }finally {
            conn.close();
        }
    }

    @Override
    public void deleteReview(int idReview) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Review WHERE Id = ?");
            ps.setInt(1, idReview);

            if(ps.executeUpdate() > 0)
                System.out.println("Delete successful");
            else
                System.out.println("Delete not successful");

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conn.close();
        }

    }
}
