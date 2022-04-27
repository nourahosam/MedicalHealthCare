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


public class Patient extends User implements UserObserver {

  private ArrayList<Appointment> comingAppointments = new ArrayList();
  private MedicalProfile medicalProfile;
  private String medicalInsurance;
  private String creditCardNumber;
  private String address;
  private OrderMedicine order;
  private Account a;
  private int amountOfMoney;

    public Patient() {
    }

    public Patient(ArrayList<Appointment> comingAppointments, MedicalProfile medicalProfile, String medicalInsurance, String creditCardNumber, String address, OrderMedicine order, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.comingAppointments = comingAppointments;
        this.medicalProfile = medicalProfile;
        this.medicalInsurance = medicalInsurance;
        this.creditCardNumber = creditCardNumber;
        this.address = address;
        this.order = order;
       
    }

    public Patient(String medicalInsurance, String creditCardNumber, String address, OrderMedicine order, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.medicalInsurance = medicalInsurance;
        this.creditCardNumber = creditCardNumber;
        this.address = address;
        this.order = order;
    }

    public Patient(String name, String email) {
        super(name, email);
    }

    public Patient(String medicalInsurance, String creditCardNumber, String address, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.medicalInsurance = medicalInsurance;
        this.creditCardNumber = creditCardNumber;
        this.address = address;
    }

   
    public Patient(String medicalInsurance, String creditCardNumber, String address, int amount, String name, String phonenumber, String birthdate, String email) {
        super(name, phonenumber, birthdate, email);
        this.medicalInsurance = medicalInsurance;
        this.creditCardNumber = creditCardNumber;
        this.address = address;
        this.amountOfMoney = amount;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
    
    
    public ArrayList<Appointment> getComingAppointments() {
        return comingAppointments;
    }

    public void setComingAppointments(ArrayList<Appointment> comingAppointments) {
        this.comingAppointments = comingAppointments;
    }

    public MedicalProfile getMedicalProfile() {
        return medicalProfile;
    }

    public void setMedicalProfile(MedicalProfile medicalProfile) {
        this.medicalProfile = medicalProfile;
    }

    public String getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(String medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderMedicine getOrder() {
        return order;
    }

    public void setOrder(OrderMedicine order) {
        this.order = order;
    }

   


     
    @Override
    public void update(String message)
    {
       System.out.println(getName() + " recevied an email that says: " + message);
    }
 
    
     public void addAppointments(Appointment a) 
     
    {
        comingAppointments.add(a);
    }
       
//    public void addOrder(OrderMedicine o) {
//        ordeMedicines.add(o);
//    }
    
    public void addAccount(Account a)
    {
       this.a=a ;
    }
   
      public void addMedicalProfile(MedicalProfile medprof)
    {
       this.medicalProfile=medprof ;
    }
}
