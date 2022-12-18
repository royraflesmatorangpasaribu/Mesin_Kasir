/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uappbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 62823
 */
public class MenuController {

     @FXML
    private Button MenuButton;
     
     @FXML
    private Button MenuMakanan;
     
     @FXML
    private Button MenuLog;

    @FXML
    void openForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListBarang.fxml"));
        //Parent root2 = FXMLLoader.load(getClass().getResource("Logout.fxml"));
          
        Stage stage = (Stage) MenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
          
//          Stage stage2 = (Stage) MenuLog.getScene().getWindow();
//          stage2.setScene(new Scene(root2));
    }
    
    @FXML
    void openForm2(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        Stage stage = (Stage) MenuLog.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void OpenMakanan(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BarangList.fxml"));
          Stage stage = (Stage) MenuMakanan.getScene().getWindow();
          stage.setScene(new Scene(root));
    }
    
    
    
}
