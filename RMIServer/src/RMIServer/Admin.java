/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import static RMIServer.DB.gson;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author meriam
 */
public class Admin extends User implements AdminSubject{
    private int id;
    private static Admin admin;
    private Account account;
    private ArrayList<UserObserver> observers = new ArrayList();
 
    DB db;
    private Admin() 
    {

    
        admin= new Admin(1,"Morad Ossman","0123434343","19/2/1992","MoradF2@yahoo.com");
       
    }

    private Admin(int id, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.id = id;
    }

  
         public void insertAdmin(Admin a) 
    {
        db= new DB();
        db.adminCol.insertOne(Document.parse(gson.toJson(a)));
        System.out.println("Admin is inserted.");
    }  
         
   public static Admin getInstance()
    {
        if ( admin == null )
        {
            admin = new Admin();
        }
        return admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
   
     public void addAccount(Account a)
    {
       this.account=a ;
    }
     
    public void SendNotification(String message)
    {
        System.out.println("Getting Messages...");
       notifyAll(message);
    }
    
     
    @Override
    public void addObserver(UserObserver o) 
    {
        observers.add(o);
    }
    
    @Override
    public void removeObserver(UserObserver o)
    {
        observers.remove(o);
    }
    
    @Override
    public void notifyAll(String message)
    {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(message);
        }
    }
    
     
}
