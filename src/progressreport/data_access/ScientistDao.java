package progressreport.data_access;

import progressreport.ProgressReport;
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
            }
            return scientists;

        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Scientist findByKey(Integer integer) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Scientists WHERE Freshman = ?");
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

                return scientist;
            }else
                return null;


        }catch (SQLException ex){
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

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch (SQLException ex){
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(Scientist scientist) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Scientists SET Name= ?, Surname= ?, Email= ?, Description= ? WHERE Freshman= ?");
            stmt.setString(1, scientist.getName());
            stmt.setString(2, scientist.getSurname());
            stmt.setString(3, scientist.getEmail());
            stmt.setString(4, scientist.getDescription());
            stmt.setInt(5, scientist.getFreshman());

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch(SQLException ex){
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

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch(SQLException ex){
            return false;
        }finally {
            conn.close();
        }
    }

    public List<Integer> getStudents(Integer scientistFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT StudentFreshman \n" +
                    "FROM SupervisoryCommittee\n" +
                    "INNER JOIN ProgressReports ON IdProgressReport = Id \n" +
                    "WHERE IdScientist = ?");
            stmt.setInt(1, scientistFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Integer> idStudents = new ArrayList<Integer>();

            while(rs.next()){
                Integer f = rs.getInt("studentFreshman");
                idStudents.add(f);
            }

            return idStudents;
        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public List<ProgressReport> getProgressReportByScientistStudent(Integer scientistFreshman, Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Id, Title, ProgressReports.Description, UrlDocument \n" +
                    "FROM Scientists \n" +
                    "INNER JOIN SupervisoryCommittee ON IdScientist=Freshman \n" +
                    "INNER JOIN ProgressReports ON IdProgressReport = Id \n" +
                    "WHERE State = 'Load' AND Freshman = ? AND StudentFreshman = ?");
            stmt.setInt(1, scientistFreshman);
            stmt.setInt(2, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<ProgressReport> progressReports = new ArrayList<ProgressReport>();

            while(rs.next()){
                Integer id = rs.getInt("Id");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String url = rs.getString("UrlDocument");

                progressReports.add(new ProgressReport(id, title, description, url, studentFreshman));
            }

            return progressReports;

        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public boolean updatePassword(Integer idScientist, String password) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Scientists SET Password = ? WHERE Freshman = ?");
            stmt.setString(1, password);
            stmt.setInt(2, idScientist);

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch(SQLException ex){
            return false;
        }finally {
            conn.close();
        }
    }


}
