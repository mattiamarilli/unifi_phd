package progressreport.data_access;

import progressreport.Scientist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class ScientistDao implements GenericDao<Scientist, Integer> {

    private Connection conn;

    @Override
    public List<Scientist> getAll() throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Scientists");

            List<Scientist> scientists = new ArrayList<Scientist>();

            while(rs.next()){
                int f = rs.getInt("Freshman");
                String p = rs.getString("Password");
                String n = rs.getString("Name");
                String s = rs.getString("Surname");
                String e = rs.getString("Email");
                String d = rs.getString("Description");

                Scientist scientist = new Scientist(f, n, s, p, e, d);

                scientists.add(scientist);

                //only for testing
                System.out.println(scientist.toString());

            }

            if(scientists.isEmpty())
                System.out.println("Don't exist scientists");

            return scientists;

        }catch (SQLException ex){
            System.out.println("Error get all scientists");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Scientist findByKey(Integer integer) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Scientist WHERE Freshman = ?");
            stmt.setInt(1, integer);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int f = rs.getInt("Freshman");
                String p = rs.getString("Password");
                String n = rs.getString("Name");
                String s = rs.getString("Surname");
                String e = rs.getString("Email");
                String d = rs.getString("Description");

                Scientist scientist = new Scientist(f, n, s, p, e, d);

                //only for testing
                System.out.println(scientist.toString());

                return scientist;
            }else{
                System.out.println("Doesn't exist scientist with id=" + integer);
                return null;
            }

        }catch (SQLException ex){
            System.out.println("Error get scientist by id");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean insert(Scientist scientist) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Scientists(Freshman, Password, Name, Surname, Email, Description) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, scientist.getFreshman());
            stmt.setString(2, scientist.getPassword());
            stmt.setString(3, scientist.getName());
            stmt.setString(4, scientist.getSurname());
            stmt.setString(5, scientist.getEmail());
            stmt.setString(6, scientist.getDescription());

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert scientist successful");
                return true;
            }else{
                System.out.println("Insert scientist not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error insert scientist");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(Scientist scientist) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Scientists SET Name= ?, Surname= ?, Email= ?, Password= ?, Description= ? WHERE Freshman= ?");
            stmt.setString(1, scientist.getName());
            stmt.setString(2, scientist.getSurname());
            stmt.setString(3, scientist.getEmail());
            stmt.setString(4, scientist.getPassword());
            stmt.setString(5, scientist.getDescription());
            stmt.setInt(6, scientist.getFreshman());

            if(stmt.executeUpdate() > 0){
                System.out.println("Update scientist successful");
                return true;
            }else{
                System.out.println("Update scientist not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update scientist");
            ex.printStackTrace();
            return false;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Scientists WHERE Freshman= ?");
            stmt.setInt(1, integer);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete scientist successful");
                return true;
            }else{
                System.out.println("Delete scientist not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error delete scientist");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }
}
