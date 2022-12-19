/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uappbo;

import db.DBHelper;
import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdbc.BarangModel;
import uappbo.Classes.Barang;

/**
 * FXML Controller class
 *
 * @author royraflesmp
 */
public class ViewController implements Initializable {


    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;
    
    @FXML
    private TableColumn<Barang, String> tabBarcode;

    @FXML
    private TableColumn<Barang, Double> tabDiskon;

    @FXML
    private TableColumn<Barang, String> tabExpired;

    @FXML
    private TableColumn<Barang, Double> tabHarga;

    @FXML
    private TableColumn<Barang, Integer> tabJumlah;

    @FXML
    private TableColumn<Barang, String> tabNama;
    
    @FXML
    private TableView<Barang> tabView;
    
    ObservableList<Barang> barang;
    
    @Override
    public void initialize(URL url, ResourceBundle resource) {
       try {
            showBarang();
        } catch (SQLException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<Barang> getBarangList() throws SQLException{
        ObservableList<Barang> barangList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        
        String query = "SELECT * FROM barang;";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Barang brg;
            while(rs.next()){
                brg = new Barang(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("barcode"), rs.getString("expired"));
                barangList.add(brg);
            }
            
        }catch(Exception ex){
        }
        return barangList;
    }
     
     public void showBarang() throws SQLException{
        ObservableList<Barang> list = getBarangList();
        tabNama.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        tabHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        tabJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tabDiskon.setCellValueFactory(new PropertyValueFactory<>("diskon"));
        tabBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        tabExpired.setCellValueFactory(new PropertyValueFactory<>("expired"));
        barang = DBHelper.getMenuBarang();
        
        tabView.setItems(list);
    }

    @FXML
    void removeData(ActionEvent event) throws IOException{
        int selectedID = tabView.getSelectionModel().getSelectedIndex();
//        tabView.getItems().remove(selectedID);
//        BarangModel model = new BarangModel();
//        double hrg = Double.parseDouble(tabHarga.getText());
//        int jml = Integer.parseInt(tabJumlah.getText());
//        double disc = Double.parseDouble(tabDiskon.getText());
//                
//        Barang brg = new Barang(tabNama.getText(), hrg, jml, disc, tabBarcode.getText(), tabExpired.getText());
//        model.deleteBarangSQL(brg1);
        
      //  Barang brg=new Barang(tabView.getSelectionModel().);
        BarangModel model=new BarangModel();
        model.deleteBarangSQL(tabView.getSelectionModel().getSelectedItem());
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
//        Parent root = loader.load();
//        Stage stage= (Stage) btnDelete.getScene().getWindow();
//        stage.setScene(new Scene(root));
         tabView.getItems().remove(selectedID);
    }

    @FXML
    public void openForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BarangList.fxml"));
          
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
