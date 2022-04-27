/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIClient;

import Controllers.CreateAccountController;
import Controllers.DeleteAccountController;
import Controllers.DeleteMedicineController;
import Controllers.EditMedicineController;
import Controllers.LoginController;
import Controllers.PayForAppointController;
import RMI.MedicineDTO;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.MedicineFacadeInterface;
import Controllers.PostMedicineController;
import Controllers.RequestOperationRoomController;
import Controllers.ReviewMedicalProfileController;
import Controllers.UpdateAccountController;
import Controllers.makeDRRatingController;
import RMI.AccountInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author meriam
 */
public class RMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        try {
            
           // System.out.println("here");
        

        
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(1099);
           // System.out.println("here");

                        
                    // We create an object from the GUI window
//            PostMedicineGUI gui = new PostMedicineGUI();
//            gui.setLocationRelativeTo(null); // This makes the window appears centered
//            gui.setVisible(true); // This shows the gui
//            PostMedicineController gui_controller = new PostMedicineController(gui, registry);
//                        System.out.println("here");
//
////
////            UpdateAccount guix = new UpdateAccount();
////            guix.setLocationRelativeTo(null); // This makes the window appears centered
////            guix.setVisible(true); // This shows the gui
////            UpdateAccountController gui_controller1 = new UpdateAccountController(guix, registry);
////          DeleteAccount guib = new DeleteAccount();
////            guib.setLocationRelativeTo(null); // This makes the window appears centered
////            guib.setVisible(true); // This shows the gui
////            DeleteAccountController gui_controller1 = new DeleteAccountController(guib, registry);
//
//         // We create an object from the GUI window
//
//
//         
//         
//         
//
//            CreateAccount guia = new CreateAccount();
//            guia.setLocationRelativeTo(null); // This makes the window appears centered
//            guia.setVisible(false); // This shows the gui
//            CreateAccountController gui_controller1 = new CreateAccountController(guia, registry);
//
//                        System.out.println("here");
//
//
//            
//            RequestOperationRoomGUI gui_op = new RequestOperationRoomGUI();
//            gui_op.setLocationRelativeTo(null); // This makes the window appears centered
//            gui_op.setVisible(false); // This shows the gui
//            RequestOperationRoomController gui_controller_op = new RequestOperationRoomController(gui_op, registry);
//                        System.out.println("here");



            
//            RequestOperationRoomGUI gui_op = new RequestOperationRoomGUI();
//            gui_op.setLocationRelativeTo(null); // This makes the window appears centered
//            gui_op.setVisible(false); // This shows the gui
//            RequestOperationRoomController gui_controller_op = new RequestOperationRoomController(gui_op, registry);
//                        System.out.println("here");
//
//
//            EditMedicineGUI EditMedgui = new EditMedicineGUI();
//            EditMedgui.setLocationRelativeTo(null); // This makes the window appears centered
//            EditMedgui.setVisible(false); // This shows the gui
//            EditMedicineController EditMedgui_controller = new EditMedicineController(EditMedgui, registry);
//                      System.out.println("here");

            
                        
//
//            DeleteMedicineGUI DeleteMedgui = new DeleteMedicineGUI();
//            DeleteMedgui.setLocationRelativeTo(null); // This makes the window appears centered
//            DeleteMedgui.setVisible(false); // This shows the gui
//            DeleteMedicineController DeleteMedgui_controller = new DeleteMedicineController(DeleteMedgui, registry);
//                        System.out.println("here");

//            
//            makeDRRatingGUI makeRatingGUI = new makeDRRatingGUI();
//            makeRatingGUI.setLocationRelativeTo(null); // This makes the window appears centered
//            makeRatingGUI.setVisible(false); // This shows the gui
//            makeDRRatingController makeDRRating_Controller = new makeDRRatingController(makeRatingGUI, registry);
          
                        
//            ReviewMedicalProfileGUI ReviewMedicalProfile = new ReviewMedicalProfileGUI();
//            ReviewMedicalProfile.setLocationRelativeTo(null); // This makes the window appears centered
//            ReviewMedicalProfile.setVisible(false); // This shows the gui
//            ReviewMedicalProfileController ReviewMedicalProfile_cont = new ReviewMedicalProfileController(ReviewMedicalProfile, registry);
//          
//            PayForAppoint PayForAppointGUI = new PayForAppoint();
//            PayForAppointGUI.setLocationRelativeTo(null); // This makes the window appears centered
//            PayForAppointGUI.setVisible(false); // This shows the gui
//            PayForAppointController PayForAppoint_controller = new PayForAppointController(PayForAppointGUI, registry);
            
//
//
//            EditMedicineGUI EditMedgui = new EditMedicineGUI();
//            EditMedgui.setLocationRelativeTo(null); // This makes the window appears centered
//            EditMedgui.setVisible(false); // This shows the gui
//            EditMedicineController EditMedgui_controller = new EditMedicineController(EditMedgui, registry);
//                      System.out.println("here");
//
//            
//                        
//
//            DeleteMedicineGUI DeleteMedgui = new DeleteMedicineGUI();
//            DeleteMedgui.setLocationRelativeTo(null); // This makes the window appears centered
//            DeleteMedgui.setVisible(false); // This shows the gui
//            DeleteMedicineController DeleteMedgui_controller = new DeleteMedicineController(DeleteMedgui, registry);
//                        System.out.println("here");
//
//            
//            makeDRRatingGUI makeRatingGUI = new makeDRRatingGUI();
//            makeRatingGUI.setLocationRelativeTo(null); // This makes the window appears centered
//            makeRatingGUI.setVisible(true); // This shows the gui
//            makeDRRatingController makeDRRating_Controller = new makeDRRatingController(makeRatingGUI, registry);



//          
            Login login2 = new Login();
            login2.setLocationRelativeTo(null); 
            login2.setVisible(true); // This shows the gui
            LoginController Accountinf = new LoginController(login2, registry);

            
            
//  MedicineFacadeInterface f = (MedicineFacadeInterface) registry.lookup("fac");



            
            
       //    f.SetMedicineData("s ", "s ", " s",2,3);
      //     MedicineDTO c= f.getMedicine();
         //  System.out.println("Medicine name "+c.getName());
            
           
        } catch (Exception ex) {
            System.out.println("Exception occured");
        }
        
        
    }
    
}
