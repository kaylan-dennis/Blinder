package za.co.wethinkcode.Data;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    public static final String DISK_DB_URL_PREFIX = "jdbc:sqlite:";
    private String dbUrl;
    private Connection connection;

    public DBConnect(String name) {
        dbUrl = DISK_DB_URL_PREFIX + name + ".db";
        System.out.println("Connection url set.");
        openDBFile(name);
        createDBTable();
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void createDBTable() {
        String tableQuery;
        try (Connection connection = DriverManager.getConnection(dbUrl);
             final Statement stmt = connection.createStatement()
        ) {
            tableQuery = new StringBuilder().append("CREATE TABLE IF NOT EXISTS profiles (")
                    .append("id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,")
                    .append("name TEXT NOT NULL,")
                    .append("surname TEXT NOT NULL,")
                    .append("email TEXT UNIQUE NOT NULL,")
                    .append("age TEXT NOT NULL,")
                    .append("gender TEXT NOT NULL,")
                    .append("hash TEXT NOT NULL,")
                    .append("preference TEXT,")
                    .append("bio TEXT,")
                    .append("interests TEXT,")
                    .append("likes TEXT")
                    .append(")")
                    .toString();

            stmt.executeUpdate(tableQuery);

            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("Table already exist");
        }
    }


    private void openDBFile(String name) {
        try {
            boolean dbFile = new File(name).createNewFile();
            if (!dbFile) {
                dbUrl = DISK_DB_URL_PREFIX + name;
                System.out.printf("Database file: \"%s\" already exists.\n", name);
            } else {
                System.out.printf("Database file: \"%s\" not found.\n", name);
                System.out.printf("Database file \"%s\" created.\n", name);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

}