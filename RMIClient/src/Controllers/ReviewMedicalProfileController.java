/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import RMI.DoctorMedicalFunctionalities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import RMIClient.*;
import RMI.MedicalProInterface;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author noura
 */
public class ReviewMedicalProfileController {

    ReviewMedicalProfileGUI gui = new ReviewMedicalProfileGUI() ;
    Registry r;

    public ReviewMedicalProfileController() throws RemoteException
    {
            r=LocateRegistry.getRegistry(1099);
            gui.setLocationRelativeTo(null); // This makes the window appears centered
            gui.setVisible(true); // This shows the gui
            ReviewMedicalProfileController gui_controller2 = new ReviewMedicalProfileController(gui, r);
           
    }
    public ReviewMedicalProfileController(ReviewMedicalProfileGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        gui.getjButton3().addActionListener(new reviewMedicalClass());
    }

    class reviewMedicalClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                
                 System.out.println("debug1");
               
                DoctorMedicalFunctionalities re = (DoctorMedicalFunctionalities) r.lookup("DoctorMedicalFunctionalities");
                                 System.out.println("debug1");

                 String name = gui.getjTextField1().getText();
                                 System.out.println("debug1");

                re.reviewMedicalProfile(name);
                
                
               // gui.getjLabel3().setText("h");
                 System.out.println("debug1");

            } catch (RemoteException ex) {

            } catch (NotBoundException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
