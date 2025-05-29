package org.example.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String user = "postgres";
    private static final String password = "busubaha";

    public static Connection getConnection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection (url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
