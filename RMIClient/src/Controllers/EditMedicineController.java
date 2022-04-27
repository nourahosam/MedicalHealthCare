package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import RMI.MedicineInterface;
import RMIClient.EditMedicineGUI;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Mariam
 */
public class EditMedicineController extends RemoteException{
        // We have reference to both the GUI and the rmi registry
    EditMedicineGUI gui = new EditMedicineGUI();
    Registry r;
    
    public EditMedicineController() throws RemoteException
    {
           r=LocateRegistry.getRegistry(1099);
           gui.setLocationRelativeTo(null); // This makes the window appears centered
           gui.setVisible(true); // This shows the gui
           EditMedicineController gui_controller1 = new EditMedicineController(gui, r);
    
    }
    
    // The constructor takes the gui and the rmi registry as paramaters
    public EditMedicineController(EditMedicineGUI gui, Registry r)
    {
       
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
       

 gui.getjButton1().addActionListener(new postMedicineClass() );
    }
        
            // This class is responsible for handling the button click
       class postMedicineClass implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                
                MedicineInterface p = (MedicineInterface) r.lookup("MedicineInterface");

                
                // Get the grade (in numbers) as it is written inside the text field
                // Please note that we are able to interact with the gui elements through
                // the getters that we have set up earlier
                
                // Also we are parsing to int below because by default, the text field
                // will return a string
                
                
                String name = gui.getjTextField1().getText();

                String type = gui.getjTextField4().getText();

                 String expiredDate = gui.getjTextField2().getText();

                int amount = Integer.parseInt(gui.getjTextField5().getText());

                int price = Integer.parseInt(gui.getjTextField3().getText());


                
                // Once we have the grade as numbers, we can pass it to the remote
                // function getGrade using our remote reference g
               
                

              p.editMedicine(name,type,expiredDate,amount,price);

                
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                


               gui.getjLabel7().setText("Medicine edited");

               
            } catch (RemoteException ex) {
                Logger.getLogger(PostMedicineController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PostMedicineController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    



    
}
