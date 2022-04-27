/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.PaymentMethod;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;

/**
 *
 * @author noura
 */
public class Cash extends UnicastRemoteObject  implements PaymentMethod{
 DB db ;
    public Cash() throws RemoteException {
        db = new DB();
    }
    
    
  
    @Override
    public String makeAppointmentPayment(String pName, int price, String cardno) throws RemoteException{
        Document dd = new Document("paymentType", "Cash").append("cost", price);
        db.paymentCol.insertOne(dd);
        
        return "Payment Successful.";
    }
    
    @Override
    public String payMedicine(String pName, int price, String cardno) throws RemoteException{
        Document dd = new Document("paymentType", "Cash").append("cost", price);
        db.paymentCol.insertOne(dd);
        
        return "Payment Successful.";
    }
    
}
