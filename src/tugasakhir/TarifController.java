/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zeta-PC
 */
public class TarifController implements Initializable {

    @FXML
    private RadioButton idmy;
    @FXML
    private ToggleGroup grup;
    @FXML
    private RadioButton idms;
    @FXML
    private RadioButton idmm;
    @FXML
    private RadioButton idmj;
    @FXML
    private TextField berat;
    @FXML
    private TextArea Total;
    private Label namauser;
    @FXML
    private TextArea Hasilnya;
    @FXML
    private TextField nm;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }    
    @FXML
    void metuae(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
             Parent root = (Parent)loader.load();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.setTitle("Login");
             stage.show();
    }
    @FXML
     void okeaksi(ActionEvent event) {
        String tarif = "";
        if(idmy.isSelected())
            tarif = "Malang-Yogya";
        else if(idms.isSelected())
            tarif = "Malang-Surabaya";
        else if(idmm.isSelected())
            tarif = "Malang-Madiun";
            else if(idmj.isSelected())
                tarif = "Malang-Jakarta";
        else
          tarif = "";
        
        if(!(idmy.isSelected() || idms.isSelected() || idmm.isSelected() || 
                idmj.isSelected())){
            JOptionPane.showMessageDialog(null, "Harap Pilih Tarif Layanan");
    }else{
    int harga =0;
    String Nama = nm.getText();
    String Berat = berat.getText()+"kg";
    int hitung = Integer.parseInt(berat.getText());
    
    if(idmy.isSelected()){
        harga = hitung*40000;}
    if(idms.isSelected()){
        harga = hitung*15000;}
    if(idmm.isSelected()){
        harga = hitung*35000;}
    if(idmj.isSelected()){
        harga = hitung*50000;}
    
    Total.setText("Rp."+harga);
    
    Hasilnya.setText("Nama  : "+Nama+"\n"+"Pilih Tarif : "+tarif+"\n"+"Berat : "+Berat);
        }
    }
    @FXML
    void okekeluar(ActionEvent event) {
        System.exit(0);
    }
}