/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uappbo.Classes.Barang;

public class BarangModel {
    public boolean status;
    private final Connection CONN;
    public BarangModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addBarangSQL(Barang brg){
        String insert = "INSERT INTO barang VALUES ('" + brg.getNama_produk() + "', " + brg.getHarga() + ", " + brg.getJumlah() + ", " + brg.getDiskon() + ", null, '" + brg.getBarcode() + "', '" + brg.getExpired() + "');";
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("Berhasil Memasukkan Data");
                status = true;
            }else{
                System.out.println("Gagal Memasukkan Data");
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data, Periksa Query SQL anda!");
            status = false;
        }
    }
    
    public void deleteBarangSQL(Barang brg){
        String delete = "DELETE FROM barang WHERE barang.nama_produk='" + brg.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete)>0){
                System.out.println("Berhasil Menghapus Data");
                status = true;
            }else{
                System.out.println("Gagal Menghapus Data");
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data, Periksa Query SQL anda!");
            status = false;
        }
    }
    public void updateHargaBarang(Barang brg){
        String update = "UPDATE brg SET barang.harga='" + brg.getHarga()+ "' WHERE barang.nama_produk='" + brg.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(update)>0){
                System.out.println("Berhasil Update Data");
            }else{
                System.out.println("Gagal Update Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data, Periksa Query SQL anda!");
        }
    }
    
    
    public ArrayList<Barang> getBarang(){
        String query = "SELECT * FROM barang";
        ArrayList<Barang> brg = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Barang temp = new Barang(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("barcode"), rs.getString("expired"));
                brg.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Berhasil Mengambil Data");
        }
        return brg;
    }
}
    
      
    

