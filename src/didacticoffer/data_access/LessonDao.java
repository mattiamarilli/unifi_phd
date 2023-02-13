package didacticoffer.data_access;

import didacticoffer.Course;
import didacticoffer.Lesson;

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
                String mode = rs.getString("Mode");
                String code = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course course = new Course(code, title, description, cfu, year);
                if(mode == "Presence") {
                    int room = rs.getInt("Room");
                    String universityComplex = rs.getString("UniversityComplex");
                    String university = rs.getString("University");

                    lessons.add(new Lesson(id, date, startTime, endTime, room, universityComplex, university, mode, course));

                }else{
                    lessons.add(new Lesson(id, date, startTime, endTime, mode, course));
                }
            }

            return lessons;

        }catch(SQLException ex){
            System.out.println("Error get all lessons");
            ex.printStackTrace();
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
                String mode = rs.getString("Mode");
                String code = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course course = new Course(code, title, description, cfu, year);
                if(mode == "Presence") {
                    int room = rs.getInt("Room");
                    String universityComplex = rs.getString("UniversityComplex");
                    String university = rs.getString("University");

                    return new Lesson(idLesson, date, startTime, endTime, room, universityComplex, university, mode, course);

                }else{
                    return new Lesson(idLesson, date, startTime, endTime, mode, course);
                }
            }else{
                System.out.println("Doesn't exist lesson with id =" + idLesson);
                return null;
            }


        }catch (SQLException ex){
            System.out.println("Error gets lesson by id");
            ex.printStackTrace();
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
            if(String.valueOf(lesson.getMode()) == "Presence") {
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

            if(stmt.executeUpdate() > 0) {
                System.out.println("Insert lesson successful");
                return true;
            }else{
                System.out.println("Insert lesson not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error insert lesson");
            ex.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }

    //TODO: finire
    @Override
    public Boolean update(Lesson lesson) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(Integer idLesson) throws SQLException {
        return null;
    }
}
