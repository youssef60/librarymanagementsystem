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
import java.sql.Connection;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */

public class testa {
    public static void calculPrix(){
               Date dateDebut = new Date();
               Date dateFin = new Date();
               LocalDateTime d1 =  LocalDateTime.of(dateDebut.getYear(), dateDebut.getMonth(), dateDebut.getDay(), dateDebut.getHours(), dateDebut.getSeconds());
               LocalDateTime d2 =  LocalDateTime.of(dateFin.getYear(), dateFin.getMonth(), dateFin.getDay(), dateFin.getHours(), dateFin.getSeconds());
               Duration weeks = Duration.between(d1, d2);
               System.out.println(weeks.getSeconds()/(60*60*24*7));
              
   }
    
    public static void main(String[] args) throws SQLException {

   calculPrix();

         
    }
    
}
