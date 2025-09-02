package db;

import java.sql.*;

public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


}
