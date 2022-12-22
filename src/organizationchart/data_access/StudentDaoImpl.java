package organizationchart.data_access;

import organizationchart.FacultyMember;
import organizationchart.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    static final String DB_URL = "jdbc:mysql://localhost:3306/oc_schema";
    static final String USER = "root";
    static final String PASS = "test";
    
    @Override
    public List<Student> getAllStudent() {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");
            List<Student> students = new ArrayList<Student>();

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("Freshman"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Topics")
                        );
                students.add(student);
            }
            return students;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student getStudent(Integer freshman) {
        try{
            Student student = null;
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE Freshman=?");
            preparedStatement.setInt(1, freshman);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                student = new Student(resultSet.getInt("Freshman"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Topics")
                );
            }
            return student;
        }catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
    }

    @Override
    public List<FacultyMember> getAdvisors(Integer freshman) {
        return null;
    }

    @Override
    public boolean saveStudent(Student student) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO `Students` (`Freshman`,`Name`, `Surname`, `Topics`) VALUES (?,?, ?, ?)");
            preparedStatement.setInt(1,student.getFreshman());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setString(4, student.getTopics());
            preparedStatement.executeUpdate();
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE `Students` SET `Name` = ?, `Surname` = ?, `Topics` = ? WHERE (`Freshman` = ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getTopics());
            preparedStatement.setInt(4, student.getFreshman());
            preparedStatement.executeUpdate();
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Integer freshman) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM `Students` WHERE (`Freshman` = ?)");
            preparedStatement.setInt(1, freshman);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
}
