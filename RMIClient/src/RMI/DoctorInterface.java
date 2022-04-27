/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import com.mongodb.client.model.Filters;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;

/**
 *
 * @author Mariam
 */
public interface DoctorInterface extends Remote{
      
    
    public void makeRating(int rating, String name) throws RemoteException;
   
    public void viewDoctor(String name) throws RemoteException;
    
    public void editProfile(String name, String levelOfExpertise,  String phonenumber, String email) throws RemoteException;
    
}
