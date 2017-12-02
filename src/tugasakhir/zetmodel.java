/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Zeta-PC
 */
public class zetmodel {
    Connection conection;
    String nama;
    public zetmodel() {
        conection = koneksi.konektor();
        if(conection == null) System.exit(1);
    }
    public boolean isDBConnected(){
        try{
            return !conection.isClosed();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean isLogin(String name,String pass) throws SQLException {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String query = "select * from tb_user where username = ? and password = ?";
        try{
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            nama = resultSet.getString("nama_user");
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
   public boolean isSignup(String n_depan,String n_belakang,String usname,String sandi,String namauser){
       
       String query = "INSERT INTO tb_user (namadepan,namabelakang,username,password,nama_user) VALUES (?,?,?,?,?)";
       try(
           PreparedStatement abc = conection.prepareStatement(query)){
           
           abc.setString(1, n_depan);
           abc.setString(2, n_belakang);
           abc.setString(3, usname);
           abc.setString(4, sandi);
           abc.setString(5, namauser);
           abc.executeUpdate();
           return true;
       }catch (SQLException e){
           System.out.println(e.getMessage());
           return false;
       }
   }
}
