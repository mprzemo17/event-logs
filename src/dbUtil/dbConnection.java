package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
   // private static final String CONNECTION = "jdbc:mysql://localhost/eventlogsdb";
    private static final String SQLITECONNECTION = "jdbc:sqlite:eventlogsdb.sqlite";


    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQLITECONNECTION);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
