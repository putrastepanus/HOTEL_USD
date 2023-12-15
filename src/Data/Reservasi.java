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
import java.util.ArrayList;
import java.util.List;
import Konek.db;

public class Reservasi {

    private static List<Reservasi> reservasiList = new ArrayList<>();
    private String RESERVASI_ID;
    private String TANGGAL_RESERVASI;
    private String TANGGAL_CHECK_IN;
    private String TANGGAL_CHECK_OUT;

    public Reservasi(String RESERVASI_ID, String TANGGAL_RESERVASI, String TANGGAL_CHECK_IN, String TANGGAL_CHECK_OUT) {
        this.RESERVASI_ID = RESERVASI_ID;
        this.TANGGAL_RESERVASI = TANGGAL_RESERVASI;
        this.TANGGAL_CHECK_IN = TANGGAL_CHECK_IN;
        this.TANGGAL_CHECK_OUT = TANGGAL_CHECK_OUT;
    }

    public Reservasi() {
    }

    public static List<Reservasi> getReservasiList() {
        return reservasiList;
    }

    public String getRESERVASI_ID() {
        return RESERVASI_ID;
    }

    public String getTANGGAL_RESERVASI() {
        return TANGGAL_RESERVASI;
    }

    public String getTANGGAL_CHECK_IN() {
        return TANGGAL_CHECK_IN;
    }

    public String getTANGGAL_CHECK_OUT() {
        return TANGGAL_CHECK_OUT;
    }

    public static List<Reservasi> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM RESERVASI");
            while (rs.next()) {
                String RESERVASI_ID = rs.getString("RESERVASI_ID");
                String TANGGAL_RESERVASI = rs.getString("TANGGAL_RESERVASI");
                String TANGGAL_CHECK_IN = rs.getString("TANGGAL_CHECK_IN");
                String TANGGAL_CHECK_OUT = rs.getString("TANGGAL_CHECK_OUT");

                reservasiList.add(
                        new Reservasi(RESERVASI_ID, TANGGAL_RESERVASI, TANGGAL_CHECK_IN, TANGGAL_CHECK_OUT));
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
        return reservasiList;
    }

        public void tambahReservasi(String TANGGAL_RESERVASI, String TANGGAL_CHECK_IN, String TANGGAL_CHECK_OUT) {
        db konek = new db();
        Connection connection = konek.getConnect();
        PreparedStatement ps = null;

        try {
            // Menggunakan PreparedStatement untuk memasukkan parameter
            String insertQuery = "INSERT INTO RESERVASI (TANGGAL_RESERVASI, TANGGAL_CHECK_IN, TANGGAL_CHECK_OUT) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(insertQuery);

            // Set nilai parameter
            ps.setString(1, TANGGAL_RESERVASI);
            ps.setString(2, TANGGAL_CHECK_IN);
            ps.setString(3, TANGGAL_CHECK_OUT);

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
