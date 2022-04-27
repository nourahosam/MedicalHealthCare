/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

//import RMIServer.PaymentMethod;

/**
 *
 * @author noura
 */
import RMI.PaymentMethod;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
public class Visa extends UnicastRemoteObject  implements PaymentMethod {
DB db ;
    public Visa() throws RemoteException {
      db  = new DB();
    }
    
    
    @Override
    public String makeAppointmentPayment(String pName, int price, String cardno) throws RemoteException{
        //Document patdoc = (Document)db.collection2.find(Filters.eq("name", pName));
        //Patient patient = db.gson.fromJson(patdoc.toJson(), Patient.class);
        //OrderMedicine order = patient.getOrder();
        //PaymentMethod p = new Visa();
        Document dd = new Document("paymentType", "Visa").append("cost", price);
        db.paymentCol.insertOne(dd);
        
        return "Payment Successful.";
    }
    
    @Override
    public String  payMedicine(String pName, int price, String cardno) throws RemoteException{
        Document dd = new Document("paymentType", "Visa").append("cost", price);
        db.paymentCol.insertOne(dd);
        
        return "Payment Successful.";
    }
}
