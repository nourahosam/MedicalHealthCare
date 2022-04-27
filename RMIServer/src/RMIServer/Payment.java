/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.PaymentMethod;

/**
 *
 * @author meriam
 */
public class Payment  {
    private String paymentType;
    private PaymentMethod p;
    private int cost;

    public Payment(String paymentMethod, PaymentMethod p, int cost) {
        this.paymentType = paymentMethod;
        this.p = p;
        this.cost = cost;
    }

    public Payment(String paymentMethod, int cost) {
        this.paymentType = paymentMethod;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    

    public String getPaymentMethod() {
        return paymentType;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentType = paymentMethod;
    }

    public PaymentMethod getP() {
        return p;
    }

    public void setP(PaymentMethod p) {
        this.p = p;
    }
    
    //FUNCTIONS
    
    public String refund(){
        return "Your money is refunded in your visa";
    }
    
    
    public void makeAppointmentPayment(String paymentType){
        if ( paymentType == "cash"){
            
        }
        else if (paymentType == "visa"){
            
        }
    }
    
      public void payMedicine(String paymentType){
        if ( paymentType == "cash"){
            
        }
        else if (paymentType == "visa"){
            
        }
    }
    
    
}
