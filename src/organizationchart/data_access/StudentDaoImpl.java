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
        List<Student> students = new ArrayList<Student>();
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("topics")
                        );
                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return students;
    }

    @Override
    public Student getStudent(Integer id) {
        Student student = new Student();
        try{
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
        }catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO `students` (`name`, `surname`, `topics`) VALUES (?, ?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getTopics());
            preparedStatement.executeUpdate();

        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }
}
