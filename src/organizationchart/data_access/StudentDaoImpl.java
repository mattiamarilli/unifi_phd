package organizationchart.data_access;

import organizationchart.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    String jdbc_connector = "jdbc:mysql://localhost:3306/unifi_phd";
    String user = "root";
    String password = "test";



    @Override
    public List<Student> getAllFacultyMember() {
        try{
            Connection connection = DriverManager.getConnection(this.jdbc_connector,this.user,this.password);
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
    public Student getFacultyMember(int id) {
        return null;
    }

    @Override
    public void updateCycle(Student facultyMember) {

    }

    @Override
    public void deleteStudent(Student facultyMember) {

    }
}
