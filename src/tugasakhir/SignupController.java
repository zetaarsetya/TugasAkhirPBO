/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Zeta-PC
 */
public class SignupController implements Initializable {
    //instance sebuah variabel/method yg berasal dari file class lain
    zetmodel signupmodel = new zetmodel();
    @FXML
    private JFXTextField namadepan;
    @FXML
    private JFXTextField namabelakang;
    @FXML
    private JFXTextField usernamesign;
    @FXML
    private JFXTextField passsign;
    @FXML
    private JFXTextField nuser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okesignup(ActionEvent event) throws IOException {
        String nama_depan, nama_belakang, username, password , namauser;
        nama_depan = namadepan.getText();
        nama_belakang = namabelakang.getText();
        username = usernamesign.getText();
        password = passsign.getText();
        namauser = nuser.getText();
        
            if(signupmodel.isSignup(nama_depan, nama_belakang, username, 
                    password,namauser)){
             JOptionPane.showMessageDialog(null, "SIGN UP SUKSES !!");
             ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
             FXMLLoader loader = new FXMLLoader(getClass().getResource
        ("Login.fxml"));
             Parent root = (Parent)loader.load();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.setTitle("Login");
             stage.show();
            }else {
            JOptionPane.showMessageDialog(null, "SIGN UP GAGAL");
            }
        
    }
     @FXML
    void tutupaja(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
             FXMLLoader loader = new FXMLLoader(getClass().getResource
        ("Login.fxml"));
             Parent root = (Parent)loader.load();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.setTitle("Login");
             stage.show();
    }
    
}
