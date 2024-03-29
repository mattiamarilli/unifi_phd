package didacticoffer.data_access;

import didacticoffer.Course;
import didacticoffer.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements GenericDao <Professor, Integer> {

    private Connection conn;

    @Override
    public List<Professor> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Professors LEFT JOIN Courses ON Professors.CodeCourse = Courses.Code;");

            List<Professor> professors = new ArrayList<Professor>();

            while(rs.next()){
                int freshman = rs.getInt("Freshman");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String specialization = rs.getString("Specialization");
                String university = rs.getString("University");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String codeCourse = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(codeCourse, title, description, cfu, year);
                Professor p = new Professor(freshman, name, surname, specialization, university, email, password, c);

                professors.add(p);

            }

            if(professors.isEmpty())
                return null;

            return professors;


        }catch (SQLException ex) {
            return null;
        }finally {
            conn.close();
        }
    }


    //key = freshman
    @Override
    public Professor findByKey(Integer integer) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Professors INNER JOIN Courses ON CodeCourse = Code WHERE freshman = ?");
            stmt.setInt(1, integer);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int freshman = rs.getInt("Freshman");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String specialization = rs.getString("Specialization");
                String university = rs.getString("University");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String codeCourse = rs.getString("CodeCourse");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                int cfu = rs.getInt("CFU");
                int year = rs.getInt("Year");

                Course c = new Course(codeCourse, title, description, cfu, year);
                Professor p = new Professor(freshman, name, surname, specialization, university, email, password, c);

                return p;
            }else
                return null;


        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean insert(Professor professor) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, professor.getFreshman());
            stmt.setString(2, professor.getName());
            stmt.setString(3, professor.getSurname());
            stmt.setString(4, professor.getSpecialization());
            stmt.setString(5, professor.getUniversity());
            stmt.setString(6, professor.getEmail());
            stmt.setString(7, professor.getPassword());

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

    @Override
    public Boolean update(Professor professor) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Professors SET Name = ?, Surname = ?, Specialization = ?, University = ?, Email= ? WHERE Freshman = ?");
            stmt.setString(1, professor.getName());
            stmt.setString(2, professor.getSurname());
            stmt.setString(3, professor.getSpecialization());
            stmt.setString(4, professor.getUniversity());
            stmt.setString(5, professor.getEmail());
            stmt.setInt(6, professor.getFreshman());

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
    public Boolean delete(Integer integer) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Professors WHERE Freshman = ?");
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

    public Boolean updatePasswordProfessor(Integer freshman, String password) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Professors SET Password = ? WHERE Freshman = ?");
            stmt.setString(1, password);
            stmt.setInt(2, freshman);

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

    public Boolean updateCodeCourseProfessor(Integer professorFreshman, String codeCourse) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Professors SET CodeCourse = ? WHERE Freshman = ?");
            stmt.setString(1, codeCourse);
            stmt.setInt(2, professorFreshman);

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


    public List<Integer> getStudentFreshmenByProfessor(Integer professorFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT StudentCareers.Studentfreshman FROM Professors\n" +
                    "INNER JOIN Courses ON Professors.CodeCourse = Code\n" +
                    "INNER JOIN StudyPlans ON StudyPlans.CodeCourse = Courses.Code\n" +
                    "INNER JOIN StudentCareers ON StudentCareers.StudentFreshman = StudyPlans.StudentFreshman\n" +
                    "WHERE Professors.Freshman = ?");
            stmt.setInt(1, professorFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Integer> studentFreshmen = new ArrayList<Integer>();

            while(rs.next()){
                studentFreshmen.add(rs.getInt("StudentFreshman"));
            }

            return studentFreshmen;

        }catch (SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Professor> getProfessorsWithoutCourse() throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Professors \n" +
                    "WHERE CodeCourse is NULL");

            List<Professor> professors = new ArrayList<Professor>();

            while(rs.next()){
                int freshman = rs.getInt("Freshman");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String specialization = rs.getString("Specialization");
                String university = rs.getString("University");
                String email = rs.getString("Email");

                professors.add(new Professor(freshman, name, surname, specialization, university, email));
            }

            return professors;

        }catch(SQLException ex){
            return null;
        }finally {
            conn.close();
        }
    }


}
