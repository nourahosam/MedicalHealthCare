/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import RMIServer.Account;
import RMIServer.Medicine;
import RMIServer.OperationRoom;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import org.bson.Document;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *
 */
public class JUnitTesting  {
    



    @Test
    public void testRequestOperationRoom() throws RemoteException{
        OperationRoom o = new OperationRoom();
//        String result = o.RequestOperationRoom(1, 'A', "Dr.Mina@yahoo.com");
//        assertEquals("Room is requested successfully", result);
        
        String result2 = o.RequestOperationRoom(1, 'A', "Dr.M@yahoo.com");
        assertEquals("Room is requested successfully", result2);
    }


    @Test
    public void testpostMedicine() throws RemoteException{
        Medicine m = new Medicine();
//        String p = m.postMedicine("pp", "Cream", "900-", 90, 35);
//        assertEquals( "Medicine is posted successfully!", p);
        
        //fail(m.postMedicine("pp", "Cream", "900-", 90, 35));
        
         String p2 = m.postMedicine("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp", "Cream", "900-", 90, 35);
        assertEquals( "Medicine is posted successfully!", p2);
    }
    
    @Test
    public void testLogin() throws RemoteException
    {
           
          Account acc= new Account();
                 
         assertEquals(true,(acc.login("Marina", "3456")));
    }
}
