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
import RMIClient.CreateAccount;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Toumie
 */
public class CreateAccountController extends RemoteException{
    CreateAccount gui =new CreateAccount();
    Registry r;
    
   public CreateAccountController() throws RemoteException
   {
       
            r=LocateRegistry.getRegistry(1099);
            gui.setLocationRelativeTo(null); // This makes the window appears centered
            gui.setVisible(true); // This shows the gui
            CreateAccountController gui_controller1 = new CreateAccountController(gui, r);
   }
     public CreateAccountController(CreateAccount gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        gui.getCreateButton().addActionListener(new AccountClass() );
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

                String accountType = gui.getAccountType().getText();


              a.createAccount(username,password,accountType);

                
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                


               gui.getAccountAddedMessage().setText("Account added successfully.");

               
            } catch (RemoteException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      }
    
}
