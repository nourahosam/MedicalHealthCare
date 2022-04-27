/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.MedicineInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author meriam
 */
public class Medicine extends UnicastRemoteObject implements MedicineInterface{
    private String name;
    private String type;
    private String expiredDate;
    private int amountInStock;
    private int price;
    
//    private MongoClient client;
//    private MongoDatabase database;
    
//    private Gson gson = new Gson();
    
//   private MongoClient client = DB.mongoClient;
//   private MongoDatabase database = DB.database;
//   private Gson gson = DB.gson;
//    private MongoCollection<Document> collection;
      DB db ;
      Inventory inv = new Inventory();

      
      public Medicine() throws RemoteException{
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        db = new DB();
        db.mongoClient = new MongoClient();
        db.database = db.mongoClient.getDatabase("MedicalHealthCare"); // Database name
//        db.collection9 = db.database.getCollection("Medicine"); // Collection name
    }

    public Medicine(String name, String type, String expiredDate, int amountInStock, int price)  throws RemoteException  {
        this.name = name;
        this.type = type;
        this.expiredDate = expiredDate;
        this.amountInStock = amountInStock;
        this.price = price;
    }

    public String getName() throws RemoteException{
        return name;
    }

    public void setName(String name)  throws RemoteException{
        this.name = name;
    }

    public String getType() throws RemoteException{
        return type;
    }

    public void setType(String type) throws RemoteException {
        this.type = type;
    }

    public String getExpiredDate() throws RemoteException{
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) throws RemoteException {
        this.expiredDate = expiredDate;
    }

    public int getAmountInStock() throws RemoteException{
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) throws RemoteException{
        this.amountInStock = amountInStock;
    }

    public int getPrice() throws RemoteException{
        return price;
    }

    public void setPrice(int price) throws RemoteException{
        this.price = price;
    }
    
    
    @Override
    public String postMedicine(String name, String type, String expiredDate, int amountInStock, int price) throws RemoteException{
        if(name.length() > 50){
             return "too long name";
        }
        else{
        Medicine newMedicineObject = new Medicine(name,type,expiredDate,amountInStock,price);
        db.medicineCol.insertOne(Document.parse(db.gson.toJson(newMedicineObject)));
        //System.out.println("Medicine Posted!.");
        inv.addMedicine(newMedicineObject);
        return "Medicine is posted successfully!";
        }
    }
    
    @Override
    public void deleteMedicine(String name) throws RemoteException{
       db.medicineCol.deleteOne(Filters.eq("name", name));
    }
    
    @Override
    public void editMedicine(String name,String type, String expiredDate, int amountInStock, int price) throws RemoteException{
       Medicine newMedicineObject = new Medicine(name,type,expiredDate,amountInStock,price);
       Document doc = Document.parse(db.gson.toJson(newMedicineObject));
       db.medicineCol.replaceOne(Filters.eq("name", newMedicineObject.getName()), doc);
           
    }



}
