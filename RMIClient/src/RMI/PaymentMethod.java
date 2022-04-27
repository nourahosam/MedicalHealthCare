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
 * @author noura
 */
public interface PaymentMethod extends Remote{
    
    public String makeAppointmentPayment(String pName, int price, String cardno) throws RemoteException;
    public String  payMedicine(String pName, int price, String cardno) throws RemoteException;
    
}
