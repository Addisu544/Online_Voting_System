/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author addis
 */
class DataBase {
     String URL="jdbc:oracle:thin:@localhost:1521:xe";
    String DRIVER="oracle.jdbc.driver.OracleDriver";
    String PASSWORD="aman";
    String USER_NAME="ADDISU";
    Connection connect;

    Connection getConnection() throws SQLException{
        try {
            Class.forName(DRIVER);
            connect=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException ex) {
     }

        return connect;

    }
public void add(Contestant contest){
    Connection connection;
    
       try{
             connection = getConnection();
             String sql="insert into CONTESTANT values(?,?,?,?)";        
    PreparedStatement statement=connection.prepareStatement(sql);
    statement.setString(1,contest.firstName);
      statement.setString(2,contest.lastName);
        statement.setString(3,contest.id);
        statement.setInt(4,contest.value);
        statement.executeUpdate();
         } catch (SQLException ex) {
             System.out.println("there is a problem");
         }
}

    ArrayList<Contestant> retrive(){
       ArrayList<Contestant>contestants = new ArrayList<>();
        Connection connection;
         try {
                  connection = getConnection();
              Statement statement=connection.createStatement();
        String sql="select * from CONTESTANT";
        ResultSet resultset=statement.executeQuery(sql);
        while(resultset.next()){
        String str=resultset.getString(1);
        String str1=resultset.getString(2);
        String str2=resultset.getString(3);
        int str3=0;
                      //   Contestant contest = ;
         contestants.add(new Contestant(str,str1,str2,str3));
         }
        
         }catch (SQLException ex) {

         }
       
        
        
         return contestants;
        }

    void update(Contestant contest) {
         try {     
             Connection connection=getConnection();
             String sqs="select * from CONTESTANT where id=?";
              PreparedStatement statement1=connection.prepareStatement(sqs);
                  statement1.setString(1,contest.id);
                  ResultSet resultset=statement1.executeQuery();
                  resultset.next();
                  int val=resultset.getInt(4);
               ++val;
        //          Integer number=Integer.parseInt(val);
                  
             String sql="update CONTESTANT set firstName=?,lastName=?,id=?,value=? where id=?";
             
         //    ++number;
        //    String num=number.toString();
             
             PreparedStatement statement=connection.prepareStatement(sql);
             statement.setString(1,contest.firstName);
               statement.setString(2,contest.lastName);
                 statement.setString(3,contest.id);
                  statement.setInt(4,val);
                  
                   statement.setString(5,contest.id);
                   statement.executeUpdate();
                   
         } catch (SQLException ex) {
             System.out.println("there is error bro");
         }
    }

    void addElector(Elector elector) {
         Connection connection;
    
       try{
             connection = getConnection();
             String sql="insert into ELECTOR values(?,?,?,?,?,?)";        
    PreparedStatement statement=connection.prepareStatement(sql);
    statement.setString(1,elector.firstName);
      statement.setString(2,elector.lastName);
        statement.setString(3,elector.username);
        statement.setString(4,elector.password);
         statement.setString(5,elector.isElect);
         statement.setString(6,elector.contestant);
        statement.executeUpdate();
         } catch (SQLException ex) {
             System.out.println("there is a problem");
         }
    }

    
    
    
    
    void updateElector(Elector elector,String contestant) {
          try {     
             Connection connection=getConnection();  
             String sql="update ELECTOR set firstName=?,lastName=?,username=?,password=?,isElect=?,contestant=? where username=?";
             PreparedStatement statement=connection.prepareStatement(sql);
             
             statement.setString(1,elector.firstName);
               statement.setString(2,elector.lastName);
                 statement.setString(3,elector.username);
                  statement.setString(4,elector.password);     
                   statement.setString(5,"true");
                   statement.setString(6,contestant);
                    statement.setString(7,elector.firstName);
                   statement.executeUpdate();
                   
         } catch (SQLException ex) {
             System.out.println("there is error bro");
         }
    }

    Elector select(String username,String password){
          String str1 = null ;
        String str2 = null ;
        String str3 = null ;
        String str4;
        String str = null;
    
      Connection connection;
         try {
             connection = getConnection();
              String sqs="select * from USERLIST where username=? AND password=?";
              PreparedStatement statement=connection.prepareStatement(sqs);
                  statement.setString(1,username);
                  statement.setString(2,password);
                  ResultSet resultset;
         resultset = statement.executeQuery();
         if(!resultset.next()){
         return null;
         } else {
                   String sql="select * from ELECTOR where firstname=?";
              PreparedStatement statement1=connection.prepareStatement(sql);
                  statement1.setString(1,username);
                  ResultSet resultset1;
         resultset1 = statement1.executeQuery();
                  while(resultset1.next()){
                str=resultset1.getString(1);
        str1 =resultset1.getString(2);
         str2 =resultset1.getString(3);
      str3 =resultset1.getString(4);
        str4=resultset1.getString(5);
        if("true".equals(str4))return null;
                  
                  }
     
    }
         } catch (SQLException ex) {
             System.out.println("there su error klfdksla"); 
         }
            
 
  return new Elector(str,str1,str2,str3);  
}

}
