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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 62823
 */
public class ProdukInputController implements Initializable {

    @FXML
    private TableView<Produk> PITable;

    @FXML
    private TableColumn<Produk, String> PIKategori;

    @FXML
    private TableColumn<Produk, String> PIBarang;

    @FXML
    private Button PIHapus;

    @FXML
    private TextField PIN;

    @FXML
    private TextField PIK;

    @FXML
    private Button PIM;
    
    @FXML
    private Button PITambah;
    

    @FXML
    void addData(MouseEvent event) {
        Produk produk = new Produk(PIN.getText(), PIK.getText());
       ObservableList<Produk> produks = PITable.getItems();
       produks.add(produk);
       PITable.setItems(produks);
    }

    @FXML
    void removeData(MouseEvent event) {
        int selectedID = PITable.getSelectionModel().getSelectedIndex();
        PITable.getItems().remove(selectedID);
    }
    
    @FXML
    void openForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
          
          Stage stage = (Stage) PIM.getScene().getWindow();
          stage.setScene(new Scene(root));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       PIKategori.setCellValueFactory(new PropertyValueFactory<Produk, String>("Kategori"));
       PIBarang.setCellValueFactory(new PropertyValueFactory<Produk, String>("Produk"));
    }    
    
}
