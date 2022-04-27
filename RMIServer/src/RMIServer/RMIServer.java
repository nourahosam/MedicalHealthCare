/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.AccountInterface;
import RMI.AdminInterface;
import RMI.DoctorInterface;
import RMI.DoctorMedicalFunctionalities;
import RMI.MedicineInterface;
import RMI.MedicineFacadeInterface;
import RMI.NotifyInterface;
import RMI.OperationRoomInterface;
import RMI.PaymentMethod;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.AlreadyBoundException;
import org.bson.Document;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sun.security.jca.GetInstance;
/**
 *
 * @author meriam
 */
public class RMIServer {

    /**
     * @param args the command line arguments
     */
    
       static Nurse n1 ;
       static Nurse n2;
       static Inventory Inv;
       static Medicine med1;
       static Medicine med2;
       static Medicine med3;
       static  Account acc1;
       static  Account acc2;
       static  Account acc3;
       static  Account acc4;
       static  Account acc5;
       static  Account acc6;
       static  Account acc7;
       static  Account acc8;
       static Account acc9;
       static  Prescription pres1;
       static  Prescription pres2;
       static Patient p1;
       static Patient p2;
       static Appointment a1;
       static Appointment a2;
       static Appointment a3;
       static Appointment a4;
       static  Doctor doc1;
       static  Doctor doc2;     
       static Doctor doc3;
       static  Doctor doc4;
       static  Doctor doc5;     
       static Doctor doc6;
       static  MedicalProfile prof1;
       static  MedicalProfile prof2;
       static  Payment pay1;
       static  Payment pay2;
       static  OrderMedicine o1;
       static  Pharmacist pharma1;
       static  Pharmacist pharma2;
       static  OperationRoom or1;
       static  OperationRoom or2;
       static  Admin ad;
       static  Specialization spe1;
       static Specialization spe2;
       
