/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author stepa
 */
import java.sql.*;

public class TestingDB {
    private int id;
    private String name;
    private int age;

    // Konstruktor
    public TestingDB(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Metode untuk menambahkan data ke database
    public void saveToDatabase() {
        Connection connection = null;
        try {
            // Mengatur koneksi ke database (misalnya, MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/nama_database";
            String username = "username";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);

            // Menyiapkan pernyataan SQL
            String sql = "INSERT INTO person (id, name, age) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, age);

                // Menjalankan pernyataan SQL
                statement.executeUpdate();
                System.out.println("Data berhasil disimpan ke database.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi setelah selesai
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Membuat objek Person
        TestingDB person = new TestingDB(1, "John Doe", 25);

        // Menyimpan objek ke database
        person.saveToDatabase();
    }
}

