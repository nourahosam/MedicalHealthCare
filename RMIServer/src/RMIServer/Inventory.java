/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import java.util.ArrayList;

/**
 *
 * @author Mariam
 */
public class Inventory {
    ArrayList<Medicine> medicines = new ArrayList();

    public Inventory() {
    }
    
    public Inventory(ArrayList<Medicine> medicines ) {
        this.medicines = medicines;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }
    
   public void addMedicine(Medicine m) {
        medicines.add(m);
    }
   
   
    
}
