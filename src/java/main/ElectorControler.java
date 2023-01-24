/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author addis
 */
@ManagedBean
public class ElectorControler {
      String firstName;
     String lastName;
     String username;
     String password;
      Elector elector;
public ElectorControler(){
    
}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

      public String register(){
     Elector elector1=new Elector(this.firstName,this.lastName,this.username,this.password);
     DataBase database=new DataBase();
     database.addElector(elector1);
         return "log_in_page";
     }

   public ArrayList<Contestant> retrive() throws SQLException{
DataBase database=new DataBase();
        ArrayList<Contestant> contestant=database.retrive();
       
      // System.out.println(contestant.toString());
 return contestant;
//public String add(Contestant contest){
//    
//}
    }
      
   public  Elector caller(){
       System.out.println(this.elector.toString());
 return this.elector;
   }
   
   public static void update(Elector elector,String contestant){

  DataBase database=new DataBase();
  
 database.updateElector(elector,contestant);
  
   }
   
   public void load(){
       
   }
   
   
   
   public String loginCheek(String username,String password){
     DataBase database=new DataBase();  
elector=database.select(username,password);

 if(elector==null){
        return "notIllgable";
 }
   
 return "Contestants";

 }
   
   
   
}
