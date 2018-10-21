package ua.training.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
    private static Connection connection;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/NotebookDb";
    private static  final String USER_NAME = "root";
    private static final String PASSWORD = "15935755zc";
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {

            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            } catch (ClassNotFoundException  | SQLException e) {
               e.printStackTrace();
               System.out.println("Connection error");
            }


        }
        return connection;
    }
}

