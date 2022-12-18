package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uappbo.Classes.Barang;


public class DBHelper {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "uappbo";
    private static final String MYCONN = "jdbc:mysql://localhost/"+DB;
    
    public static Connection conn = null;
    public static Connection getConnection(){
//        Connection conn = null;
        try{
            conn = DriverManager.getConnection(MYCONN, USERNAME, PASSWORD);
            System.out.println("Koneksi Berhasil");
        }catch(SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        return conn;
    }

    public static ObservableList<Barang> getMenuBarang(){
        ObservableList<Barang> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Barang(rs.getString("nama_produk"), Double.parseDouble("harga"), Integer.parseInt("jumlah"), Double.parseDouble("diskon"), rs.getString("barcode"), rs.getString("expired")));
            }
        }catch(SQLException | NumberFormatException e){
            
        }
        return list;
        
    }  
}