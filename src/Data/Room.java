package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Konek.db;

public class Room {

    private static List<Room> RoomsList = new ArrayList<>();
    private int no_kamar;
    private String tipe_kamar;
    private int kapasitas_kamar;
    private String ukuran_kamar;
    private int harga_per_malam;
    private boolean ketersediaan;

    public Room(int no_kamar, String tipe_kamar, int kapasitas_kamar, String ukuran_kamar, int harga_per_malam, boolean ketersediaan) {
        this.no_kamar = no_kamar;
        this.tipe_kamar = tipe_kamar;
        this.kapasitas_kamar = kapasitas_kamar;
        this.ukuran_kamar = ukuran_kamar;
        this.harga_per_malam = harga_per_malam;
        this.ketersediaan = ketersediaan;
    }

    public Room() {
    }

    public static List<Room> getRooms() {
        return RoomsList;
    }

    public int getNo_kamar() {
        return no_kamar;
    }

    public String getTipe_kamar() {
        return tipe_kamar;
    }

    public int getKapasitas_kamar() {
        return kapasitas_kamar;
    }

    public String getUkuran_kamar() {
        return ukuran_kamar;
    }

    public int getHarga_per_malam() {
        return harga_per_malam;
    }

    public boolean isKetersediaan() {
        return ketersediaan;
    }

    public static List<Room> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM ROOM");
            while (rs.next()) {
                int no_kamar = rs.getInt("no_kamar");
                String tipe_kamar = rs.getString("tipe_kamar");
                int kapasitas_kamar = rs.getInt("kapasitas_kamar");
                String ukuran_kamar = rs.getString("ukuran_kamar");
                int harga_per_malam = rs.getInt("harga_per_malam");
                boolean ketersediaan = rs.getBoolean("ketersediaan");
                RoomsList.add(new Room(no_kamar, tipe_kamar, kapasitas_kamar, ukuran_kamar, harga_per_malam, ketersediaan));
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
        return RoomsList;
    }

    public void setKetersediaan(boolean ketersediaan, int no_kamar) {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        PreparedStatement ps = null;
        try {
            String updateQuery = "UPDATE ROOM SET ketersediaan = ? WHERE no_kamar = ?";
            ps = connection.prepareStatement(updateQuery);

            // Set nilai parameter
            ps.setBoolean(1, ketersediaan);
            ps.setInt(2, no_kamar);

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

    public void tambahKamar(int no_kamar, String tipe_kamar, int kapasitas_kamar, String ukuran_kamar, int harga_per_malam, boolean ketersediaan) {
        db konek = new db();
        Connection connection = konek.getConnect();
        PreparedStatement ps = null;

        try {
            // Menggunakan PreparedStatement untuk memasukkan parameter
            String insertQuery = "INSERT INTO ROOM (no_kamar, tipe_kamar, kapasitas_kamar, ukuran_kamar, harga_per_malam, ketersediaan) VALUES (?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(insertQuery);

            // Set nilai parameter
            ps.setInt(1, no_kamar);
            ps.setString(2, tipe_kamar);
            ps.setInt(3, kapasitas_kamar);
            ps.setString(4, ukuran_kamar);
            ps.setInt(5, harga_per_malam);
            ps.setBoolean(6, ketersediaan);

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

    public void editKamar(int no_kamar, String tipe_kamar, int kapasitas_kamar, String ukuran_kamar, int harga_per_malam, boolean ketersediaan) {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        PreparedStatement ps = null;
        try {
            String updateQuery = "UPDATE ROOM SET tipe_kamar = ?, kapasitas_kamar = ?, ukuran_kamar = ?, harga_per_malam = ?, ketersediaan = ? WHERE no_kamar = ?";
            ps = connection.prepareStatement(updateQuery);

            // Set nilai parameter
            ps.setString(1, tipe_kamar);
            ps.setInt(2, kapasitas_kamar);
            ps.setString(3, ukuran_kamar);
            ps.setInt(4, harga_per_malam);
            ps.setBoolean(5, ketersediaan);
            ps.setInt(6, no_kamar);
            

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
