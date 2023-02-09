package thesisapprovation.data_access;

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

                Thesis t = new Thesis(id, title, description, url, studentFreshman, state);

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

                Thesis t = new Thesis(id, title, description, url, studentFreshman, state);

                //output only testing
                System.out.println(t.toString());

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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, thesis.getTitle());
            stmt.setString(2, thesis.getDescription());
            stmt.setString(3, thesis.getUrlDocument());
            stmt.setInt(4, thesis.getFreshmanStudent());
            stmt.setString(5, String.valueOf(thesis.getState()));

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
            }
            else
            {
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
            }
            else
            {
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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO EvaluationCommittee (IdThesis,IdReviewer) VALUES(?, ?)");
            stmt.setInt(1, idThesis);
            stmt.setInt(2, reviewerFreshman);


            if(stmt.executeUpdate() > 0)
            {
                System.out.println("Insert evaluation successful");
                return true;
            }
            else
            {
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

    public boolean updateState(Integer studentFreshman, String state) throws SQLException{
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

}



