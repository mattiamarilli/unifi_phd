package organizationchart.data_access;

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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            List<Student> students = new ArrayList<Student>();

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("topics")
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
    public Student getStudent(Integer id) {
        try{
            Student student = null;
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("topics")
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
    public boolean saveStudent(Student student) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO `students` (`id`,`name`, `surname`, `topics`) VALUES (?,?, ?, ?)");
            preparedStatement.setInt(1,student.getId());
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
                    "UPDATE `students` SET `name` = ?, `surname` = ?, `topics` = ? WHERE (`id` = ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getTopics());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Integer id) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM `students` WHERE (`id` = ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
}
