/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import static RMIServer.DB.database;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.bson.Document;
import java.util.*;
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
public class Prescription {

    private String prescriptions;

    DB db;

    public Prescription() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
// Initialize
        db = new DB();
        db.mongoClient = new MongoClient();
        db.database = db.mongoClient.getDatabase("MedicalHealthCare");
        db.patientCol = database.getCollection("Patient"); 
    }

    public Prescription(String prescription) {
        prescriptions = prescription;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
    // FUNCTIONS

    public void uploadPrescription(String x, String pName) throws RemoteException {
        System.out.println("fits");

        Document coll =  (Document)db.patientCol.find(Filters.eq("name", pName)).first();
            System.out.println("two");
        System.out.println(coll);
        Patient pat = db.gson.fromJson(coll.toJson(), Patient.class);
        //db.gson.fromJson(ORdoc.toJson(), OperationRoom.class)
        System.out.println("third");
        MedicalProfile medpro = new MedicalProfile();
        System.out.println("44");
        medpro = pat.getMedicalProfile();
        System.out.println("55");

        String pres = "new pres";
        System.out.println("66");
        prescriptions = pres;
        System.out.println("77");
        medpro.setPrescriptions(this);
        System.out.println("88");
        pat.setMedicalProfile(medpro);
        System.out.println("99");
        Document result = Document.parse(db.gson.toJson(pat));
        System.out.println("processed");
        db.patientCol.replaceOne(Filters.eq("email", pName), result);
        System.out.println("done");

    }

//     public void addPresciption(String prescription)
//    {
//       prescriptions = prescription;
//    } 
}
