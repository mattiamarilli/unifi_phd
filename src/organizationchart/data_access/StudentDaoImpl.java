package organizationchart.data_access;

import organizationchart.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

        }catch (Exception e){ e.printStackTrace();}


        return students;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }
}
