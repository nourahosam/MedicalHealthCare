/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import RMI.MedicineFacadeInterface;
import RMI.MedicineDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Mariam
 */
public class MedicineFacade extends UnicastRemoteObject implements MedicineFacadeInterface{

    Medicine m;
//        public CourseFacade() throws RemoteException {
//        c= new Course("", "", "");
//    }
    
    public MedicineFacade() throws RemoteException {
        m = new Medicine("","","",0,0);
    }
    
    @Override
    public void SetMedicineData(String name, String type, String expiredDate, int amountInStock, int price) throws RemoteException {
        m.setName(name);
        m.setType(type);
        m.setExpiredDate(expiredDate);
        m.setAmountInStock(amountInStock);
        m.setPrice(price);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMedicineData() throws RemoteException {
        String MedicineData = m.getName() + m.getType() + m.getExpiredDate() + m.getAmountInStock() + m.getPrice();
        return MedicineData;
    }

    @Override
    public MedicineDTO getMedicine() throws RemoteException {
                
        MedicineDTO dto=new MedicineDTO(m.getName() , m.getType() , m.getExpiredDate() , m.getAmountInStock() , m.getPrice());
        return dto;
        
    }
    
}
