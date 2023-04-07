package organizationchart.data_access;

import organizationchart.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CycleDao implements GenericDao<Cycle, String> {

    private Connection connection;
    @Override
    public List<Cycle> getAll() throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Cycles");

            List<Cycle> cycles = new ArrayList<Cycle>();

            while (resultSet.next()) {
                String number = resultSet.getString("Number");
                Integer year = resultSet.getInt("Year");
                String description = resultSet.getString("Description");

                Cycle c = new Cycle(number, year, description);
                cycles.add(c);
            }
            return cycles;

        }catch (SQLException e){
            return null;
        }finally {
            connection.close();
        }
    }

    @Override
    public Cycle findByKey(String number) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Cycles WHERE Number = ?");
            stmt.setString(1, number);
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()) {
                Integer year = resultSet.getInt("Year");
                String description = resultSet.getString("Description");

                Cycle c = new Cycle(number, year, description);

                return c;
            }else
                return null;

        }catch (SQLException e){
            return null;
        }finally {
            connection.close();
        }

    }

    @Override
    public Boolean insert(Cycle cycle) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO Cycles (Number, Year, Description) VALUES (?, ?, ?)");
            stmt.setString(1, cycle.getNumber());
            stmt.setInt(2, cycle.getYear());
            stmt.setString(3, cycle.getDescription());

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;


        }catch (SQLException e){
            return false;
        }finally {
            connection.close();
        }
    }

    @Override
    public Boolean update(Cycle cycle) throws SQLException{
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE Cycles SET Year = ?, Description = ? WHERE Number = ?");
            stmt.setInt(1, cycle.getYear());
            stmt.setString(2, cycle.getDescription());
            stmt.setString(3, cycle.getNumber());

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;


        }catch (SQLException e){
            return false;
        }finally {
            connection.close();
        }
    }

    @Override
    public Boolean delete(String number) throws SQLException {
        try{
            connection = ConnectionDao.getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Cycles WHERE Number = ?");
            stmt.setString(1, number);

            if(stmt.executeUpdate() > 0)
                return true;
            else
                return false;

        }catch (SQLException e){
            return false;
        }finally {
            connection.close();
        }
    }
}

