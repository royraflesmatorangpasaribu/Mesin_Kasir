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
import javax.swing.JOptionPane;
import jdbc.MakananModel;
import uappbo.Classes.Barang;
import uappbo.Classes.Makanan;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewMakananController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Makanan> tabView;
    
    @FXML
    private TableColumn<Makanan, String> tabNama;

    @FXML
    private TableColumn<Makanan, Double> tabHarga;

    @FXML
    private TableColumn<Makanan, Integer> tabJumlah;

    @FXML
    private TableColumn<Makanan, Double> tabDiskon;

    @FXML
    private TableColumn<Makanan, String> tabExpired;

    @FXML
    private Button buy;

    @FXML
    private Button backBtn;

    @FXML
    private Button delBtn;
    
    ObservableList<Makanan> makanan;

    @FXML
    void openBuy(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Struk.fxml"));
          
        Stage stage = (Stage) buy.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    public ObservableList<Makanan> getMakananList() throws SQLException{
        ObservableList<Makanan> makananList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        
        String query = "SELECT * FROM makanan;";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Makanan mkn;
            while(rs.next()){
                mkn = new Makanan(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("daya_tahan"));
                makananList.add(mkn);
            }
            
        }catch(Exception ex){
        }
        return makananList;
    }
     
     public void showMakanan() throws SQLException{
        ObservableList<Makanan> list = getMakananList();
        tabNama.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        tabHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        tabJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tabDiskon.setCellValueFactory(new PropertyValueFactory<>("diskon"));
        tabExpired.setCellValueFactory(new PropertyValueFactory<>("daya_tahan"));
        makanan = DBHelper.getMenuMakanan();
        
        tabView.setItems(list);
    }
    @FXML
    void removeData(ActionEvent event) {
        int selectedID = tabView.getSelectionModel().getSelectedIndex();
        MakananModel model = new MakananModel();
        model.dltMakananSQL(tabView.getSelectionModel().getSelectedItem());
        tabView.getItems().remove(selectedID);
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus!!!");
    }

    @FXML
    void toMakananList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MakananList.fxml"));
          
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showMakanan();
        } catch (SQLException ex) {
            Logger.getLogger(ViewMakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
