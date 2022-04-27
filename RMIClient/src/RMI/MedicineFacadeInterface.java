/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import RMI.MedicineDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mariam
 */
public interface MedicineFacadeInterface {
       public void SetMedicineData(String name, String type, String expiredDate, int amountInStock, int price) throws RemoteException;
       public String getMedicineData() throws RemoteException;
       public MedicineDTO getMedicine() throws RemoteException;

}
