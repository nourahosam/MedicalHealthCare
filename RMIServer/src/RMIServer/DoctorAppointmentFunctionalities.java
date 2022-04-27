/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import java.rmi.RemoteException;

/**
 *
 * @author Mariam
 */
public interface DoctorAppointmentFunctionalities  {
    
    public void changeAppointment( String timeslot)throws RemoteException;
    
}
