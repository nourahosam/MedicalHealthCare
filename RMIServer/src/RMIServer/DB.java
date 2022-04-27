/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author meriam
 */
public class DB {
    
   public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> doctorCol;
   MongoCollection<Document> patientCol;
   MongoCollection<Document> nurseCol;
   MongoCollection<Document> adminCol;
   MongoCollection<Document> accountCol;
   MongoCollection<Document> appointmentCol;
   MongoCollection<Document> inventoryCol;
   MongoCollection<Document> medicalProfileCol;
   MongoCollection<Document> medicineCol;
   MongoCollection<Document> operationRoomCol;
   MongoCollection<Document> orderMedicineCol;
   MongoCollection<Document> paymentCol;
   MongoCollection<Document> pharmacistCol;
   MongoCollection<Document> prescriptionCol;
   MongoCollection<Document> specializationCol;
   // MongoCollection<Document> collection16;
    
     public static Gson gson = new Gson();
    
    
     public DB() 
    {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("MedicalHealthCare"); 
        // Collection for the doctor 
        doctorCol = database.getCollection("Doctor"); 
        //Collection for the Patient
        patientCol = database.getCollection("Patient"); 
        //Collection for the Nurse
        nurseCol = database.getCollection("Nurse"); 
         //Collection for the Admin
        adminCol = database.getCollection("Admin");
        //Collection for the Account
        accountCol = database.getCollection("Account"); 
        //Collection for the Appointment
        appointmentCol = database.getCollection("Appointment");
        //Collection for the Inventory
        inventoryCol = database.getCollection("Inventory"); 
        //Collection for the MedicalProfile
        medicalProfileCol = database.getCollection("MedicalProfile"); 
        //Collection for the Medicine
        medicineCol = database.getCollection("Medicine"); 
        //Collection for the Operation Room
        operationRoomCol = database.getCollection("OperationRoom");
        //Collection for the OrderMedicine
        orderMedicineCol = database.getCollection("OrderMedicine"); 
        //Collection for the Payment
        paymentCol = database.getCollection("Payment"); 
        //Collection for the Pharmacist
        pharmacistCol = database.getCollection("Pharmacist"); 
        //Collection for the Prescription
        prescriptionCol = database.getCollection("Prescription");
        //Collection for the Specializtion
        specializationCol = database.getCollection("Specialization"); 
      
    }
     
      public void insertDoctor(Doctor d) 
    {
        doctorCol.insertOne(Document.parse(gson.toJson(d)));
        System.out.println("Doctor is inserted.");
    }
        
      public void insertPatient(Patient p) 
    {
        patientCol.insertOne(Document.parse(gson.toJson(p)));
        System.out.println("Patient is inserted.");
    } 
    
    
    public void insertNurse(Nurse n) 
    {
        nurseCol.insertOne(Document.parse(gson.toJson(n)));
        System.out.println("Nurse is inserted.");
    } 
    
//    public void insertAdmin(Admin a) 
//    {
//        collection4.insertOne(Document.parse(gson.toJson(a)));
//        System.out.println("Admin is inserted.");
//    } 
    
    
    public void insertAccount(Account a) 
    {
        accountCol.insertOne(Document.parse(gson.toJson(a)));
        System.out.println("Account is inserted.");
    } 
    
     public void insertAppointment(Appointment a) 
    {
        appointmentCol.insertOne(Document.parse(gson.toJson(a)));
        System.out.println("Appointment is inserted.");
    } 
     
     public void insertInventory(Inventory i) 
    {
        inventoryCol.insertOne(Document.parse(gson.toJson(i)));
        System.out.println("Inventory is inserted.");
    } 
     
     public void insertMedicalProfile(MedicalProfile m) 
    {
        medicalProfileCol.insertOne(Document.parse(gson.toJson(m)));
        System.out.println("MedicalProfile is inserted.");
    }
     
     public void insertMedicine(Medicine m) 
    {
        medicineCol.insertOne(Document.parse(gson.toJson(m)));
        System.out.println("Medicine is inserted.");
    } 
     
     public void insertOperationRoom(OperationRoom o) 
    {
        operationRoomCol.insertOne(Document.parse(gson.toJson(o)));
        System.out.println("OperationRoom is inserted.");
    } 
    
     public void insertOrderMedicine(OrderMedicine o) 
    {
        orderMedicineCol.insertOne(Document.parse(gson.toJson(o)));
        System.out.println("OrderMedicine is inserted.");
    }
      
      public void insertPayment(Payment p) 
    {
        paymentCol.insertOne(Document.parse(gson.toJson(p)));
        System.out.println("Payment is inserted.");
    } 
      
      public void insertPharmacist(Pharmacist p) 
    {
        pharmacistCol.insertOne(Document.parse(gson.toJson(p)));
        System.out.println("Pharmacist is inserted.");
    }
      
      public void insertPrescription(Prescription p) 
    {
        Document d1 = new Document("prescription", p.getPrescriptions());
        prescriptionCol.insertOne(Document.parse(gson.toJson(d1)));
        System.out.println("Prescription is inserted.");
    }
      public void insertSpecialization(Specialization s) 
    {
        specializationCol.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Specialization is inserted.");
    }
      
  
       public void close() 
    {
        mongoClient.close();
    }
}
