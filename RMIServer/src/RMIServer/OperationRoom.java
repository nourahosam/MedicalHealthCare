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
import RMI.MedicineInterface;
import RMI.OperationRoomInterface;
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

public class OperationRoom  extends UnicastRemoteObject implements OperationRoomInterface{
    private int ID;
    private char Type;
    private Doctor ReservedDoctor; 

    DB db;
    public OperationRoom()throws RemoteException{
                // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
       db = new DB();
       db.mongoClient = new MongoClient();
        db.database = db.mongoClient.getDatabase("MedicalHealthCare"); // Database name
    }
    
    
  public OperationRoom(int ID, char Type)  throws RemoteException{
        this.ID = ID;
        this.Type = Type;
    }

    public OperationRoom(int ID, char Type, Doctor ReservedDoctor) throws RemoteException {
        this.ID = ID;
        this.Type = Type;
        this.ReservedDoctor = ReservedDoctor;
    }

    public int getID() throws RemoteException{
        return ID;
    }

    public void setID(int ID)throws RemoteException {
        this.ID = ID;
    }

    public char getType() throws RemoteException{
        return Type;
    }

    public void setType(char Type) throws RemoteException{
        this.Type = Type;
    }

    public Doctor getReservedDoctor()throws RemoteException {
        return ReservedDoctor;
    }

    public void setReservedDoctor(Doctor ReservedDoctor)throws RemoteException {
        this.ReservedDoctor = ReservedDoctor;
    }
    
//        public Student getStudentByMail(String email) {
//        Document doc = collection.find(Filters.eq("email", email)).first();
//        Student result = gson.fromJson(doc.toJson(), Student.class);
//        return result;
//    }


    
    @Override
    public String RequestOperationRoom(int id, char type,String DRmail)throws RemoteException{
               
        Document ORdoc = db.operationRoomCol.find(Filters.eq("ID", id)).first();
        OperationRoom result =    db.gson.fromJson(ORdoc.toJson(), OperationRoom.class);            
         Document doc = db.doctorCol.find(Filters.eq("email", DRmail)).first();
        Doctor DRresult =    db.gson.fromJson(doc.toJson(), Doctor.class);           
         result.ReservedDoctor =  DRresult;       
         Document UpdatedRoom =Document.parse(db.gson.toJson(result));       
          db.operationRoomCol.replaceOne(Filters.eq("ID", id), UpdatedRoom);        
          return "Room is requested successfully";
          
    }
    
       public void addDoctor(Doctor d)throws RemoteException
    {
       this.ReservedDoctor=d ;
    }
    
}