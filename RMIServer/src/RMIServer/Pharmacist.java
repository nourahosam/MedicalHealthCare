/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

/**
 *
 * @author meriam
 */
public class Pharmacist extends User implements UserObserver{
    Account account;

    public Pharmacist() {
    }

    public Pharmacist(String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
    }

    public Pharmacist(String name, String email) {
        super(name, email);
    }
    
    
     @Override
    public void update(String message)
    {
       System.out.println(getName() + " recevied an email that says: " + message);
    }
    
     public void addAccount(Account a)
    {
       this.account=a ;
    }
    
}
