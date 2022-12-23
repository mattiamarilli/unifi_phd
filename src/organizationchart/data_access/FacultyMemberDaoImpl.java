package organizationchart.data_access;

import organizationchart.FacultyMember;
import organizationchart.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyMemberDaoImpl implements FacultyMemberDao {

    private Connection connection;
    @Override
    public List<FacultyMember> getAllFacultyMember() throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Facultymembers");

            List<FacultyMember> facultymembers = new ArrayList<FacultyMember>();

            while (resultSet.next()) {
                Integer freshman = resultSet.getInt("Freshman");
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String specialization = resultSet.getString("Specialization");
                String institution = resultSet.getString("Institution");

                FacultyMember f = new FacultyMember(freshman,name,surname,email,password,specialization,institution);

                facultymembers.add(f);
            }
            return facultymembers;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public FacultyMember getFacultyMember(int freshman) throws SQLException {
        try{
            Connection connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Facultymembers WHERE Freshman=?");
            preparedStatement.setInt(1, freshman);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String specialization = resultSet.getString("Specialization");
                String institution = resultSet.getString("Institution");
                FacultyMember f = new FacultyMember(freshman,name,surname,email,password,specialization,institution);

                return f;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public Boolean insertFacultyMember(FacultyMember facultyMember) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO `Facultymembers` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Specialization`, `Institution`) VALUES (?,?,?,?,?,?,?);");
            preparedStatement.setInt(1,facultyMember.getFreshman());
            preparedStatement.setString(2, facultyMember.getName());
            preparedStatement.setString(3, facultyMember.getSurname());
            preparedStatement.setString(4, facultyMember.getEmail());
            preparedStatement.setString(5, facultyMember.getPassword());
            preparedStatement.setString(6, facultyMember.getSpecialization());
            preparedStatement.setString(7,facultyMember.getInstitution());

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
    public Boolean updateFacultyMember(FacultyMember facultyMember) throws SQLException {
        return false;

    }

    @Override
    public Boolean deleteFacultyMember(FacultyMember facultyMember) throws SQLException {
        return false;
    }
}
