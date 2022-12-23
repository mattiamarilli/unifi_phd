package organizationchart.data_access;

import organizationchart.FacultyMember;
import organizationchart.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private Connection connection;
    
    @Override
    public List<Student> getAllStudent() throws SQLException{
        try{
            connection = ConnectionDao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");

            List<Student> students = new ArrayList<Student>();

            while (resultSet.next()) {
                Integer freshman = resultSet.getInt("Freshman");
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String topics = resultSet.getString("Topics");

                Student s = new Student(freshman,name,surname,email,password,topics);

                students.add(s);
            }
            return students;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public Student getStudentByFreshman(Integer freshman) throws SQLException{
        try{
            Connection connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE Freshman=?");
            preparedStatement.setInt(1, freshman);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String topics = resultSet.getString("Topics");
                Student s = new Student(freshman,name,surname,email,password,topics);

                return s;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public List<FacultyMember> getAdvisors(Integer freshman) {
        return null;
    }

    @Override
    public boolean insertStudent(Student student) throws SQLException{
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO `Students` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Topics`) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1,student.getFreshman());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getPassword());
            preparedStatement.setString(6, student.getTopics());

            if(preparedStatement.executeUpdate() > 0)
                return true;
            else
               return false;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            connection.close();
        }
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException{
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE `Students` SET `Name` = ?, `Surname` = ?,`Email`=?,`Password`=?, `Topics` = ? WHERE (`Freshman` = ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getTopics());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getPassword());
            preparedStatement.setInt(6, student.getFreshman());

            if(preparedStatement.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            connection.close();
        }
    }

    @Override
    public boolean deleteStudent(Integer freshman) throws SQLException {
        try{

            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM `Students` WHERE (`Freshman` = ?)");
            preparedStatement.setInt(1, freshman);
            if(preparedStatement.executeUpdate() > 0)
                return true;
            else
                return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            connection.close();
        }

    }
}
