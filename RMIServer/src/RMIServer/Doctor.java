/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.DoctorMedicalFunctionalities;
import RMI.DoctorInterface;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.bson.Document;
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
public class Doctor extends User implements UserObserver{
    private int rating;
    private String levelOfExpertise;
    private ArrayList<Nurse> nurse = new ArrayList();
    private String timeSlots;
    private Account account;
    private DoctorAppointmentFunctionalities doctorAppointmentFunctionalities;
    private DoctorMedicalFunctionalities doctorMedicalFunctionalities;
    private int price;
    
    DB db ; 
    
    public Doctor() throws RemoteException {
        db=new DB();
        db.mongoClient = new MongoClient();
        db.database = db.mongoClient.getDatabase("MedicalHealthCare");

     }

    public Doctor(int rating, String levelOfExpertise, Account account, DoctorAppointmentFunctionalities doctorAppointmentFunctionalities, DoctorMedicalFunctionalities doctorMedicalFunctionalities, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.rating = rating;
        this.levelOfExpertise = levelOfExpertise;
        this.account = account;
        this.doctorAppointmentFunctionalities = doctorAppointmentFunctionalities;
        this.doctorMedicalFunctionalities = doctorMedicalFunctionalities;
    }

    public Doctor(String name, String email) {
        super(name, email);
    }

    public Doctor(int rating, String levelOfExpertise, String timeSlots, int price, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.rating = rating;
        this.levelOfExpertise = levelOfExpertise;
        this.timeSlots = timeSlots;
        this.price = price;
    }

 
  

    public Doctor(int rating, String levelOfExpertise, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.rating = rating;
        this.levelOfExpertise = levelOfExpertise;
    }

    public Doctor(String name, String levelOfExpertise,  String phonenumber, String email) {
        super(name, phonenumber, email);
        this.levelOfExpertise = levelOfExpertise;
        
    }

    public Doctor(int rating, String name) {
        super(name);
        this.rating = rating;
    }
    
    public Doctor(int rating, String levelOfExpertise, String name, String phonenumber, String birthdate, String email,int price) {
        super(name, phonenumber, birthdate, email);
        this.rating = rating;
        this.levelOfExpertise = levelOfExpertise;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(String levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public ArrayList<Nurse> getNurse() {
        return nurse;
    }

    public void setNurse(ArrayList<Nurse> nurse) {
        this.nurse = nurse;
    }

    public String getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String timeSlots) {
        this.timeSlots = timeSlots;
    }

 
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    

    

    
     @Override
    public void update(String message)
    {
       System.out.println(getName() + " recevied an email that says: " + message);
    }
    
     public void addNurses(Nurse n) 
     {
        nurse.add(n);
    }
        

       
//      public void adddTimeslots(String timeslots)
//    {
//       timeSlots.add(timeslots);
//    }  
    
     public void addAccount(Account a)
    {
       this.account=a ;
    }
     

    public  Doctor getDrByName(String name){
//                Document doc = collection.find(Filters.eq("email", email)).first();
//        Student result = gson.fromJson(doc.toJson(), Student.class);
//        return result;
                    Document doc = db.doctorCol.find(Filters.eq("name", name)).first();
                    Doctor result = db.gson.fromJson(doc.toJson(), Doctor.class);
                    return result;
    }

     
//     public Doctor findDrByName(String name){
//         for (){
//             
//         }
//         return null;
//     }

}
