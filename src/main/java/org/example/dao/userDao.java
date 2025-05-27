package org.example.dao;
import org.example.config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class userDao {
    Connection connection = DBConnection.getConnection();

    public void createUserTable() {
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            statement.executeUpdate("""
                        CREATE TABLE IF NOT EXISTS users(
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50),
                            password VARCHAR(50)
                        );
                    """);
            statement.close();
            System.out.println("Table created");
        } catch (SQLException e) {
            throw new RuntimeException("error bro " + e);
        }
    }

    public void saveUser(String userName, String password) {
        try (PreparedStatement statement = connection.prepareStatement("""
                Insert into users(name, password) VALUES (?,?)
                """)) {
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("User saved");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser (Long id){
        try(PreparedStatement statement = connection.prepareStatement("""
            DELETE FROM users WHERE id = ?;
        """)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("user deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

