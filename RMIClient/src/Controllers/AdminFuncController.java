/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import RMIClient.AdminFunc;
import RMIClient.CreateAccount;
import RMIClient.UpdateAccount;
import RMIClient.DeleteAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;

/**
 *
 * @author Toumie
 */
public class AdminFuncController {
    
    AdminFunc gui;
    Registry r;
    
   
     public AdminFuncController(AdminFunc gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        gui.getCreateAccountButton().addActionListener(new Account1Class() );
//        gui.getUpdateAccountButton().addActionListener(new Account2Class() );
//        gui.getDeleteAccountButton().addActionListener(new Account3Class() );
//        gui.getNotifyAllButton().addActionListener(new Account4Class() );
    }
    class Account1Class implements ActionListener {
      @Override
        public void actionPerformed(ActionEvent ae) {
          CreateAccount itemloader =new CreateAccount();
          itemloader.setVisible(true);
          gui.setVisible(false);
        
        }
    }
}
