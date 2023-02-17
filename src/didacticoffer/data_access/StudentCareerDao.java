package didacticoffer.data_access;

import didacticoffer.AppealParticipation;
import didacticoffer.Course;
import didacticoffer.StudentCareer;
import didacticoffer.StudyPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCareerDao implements GenericDao<StudentCareer, Integer> {

    private Connection conn;

    @Override
    public List<StudentCareer> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudentCareers");

            List<StudentCareer> studentCareers = new ArrayList<StudentCareer>();

            while(rs.next()){
                int freshmanStudent = rs.getInt("StudentFreshman");
                studentCareers.add(new StudentCareer(freshmanStudent));
            }

            return studentCareers;

        }catch (SQLException ex){
            System.out.println("Error get all student careers");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    @Override
    public StudentCareer findByKey(Integer studentFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM StudentCareers WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int freshmanStudent = rs.getInt("StudentFreshman");
                return new StudentCareer(freshmanStudent);
            }else{
                System.out.println("Doesn't exist student career with freshman = " + studentFreshman);
                return null;
            }

        }catch (SQLException ex){
            System.out.println("Error gets student career by freshman");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean insert(StudentCareer studentCareer) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO StudentCareers (StudentFreshman) VALUES (?)");
            stmt.setInt(1, studentCareer.getFreshmanStudent());

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert student career successful");
                return true;
            }else{
                System.out.println("Insert student career not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error insert student career");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(StudentCareer studentCareer) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(Integer studentFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE * FROM StudentCareers WHERE StudentFreshman = ?");
            stmt.setInt(1, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete student career successful");
                return true;
            }else{
                System.out.println("Delete student career not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error delete student career");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean insertStudyPlan(StudyPlan studyPlan) throws  SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, studyPlan.getStudentCareer().getFreshmanStudent());
            stmt.setString(2, studyPlan.getCourse().getCode());
            stmt.setString(3, String.valueOf(studyPlan.getState()));
            stmt.setDate(4, studyPlan.getRegistrationDate());

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert study plan successful");
                return true;
            }else{
                System.out.println("Insert study plan not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error insert study plan");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean deleteStudyPlan(Integer studentFreshman, String courseCode) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM StudyPlans \n" +
                    "WHERE StudentFreshman = ? AND CodeCourse = ?");
            stmt.setInt(1, studentFreshman);
            stmt.setString(2, courseCode);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete study plan successful");
                return true;
            }else{
                System.out.println("Delete study plan not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error delete study plan");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }


    public Boolean insertAppealParticipation(AppealParticipation appealParticipation) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AppealParticipation (StudentFreshman, IdAppeal) VALUES (?, ?)");
            stmt.setInt(1, appealParticipation.getStudentCareer().getFreshmanStudent());
            stmt.setInt(2, appealParticipation.getAppeal().getId());

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert appeal participation successful");
                return true;
            }else{
                System.out.println("Insert appeal participation not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error appeal participation");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean deleteAppealParticipationByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM AppealParticipation \n" +
                    "WHERE IdAppeal = ? AND StudentFreshman = ?");
            stmt.setInt(1, idAppeal);
            stmt.setInt(2, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete appeal participation by student successful");
                return true;
            }else{
                System.out.println("Delete appeal participation by student not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error delete appeal participation by student");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public List<Course> getCoursesByStudentFreshman(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Courses.Code, Courses.Title, Courses.Description, Courses.CFU, Courses.Year FROM StudentCareers\n" +
                    "INNER JOIN StudyPlans ON StudentCareers.Studentfreshman = StudyPlans.Studentfreshman\n" +
                    "INNER JOIN Courses ON Courses.Code = StudyPlans.CodeCourse\n" +
                    "WHERE StudentCareers.Studentfreshman = ?");
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

            return courses;

        }catch (SQLException ex){
            System.out.println("Error get courses by student freshman");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Course> getCoursesAccreditedByStudentFreshman(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Courses.Code, Courses.Title, Courses.Description, Courses.CFU, Courses.Year FROM StudentCareers\n" +
                    "INNER JOIN StudyPlans ON StudentCareers.Studentfreshman = StudyPlans.Studentfreshman\n" +
                    "INNER JOIN Courses ON Courses.Code = StudyPlans.CodeCourse\n" +
                    "WHERE StudentCareers.StudentFreshman = ? AND StudyPlans.State = 'Accredited'");
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

            return courses;

        }catch(SQLException ex){
            System.out.println("Error get courses accredited by student freshman");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    //TODO: finire
    public List<AppealParticipation> getAppealParticipation(Integer studentFreshman) throws SQLException{
        return null;
    }

}
