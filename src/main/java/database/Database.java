package database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.SQLException;
import java.sql.Connection;

public class Database {

    public static Connection getConnection() {
        Connection connection = null;

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/library");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");

        try {
            connection = mysqlDataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Database is not established: " + e);
        }
        return connection;
    }

    public static void CloseConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection isn't closed: " + e);
        }
    }
}
