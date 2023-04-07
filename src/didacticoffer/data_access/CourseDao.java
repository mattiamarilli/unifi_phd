package didacticoffer.data_access;

import didacticoffer.Course;

import java.awt.desktop.SystemEventListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements GenericDao<Course, String>{

    private Connection conn;
    @Override
    public List<Course> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Courses");

            List<Course> courses = new ArrayList<Course>();

            while(rs.next()){
                String code = rs.getString("Code");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(code, title, description, cfu, year);

                courses.add(c);
            }

            if(courses.isEmpty())
                return null;

            return courses;
        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }


    //key = code
    @Override
    public Course findByKey(String s) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Courses WHERE Code = ?");
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String code = rs.getString("Code");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(code, title, description, cfu, year);

                return c;

            }else
                return null;

        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean insert(Course course) throws SQLException {
        try{

            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getTitle());
            stmt.setString(3, course.getDescription());
            stmt.setInt(4, course.getCfu());
            stmt.setInt(5, course.getYear());

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
    public Boolean update(Course course) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Courses SET Title= ?, Description= ?, CFU= ?, Year= ? WHERE Code= ?");
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getDescription());
            stmt.setInt(3, course.getCfu());
            stmt.setInt(4, course.getYear());
            stmt.setString(5, course.getCode());

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
    public Boolean delete(String s) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Courses WHERE Code = ?");
            stmt.setString(1, s);

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

    public Boolean updateStateStudyPlan(String courseCode, String state) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE StudyPlans SET State = ? WHERE CodeCourse = ?");
            stmt.setString(1, state);
            stmt.setString(2, courseCode);


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

    public List<Course> getCoursesNotRegisteredByStudent(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * \n" +
                    "FROM Courses\n" +
                    "WHERE Code NOT IN (\n" +
                    "SELECT CodeCourse\n" +
                    "FROM StudyPlans \n" +
                    "WHERE StudentFreshman = ?)");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Course> courses = new ArrayList<Course>();

            while(rs.next()){
                String code = rs.getString("Code");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(code, title, description, cfu, year);

                courses.add(c);
            }

            if(courses.isEmpty())
                return null;

            return courses;


        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

}
