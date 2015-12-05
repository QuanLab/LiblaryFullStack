package server.connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/liblary";
    static final String USER = "root";
    static final String PASS = "admin123";
    
    public static Connection conn = null;
    
    public DBConnection() {
        
    }

    public static boolean connectDB() {
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: canot connect to database!");
        }
        return false;
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error when trying to close connection!");
        }
    }
}
