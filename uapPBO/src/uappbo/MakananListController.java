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
import javax.swing.JOptionPane;
import jdbc.BarangModel;
import jdbc.MakananModel;
import uappbo.Classes.Barang;
import uappbo.Classes.Makanan;

/**
 * FXML Controller class
 *
 @author royraflesmp
 */
public class MakananListController implements Initializable {

    @FXML
    private Button addBtn;

    @FXML
    private Button btnBack;

    @FXML
    private Button bukabtn;

    @FXML
    private TextField Nama;

    @FXML
    private TextField Harga;

    @FXML
    private TextField Jumlah;

    @FXML
    private TextField Diskon;

    @FXML
    private TextField Expired;

    @FXML
    void addData(ActionEvent event) {
        MakananModel model = new MakananModel();
        double hrg = Double.parseDouble(Harga.getText());
        int jml = Integer.parseInt(Jumlah.getText());
        double disc = Double.parseDouble(Diskon.getText());
                
        Makanan mkn = new Makanan(Nama.getText(), hrg, jml, disc, Expired.getText());
        model.addMakananSQL(mkn);
        System.out.println(Nama.getText());
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan!!!");
    }

    @FXML
    void openForm2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMakanan.fxml"));
          
        Stage stage = (Stage) bukabtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void toMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
          
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
