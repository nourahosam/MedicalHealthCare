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
import RMI.NotifyInterface;
import RMIClient.Login;
import RMIClient.NotifyAll;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author Toumie
 */
public class NotifyAllController extends RemoteException{
    NotifyAll gui = new NotifyAll();
    Registry r;
    
      public NotifyAllController(NotifyAll gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        gui.getSendButton().addActionListener(new AccountClass() );
    }
        
      public NotifyAllController() throws RemoteException
    {
            r=LocateRegistry.getRegistry(1099);
            gui.setLocationRelativeTo(null); // This makes the window appears centered
            gui.setVisible(true); // This shows the gui
            NotifyAllController gui_controller1 = new NotifyAllController(gui, r);
    }
      class AccountClass implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                
                NotifyInterface a = (NotifyInterface) r.lookup("NotifyInterface");
                
                String message = gui.getMessage().getText();

                  a.notifyAll(message);

                
              
            }
    
    catch (RemoteException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
        }
      }
}
