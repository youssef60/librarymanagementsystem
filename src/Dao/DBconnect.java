/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MHD
 */
public class DBconnect {
    static Connection con;

   static {
     try{
         
           Class.forName("com.mysql.cj.jdbc.Driver");
       }catch(ClassNotFoundException e){
         
            e.printStackTrace();
       }

}
       public static Connection getConnection() throws SQLException{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem" ,"root" ,"" );
             return con;



























}

 

}
