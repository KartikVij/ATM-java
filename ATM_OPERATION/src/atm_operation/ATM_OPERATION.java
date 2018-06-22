/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_operation;

/**
 *
 * @author Aurobind singh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Database
{       String username = "root";
        String password = "";
        String database_location = "jdbc:mysql://localhost/database1";
        
   public void insert(String name1,String pin1,String balance1)
    {
        try 
        {
            Connection con = DriverManager.getConnection(database_location, username, password);
            System.out.println("you are connected to the database");
            Statement st =  con.createStatement();
            st.executeUpdate("insert into data1(name,pin,balance) values('"+name1+"', '"+pin1+"' , '"+balance1+"')");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
   public void updatePin(String old_pin, String new_pin)
    {
        try 
        {
            Connection con = DriverManager.getConnection(database_location, username, password);
            System.out.println("you are connected to the database");
            Statement st =  con.createStatement();
            st.executeUpdate("update data1 pin='"+new_pin+"' where pin = '"+old_pin+"'  " );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
   public void update_balance(String balance,String pin)
    {
        try 
        {
            Connection con = DriverManager.getConnection(database_location, username, password);
            System.out.println("you are connected to the database");
            Statement st =  con.createStatement();
            st.executeUpdate("update data1 set balance='"+balance+"' where pin='"+pin+"'" );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
   public boolean check_pin(String pin)
   {
       boolean rt = false;
       try 
        {
            Connection con = DriverManager.getConnection(database_location, username, password);
            System.out.println("you are connected to the database");
            Statement st =  con.createStatement();
         ResultSet rs =    st.executeQuery("select * from data1 where pin= '"+pin+"'");
         if(rs.next())
         {
             rt =  true;
         }
         else
         {
             rt =  false;
         }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       return rt;
   }
   public String get_balance(String pin)
   {
       String balance = null ;
       try 
        {
            Connection con = DriverManager.getConnection(database_location, username, password);
            System.out.println("you are connected to the database");
            Statement st =  con.createStatement();
         ResultSet rs =    st.executeQuery("select balance from data1 where pin= '"+pin+"'");
         if(rs.next())
         {
             balance = rs.getString("balance");
         }
         else
         {
             System.out.println("you entered a wrong pin");
         }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
       return balance;
   }
    
    
    
}

public class ATM_OPERATION {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      new start_page().setVisible(true);
    }

}
