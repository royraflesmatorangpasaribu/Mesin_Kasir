/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uappbo;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdbc.BarangModel;
import uappbo.Classes.Barang;

public class UapPBO extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Mesin Kasir");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
//        BarangModel model = new BarangModel();
//        Barang brg = new Barang("Basreng", 5000.0, 20, 0.05, "barcode", "2022-12-31");
//        model.addBarangSQL(brg);
    }    
}
