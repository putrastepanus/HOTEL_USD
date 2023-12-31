/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Konek.db;

/**
 *
 * @author stepa
 */
public class Receptionis {

    private static List<Receptionis> RepceptionisList = new ArrayList<>();
    private int Repceptionis_ID;
    private String nama;
    private String email;
    private String no_telp;
    private String alamat;

    public Receptionis(int Repceptionis_ID, String nama, String email, String noTelp, String alamat) {
        this.Repceptionis_ID = Repceptionis_ID;
        this.nama = nama;
        this.email = email;
        this.no_telp = noTelp;
        this.alamat = alamat;
    }

    public Receptionis() {

    }

//    public static List<Receptionis> getRepceptionisList() {
//        return RepceptionisList;
//    }
    public int getRepceptionis_ID() {
        return Repceptionis_ID;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNoTelp() {
        return no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    private static void addUserToDatabase(Receptionis Repceptionis) {
        RepceptionisList.add(Repceptionis);
    }

    public static List<Receptionis> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM receptionis");
            while (rs.next()) {
                int repceptionis_ID = rs.getInt("RECEPTIONIS_ID"); // Ganti dengan nama kolom yang sesuai
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String noTelp = rs.getString("no_telp"); // Ganti dengan nama kolom yang sesuai
                String alamat = rs.getString("alamat");
                RepceptionisList.add(new Receptionis(repceptionis_ID, nama, email, noTelp, alamat));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return RepceptionisList;
    }

    public void tambahReceptionis(String nama, String email, String no_telp, String alamat) {
        db konek = new db();
        Connection connection = konek.getConnect();
        PreparedStatement ps = null;

        try {
            // Menggunakan PreparedStatement untuk memasukkan parameter
            String insertQuery = "INSERT INTO RECEPTIONIS (nama, email, no_telp, alamat) VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(insertQuery);

            // Set nilai parameter
            ps.setString(1, nama);
            ps.setString(2, email);
            ps.setString(3, no_telp);
            ps.setString(4, alamat);

            // Eksekusi insert
            int rowsInserted = ps.executeUpdate();

            // Menampilkan jumlah baris yang berhasil diinsert
            System.out.println("Jumlah baris yang berhasil diinsert: " + rowsInserted);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
