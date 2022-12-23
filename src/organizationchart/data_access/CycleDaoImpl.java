package organizationchart.data_access;

import organizationchart.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CycleDaoImpl implements CycleDao {

    private Connection connection;
    @Override
    public List<Cycle> getAllCycle() throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `Cycles`");

            List<Cycle> cycles = new ArrayList<Cycle>();

            while (resultSet.next()) {
                Integer number = resultSet.getInt("Number");
                String year = resultSet.getString("Year");
                String description = resultSet.getString("Description");

                Cycle c = new Cycle(number,year,description);
                cycles.add(c);
            }
            return cycles;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public Cycle getCycle(Integer number) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Cycles` WHERE `Number`=?");
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                String year = resultSet.getString("Year");
                String description = resultSet.getString("Description");

                Cycle c = new Cycle(number,year,description);

                return c;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public Boolean insertCycle(Cycle cycle) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO `Cycles` (`Number`, `Year`, `Description`) VALUES (?,?, ?)");
            preparedStatement.setInt(1,cycle.getNumber());
            preparedStatement.setString(2, cycle.getYear());
            preparedStatement.setString(3, cycle.getDescription());

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
    public Boolean updateCycle(Cycle cycle) throws SQLException{
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE `Cycles` SET `Year` = ?, `Description` = ? WHERE (`Number` = ?)");
            preparedStatement.setString(1, cycle.getYear());
            preparedStatement.setString(2, cycle.getDescription());
            preparedStatement.setInt(3, cycle.getNumber());

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
    public Boolean deleteCycle(Integer number) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM `Cycles` WHERE (`Number` = ?)");
            preparedStatement.setInt(1, number);
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

