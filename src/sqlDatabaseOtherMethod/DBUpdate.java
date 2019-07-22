/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlDatabaseOtherMethod;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.util.Scanner;
/**
 *
 * @author user
 */
public class DBUpdate {
    String url="jdbc:mysql://localhost/db_practice";
    String username="root";
    String password="";
    
    int id;
    String name;
    String address;
    
    public void updatePerson(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn=DriverManager.getConnection(url,username,password);
            
            System.out.println("Enter your id");
            id=new Scanner(System.in).nextInt();
            System.out.println("Enter your name");
            name=new Scanner(System.in).nextLine();
            System.out.println("Enter your address");
            address=new Scanner(System.in).nextLine();
            
            String sql="UPDATE practice_person SET name=?,address=? WHERE id=?";
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1,name);
            pr.setString(2,address);
            pr.setInt(3,id);
            
            pr.executeUpdate();
            
            System.out.println("Updated Successfully!!");
            conn.close();
            
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
    }
    
    public void updatePerson(Person p){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn=DriverManager.getConnection(url,username,password);
            
            String sql="UPDATE practice_person SET name=?,address=? WHERE id=?";
            PreparedStatement pr=conn.prepareStatement(sql);
            
            pr.setString(1,p.getName());
            pr.setString(2,p.getAddress());
            pr.setInt(3,p.getId());
            
            pr.executeUpdate();
            conn.close();
            
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
        
    }
    
    
    public static void main(String[]args){
        new DBUpdate();
    }
}
