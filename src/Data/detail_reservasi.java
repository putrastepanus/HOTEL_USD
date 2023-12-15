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
public class detail_reservasi {

    private static List<detail_reservasi> detailReservasi = new ArrayList<>();
    private int DETAIL_RESERVASI;
    private int RECEPTIONIS_ID;
    private int RESERVASI_ID;
    private int NO_KAMAR;
    private int GUEST_ID;
    private int JUMLAH_KAMAR;
    private int BIAYA;
    private int JUMLAH_TAMU;

    public detail_reservasi(int DETAIL_RESERVASI, int RECEPTIONIS_ID, int RESERVASI_ID, int NO_KAMAR, int GUEST_ID, int JUMLAH_KAMAR, int BIAYA, int JUMLAH_TAMU) {
        this.DETAIL_RESERVASI = DETAIL_RESERVASI;
        this.RECEPTIONIS_ID = RECEPTIONIS_ID;
        this.RESERVASI_ID = RESERVASI_ID;
        this.NO_KAMAR = NO_KAMAR;
        this.GUEST_ID = GUEST_ID;
        this.JUMLAH_KAMAR = JUMLAH_KAMAR;
        this.BIAYA = BIAYA;
        this.JUMLAH_TAMU = JUMLAH_TAMU;
    }

    public detail_reservasi() {
    }

    public static List<detail_reservasi> getDetailReservasi() {
        return detailReservasi;
    }

    public int getDETAIL_RESERVASI() {
        return DETAIL_RESERVASI;
    }

    public int getRECEPTIONIS_ID() {
        return RECEPTIONIS_ID;
    }

    public int getRESERVASI_ID() {
        return RESERVASI_ID;
    }

    public int getNO_KAMAR() {
        return NO_KAMAR;
    }

    public int getGUEST_ID() {
        return GUEST_ID;
    }

    public int getJUMLAH_KAMAR() {
        return JUMLAH_KAMAR;
    }

    public int getBIAYA() {
        return BIAYA;
    }

    public int getJUMLAH_TAMU() {
        return JUMLAH_TAMU;
    }

    public static List<detail_reservasi> getAllUsers() {
        db konek = new db();
        Connection connection = konek.getConnect();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM detail_reservasi");
            while (rs.next()) {
                int DETAIL_RESERVASI = rs.getInt("DETAIL_RESERVASI");
                int RECEPTIONIS_ID = rs.getInt("RECEPTIONIS_ID");
                int RESERVASI_ID = rs.getInt("RESERVASI_ID");
                int NO_KAMAR = rs.getInt("NO_KAMAR");
                int GUEST_ID = rs.getInt("GUEST_ID");
                int JUMLAH_KAMAR = rs.getInt("JUMLAH_KAMAR");
                int BIAYA = rs.getInt("BIAYA");
                int JUMLAH_TAMU = rs.getInt("JUMLAH_TAMU");

                detailReservasi.add(
                        new detail_reservasi(DETAIL_RESERVASI, RECEPTIONIS_ID, RESERVASI_ID, NO_KAMAR, GUEST_ID, JUMLAH_KAMAR, BIAYA, JUMLAH_TAMU));
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
        return detailReservasi;
    }

}
