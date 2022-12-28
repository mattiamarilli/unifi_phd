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

            if (reviewers.isEmpty())
                System.out.println("Don't exist reviewers");

        } catch (SQLException ex) {
            System.out.println("Error get all reviewers");
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return null;
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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Reviewer (Freshman, Name, Surname, Password, Email, Description) VALUES (?, ?, ?, ?, ?, ?)");
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
            PreparedStatement stmt = conn.prepareStatement("UPDATE Reviewer SET Name = ?, Surname = ?, Password = ?, Email = ?, Description = ? WHERE Freshman = ?");
            stmt.setString(1, reviewer.getName());
            stmt.setString(2, reviewer.getSurname());
            stmt.setString(3, reviewer.getPassword());
            stmt.setString(4, reviewer.getEmail());
            stmt.setString(5, reviewer.getDescription());
            stmt.setInt(6, reviewer.getFreshman());

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
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Reviewer WHERE Freshman = ?");
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
}

