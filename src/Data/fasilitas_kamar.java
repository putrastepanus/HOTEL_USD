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
public class fasilitas_kamar {

    private static List<fasilitas_kamar> fasilitasKamar = new ArrayList<>();
    private int FASILITAS_KAMAR_ID;
    private int FASILITAS_ID;
    private int NO_KAMAR;

    public fasilitas_kamar(int FASILITAS_KAMAR_ID, int FASILITAS_ID, int NO_KAMAR) {
        this.FASILITAS_KAMAR_ID = FASILITAS_KAMAR_ID;
        this.FASILITAS_ID = FASILITAS_ID;
        this.NO_KAMAR = NO_KAMAR;
    }

    public fasilitas_kamar() {
    }

    public static List<fasilitas_kamar> getFasilitasKamar() {
        return fasilitasKamar;
    }

    public int getFASILITAS_KAMAR_ID() {
        return FASILITAS_KAMAR_ID;
    }

    public int getFASILITAS_ID() {
        return FASILITAS_ID;
    }

    public int getNO_KAMAR() {
        return NO_KAMAR;
    }

    public static List<fasilitas_kamar> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM fasilitas");
            while (rs.next()) {
                int FASILITAS_KAMAR_ID = rs.getInt("FASILITAS_KAMAR_ID");
                int FASILITAS_ID = rs.getInt("FASILITAS_ID");
                int NO_KAMAR = rs.getInt("NO_KAMAR");
                fasilitasKamar.add(new fasilitas_kamar(FASILITAS_KAMAR_ID, FASILITAS_ID, NO_KAMAR));
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
        return fasilitasKamar;
    }

    public void tambahFasilitasKamar(int FASILITAS_ID, int NO_KAMAR) {
        db konek = new db();
        Connection connection = konek.getConnect();
        PreparedStatement ps = null;

        try {
            // Menggunakan PreparedStatement untuk memasukkan parameter
            String insertQuery = "INSERT INTO FASILITAS_KAMAR (FASILITAS_ID, NO_KAMAR) VALUES (?, ?)";
            ps = connection.prepareStatement(insertQuery);

            // Set nilai parameter
            ps.setInt(1, FASILITAS_ID);
            ps.setInt(2, NO_KAMAR);

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
    
        public void editFasilitasKamar(int FASILITAS_KAMAR_ID, int FASILITAS_ID, int NO_KAMAR) {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        PreparedStatement ps = null;
        try {
            String updateQuery = "UPDATE FASILITAS_KAMAR SET FASILITAS_ID = ?, NO_KAMAR = ? WHERE FASILITAS_KAMAR_ID = ?";
            ps = connection.prepareStatement(updateQuery);

            // Set nilai parameter
            ps.setInt(1, FASILITAS_ID);
            ps.setInt(2, NO_KAMAR);

            // Eksekusi update
            int rowsUpdated = ps.executeUpdate();

            // Menampilkan jumlah baris yang terupdate
            System.out.println("Jumlah baris yang terupdate: " + rowsUpdated);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
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
    }
}
