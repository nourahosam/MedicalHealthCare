/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Mariam
 */
public interface OperationRoomInterface  extends Remote{
        public String RequestOperationRoom(int id, char type,String DRmail)throws RemoteException;
}
