package didacticoffer.data_access;

import didacticoffer.Appeal;
import didacticoffer.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppealDao implements GenericDao<Appeal, Integer> {

    private Connection conn;

    @Override
    public List<Appeal> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id, Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse, Title, Description, CFU, Year FROM Appeals\n" +
                    "INNER JOIN Courses ON CodeCourse = Code");

            List<Appeal> appeals = new ArrayList<Appeal>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                String note = rs.getString("Note");
                String mode = rs.getString("Mode");
                String codeCourse = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(codeCourse, title, description, cfu, year);

                if(mode == "Presence"){
                    int room = rs.getInt("Room");
                    String universityComplex = rs.getString("UniversityComplex");
                    String university = rs.getString("University");

                    appeals.add(new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c));
                }else{
                    appeals.add(new Appeal(id, date, startTime, note, mode, c));
                }
            }

            return appeals;

        }catch(SQLException ex){
            System.out.println("Error get all appeals");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    @Override
    public Appeal findByKey(Integer idAppeal) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Id, Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse, Title, Description, CFU, Year FROM Appeals\n" +
                    "INNER JOIN Courses ON CodeCourse = Code\n" +
                    "WHERE Id = ?");
            stmt.setInt(1, idAppeal);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                String note = rs.getString("Note");
                String mode = rs.getString("Mode");
                String codeCourse = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(codeCourse, title, description, cfu, year);

                if(mode == "Presence"){
                    int room = rs.getInt("Room");
                    String universityComplex = rs.getString("UniversityComplex");
                    String university = rs.getString("University");

                    return new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
                }else{
                    return new Appeal(id, date, startTime, note, mode, c);
                }
            }else{
                System.out.println("Doesn't exist appeal with id= " + idAppeal);
                return null;
            }
        }catch (SQLException ex){
            System.out.println("Error gets appeal by id");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean insert(Appeal appeal) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt;

            String mode = String.valueOf(appeal.getMode());

            if(mode == "Presence"){
                stmt = conn.prepareStatement("INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setDate(1, appeal.getDate());
                stmt.setTime(2, appeal.getStartTime());
                stmt.setInt(3, appeal.getRoom());
                stmt.setString(4, appeal.getUniversityComplex());
                stmt.setString(5, appeal.getUniversity());
                stmt.setString(6, appeal.getNote());
                stmt.setString(7, mode);
                stmt.setString(8, appeal.getCourse().getCode());

            }else{
                stmt = conn.prepareStatement("INSERT INTO Appeals (Date, StartTime, Note, Mode, CodeCourse) VALUES(?, ?, ?, ?, ?)");
                stmt.setDate(1, appeal.getDate());
                stmt.setTime(2, appeal.getStartTime());
                stmt.setString(3, appeal.getNote());
                stmt.setString(4, mode);
                stmt.setString(5, appeal.getCourse().getCode());
            }

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert appeal successful");
                return true;
            }else{
                System.out.println("Insert appeal not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error insert appeal");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(Appeal appeal) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Appeals SET Date = ?, StartTime = ?, Room = ?, UniversityComplex = ?,  " +
                    "University = ?, Note = ?, Mode = ?, CodeCourse = ? WHERE Id = ?");
            stmt.setDate(1, appeal.getDate());
            stmt.setTime(2, appeal.getStartTime());
            stmt.setInt(3, appeal.getRoom());
            stmt.setString(4, appeal.getUniversityComplex());
            stmt.setString(5, appeal.getUniversity());
            stmt.setString(6, appeal.getNote());
            stmt.setString(7, String.valueOf(appeal.getMode()));
            stmt.setString(8, appeal.getCourse().getCode());
            stmt.setInt(9, appeal.getId());

            if(stmt.executeUpdate() > 0){
                System.out.println("Update appeal successful");
                return true;
            }else{
                System.out.println("Update appeal not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update appeal");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean delete(Integer idAppeal) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Appeals WHERE Id = ?");
            stmt.setInt(1, idAppeal);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete appeal successful");
                return true;
            }else{
                System.out.println("Delete appeal not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error delete appeal");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }
}
