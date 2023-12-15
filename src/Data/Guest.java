package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Konek.db;

public class Guest {

    private static List<Guest> GuestList = new ArrayList<>();
    private int GUEST_ID;
    private String nama;
    private String email;
    private String no_telp;
    private String alamat;

    public Guest(int GUEST_ID, String nama, String email, String no_telp, String alamat) {
        this.GUEST_ID = GUEST_ID;
        this.nama = nama;
        this.email = email;
        this.no_telp = no_telp;
        this.alamat = alamat;
    }

    public Guest() {
    }

    public static List<Guest> getGuestList() {
        return GuestList;
    }

    public int getGUEST_ID() {
        return GUEST_ID;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getAlamat() {
        return alamat;
    }


    

    private void addUserToDatabase(Guest user) {
        GuestList.add(user);
    }

    public static List<Guest> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM GUEST");
            while (rs.next()) {
                int GUEST_ID = rs.getInt("GUEST_ID"); // Ganti dengan nama kolom yang sesuai
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String no_telp = rs.getString("no_telp"); // Ganti dengan nama kolom yang sesuai
                String alamat = rs.getString("alamat");
                GuestList.add(new Guest(GUEST_ID, nama, email, no_telp, alamat));
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
        return GuestList;
    }
    
        public void tambahGuest(String nama, String email, String no_telp, String alamat) {
        db konek = new db();
        Connection connection = konek.getConnect();
        PreparedStatement ps = null;

        try {
            // Menggunakan PreparedStatement untuk memasukkan parameter
            String insertQuery = "INSERT INTO GUEST (nama, email, no_telp, alamat) VALUES (?, ?, ?, ?)";
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
