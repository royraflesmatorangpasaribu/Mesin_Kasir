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
import uappbo.Classes.Penjualan;
import uappbo.Classes.Produk;

/**
 *
 * @author egyve
 */
public class PenjualanModel {
    private final Connection CONN;

    public PenjualanModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addPenjualan(Penjualan pjl){
        String insert = "INSERT INTO pjl VALUES ('" + pjl.getListProduk() + "', " + pjl.getJumlahProduk() + ", " + pjl.getStok() + ");";
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }
    public void dltPenjualan(Penjualan pjl){
        String delete = "DELETE FROM pjl WHERE pjl.listProduk='" + pjl.getListProduk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete)>0){
                System.out.println("Berhasil Menghapus Data");
            }else{
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    public void updPenjualan(Penjualan pjl){
        String update = "UPDATE pjl SET pjl.listProduk='" + pjl.getListProduk()+ "' WHERE pjl.listProduk='" + pjl.getListProduk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(update)>0){
                System.out.println("Berhasil Update Data");
            }else{
                System.out.println("Gagal Update Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data");
        }
    }
    public ArrayList<Produk> getProduk(){
        String query = "SELECT * FROM pjl";
        ArrayList<Produk> pjl = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Produk temp = new Produk(rs.getString("listProduk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"));
                pjl.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Berhasil Mengambil Data");
        }
        return pjl;
    }
    
}
