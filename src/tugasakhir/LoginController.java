/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Zeta-PC
 */
public class LoginController implements Initializable {
zetmodel loginmodel = new zetmodel();

  @FXML
    private JFXTextField username;

       @FXML
    private JFXPasswordField password;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(loginmodel.isDBConnected()){
        JOptionPane.showMessageDialog(null,"Connect");
        }else{
        JOptionPane.showMessageDialog(null,"Not Connect");
        }
    }    

    @FXML
    private void aksilogin(javafx.event.ActionEvent event) throws IOException {
        String usrnm = username.getText();
        String unama = loginmodel.nama;
        String pass = password.getText();
    try {
        if(loginmodel.isLogin(usrnm,pass)){
        ((Node) (event.getSource())).getScene().getWindow().hide();
            //load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Tarif.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 459, 497);
            TarifController tarifController = (TarifController)fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Tarif");
            stage.show();
        }else{
        JOptionPane.showMessageDialog(null," Gagal Login");
        }
    } catch (SQLException ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null," Gagal Login");
    }
        
        
    }

    @FXML
    private void aksisignup(javafx.event.ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            //load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Signup.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sign Up");
            stage.show();
    }
    
}
