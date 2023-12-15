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

public class TestingDB {

    public static void main(String[] args) {
        //        List<Receptionis> dataResepsionis = Receptionis.getAllUsers();
        //
        //        // Menampilkan data receptionis yang didapatkan dari database
        //        for (Receptionis receptionist : dataResepsionis) {
        //            System.out.println("ID: " + receptionist.getRepceptionis_ID());
        //            System.out.println("Nama: " + receptionist.getNama());
        //            System.out.println("Email: " + receptionist.getEmail());
        //            System.out.println("Nomor Telepon: " + receptionist.getNoTelp());
        //            System.out.println("Alamat: " + receptionist.getAlamat());
        //            System.out.println("------------------------------");
        //        }
        //
        //        List<Guest> dataGuest = Guest.getAllUsers();
        //
        //        // Menampilkan data receptionis yang didapatkan dari database
        //        for (Guest receptionist : dataGuest) {
        //            System.out.println("ID: " + receptionist.getGUEST_ID());
        //            System.out.println("Nama: " + receptionist.getNama());
        //            System.out.println("Email: " + receptionist.getEmail());
        //            System.out.println("Nomor Telepon: " + receptionist.getNoTelp());
        //            System.out.println("Alamat: " + receptionist.getAlamat());
        //            System.out.println("------------------------------");
        //        }

//        Room room = new Room();
//        room.setKetersediaan(false, 139);
        List<Room> roomList = Room.cariKamar("193");
        for (Room room : roomList) {
            System.out.println("Room Number: " + room.getNo_kamar());
            System.out.println("Room Type: " + room.getTipe_kamar());
            System.out.println("Capacity: " + room.getKapasitas_kamar());
            System.out.println("Ukuran: " + room.getUkuran_kamar());
            System.out.println("harga: " + room.getHarga_per_malam());
            System.out.println("ketersediaan: " + room.isKetersediaan());
            // Add more print statements for other room details
        }

    }
}
