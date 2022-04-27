/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.DoctorInterface;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author meriam
 */

public class Appointment extends UnicastRemoteObject implements DoctorAppointmentFunctionalities, DoctorInterface{
    private String timeslot;
    private Payment payment;
    
    DB db;
   

    public Appointment()  throws RemoteException{
           Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
mongoLogger.setLevel(Level.SEVERE);



// Initialize
db = new DB();
db.mongoClient = new MongoClient();
db.database = db.mongoClient.getDatabase("MedicalHealthCare"); // Database name
// db.collection9 = db.database.getCollection("Medicine"); // Collection name
    }

    public Appointment(String timeslot, Payment payment)  throws RemoteException{
        this.timeslot = timeslot;
        this.payment = payment;
    }

    public Appointment(String timeslot) throws RemoteException {
        this.timeslot = timeslot;
    }
 
    
    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
    
    public void bookAnAppointment(String timeslot) throws RemoteException 
    {
        Appointment newAppObject = new Appointment (timeslot);
        db.appointmentCol.insertOne(Document.parse(db.gson.toJson(newAppObject)));
        String message = "Your appointment has been booked successfully.";
        sendAppointmentConfirmationNotification(message);
    }
    
    public void CancelAppointment(String timeslot,String PatientName) throws RemoteException
    {
          Document doc = db.patientCol.find(Filters.eq("name", PatientName)).first();
         Patient result = db.gson.fromJson(doc.toJson(), Patient.class);
        for (int i=0; i<result.getComingAppointments().size();i++)
        {
            if (timeslot.equals(result.getComingAppointments().get(i)))
            {
                 
              result.getComingAppointments().remove(i);
            }
           
           db.insertPatient(result);
        }
         
          
         System.out.println("Deleted");
//       Document doc = db.patientCol.find(Filters.eq("commingAppointment", timeslot)).first();
//       Patient result = db.gson.fromJson(doc.toJson(), Patient.class);
//       
//       db.appointmentCol.deleteOne(Filters.eq("timeslot", timeslot));
//       System.out.println("Your appointment has been canceled.");
       // System.out.println(payment.refund());
    }
    
    public void bookThePatientFollowUpAppointment(Patient p, Doctor d, String timeslot)  throws RemoteException{
        //HEREEEE appointmentCol
        Payment pay = new Payment("Cash", new Cash(), 0);
        ArrayList<Appointment> appoint = new ArrayList<Appointment>();
        appoint.add(new Appointment(timeslot, pay));
        db.appointmentCol.insertOne(Document.parse(db.gson.toJson(new Appointment(timeslot))));
        p.setComingAppointments(appoint);
        String message = "Follow-up appointment successfully booked.";
        sendAppointmentConfirmationNotification(message);
    }
    
    @Override
    public void changeAppointment(String timeslot) throws RemoteException
    {
     Appointment newAppObject = new Appointment (timeslot);
                Document doc = Document.parse(db.gson.toJson(newAppObject));
               db.medicineCol.replaceOne(Filters.eq("timeslot", newAppObject.getTimeslot()), doc);
        
    String s= "Your appointment has been updated successfully.";
    sendUpdateInAppointmentDetailsNotification(s); 
    }
    
    public void sendUpdateInAppointmentDetailsNotification(String s)
    {
     System.out.println("Your appointment has been updated successfully.");
    }
    public void sendAppointmentConfirmationNotification(String message)
    {
     System.out.println("Your appointment has been booked successfully.");
    }

     public void addPayment(Payment p)
    {
       this.payment=p ;
    }

     
         @Override
    public void makeRating(int rating, String name) throws RemoteException{
//                Doctor newDocObject = new Doctor(rating, name);
//                Document doc = Document.parse(db.gson.toJson(newDocObject));
//                db.doctorCol.replaceOne(Filters.eq("name", newDocObject.getName()), doc);
                Document doc = db.doctorCol.find(Filters.eq("name", name)).first();
                Doctor DRresult =    db.gson.fromJson(doc.toJson(), Doctor.class);  
                DRresult.setRating((DRresult.getRating()+rating)/2);
                Document UpdatedDoc =Document.parse(db.gson.toJson(DRresult));       
                 db.doctorCol.replaceOne(Filters.eq("name", name), UpdatedDoc);     
                System.out.println("The rating has been Saved.");
    }
    
//    public void viewDoctor(String name) throws RemoteException {
//        
//       Document Result =(Document)db.doctorCol.find(Filters.eq("name",name)).;
//       System.out.println(Result);
//       
    @Override
    public void viewDoctor(String name) throws RemoteException {
     
       Document doc = db.doctorCol.find(Filters.eq("name", name)).first();
        System.out.println(doc);
    }       
//       db.doctorCol.find({​​​​​​​"name": name}​​​​​​​).forEach(printjson);
        
//     ArrayList<Doctor> result = new ArrayList();
//     ArrayList<Document> docs = db.doctorCol.find(Filters.all("name",name)).into(new ArrayList<Document>());
//     for (int i =0; i<docs.size(); i++)
//     {
//         result.add(db.gson.fromJson(docs.get(i).toJson(), Doctor.class));
//     }
//         return result;
//    }
    
    @Override
    public void editProfile(String name, String levelOfExpertise,  String phonenumber, String email) throws RemoteException{
                Doctor newDocObject = new Doctor(name, levelOfExpertise, phonenumber, email);
                Document doc = Document.parse(db.gson.toJson(newDocObject));
               db.doctorCol.replaceOne(Filters.eq("name", newDocObject.getName()), doc);
               System.out.println("The Profile has been updated.");
    }
}
