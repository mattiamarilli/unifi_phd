package progressreport.data_access;

import progressreport.ProgressReport;
import progressreport.Scientist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgressReportDao implements GenericDao<ProgressReport, Integer> {

    private Connection conn;

    @Override
    public List<ProgressReport> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Progresseports");

            List<ProgressReport> progressReports = new ArrayList<ProgressReport>();

            while(rs.next()){
                int id = rs.getInt("Id");
                String t = rs.getString("Title");
                String d = rs.getString("Description");
                String ud = rs.getString("UrlDocument");
                String s = rs.getString("State");
                int fs = rs.getInt("FreshmanStudent");

                ProgressReport pr = new ProgressReport(id, t, d, ud, s, fs);

                progressReports.add(pr);

                //only for testing
                System.out.println(pr.toString());
            }

            if(progressReports.isEmpty()) {
                System.out.println("Don't exist progress reports");
                return null;
            }

            return progressReports;

        }catch(SQLException ex){
            System.out.println("Error get all progress reports");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public ProgressReport findByKey(Integer integer) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ProgressReports WHERE StudentFreshman = ?");
            stmt.setInt(1, integer);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("Id");
                String t = rs.getString("Title");
                String d = rs.getString("Description");
                String ud = rs.getString("UrlDocument");
                String s = rs.getString("State");
                int fs = rs.getInt("StudentFreshman");

                ProgressReport pr = new ProgressReport(id, t, d, ud, s, fs);

                //only for testing
                System.out.println(pr.toString());

                return pr;
            }else{
                System.out.println("Doesn't exist progress report with id=" + integer);
                return null;
            }


        }catch(SQLException ex){
            System.out.println("Error get progress report by id");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }


    }

    @Override
    public Boolean insert(ProgressReport progressReport) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ProgressReports(Title, Description, UrlDocument, State, StudentFreshman) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, progressReport.getTitle());
            stmt.setString(2, progressReport.getDescription());
            stmt.setString(3, progressReport.getUrlDocument());
            stmt.setString(4, String.valueOf(progressReport.getState()));
            stmt.setInt(5, progressReport.getFreshmanStudent());

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert progress report successful");
                return true;
            }else{
                System.out.println("Insert progress report not successful");
                return false;
            }


        }catch(SQLException ex){
            System.out.println("Error insert progress report");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean update(ProgressReport progressReport) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE ProgressReports SET Title = ?, Description = ?, UrlDocument = ? WHERE Id = ?");
            stmt.setString(1, progressReport.getTitle());
            stmt.setString(2, progressReport.getDescription());
            stmt.setString(3, progressReport.getUrlDocument());
            stmt.setInt(4, progressReport.getId());

            if(stmt.executeUpdate() > 0){
                System.out.println("Update progress report successful");
                return true;
            }else{
                System.out.println("Update progress report not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update progress report");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM ProgressReports WHERE Id= ?");
            stmt.setInt(1, integer);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete progress report successful");
                return true;
            }else{
                System.out.println("Delete progress report not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error delete progress report");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

    public Boolean insertSupervisory(Integer idProgressReport, Integer idScientist) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO SupervisoryCommittee (IdProgressReport,IdScientist) VALUES(?, ?)");
            stmt.setInt(1, idProgressReport);
            stmt.setInt(2, idScientist);


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

    public boolean updateState(Integer studentFreshman, String state) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE ProgressReports SET State = ? WHERE StudentFreshman = ?");
            stmt.setString(1, state);
            stmt.setInt(2, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update state progress report successful");
                return true;
            }else{
                System.out.println("Update state progress report not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update state progress report");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public List<Scientist> getScientists(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Freshman, Name, Surname, Email, Scientists.Description \n" +
                    "FROM ProgressReports \n" +
                    "INNER JOIN SupervisoryCommittee ON Id = IdProgressReport \n" +
                    "INNER JOIN Scientists ON IdScientist = Freshman \n" +
                    "WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Scientist> scientists = new ArrayList<Scientist>();

            while(rs.next()){
                Integer f = rs.getInt("Freshman");
                String n = rs.getString("Name");
                String s = rs.getString("Surname");
                String e = rs.getString("Email");
                String d = rs.getString("Description");

                Scientist scientist = new Scientist(f, n, s, e, d);

                scientists.add(scientist);
            }

            return scientists;

        }catch(SQLException ex){
            System.out.println("Error get scientists by student freshman");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    public Boolean deleteProgressReportByStudent(Integer studentFreshman) throws SQLException {

        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM ProgressReports WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete progress report by student successful");
                return true;
            }else{
                System.out.println("Delete progress report by student not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error delete progress report by student");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

}
