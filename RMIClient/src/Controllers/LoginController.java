/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import RMI.AccountInterface;
import RMI.AdminInterface;
import RMIClient.Login;
import RMIClient.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meriam
 */
public class LoginController extends RemoteException{
    Login login = new Login();
    Registry r;
    
    public LoginController ()throws RemoteException
    {
            r=LocateRegistry.getRegistry(1099);
            login.setLocationRelativeTo(null); // This makes the window appears centered
            login.setVisible(true); // This shows the gui
            LoginController gui_controller1 = new LoginController(login, r);
    
    }
    
    public LoginController(Login login, Registry r)
    {
        this.login = login;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        login.getloginButton().addActionListener(new AccountClass() );
    }
        
    
      class AccountClass implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                
                AccountInterface a = (AccountInterface) r.lookup("AccountInterface");
                
                String username = login.getUsername().getText();

                String password = login.getPasswordField().getText();

            Boolean r=false;
            r = a.login(username,password);
                if (r == true )
                {
                    Users u = new Users ();
                    u.setVisible(true);
                    login.setVisible(false);
                    System.out.println("Login is Success");
                    
                }
                   
                else
                {
                    System.err.println("Username or password is wrong");
                   
                }
                
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                


             // login.

               
            } catch (RemoteException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      }
}
