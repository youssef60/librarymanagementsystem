/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.livreModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MHD
 */
public class livreRegulierDao implements Dao<livreModel> {
    
   DButil dbutil = new DButil();
  public boolean insert (livreModel obj) throws SQLException{

    String sql = "insert into livreRegulier (titre,nomAuteur,nbCopie,datePublication,isbn ,idCat) values ('" + obj.getTitre() + "' ,'"
                  + obj.getNomAuteur() +"', "+ obj.getNbCopie() +", '"+obj.getDatePublication()+"', '"+obj.getIsbn()+"' ,"+obj.getIdCat()+" ) ";
    if(dbutil.DML(sql)){
          return true;
    }
    return false;
}

  public boolean update (livreModel obj) throws SQLException{
      
    String sql = "update livreRegulier set titre = '"+ obj.getTitre() +"', nomAuteur = '"+ obj.getNomAuteur() +"' , nbCopie = "+ obj.getNbCopie() +" ,datePublication = '"+obj.getDatePublication()+"' , isbn = '"+obj.getIsbn()+"' , idCat = "+obj.getIdCat()+" where idLivreRegulier = "+obj.getIdLivre()+" "; 
    if(dbutil.DML(sql)){
          return true;
    }
    return false; 
}

  public boolean delete (livreModel obj) throws SQLException{

   String sql = "delete from livreRegulier where idLivreRegulier = "+obj.getIdLivre()+" "; 
    if(dbutil.DML(sql)){
          return true;
    }
    return false; 


}

  public livreModel select(livreModel obj) throws SQLException{

   String sql = "select * from livreRegulier where idLivreRegulier = "+obj.getIdLivre()+" "; 
   ResultSet rs = dbutil.select(sql);
   if(rs.next()){
       return new livreModel(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getInt(6))  ;  
}
   return null;
}

    public ArrayList<livreModel> getAll() throws SQLException{
       ArrayList<livreModel> list = new ArrayList();
       String sql = "select * from livreRegulier";
       ResultSet rs = dbutil.select(sql);
       while(rs.next()){
          list.add(new livreModel(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getInt(6)));
}
       return list;
}

    public ResultSet getRsAll() throws SQLException{

       String sql = "select * from livreRegulier";
       ResultSet rs = dbutil.select(sql);
       return rs;
}


    public ResultSet search(String colName , String key ) throws SQLException{

       String sql = "select * from livreRegulier where "+colName+" like '"+key+"%' "; 
       ResultSet rs = dbutil.select(sql);
       return rs;

}











    









    
    

    
   

}
