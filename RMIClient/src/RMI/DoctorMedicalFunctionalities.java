/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.bson.Document;

/**
 *
 * @author Mariam
 */
public interface DoctorMedicalFunctionalities extends Remote {
    
    public void reviewMedicalProfile(String pName)  throws RemoteException;

}

