import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    private String url = "jdbc:mysql://localhost:3306/hotel_usd";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public db(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    void connectDb() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to XAMPP database successful!");
        } catch (SQLException e) {
            System.out.println("Connection to XAMPP database failed!");
            e.printStackTrace();
        }
    }

    void disconnectDb() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}