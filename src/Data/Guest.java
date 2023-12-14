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
    private String noTelp;
    private String alamat;

    public Guest(int GUEST_ID, String nama, String email, String noTelp, String alamat) {
        this.GUEST_ID = GUEST_ID;
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
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

    public String getNoTelp() {
        return noTelp;
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
                String noTelp = rs.getString("no_telp"); // Ganti dengan nama kolom yang sesuai
                String alamat = rs.getString("alamat");
                GuestList.add(new Guest(GUEST_ID,nama,email,noTelp, alamat));
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
}
