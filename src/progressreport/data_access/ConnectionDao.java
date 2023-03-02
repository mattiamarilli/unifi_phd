package progressreport.data_access;

import com.mysql.cj.jdbc.Driver;
import thesisapprovation.Thesis;

import java.io.IOException;
import java.sql.*;

public class ConnectionDao {
    private static final String URL = "jdbc:mysql://localhost:3306/pr_schema";
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
}
