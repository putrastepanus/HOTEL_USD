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
    
}
