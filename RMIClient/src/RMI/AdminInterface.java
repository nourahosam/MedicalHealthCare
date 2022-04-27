/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Toumie
 */
public interface AdminInterface extends Remote{
   public void createAccount(String username, String pass, String accountType) throws RemoteException;
   public void deleteAccount(String username) throws RemoteException;
   public void updateAccount(String username, String pass) throws RemoteException;
    
}
