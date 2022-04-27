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
import RMIServer.Doctor;
import java.util.*;


public class Specialization {
    private String Name;
    private ArrayList<Doctor> Doc = new ArrayList();

    public Specialization() {
    }

    public Specialization(String Name) {
        this.Name = Name;
    }

    
    public Specialization(String Name, ArrayList<Doctor> Doc) {
        this.Name = Name;
        this.Doc = Doc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Doctor> getDoc() {
        return Doc;
    }

    public void setDoc(ArrayList<Doctor> Doc) {
        this.Doc = Doc;
    }
    
     public void addDoctor(Doctor doc) {
        Doc.add(doc);
    }
    
    
}
