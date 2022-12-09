package organizationchart.data_access;

import organizationchart.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    static final String DB_URL = "jdbc:mysql://localhost:3306/unifi_phd";
    static final String USER = "root";
    static final String PASS = "test";




    @Override
    public List<Student> getAllStudent() {
        try{
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                // Retrieve by column name
                System.out.print("name:" + resultSet.getString("name"));

            }

        }catch (Exception e){ e.printStackTrace();}


        return null;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }
}
