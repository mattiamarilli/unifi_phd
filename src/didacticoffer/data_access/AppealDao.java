package didacticoffer.data_access;

import didacticoffer.Appeal;
import didacticoffer.AppealParticipation;
import didacticoffer.Course;
import didacticoffer.StudentCareer;

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
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String codeCourse = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(codeCourse, title, description, cfu, year);

                appeals.add(new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c));
            }

            return appeals;

        }catch(SQLException ex){
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
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String codeCourse = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(codeCourse, title, description, cfu, year);

                return new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
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

            if(mode.equals("Presence")){
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
    public Boolean delete(Integer idAppeal) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Appeals WHERE Id = ?");
            stmt.setInt(1, idAppeal);

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

    public Boolean updateStateStudentStudyPlan(Integer studentFreshman, String courseCode, String state) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE StudyPlans SET State = ? WHERE StudentFreshman = ? AND CodeCourse = ?");
            stmt.setString(1, state);
            stmt.setInt(2, studentFreshman);
            stmt.setString(3, courseCode);

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

    public List<Appeal> getAppealsByCourseCode(String courseCode) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Id, Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse, Title, Description, CFU, Year \n" +
                    "FROM Appeals\n" +
                    "INNER JOIN Courses ON CodeCourse = Code\n" +
                    "WHERE CodeCourse = ?");
            stmt.setString(1, courseCode);
            ResultSet rs = stmt.executeQuery();

            List<Appeal> appeals = new ArrayList<Appeal>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                String note = rs.getString("Note");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(courseCode, title, description, cfu, year);
                Appeal a = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
                appeals.add(a);
            }

            return appeals;

        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public Boolean insertVote(Integer studentFreshman, Integer idAppeal, String vote) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE AppealParticipation SET Vote = ? WHERE StudentFreshman = ? AND IdAppeal = ?");
            stmt.setString(1, vote);
            stmt.setInt(2, studentFreshman);
            stmt.setInt(3, idAppeal);

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

    public List<AppealParticipation> getAppealParticipationWithoutVoteByCourseCode(String courseCode) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT StudentFreshman, IdAppeal, Vote\n" +
                    "FROM AppealParticipation\n" +
                    "INNER JOIN Appeals ON IdAppeal = Id\n" +
                    "WHERE CodeCourse = ? AND Vote IS NULL \n");
            stmt.setString(1, courseCode);
            ResultSet rs = stmt.executeQuery();

            List<AppealParticipation> appealParticipations = new ArrayList<AppealParticipation>();

            while(rs.next()){
                StudentCareer sc = new StudentCareer(rs.getInt("StudentFreshman"));
                Appeal a = new Appeal(rs.getInt("IdAppeal"));
                appealParticipations.add(new AppealParticipation(sc, a));
            }

            return appealParticipations;

        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Appeal> getAppealsByStudentFreshman(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT *\n" +
                    "FROM StudyPlans\n" +
                    "INNER JOIN Courses ON Courses.Code = StudyPlans.CodeCourse\n" +
                    "INNER JOIN Appeals ON Appeals.CodeCourse = Courses.Code\n" +
                    "WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Appeal> appeals = new ArrayList<Appeal>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                String note = rs.getString("Note");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");
                String courseCode = rs.getString("CodeCourse");

                Course c = new Course(courseCode, title, description, cfu, year);
                Appeal a = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
                appeals.add(a);
            }

            return appeals;
        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Appeal> getAppealsToAccept(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT IdAppeal, Date, StartTime, Room, UniversityComplex, University, Note, Mode, Code, Title, Description, CFU, Year\n" +
                    "FROM StudyPlans\n" +
                    "INNER JOIN AppealParticipation ON AppealParticipation.StudentFreshman = StudyPlans.StudentFreshman\n" +
                    "INNER JOIN Appeals ON IdAppeal = Id\n" +
                    "INNER JOIN Courses ON Appeals.CodeCourse = Code\n" +
                    "WHERE State = \"Attended\" AND Vote is NOT NULL AND Vote >= 18 AND StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Appeal> appeals = new ArrayList<Appeal>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                String note = rs.getString("Note");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");
                String courseCode = rs.getString("Code");

                Course c = new Course(courseCode, title, description, cfu, year);
                Appeal a = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
                appeals.add(a);
            }

            return appeals;

        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Appeal> getAppealsToRegister(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Id, Date, StartTime, Room, UniversityComplex, University, Note, Mode, Code, Title, Description, CFU, Year\n" +
                    "FROM StudyPlans\n" +
                    "INNER JOIN Courses ON StudyPlans.CodeCourse = Code\n" +
                    "INNER JOIN Appeals ON Appeals.CodeCourse = Code\n" +
                    "WHERE State = \"Attended\" AND StudyPlans.StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Appeal> appeals = new ArrayList<Appeal>();

            while(rs.next()){
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");
                Time startTime = rs.getTime("StartTime");
                String note = rs.getString("Note");
                int room = rs.getInt("Room");
                String universityComplex = rs.getString("UniversityComplex");
                String university = rs.getString("University");
                String mode = rs.getString("Mode");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");
                String courseCode = rs.getString("Code");

                Course c = new Course(courseCode, title, description, cfu, year);
                Appeal a = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
                appeals.add(a);
            }

            return appeals;

        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }


}