    public static void main(String[] args)   throws RemoteException, AlreadyBoundException{
  
        
        try {

                    
                    
           Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
           mongoLogger.setLevel(Level.SEVERE);
           
            Registry registry = LocateRegistry.createRegistry(1099);
           
           //Calling the class for the database 
           DB db = new DB();
           PaymentMethod PaymentMethod1 = new Visa();
           PaymentMethod PaymentMethod2 = new Cash();
           
            AdminInterface adminInterface = new Account();     
        
            registry.bind("AdminInterface", adminInterface);          
            

            AccountInterface accountInter = new Account();     
            registry.bind("AccountInterface", accountInter);  
            
             registry.bind("visa", PaymentMethod1);  
             registry.bind("cash", PaymentMethod2);  
            
//            MedicineInterface medicineinterface = new Medicine();     
//            // My RMI Registry
//            Registry registry = LocateRegistry.createRegistry(1099);
//            registry.bind("MedicineInterface", medicineinterface);
//            medicineinterface.postMedicine("pp", "Cream", "900-", 90, 35);
//            System.out.println("medicine posted");
//            
//            OperationRoom room = new OperationRoom();
//            room.RequestOperationRoom(1, 'A', "Dr.Farida Magdy");
//            System.out.println("room requested");
//            

//            MedicineInterface medicineinterface = new Medicine();     
//            // My RMI Registry
//            Registry registry = LocateRegistry.createRegistry(1099);
//            registry.bind("MedicineInterface", medicineinterface);
//            medicineinterface.postMedicine("pp", "Cream", "900-", 90, 35);
//            System.out.println("medicine posted");
//            
//            OperationRoom room = new OperationRoom();
//            room.RequestOperationRoom(1, 'C', "Dr.Farida Magdy");
//            System.out.println("room requested");
//            
           
            MedicineInterface medicineinterface = new Medicine();     
            OperationRoomInterface operationRoomInterface= new OperationRoom();
            DoctorInterface DoctorInterface = new Appointment() ;
            DoctorMedicalFunctionalities DoctorMedicalFunctionalities = new MedicalProfile();
         //   NotifyInterface notifyInterface = new Admin GetInstance();
            // My RMI Registry
            //Registry registry = LocateRegistry.createRegistry(1099);
            
            
            registry.bind("MedicineInterface", medicineinterface);
            medicineinterface.postMedicine("cc", "Cream", "900-", 90, 35);
            System.out.println("medicine posted");
            
            registry.bind("operationRoomInterface", operationRoomInterface);
             registry.bind("DoctorInterface", DoctorInterface);
             // registry.bind("NotifyInterface", notifyInterface);
               registry.bind("DoctorMedicalFunctionalities", DoctorMedicalFunctionalities);
            
          //  OperationRoom room = new OperationRoom();
           // room.RequestOperationRoom(1, 'C', "Dr.Farida Magdy");
           // System.out.println("room requested");
            
        //   Cash cashh = new Cash();
     //     System.out.println(cashh.payMedicine());
     
     
 

            Inv = new Inventory();
           
            med1 =  new Medicine("fucidine","cream","23/10/2022",100,25);
            med2 =  new Medicine("fucicort","cream","23/10/2023",150,30);
            med3 =  new Medicine("Meglitinides","Tablets","22/10/2023",95,35);
            
            db.insertMedicine(med1);
            db.insertMedicine(med2);
            db.insertMedicine(med3);
            
            Inv.addMedicine(med1);
            Inv.addMedicine(med2);
            Inv.addMedicine(med3);
            
            db.insertInventory(Inv);
            
            acc1 = new Account("Hossam","1234","Patient");
            acc2 = new Account("Amira","0987","Patient");
            acc3 = new Account("Marina","3456","Nurse");
            acc4 = new Account("Farid","1920","Nurse");
            acc5 = new Account("Farida","5678","Doctor");
            acc6 = new Account("Michael","1095","Doctor");
            acc7 = new Account("Mina","1945","Pharmacist");
            acc8 = new Account("Dalia","3645","Pharmacist");
            acc9 = new Account("Morad","3954","Admin");
           
            db.insertAccount(acc1);
            db.insertAccount(acc2);
            db.insertAccount(acc3);
            db.insertAccount(acc4);
            db.insertAccount(acc5);
            db.insertAccount(acc6);
            db.insertAccount(acc7);
            db.insertAccount(acc8);
            db.insertAccount(acc9);
           
           ad = Admin.getInstance();
            ad.addAccount(acc9);
            ad.insertAdmin(ad);

            n1 = new Nurse("Dr.Farida Magdy","Marina Hany","0158908089","23/12/1990","MarinaH12@gmail.com");
            n2= new Nurse("Dr.Michael Samy","Farid Essam","0121909889","1/12/1993","FaridEss@gmail.com");
            
            n1.addAccount(acc3);
            n2.addAccount(acc4);
            
            db.insertNurse(n1);
            db.insertNurse(n2);
            
            
            pres1= new Prescription();
            pres2= new Prescription();
            
//            pres1.addPresciption("You should take this medicine ");
//            pres2.addPresciption("You should take this medicine ");
            
            db.insertPrescription(pres1);
            db.insertPrescription(pres2);
            
            doc1= new Doctor(5,"Profssor","Sunday from 9 AM",0,"Dr.Farida Magdy","01228473738","12/9/1980","Dr.Farida12@yahoo.com");
            doc2= new Doctor(5,"Doctor","Sunday from 9 AM",0,"Dr.Michael Samy","01236463738","22/4/1980","Dr.Michael_Samy@yahoo.com");
            doc3= new Doctor(5,"Doctor","Sunday from 9 AM",0,"Dr.Samir Ahmed","01236463738","22/4/1980","Dr.samir@yahoo.com");
            doc4= new Doctor(5,"Doctor","Sunday from 9 AM",0,"Dr. Ahmed Osama","01236463738","22/4/1980","Dr.AhOsama@yahoo.com");
            doc5= new Doctor(5,"Doctor","Sunday from 9 AM",0,"Dr. Ahmed Mostafa","01236463738","22/4/1980","Dr.AHMED@yahoo.com");
            doc6= new Doctor(5,"Doctor","Sunday from 9 AM",0,"Dr.Mina Tamer","01236463738","22/4/1980","Dr.Mina@yahoo.com");
            
            doc1= new Doctor(5,"Profssor","Dr.Farida Magdy","01228473738","12/9/1980","Dr.Farida12@yahoo.com");
            doc2= new Doctor(5,"Doctor","Dr.Michael Samy","01236463738","22/4/1980","Dr.Michael_Samy@yahoo.com");
            doc3= new Doctor(5,"Doctor","Dr.Samir Ahmed","01236463738","22/4/1980","Dr.samir@yahoo.com");
            doc4= new Doctor(5,"Doctor","Dr. Ahmed Osama","01236463738","22/4/1980","Dr.AhOsama@yahoo.com",100);
            doc5= new Doctor(5,"Doctor","Dr. Ahmed Mostafa","01236463738","22/4/1980","Dr.AHMED@yahoo.com",200);
            doc6= new Doctor(5,"Doctor","Dr.Mina Tamer","01236463738","22/4/1980","Dr.Mina@yahoo.com",300);
                        
            //doc1= new Doctor(5,"Profssor","Sunday from 9 AM to 11 AM",0,"12/9/1980","Dr.Farida12@yahoo.com");
//            doc2= new Doctor(5,"Doctor","Dr.Michael Samy","01236463738","22/4/1980","Dr.Michael_Samy@yahoo.com");
//            doc3= new Doctor(5,"Doctor","Dr.Samir Ahmed","01236463738","22/4/1980","Dr.samir@yahoo.com");
//            doc4= new Doctor(5,"Doctor","Dr. Ahmed Osama","01236463738","22/4/1980","Dr.AhOsama@yahoo.com",100);
//            doc5= new Doctor(5,"Doctor","Dr. Ahmed Mostafa","01236463738","22/4/1980","Dr.AHMED@yahoo.com",200);
//            doc6= new Doctor(5,"Doctor","Dr.Mina Tamer","01236463738","22/4/1980","Dr.Mina@yahoo.com",300);


            doc1.addNurses(n1);
//            doc1.adddTimeslots("Sunday from 9 AM ");
//            doc1.adddTimeslots("Tusday from 1 PM ");
            doc1.addAccount(acc5);
            
            doc2.addNurses(n2);
            doc2.addAccount(acc6);
//            doc2.adddTimeslots("Saturday from 10 AM to 12 PM");
//            doc2.adddTimeslots("Monday from 8 AM to 10 AM");
            

            or1 = new OperationRoom(1,'A',doc1);
            or2= new OperationRoom(2,'C',doc2);

         
            
            db.insertOperationRoom(or1);
            db.insertOperationRoom(or2);
            
            db.insertDoctor(doc1);
            db.insertDoctor(doc2);
            db.insertDoctor(doc3);
            db.insertDoctor(doc4);
            db.insertDoctor(doc5);
            db.insertDoctor(doc6);
            


//        
//            OperationRoom rooom = new OperationRoom();
//            rooom.RequestOperationRoom(1, 'A', "Dr.Mina@yahoo.com");
//            System.out.println("room reuqsted");

        
   //         OperationRoom rooom = new OperationRoom();
    //        rooom.RequestOperationRoom(1, 'A', "Dr.Mina@yahoo.com");
   //         System.out.println("room reuqsted");

            
            spe1 = new Specialization("Dermatologists");
            spe2 = new Specialization("Ophthalmologists");
            
            spe1.addDoctor(doc1);
            spe2.addDoctor(doc2);
            
            db.insertSpecialization(spe1);
            db.insertSpecialization(spe2);
            
            pay1= new Payment("Visa",2300);
            pay2= new Payment("Cash",12);
            
            db.insertPayment(pay1);
            db.insertPayment(pay2);
            
            a1 = new Appointment("1/2/2019 Monday at 9 am");
            a2 = new Appointment("12/2/2021 tusday at 1 pm");
            a3 = new Appointment("20/1/2021 Saturday at 11 am");
            a4 = new Appointment("21/4/2018a Sunday at 8 pm");
 
            a1.addPayment(pay1);
            a3.addPayment(pay1);
            a2.addPayment(pay2);
            a4.addPayment(pay2);
           
            db.insertAppointment(a1);
            db.insertAppointment(a2);
            db.insertAppointment(a3);
            db.insertAppointment(a4);
            
            prof1 = new MedicalProfile("A+");
            prof2 = new MedicalProfile("AB+");
            
            prof1.addChronicDiseases("Diabetes");
            prof1.addMedicines("fucidine");
            prof1.addPastAppointments(a1);
            prof1.addPrescription(pres1);
            prof1.adddFollowup("Dr.Farida Magdy");
            
            prof2.addChronicDiseases("");
            prof2.addMedicines("fusicosrt");
            prof2.addPastAppointments(a4);
            prof2.addPrescription(pres2);
            prof2.adddFollowup("Dr.Michael Samy");
           
            db.insertMedicalProfile(prof1);
            db.insertMedicalProfile(prof2);
            
            o1= new OrderMedicine(1, "Arrived");
            
            o1.addOrder(med2);
            o1.addPayment(pay2);
            
            db.insertOrderMedicine(o1);
            
            p1 = new Patient("25673","234-456-329","167 Masr el gedida",o1,"Hossam Amr","012275767464","12/7/1960","Hossam23@yahoo.com");
            p2 = new Patient("","908-543-094","90 El Giza","Amira Mostafa","01564545444","09/8/1970","Amira21@yahoo.com");
            
            p1.addAppointments(a2);
            //p1.addOrder(o1);
            p1.addAccount(acc1);
            p1.addMedicalProfile(prof1);
      
            p2.addAppointments(a3);
            p2.addMedicalProfile(prof2);
            p2.addAccount(acc2);
           
            
            db.insertPatient(p1);
            db.insertPatient(p2);
            
            pharma1= new Pharmacist("Mina Fady", "012238484949","08/3/1990","Mina@outlook.com");
            pharma2= new Pharmacist("Dalia Samir", "0112364894","10/8/1989","Dalia109@outlook.com");
            
            db.insertPharmacist(pharma1);
            db.insertPharmacist(pharma2);
            
            
                       PaymentMethod p = new Visa();
            System.out.println(p.makeAppointmentPayment("n", 100, "123"));
            

            
//           Patient sub_1 = new Patient("Hossam Amr", "Hossam23@yahoo.com");
//           Doctor sub_2 = new Doctor("Dr.Farida Magdy", "Dr.Farida12@yahoo.com");
//           Nurse sub_3 = new Nurse("Marina Hany","MarinaH12@gmail.com");
//           Pharmacist sub_4 = new Pharmacist("Mina Fady","Dalia109@outlook.com");
//           
//           ad.addObserver(sub_1);
//           ad.addObserver(sub_2);
//           ad.addObserver(sub_3);
//           ad.addObserver(sub_4);
//           
//           ad.SendNotification("Happy feast wish you all best feast.");


   //         Doctor d = new Doctor();
   //         d.viewDoctor("Dr.Michael Samy");
            
   
//   
//            Account a= new Account();
//            a.login("Hossam", "1234");
//            System.out.println("ana henanaanan");



//   MedicalProfile medp = new MedicalProfile();
//   medp.reviewMedicalProfile("Amira Mostafa");






//   
//             MedicalProfile MedicalProfile = new MedicalProfile();
//              MedicalProfile.uploadMedicalHistory("hi", "no", "Amira Mostafa");
//     
//     
   
//             MedicalProfile MedicalProfile = new MedicalProfile();
//              MedicalProfile.uploadMedicalHistory("hi", "no", "Amira Mostafa");
//     
     
     
     
     

//     Medicine meddd =  new Medicine();
//     meddd.editMedicine("fucicort", "c", "1/1/2031", 50, 20);
//    System.out.println("fucicort changed");
    
//            Doctor d = new Doctor();
//            d.viewDoctor("Dr.Michael Samy");
//            
//            Account a= new Account();
//            a.login("Hossam", "1234");

//             
//        




 //           Appointment app = new Appointment();
    //        app.CancelAppointment("20/1/2021 Saturday at 11 am","Hossam Amr");
      
    
    
    
            
//            
//            Account ac = new Account();
//            ac.updateAccount("Marina", "12345marina" );
//            ac.createAccount("Samia", "samia17");
//            ac.deleteAccount("Hossam");

            //Doctor d = new Doctor();
            //d.viewDoctor("Dr.Michael Samy");
             
            
            //Appointment a = new Appointment();
            //a.CancelAppointment("1/2/2019 Monday at 9 am");
            
            
            
//            
//System.out.println("im here");
//ArrayList<String> pres = new ArrayList<String>();
//            System.out.println("222");
//            Prescription p = new Prescription();
//            pres.add("EAt brufen twice a day for 16 days");
//            System.out.println("33");
//            p.uploadPrescription(pres, p1.getName());
//            System.out.println("end");
//            
//            ArrayList<String> pres2 = new ArrayList<String>();
//            Prescription p2 = new Prescription();
//            pres2.add("sleep");
//            p2.uploadPrescription(pres2, p1.getName());
//            System.out.println("end");
            
            


    //        MedicineInterface medicineinterface = new Medicine();
            //Doctor d = new Doctor();
//            d.editProfile("Dr.Michael Samy","Gamed", "07775000", "gamed@bue.com");
             // d.makeRating(5,"Dr.Michael Samy");
       //     Doctor d = new Doctor();
//            d.editProfile("Dr.Michael Samy","Gamed", "07775000", "gamed@bue.com");
      //        d.makeRating(5,"Dr.Michael Samy");
            
         
            // My remote object [Skeleton]
            MedicineFacadeInterface facade = new MedicineFacade();
            
            // My RMI Registry
            // Registry registry = LocateRegistry.createRegistry(1099);
            
            //Add my object to the RMI Registry
//            registry.bind("facade", facade);
  //          registry.bind("MedicineInterface", medicineinterface);
            
            // medicineinterface.postMedicine("Cream", "mllk", "900-", 90, 35);
            
            
      //      Doctor drr= new Doctor();
      //      drr.makeRating(2, "Dr. Ahmed Osama");
//            MedicalProfile m = new MedicalProfile();
//            m.reviewMedicalProfile("Hossam Amr");
       
            System.out.println("My facade is ready..."); 
            db.close();
        } catch (Exception ex) {
           System.out.println("Exception occured here ");
        }  
    }
    
}
