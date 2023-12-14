
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

    public static Connection connect() {
        Connection connection = null;
        try {
            // Load driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Informasi koneksi ke database
            String url = "jdbc:mysql://localhost:3306/hotel_usd";
            String username = "root";
            String password = "";

            // Membuat koneksi
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Koneksi ke database berhasil.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Membuat koneksi
        Connection connection = connect();

        // Menutup koneksi setelah selesai
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Koneksi ditutup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
