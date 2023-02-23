package thesisapprovation.data_access;

import thesisapprovation.EvaluationCommittee;
import thesisapprovation.Review;
import thesisapprovation.Thesis;
import thesisapprovation.Reviewer;

import java.sql.*;
import java.util.*;

public class ReviewDao implements GenericDao<Review, Integer> {

    private Connection conn;

    @Override
    public List<Review> getAll() throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Reviews.Id as ReviewId, Reviews.Title as ReviewTitle, Reviews.Comment as ReviewComment, IdThesis, Thesis.Title as ThesisTitle, Thesis.Description as ThesisDescription, UrlDocument, StudentFreshman, Thesis.State, Thesis.Loaded, Reviewers.Freshman as ReviewerFreshman, Name, Surname, Email, Reviewers.Description as ReviewerDescription\n" +
                    "from Reviews inner join Thesis on idThesis = Thesis.Id \n" +
                    "inner join Reviewers on idReviewer = Freshman");

            //create empty list
            List<Review> reviews = new ArrayList<Review>();

            while(rs.next()){
                int idReview = rs.getInt("ReviewId");
                String title = rs.getString("ReviewTitle");
                String comment = rs.getString("ReviewComment");
                int idThesis = rs.getInt("IdThesis");
                int idReviewer = rs.getInt("ReviewerFreshman");
                String thesisTitle = rs.getString("ThesisTitle");
                String thesisDescription = rs.getString("ThesisDescription");
                String urlDocument = rs.getString("UrlDocument");
                int studentFreshman = rs.getInt("StudentFreshman");
                String state = rs.getString("State");
                String load = rs.getString("Loaded");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String description = rs.getString("ReviewerDescription");


                Thesis t = new Thesis(idThesis, thesisTitle, thesisDescription, urlDocument, studentFreshman, state, load);
                Reviewer r = new Reviewer(idReviewer, name, surname, email, description);

                EvaluationCommittee ec = new EvaluationCommittee(t, r);

                Review review = new Review(idReview, title, comment, ec);

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
            ResultSet rs = stmt.executeQuery("select Reviews.Id as ReviewId, Reviews.Title as ReviewTitle, Reviews.Comment as ReviewComment, IdThesis, Thesis.Title as ThesisTitle, Thesis.Description as ThesisDescription, UrlDocument, StudentFreshman, Thesis.State, Thesis.Loaded, Reviewers.Freshman as ReviewerFreshman, Name, Surname, Email, Reviewers.Description as ReviewerDescription\n" +
                    "from Reviews inner join Thesis on idThesis = Thesis.Id \n" +
                    "inner join Reviewers on idReviewer = Freshman WHERE ReviewId = " + idReview);

            if(rs.next()) {
                String title = rs.getString("ReviewTitle");
                String comment = rs.getString("ReviewComment");
                int idThesis = rs.getInt("IdThesis");
                int idReviewer = rs.getInt("ReviewerFreshman");
                String thesisTitle = rs.getString("ThesisTitle");
                String thesisDescription = rs.getString("ThesisDescription");
                String urlDocument = rs.getString("UrlDocument");
                int studentFreshman = rs.getInt("StudentFreshman");
                String state = rs.getString("State");
                String load = rs.getString("Loaded");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String description = rs.getString("ReviewerDescription");


                Thesis t = new Thesis(idThesis, thesisTitle, thesisDescription, urlDocument, studentFreshman, state, load);
                Reviewer r = new Reviewer(idReviewer, name, surname, email, description);

                EvaluationCommittee ec = new EvaluationCommittee(t, r);

                Review review = new Review(idReview, title, comment, ec);
                //output review only testing
                System.out.println(r.toString());
                conn.close();
                return review;
            }else {
                System.out.println("there aren't Reviews with id=" + idReview);
                return null;
            }

        }catch(SQLException ex){
            System.out.println("Error get review by id");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();

        }

    }

    @Override
    public Boolean insert(Review review) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES( ?, ?, ?, ?)");
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getEc().getThesis().getId());
            ps.setInt(4, review.getEc().getReviewer().getFreshman());

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
            conn.close();
        }

    }

    @Override
    public Boolean update(Review review) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE Reviews SET Title = ?, Comment = ? WHERE Id = ?");
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getId());

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
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Reviews WHERE Id = ?");
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
