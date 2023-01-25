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
            ResultSet rs = stmt.executeQuery("SELECT * FROM Professors");

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

                //output only for testing
                System.out.println(p.toString());

            }

            if(professors.isEmpty()){
                System.out.println("Don't exist professors");
                return null;
            }

            return professors;


        }catch (SQLException ex) {
            System.out.println("Error get all professors");
            ex.printStackTrace();
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

                //output only for testing
                System.out.println(p.toString());

                return p;

            }else{
                System.out.println("Doesn't exist professor with freshman= " + integer);
                return null;
            }


        }catch(SQLException ex){
            System.out.println("Error get professor");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean insert(Professor professor) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, professor.getFreshman());
            stmt.setString(2, professor.getName());
            stmt.setString(3, professor.getSurname());
            stmt.setString(4, professor.getSpecialization());
            stmt.setString(5, professor.getUniversity());
            stmt.setString(6, professor.getEmail());
            stmt.setString(7, professor.getPassword());
            stmt.setString(8, professor.getCourse().getCode());

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert professor successful");
                return true;
            }else{
                System.out.println("Insert professor not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error insert professor");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean update(Professor professor) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Professors SET Name = ?, Surname= ?, Specialization= ?, University= ?, Email= ?, Password= ?, CodeCourse= ? WHERE Freshman = ?");
            stmt.setString(1, professor.getName());
            stmt.setString(2, professor.getSurname());
            stmt.setString(3, professor.getSpecialization());
            stmt.setString(4, professor.getUniversity());
            stmt.setString(5, professor.getEmail());
            stmt.setString(6, professor.getPassword());
            stmt.setString(7, professor.getCourse().getCode());
            stmt.setInt(8, professor.getFreshman());

            if(stmt.executeUpdate() > 0){
                System.out.println("Update professor successful");
                return true;
            }else{
                System.out.println("Update professor not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update professor");
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
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Professors WHERE Freshman = ?");
            stmt.setInt(1, integer);

            if(stmt.executeUpdate() > 0){
                System.out.println("Delete professor successful");
                return true;
            }else{
                System.out.println("Delete professor not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error delete professor");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }
}