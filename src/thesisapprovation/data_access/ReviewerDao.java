package thesisapprovation.data_access;

import thesisapprovation.Reviewer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewerDao implements GenericDao<Reviewer, Integer> {

    private Connection conn;

    @Override
    public List<Reviewer> getAll() throws SQLException {
        try {
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Reviewers");

            //create empty list
            List<Reviewer> reviewers = new ArrayList<Reviewer>();

            while (rs.next()) {
                int freshman = rs.getInt("Freshman");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String description = rs.getString("Description");

                Reviewer r = new Reviewer(freshman, name, surname, password, email, description);

                reviewers.add(r);

                //output only for testing
                System.out.println(r.toString());
            }

            if (reviewers.isEmpty()) {
                System.out.println("Don't exist reviewers");
                return null;
            }

            return reviewers;

        } catch (SQLException ex) {
            System.out.println("Error get all reviewers");
            ex.printStackTrace();
            return null;
        } finally {
            conn.close();
        }

    }

    @Override
    public Reviewer findByKey(Integer f) throws SQLException {

        try {
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reviewers WHERE Freshman= ?");
            stmt.setInt(1, f);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String description = rs.getString("Description");
                Reviewer r = new Reviewer(f, name, surname, password, email, description);

                //output reviewer only for testing
                System.out.println(r.toString());
                return r;
            } else
                System.out.println("there aren't Reviewers with freshman=" + f);

        } catch (SQLException ex) {
            System.out.println("Error get reviewer by freshman");
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return null;
    }

    @Override
    public Boolean insert(Reviewer reviewer) throws SQLException {

        try {
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, reviewer.getFreshman());
            stmt.setString(2, reviewer.getName());
            stmt.setString(3, reviewer.getSurname());
            stmt.setString(4, reviewer.getPassword());
            stmt.setString(5, reviewer.getEmail());
            stmt.setString(6, reviewer.getDescription());

            if (stmt.executeUpdate() > 0) {
                System.out.println("Insert reviewer successful");
                return true;
            } else {
                System.out.println("Insert reviewer not successful");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error insert reviewer");
            ex.printStackTrace();
            return false;
        } finally {
            conn.close();
        }

    }

    @Override
    public Boolean update(Reviewer reviewer) throws SQLException {
        try {
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Reviewers SET Name = ?, Surname = ?, Email = ?, Description = ? WHERE Freshman = ?");
            stmt.setString(1, reviewer.getName());
            stmt.setString(2, reviewer.getSurname());
            stmt.setString(3, reviewer.getEmail());
            stmt.setString(4, reviewer.getDescription());
            stmt.setInt(5, reviewer.getFreshman());

            if (stmt.executeUpdate() > 0) {
                System.out.println("Update reviewer successful");
                return true;
            } else {
                System.out.println("Update reviewer not successful");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error update reviewer");
            ex.printStackTrace();
            return false;
        } finally {
            conn.close();
        }
    }

    @Override
    public Boolean delete(Integer freshman) throws SQLException {

        try {
            conn = ConnectionDao.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Reviewers WHERE Freshman = ?");
            ps.setInt(1, freshman);

            if (ps.executeUpdate() > 0) {
                System.out.println("Delete reviewer successful");
                return true;
            } else {
                System.out.println("Delete reviewer not successful");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error delete reviewer");
            ex.printStackTrace();
            return false;
        } finally {
            conn.close();
        }
    }

    public boolean updatePassword(Integer freshman, String password) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Reviewers SET Password = ? WHERE Freshman = ?");
            stmt.setString(1, password);
            stmt.setInt(2, freshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update password reviewer successful");
                return true;
            }else{
                System.out.println("Update password reviewer not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update password reviewer ");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public List<Integer> getStudentFreshmen(Integer reviewerFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT StudentFreshman FROM Reviewers\n" +
                    "INNER JOIN EvaluationCommittee ON IdReviewer = Freshman\n" +
                    "INNER JOIN Thesis ON IdThesis = Id\n" +
                    "WHERE Freshman = ?");
            stmt.setInt(1, reviewerFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Integer> studentFreshmen = new ArrayList<Integer>();

            while(rs.next()){
                studentFreshmen.add(rs.getInt("StudentFreshman"));
            }

            return studentFreshmen;

        }catch(SQLException ex){
            System.out.println("Error get student freshmen by reviewer");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }
}
