/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import RMI.AdminInterface;
import RMIClient.UpdateAccount;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author DELL
 */
public class UpdateAccountController extends RemoteException{
     UpdateAccount gui = new UpdateAccount();
     Registry r;
     
       public UpdateAccountController() throws RemoteException
    {
        
            r=LocateRegistry.getRegistry(1099);
            gui.setLocationRelativeTo(null); // This makes the window appears centered
            gui.setVisible(true); // This shows the gui
            UpdateAccountController gui_controller1 = new UpdateAccountController(gui, r);
    }
     
     public UpdateAccountController(UpdateAccount gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        gui.getUpdateButton().addActionListener(new AccountClass() );
    }
        
      class AccountClass implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                
                AdminInterface a = (AdminInterface) r.lookup("AdminInterface");
                
                String username = gui.getUsername().getText();

                String password = gui.getPasswordField().getText();

             


              a.updateAccount(username,password);

                
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                


               gui.getUpdateMessage().setText("Password updated successfully.");

               
            } catch (RemoteException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      }
     
     
     
}
