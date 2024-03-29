package didacticoffer.data_access;

import didacticoffer.Course;
import didacticoffer.Lesson;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao implements GenericDao<Lesson, Integer>{

    private Connection conn;

    @Override
    public List<Lesson> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Lessons INNER JOIN Courses ON CodeCourse = Code");

            List<Lesson> lessons = new ArrayList<Lesson>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                Time endTime = rs.getTime("EndTime");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String code = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course course = new Course(code, title, description, cfu, year);

                lessons.add(new Lesson(id, date, startTime, endTime, room, universityComplex, university, mode, course));
            }

            return lessons;

        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Lesson findByKey(Integer idLesson) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Lessons INNER JOIN Courses ON CodeCourse = Code WHERE Lessons.Id = ?");
            stmt.setInt(1, idLesson);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                Time endTime = rs.getTime("EndTime");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String code = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course course = new Course(code, title, description, cfu, year);

                return new Lesson(idLesson, date, startTime, endTime, room, universityComplex, university, mode, course);
            }else
                return null;


        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean insert(Lesson lesson) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt;

            if(String.valueOf(lesson.getMode()).equals("Presence")){
                stmt = conn.prepareStatement("INSERT INTO Lessons(Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setDate(1, lesson.getDate());
                stmt.setTime(2, lesson.getStartTime());
                stmt.setTime(3, lesson.getEndTime());
                stmt.setInt(4, lesson.getRoom());
                stmt.setString(5, lesson.getUniversityComplex());
                stmt.setString(6, lesson.getUniversity());
                stmt.setString(7, String.valueOf(lesson.getMode()));
                stmt.setString(8, lesson.getCourse().getCode());
            }else{
                stmt = conn.prepareStatement("INSERT INTO Lessons(Date, StartTime, EndTime, Mode, CodeCourse) VALUES(?, ?, ?, ?, ?)");
                stmt.setDate(1, lesson.getDate());
                stmt.setTime(2, lesson.getStartTime());
                stmt.setTime(3, lesson.getEndTime());
                stmt.setString(4, String.valueOf(lesson.getMode()));
                stmt.setString(5, lesson.getCourse().getCode());
            }

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
    public Boolean update(Lesson lesson) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Lessons SET Date = ?, StartTime = ?, EndTime = ?, Room = ?, UniversityComplex = ?, University = ?, Mode = ?, CodeCourse = ? WHERE Id = ?");
            stmt.setDate(1, lesson.getDate());
            stmt.setTime(2, lesson.getStartTime());
            stmt.setTime(3, lesson.getEndTime());
            stmt.setInt(4, lesson.getRoom());
            stmt.setString(5, lesson.getUniversityComplex());
            stmt.setString(6, lesson.getUniversity());
            stmt.setString(7, String.valueOf(lesson.getMode()));
            stmt.setString(8, lesson.getCourse().getCode());
            stmt.setInt(9, lesson.getId());

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch(SQLException ex) {
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean delete(Integer idLesson) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Lessons WHERE Id = ?");
            stmt.setInt(1, idLesson);

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

    public List<Lesson> getLessonsByCourseCode(String courseCode) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT *\n" +
                    "FROM Lessons\n" +
                    "INNER JOIN Courses ON CodeCourse = Code\n" +
                    "WHERE CodeCourse = ?");
            stmt.setString(1, courseCode);
            ResultSet rs = stmt.executeQuery();

            List<Lesson> lessons = new ArrayList<Lesson>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                Time endTime = rs.getTime("EndTime");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String code = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course course = new Course(code, title, description, cfu, year);

                lessons.add(new Lesson(id, date, startTime, endTime, room, universityComplex, university, mode, course));
            }

            return lessons;

        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

}
