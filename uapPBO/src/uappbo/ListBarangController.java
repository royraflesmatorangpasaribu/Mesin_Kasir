/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uappbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdbc.BarangModel;
import uappbo.Classes.Barang;

/**
 * FXML Controller class
 *
 * @author egyve
 */
public class ListBarangController implements Initializable {

    @FXML
    private TextField Barcode;

    @FXML
    private TextField Diskon;

    @FXML
    private TextField Expired;

    @FXML
    private TextField Harga;

    @FXML
    private TextField Jumlah;

    @FXML
    private TextField Nama;

    @FXML
    private Button addBtn;

    @FXML
    private Button btnBack;

    @FXML
    private Button buyBtn;

    @FXML
    private Button delBtn;

    @FXML
    private TableView<Barang> tabelBarang;
    
    @FXML
    private TableColumn<Barang, String> tblBarcode;

    @FXML
    private TableColumn<Barang, Double> tblDiskon;

    @FXML
    private TableColumn<Barang, Double> tblHarga;

    @FXML
    private TableColumn<Barang, String> tblBarang;

    @FXML
    private TableColumn<Barang, Integer> tblStok;
    
    @FXML
    private Button bukabtn;
    

    @FXML
    void addData(ActionEvent event) {
        BarangModel model = new BarangModel();
        double hrg = Double.parseDouble(Harga.getText());
        int jml = Integer.parseInt(Jumlah.getText());
        double disc = Double.parseDouble(Diskon.getText());
                
        Barang brg = new Barang(Nama.getText(), hrg, jml, disc, Barcode.getText(), Expired.getText());
        
//        ObservableList<Barang> brg2 = tabelBarang.getItems();
//        brg2.add(brg);
//        tabelBarang.setItems(brg2);
        
        ObservableList<Barang> brg2 = tabelBarang.getItems();
        brg2.add(brg);
        tabelBarang.setItems(brg2);
        model.addBarangSQL(brg);
        
    }

//    @FXML
//    void openForm(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Struk.fxml"));
//          
//        Stage stage = (Stage) buyBtn.getScene().getWindow();
//        stage.setScene(new Scene(root));
//    }

    @FXML
    void removeData(ActionEvent event) {
        int selectedID = tabelBarang.getSelectionModel().getSelectedIndex();
        tabelBarang.getItems().remove(selectedID);
        BarangModel model = new BarangModel();
        double hrg = Double.parseDouble(Harga.getText());
        int jml = Integer.parseInt(Jumlah.getText());
        double disc = Double.parseDouble(Diskon.getText());
                
        Barang brg = new Barang(Nama.getText(), hrg, jml, disc, Barcode.getText(), Expired.getText());
        model.deleteBarangSQL(brg);
    }

    @FXML
    void toMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
          
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblBarang.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        tblHarga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        tblStok.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));
        tblDiskon.setCellValueFactory(new PropertyValueFactory<>("Diskon"));
        tblBarcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));
    }
    
        @FXML
    void openForm2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
          
        Stage stage = (Stage) bukabtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
