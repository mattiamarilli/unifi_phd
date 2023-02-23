package thesisapprovation.data_access;

import thesisapprovation.EvaluationCommittee;
import thesisapprovation.Review;
import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThesisDao implements GenericDao<Thesis, Integer> {

    private Connection conn;
    @Override
    public List<Thesis> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Thesis");

            //create empty list
            List<Thesis> thesisList = new ArrayList<Thesis>();

            while(rs.next()){
                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String url = rs.getString("UrlDocument");
                int studentFreshman = rs.getInt("StudentFreshman");
                String state = rs.getString("State");
                String load = rs.getString("Loaded");

                Thesis t = new Thesis(id, title, description, url, studentFreshman, state, load);

                thesisList.add(t);

                //output only testing
                System.out.println(t.toString());

            }

            if(thesisList.isEmpty()) {
                System.out.println("Don't exist thesis");
                return null;
            }

            return thesisList;

        }catch(SQLException ex){
            System.out.println("Error get all thesis");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Thesis findByKey(Integer id) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Thesis WHERE Id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String url = rs.getString("UrlDocument");
                int studentFreshman = rs.getInt("StudentFreshman");
                String state = rs.getString("State");
                String load = rs.getString("Loaded");

                Thesis t = new Thesis(id, title, description, url, studentFreshman, state, load);

                return t;

            }else{
                System.out.println("Doesn't exist thesis with id=" + id);
                return null;
            }
        }catch (SQLException ex){
            System.out.println("Error get thesis by id");
            ex.printStackTrace();
            return null;
        }finally{
            conn.close();
        }

    }

    @Override
    public Boolean insert(Thesis thesis) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Thesis (StudentFreshman, State, Loaded) VALUES(?, ?, ?)");
            stmt.setInt(1, thesis.getStudentFreshman());
            stmt.setString(2, String.valueOf(thesis.getState()));
            stmt.setString(3, String.valueOf(thesis.getLoad()));

            if(stmt.executeUpdate() > 0)
            {
                System.out.println("Insert thesis successful");
                return true;
            }
            else
            {
                System.out.println("Insert thesis not successful");
                return false;
            }

        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error insert thesis");
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(Thesis thesis) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Thesis SET Title= ?, Description= ?, UrlDocument= ? WHERE Id= ?");
            stmt.setString(1, thesis.getTitle());
            stmt.setString(2, thesis.getDescription());
            stmt.setString(3, thesis.getUrlDocument());
            stmt.setInt(4, thesis.getId());

            if(stmt.executeUpdate() > 0)
            {
                System.out.println("Update thesis successful");
                return true;
            }else{
                System.out.println("Update thesis not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update thesis ");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean delete(Integer id) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Thesis WHERE Id= ?");
            stmt.setInt(1, id);

            if(stmt.executeUpdate() > 0)
            {
                System.out.println("Delete thesis successful");
                return true;
            }else{
                System.out.println("Delete thesis not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error delete thesis");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean insertEvaluation(Integer idThesis, Integer reviewerFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES(?, ?)");
            stmt.setInt(1, idThesis);
            stmt.setInt(2, reviewerFreshman);


            if(stmt.executeUpdate() > 0)
            {
                System.out.println("Insert evaluation successful");
                return true;
            }else{
                System.out.println("Insert evaluation not successful");
                return false;
            }

        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error insert evaluation");
            return false;
        }finally {
            conn.close();
        }
    }

    public boolean updateStateThesis(Integer studentFreshman, String state) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Thesis SET State = ? WHERE StudentFreshman = ?");
            stmt.setString(1, state);
            stmt.setInt(2, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update state successful");
                return true;
            }else{
                System.out.println("Update state not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update state");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public boolean updateLoadedThesis(Integer idThesis, String stateLoaded) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Thesis SET Loaded = ? WHERE Id = ?");
            stmt.setString(1, stateLoaded);
            stmt.setInt(2, idThesis);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update loaded successful");
                return true;
            }else{
                System.out.println("Update loaded not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update loaded by student");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public List<Reviewer> getReviewersByStudent(Integer studentFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Freshman, Name, Surname, Email, Reviewers.Description FROM Thesis INNER JOIN EvaluationCommittee ON Id = IdThesis INNER JOIN Reviewers ON Freshman = IdReviewer WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Reviewer> reviewers = new ArrayList<Reviewer>();

            while(rs.next()){
                int freshman = rs.getInt("Freshman");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String description = rs.getString("Description");

                Reviewer r = new Reviewer(freshman, name, surname, email, description);

                reviewers.add(r);
            }

            return reviewers;

        }catch(SQLException ex){
            System.out.println("Error get reviewers by student");
            ex.printStackTrace();
            return null;
        }finally{
            conn.close();
        }
    }

    public Review getReviewByStudentReviewer(Integer studentFreshman, Integer reviewerFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Thesis.Id as ThesisId, Thesis.Title as ThesisTitle, Thesis.Description as ThesisDescription, Thesis.UrlDocument, Thesis.StudentFreshman, Thesis.State, Thesis.Loaded, Reviewers.Freshman as ReviewerFreshman, Reviewers.Name, Reviewers.Surname, Reviewers.Email, Reviewers.Description as ReviewersDescription, Reviews.Id as ReviewId, Reviews.Title as ReviewTitle, Reviews.Comment as ReviewComment FROM Thesis \n" +
                    "INNER JOIN EvaluationCommittee ON IdThesis = Thesis.Id\n" +
                    "INNER JOIN Reviewers ON Freshman = EvaluationCommittee.IdReviewer\n" +
                    "INNER JOIN Reviews ON Reviews.IdThesis = EvaluationCommittee.IdThesis AND Reviews.IdReviewer = EvaluationCommittee.IdReviewer\n" +
                    "WHERE StudentFreshman = ? AND EvaluationCommittee.IdReviewer = ?");

            stmt.setInt(1, studentFreshman);
            stmt.setInt(2, reviewerFreshman);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int thesisId = rs.getInt("ThesisId");
                String thesisTitle = rs.getString("ThesisTitle");
                String thesisDescription = rs.getString("ThesisDescription");
                String urlDocument = rs.getString("UrlDocument");
                String state = rs.getString("State");
                String load = rs.getString("Loaded");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String reviewersDescription = rs.getString("ReviewersDescription");
                int reviewId = rs.getInt("ReviewId");
                String reviewTitle = rs.getString("ReviewTitle");
                String reviewComment = rs.getString("ReviewComment");

                Thesis t = new Thesis(thesisId, thesisTitle, thesisDescription, urlDocument, studentFreshman, state, load);
                Reviewer r = new Reviewer(reviewerFreshman, name, surname, email, reviewersDescription);
                EvaluationCommittee ec = new EvaluationCommittee(t, r);

                Review review = new Review(reviewId, reviewTitle, reviewComment, ec);

                return review;

            }else{
                System.out.println("Doesn't exist review ");
                return null;
            }

        }catch(SQLException ex){
            System.out.println("Error gets review by student and reviewer");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    public Thesis getThesisByStudent(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Thesis WHERE StudentFreshman = ? AND Loaded = 'Load'");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String url = rs.getString("UrlDocument");
                String state = rs.getString("State");
                String load = rs.getString("Loaded");

                Thesis t = new Thesis(id, title, description, url, studentFreshman, state, load);
                return t;
            }else{
                System.out.println("Doesn't load thesis by student");
                return null;
            }


        }catch(SQLException ex){
            System.out.println("Error gets thesis by student freshman");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    public Boolean deleteThesisByStudent(Integer studentFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Thesis WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);

            if(stmt.executeUpdate() > 0)
            {
                System.out.println("Delete thesis by student successful");
                return true;
            }else{
                System.out.println("Delete thesis by student not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error delete thesis by student");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

}



