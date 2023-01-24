/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Contestant {
       String firstName;
     String lastName;
     String id;
    int value;

    public Contestant(String firstName, String lastName, String id,int value) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.value=value;
    }
      @Override
    public String toString() {
        return
               "FirstName=" + firstName  +
                ", lastName=" + lastName + 
                ", id=" + id;
    }  

}
