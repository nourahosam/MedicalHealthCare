/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import java.util.*;

/**
 *
 * @author meriam
 */
public class OrderMedicine {
    private int amountNeeded;
    private String orderStatus;
    private ArrayList<Medicine> med = new ArrayList();
    private String patientName;
    private Payment payment;

    public OrderMedicine(int amountNeeded, String orderStatus, ArrayList<Medicine> med, String patientName, Payment payment) {
        this.amountNeeded = amountNeeded;
        this.orderStatus = orderStatus;
        this.med = med;
        this.patientName = patientName;
        this.payment = payment;
    }

    public OrderMedicine(int amountNeeded, String orderStatus) {
        this.amountNeeded = amountNeeded;
        this.orderStatus = orderStatus;
       
    }
    
    

    public int getAmountNeeded() {
        return amountNeeded;
    }

    public void setAmountNeeded(int amountNeeded) {
        this.amountNeeded = amountNeeded;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<Medicine> getMed() {
        return med;
    }

    public void setMed(ArrayList<Medicine> med) {
        this.med = med;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    //Functions 
    
    public void orderMedicine(int x, String y){
        
    }
    
    public void checkMedicineAvailability(int x, ArrayList<Medicine> m, String y, Payment z){
        
    }
    public int calculateOrderTotal(){
        return 0;
    }
    
        public void addOrder(Medicine m) 
    {
        med.add(m);
    }
    
     public void addPayment(Payment p)
    {
       this.payment=p ;
    }
}
