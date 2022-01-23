/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author MHD
 */
public class ValidationUtil {
   
     public boolean isEmpty(String data){

     if(data.isEmpty()){
         return true;
     }
     return false;
    }

    public boolean length(String data,int n,int m){

        if(data.length() < n || data.length() > m){
               return false;
        }

        return true;
    }

    








}
