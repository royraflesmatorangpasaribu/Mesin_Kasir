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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class LoginController{

    @FXML
    private ImageView LoginLogo;
    
    @FXML
    private Button LoginButton;

    @FXML
    void openForm(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
          
          Stage stage = (Stage) LoginButton.getScene().getWindow();
          stage.setScene(new Scene(root));
    }
    
   
}
