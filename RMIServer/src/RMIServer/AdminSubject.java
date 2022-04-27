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
public interface AdminSubject {
    
    public void addObserver( UserObserver p);
    
    public void removeObserver(UserObserver m);
    
    public void notifyAll(String s);
    
     
    
}
