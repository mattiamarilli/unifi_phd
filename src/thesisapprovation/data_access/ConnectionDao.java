package thesisapprovation.data_access;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class ConnectionDao {

    private static final String URL = "jdbc:mysql://localhost:3306/ta_schema";
    public static final String USER = "root";
    public static final String PASS = "test";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        //main test for connection and queries

        ReviewDaoImpl prova = new ReviewDaoImpl();
        prova.getReviewById(1);

        Connection connection = ConnectionDao.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Thesis");

        while(rs.next())
        {
            System.out.println(rs.getString("Title")+ "\n");

        }


    }
}
