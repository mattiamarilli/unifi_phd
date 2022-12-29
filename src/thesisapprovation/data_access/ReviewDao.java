package thesisapprovation.data_access;

import thesisapprovation.Review;

import java.sql.*;
import java.util.*;

public class ReviewDao implements GenericDao<Review, Integer> {

    private Connection conn;

    @Override
    public List<Review> getAll() throws SQLException {

        try{
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

            if(reviews.isEmpty()) {
                System.out.println("Don't exist reviews");
                return null;
            }

            return reviews;

        }catch(SQLException ex){
            System.out.println("Error get all reviews");
            ex.printStackTrace();
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public Review findByKey(Integer idReview) throws SQLException {

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
            }else
                System.out.println("there aren't Reviews with id=" + idReview);

        }catch(SQLException ex){
            System.out.println("Error get review by id");
            ex.printStackTrace();
        }finally {
            conn.close();

        }
        return null;
    }

    @Override
    public Boolean insert(Review review) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES( ?, ?, ?, ?)");
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getIdThesis());
            ps.setInt(4, review.getIdReviewer());

            if(ps.executeUpdate() > 0) {
                System.out.println("Insert review successful");
                return true;
            }
            else
            {
                System.out.println("Insert review not successful");
                return false;
            }


        }catch(SQLException ex){
            System.out.println("Error insert review");
            ex.printStackTrace();
            return false;
        }finally{
            System.out.println("Connessione chiusa");
            conn.close();
        }

    }

    @Override
    public Boolean update(Review review) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE Review SET Title = ?, Comment = ? IdThesis = ?, IdReviewer = ? WHERE Id = ?");
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getIdThesis());
            ps.setInt(4, review.getIdReviewer());
            ps.setInt(5, review.getId());

            if(ps.executeUpdate() > 0)
            {
                System.out.println("Update review successful");
                return true;
            }
            else{
                System.out.println("Update review not successful");
                return false;
            }


        }catch(SQLException ex){
            System.out.println("Error update review");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean delete(Integer idReview) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Review WHERE Id = ?");
            ps.setInt(1, idReview);

            if(ps.executeUpdate() > 0)
            {
                System.out.println("Delete review successful");
                return true;
            }
            else
            {
                System.out.println("Delete review not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error delete review");
            ex.printStackTrace();
            return false;
        }finally{
            conn.close();
        }

    }
}
