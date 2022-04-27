/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.DoctorMedicalFunctionalities;
import com.mongodb.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.*;
import RMI.*;
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
public class MedicalProfile extends UnicastRemoteObject implements MedicalProInterface, DoctorMedicalFunctionalities {
    private ArrayList<String> drFollowup = new ArrayList();
    private ArrayList<String> chronicDisease = new ArrayList();
    private ArrayList<String> medicines = new ArrayList();
    private String bloodType;
    private ArrayList<Appointment> pastAppointments = new ArrayList();
    private Prescription prescriptions;
    DB db;
    public MedicalProfile() throws RemoteException{
Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
mongoLogger.setLevel(Level.SEVERE);



// Initialize
db = new DB();
db.mongoClient = new MongoClient();
db.database = db.mongoClient.getDatabase("MedicalHealthCare"); // Database name
// db.collection9 = db.database.getCollection("Medicine"); // Collection name
    }
    
    public MedicalProfile( ArrayList<String> drFollowup, ArrayList<String> chronicDisease, ArrayList<String> medicines , 
            String bloodType, ArrayList<Appointment> pastAppointments, Prescription prescriptions) throws RemoteException {
        this.drFollowup = drFollowup;
        this.chronicDisease = chronicDisease;
        this.medicines = medicines;
        this.bloodType = bloodType;
        this.pastAppointments = pastAppointments;
        this.prescriptions = prescriptions;
    }

    public MedicalProfile(String bloodType) throws RemoteException{
        this.bloodType = bloodType;
    }
    
    
    
    public ArrayList<String> getDrFollowup() {
        return drFollowup;
    }

    public void setDrFollowup(ArrayList<String> drFollowup) {
        this.drFollowup = drFollowup;
    }

    public ArrayList<String> getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(ArrayList<String> chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public ArrayList<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<String> medicines) {
        this.medicines = medicines;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public ArrayList<Appointment> getPastAppointments() {
        return pastAppointments;
    }

    public void setPastAppointments(ArrayList<Appointment> pastAppointments) {
        this.pastAppointments = pastAppointments;
    }

    public Prescription getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Prescription prescriptions) {
        this.prescriptions = prescriptions;
    }
    
//           Document ORdoc = db.collection10.find(Filters.eq("ID", id)).first();
//        OperationRoom result =    db.gson.fromJson(ORdoc.toJson(), OperationRoom.class);            
//         Document doc = db.collection1.find(Filters.eq("email", DRmail)).first();
//        Doctor DRresult =    db.gson.fromJson(doc.toJson(), Doctor.class);           
//         result.ReservedDoctor =  DRresult;       
//         Document UpdatedRoom =Document.parse(db.gson.toJson(result));       
//          db.collection10.replaceOne(Filters.eq("ID", id), UpdatedRoom);        
//          return "Room is requested successfully";

    //@Override
    public void uploadMedicalHistory(String chronicDisease,String medicine, String patientName) throws RemoteException{
              Document PatientDoc = db.patientCol.find(Filters.eq("name", patientName)).first();
              System.out.println(PatientDoc);
           //   Patient result =    db.gson.fromJson(PatientDoc.toJson(), Patient.class);    
           //   System.out.println(result);
              
    }

    @Override
    public void reviewMedicalProfile(String pName) throws RemoteException {
 
   //     Document D1 = (Document)db.collection2.find(Filters.eq("name", pName));
        Document PatientDoc = (Document) db.patientCol.find(Filters.eq("name", pName)).first();
          //db.gson.fromJson(PatientDoc.toJson(), Patient.class);

            System.out.println(PatientDoc);

       // return PatientDoc;

        //System.out.println(D1.getn);
        //Document doc = (Document)db.collection2.find(Filters.eq("name",pName));

    }


    //@Override
    public void editMedicalProfile( ArrayList<String> drFollowup, ArrayList<String> chronicDisease, ArrayList<Medicine> medicines , 
            String bloodType, ArrayList<Appointment> pastAppointments, ArrayList<Prescription> prescriptions) throws RemoteException{
        
    }
    
      public void addPrescription(Prescription pres)
    {
       prescriptions = pres;
    }
    
     public void addPastAppointments(Appointment app)
    {
       pastAppointments.add(app);
    }  
     
     public void addMedicines(String med)
    {
       medicines.add(med);
    } 
     
       public void addChronicDiseases(String chronicDiseases)
    {
       chronicDisease.add(chronicDiseases);
    }  
    
      public void adddFollowup(String doctorName)
    {
       drFollowup.add(doctorName);
    } 
     
}
