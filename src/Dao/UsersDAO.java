/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 *
 * @author PC
 */
public class UsersDAO {
    
        Connection con = null ;
	Statement stmt = null ;
	ResultSet res = null ;

    public UsersDAO() {
            try {
                con = (Connection) ConexionBD.getConnection();
                stmt = (Statement) con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
        

    
    public boolean isExist(String userN, String pass) {
        int count = -1;
        try
{


String req = "SELECT COUNT(*) COUNT FROM users WHERE login = '"+userN+"' and mdp = '"+pass+"';";
res = stmt.executeQuery(req);

res.next();
count = res.getInt("COUNT");

}catch(SQLException e)
{
System.out.println(e.getMessage());

}
        
if(count==0) return false;
else if(count>0) return true;
else return false;
              
   
    }
 
 public ArrayList<Users> getUserstList()
    {
        ArrayList<Users> usersList = new ArrayList();
        String query = "SELECT * FROM USERS";
 
       
     
 
        try {
 
            
            res = stmt.executeQuery(query);
            Users user;
 
            while(res.next())
            {
                user = new Users(
                        res.getInt("idUser"),
                        res.getString("prenom"),
                        res.getString("nom"),
                        res.getString("numTel"),
                        res.getBytes("image"),
                        Boolean.parseBoolean(res.getString("isResid"))
                );
                usersList.add(user);
            }
 
//            con.close();
        }
        catch (SQLException ex) {
            System.out.println("controlers.UsersDAO.getProductList() error : SQLException");
        }
 
        return usersList;
    }
  
     public int add(Users u , String selectedImagePath) throws SQLException, FileNotFoundException
    {
                PreparedStatement ps;
 
                if (selectedImagePath == null) {
                    ps = (PreparedStatement) con.prepareStatement("INSERT INTO users(prenom,nom,  numTel,isResid ) values(?,?,?,?)");
                }
 
                else {
                    ps = (PreparedStatement) con.prepareStatement("INSERT INTO users(prenom,nom,  numTel,isResid , image) values(?,?,?,?,?)");
 
                    InputStream img = new FileInputStream(new File(selectedImagePath));
                    ps.setBlob(5, img);
                }
                
                
                ps.setString(1, u.getPrenom());
                ps.setString(2, u.getNom());

                ps.setString(3, u.getNumTel());
                
                ps.setInt(4, u.getIsResid() ? 1 : 0);
 
                int r= ps.executeUpdate();
//               con.close();
                return r;
           
        }
 
    
     public int update(Users u , String selectedImagePath) throws SQLException, FileNotFoundException
    {
                PreparedStatement ps;
 
                if (selectedImagePath == null) {
                    ps = (PreparedStatement) con.prepareStatement("UPDATE `users` SET `prenom`=?,`nom`=?,`numTel`=?,`isResid`=? WHERE `idUser`= ?");
                     ps.setInt(5, u.getIdUser());
                }
 
                else {
                    ps = (PreparedStatement) con.prepareStatement("UPDATE `users` SET `prenom`=?,`nom`=?,`numTel`=?,`isResid`=?, `image`=? WHERE `idUser`= ?");
 
                    InputStream img = new FileInputStream(new File(selectedImagePath));
                    ps.setBlob(5, img);
                    ps.setInt(6, u.getIdUser());
                }
                
                
                ps.setString(1, u.getPrenom());
                ps.setString(2, u.getNom());

                ps.setString(3, u.getNumTel());
                
                ps.setInt(4, u.getIsResid() ? 1 : 0);
               
 
                int r= ps.executeUpdate();
//               con.close();
                return r;
           
        }
 
public void update2(int i){
            String query="UPDATE `users` SET `nom`='AAupupuppupuap' WHERE `idUser`= "+i+"";
    
            try {
                java.sql.PreparedStatement ps = con.prepareStatement(query);
                 ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

    
                            
}

public void delete(int id){
   
 
             
            try {
             PreparedStatement   ps = (PreparedStatement) con.prepareStatement("DELETE FROM `users` WHERE `idUser`="+id+" ");
            
             ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
}
	
     
		
	
}
