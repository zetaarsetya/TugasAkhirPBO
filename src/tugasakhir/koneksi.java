/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Zeta-PC
 */
public class koneksi {
             public static Connection konektor(){
             try{
             Class.forName("org.sqlite.JDBC");
             Connection jet = DriverManager.getConnection("jdbc:sqlite:Zet-Express.sqlite");
             return jet;
             }catch (Exception e){
                 System.out.println(e);
                 return null;
             }
             }
}
