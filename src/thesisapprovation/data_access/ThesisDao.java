package thesisapprovation.data_access;

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

            if(thesisList.isEmpty())
                System.out.println("Don't exist thesis");

        }catch(SQLException ex){
            System.out.println("Error get all thesis");
            ex.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
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
            }
        }catch (SQLException ex){
            System.out.println("Error get thesis by id");
            ex.printStackTrace();
        }finally{
            conn.close();
        }
        return null;
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
            PreparedStatement stmt = conn.prepareStatement("UPDATE Thesis SET Title= ?, Description= ?, UrlDocument= ?, State= ? WHERE Id= ?");
            stmt.setString(1, thesis.getTitle());
            stmt.setString(2, thesis.getDescription());
            stmt.setString(3, thesis.getUrlDocument());
            stmt.setString(4, String.valueOf(thesis.getState()));
            stmt.setInt(5, thesis.getId());

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
}
