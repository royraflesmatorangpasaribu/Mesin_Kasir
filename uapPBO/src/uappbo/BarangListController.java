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
 * @author royraflesmp
 */
public class BarangListController implements Initializable {
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
    private Button mknBack;

 
    
    @FXML
    private Button showView;
    
    
    @FXML
    void openForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
          
        Stage stage = (Stage) showView.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void ToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
          
        Stage stage = (Stage) mknBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }



    @FXML
    void addData(ActionEvent event) {
        BarangModel model = new BarangModel();
        double hrg = Double.parseDouble(Harga.getText());
        int jml = Integer.parseInt(Jumlah.getText());
        double disc = Double.parseDouble(Diskon.getText());
                
        Barang brg = new Barang(Nama.getText(), hrg, jml, disc, Barcode.getText(), Expired.getText());
        model.addBarangSQL(brg);
        System.out.println(Nama.getText());
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan!!!");
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
