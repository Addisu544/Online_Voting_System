/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author addis
 */
@ManagedBean
@ApplicationScoped
public class ContestantControler {
    private String firstName;
     private String lastName;
     private String id;
     private int value;
Contestant con;

    public Contestant getCon() {
        return con;
    }

    public void setCon(Contestant con) {
        this.con = con;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    
    
    
    
    public void reset(){
               this.firstName = "";
        this.lastName = "";
        this.id = "";
    }
     ArrayList<Contestant> contestants;
     public ContestantControler(){ }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
    }
    
    
     public String register(){
     Contestant contestant=new Contestant(this.firstName,this.lastName,this.id,this.value);
     DataBase database=new DataBase();
     database.add(contestant);
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
     
  public String update(Contestant contest){
  DataBase database=new DataBase(); 
  this.con=contest;
 database.update(contest);
      System.out.println("normal till now");

    
      
      
      
//      Elector caller = null;
//        ElectorControler electorController=new ElectorControler(); 
//        caller = electorController.caller();
//            System.out.println(" also normal till now"); 
//        ElectorControler.update(caller,contest.toString());
      return "success";

  }
     
    void load(){
         
     }
     
     
}
