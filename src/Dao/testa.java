/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Users;

/**
 *
 * @author PC
 */
public class testa {
    
    
    public static void main(String[] args) {
//        System.out.println("controlers.test.main()");
//         boolean b= new UsersDAO(). isExist("admin", "admin");
//         
//         if (b) System.out.println("controlers.test.main() TRUE");
//         else System.out.println("controlers.test.main()FALSE");

System.out.println("controlers.testa.main()");
UsersDAO ud = new UsersDAO();
 ArrayList<Users> ul = ud.getUserstList();
        System.out.println( ul.get(0).getNom());

//new UsersDAO().update2(4);

//Users u = new Users(6,"test","test","test",true);
//
//        try {
//            
//            
//            new UsersDAO().update(u,null);
//        } catch (SQLException ex) {
//            Logger.getLogger(testa.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(testa.class.getName()).log(Level.SEVERE, null, ex);
//        }



         
    }
    
}
