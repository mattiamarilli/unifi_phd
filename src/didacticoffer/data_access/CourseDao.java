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

            if(courses.isEmpty()) {
                System.out.println("Don't exist courses");
                return null;
            }

            return courses;


        }catch(SQLException ex){
            System.out.println("Error get all courses");
            ex.printStackTrace();
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

            }else{
                System.out.println("Doesn't exist course with code= " + s);
                return null;
            }


        }catch (SQLException ex){
            System.out.println("Error get course by id");
            ex.printStackTrace();
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

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert course successful");
                return true;
            }else{
                System.out.println("Insert course not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error insert course");
            ex.printStackTrace();
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

            if(stmt.executeUpdate() > 0){
                System.out.println("Update course successful");
                return true;
            }else{
                System.out.println("Update course not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update course");
            ex.printStackTrace();
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

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete course successful");
                return true;
            }else{
                System.out.println("Delete course not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error delete course");
            ex.printStackTrace();
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


            if(stmt.executeUpdate() > 0){
                System.out.println("Update state study plan successful");
                return true;
            }else{
                System.out.println("Update state study plan not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update state study plane");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

}
