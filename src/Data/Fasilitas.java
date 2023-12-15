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
public class Fasilitas {

    private static List<Fasilitas> FasilitasList = new ArrayList<>();
    private int Fasilitas_ID;
    private String Nama_fasilitas;
    private int Biaya_fasilitas;

    public Fasilitas(int Fasilitas_ID, String Nama_fasilitas, int Biaya_fasilitas) {
        this.Fasilitas_ID = Fasilitas_ID;
        this.Nama_fasilitas = Nama_fasilitas;
        this.Biaya_fasilitas = Biaya_fasilitas;
    }

    public Fasilitas() {
    }

    public static List<Fasilitas> getRoomsList() {
        return FasilitasList;
    }

    public int getFasilitas_ID() {
        return Fasilitas_ID;
    }

    public String getNama_fasilitas() {
        return Nama_fasilitas;
    }

    public int getBiaya_fasilitas() {
        return Biaya_fasilitas;
    }
    
        public static List<Fasilitas> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM fasilitas");
            while (rs.next()) {
                int Fasilitas_ID = rs.getInt("fasilitas_id");
                String Nama_fasilitas = rs.getString("nama_fasilitas");
                int Biaya_fasilitas = rs.getInt("biaya_fasilitas");
                FasilitasList.add(new Fasilitas(Fasilitas_ID, Nama_fasilitas, Biaya_fasilitas));
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
        return FasilitasList;
    }
        
            public void tambahFasilitas(String Nama_fasilitas, int Biaya_fasilitas) {
        db konek = new db();
        Connection connection = konek.getConnect();
        PreparedStatement ps = null;

        try {
            // Menggunakan PreparedStatement untuk memasukkan parameter
            String insertQuery = "INSERT INTO FASILITAS (Nama_fasilitas, Biaya_fasilitas) VALUES (?, ?)";
            ps = connection.prepareStatement(insertQuery);

            // Set nilai parameter
            ps.setString(1, Nama_fasilitas);
            ps.setInt(2, Biaya_fasilitas);

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
