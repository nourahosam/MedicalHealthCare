/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import lab9.Calculator;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 
 */
public class JUnitTesting {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int result = c.add(5, 6);
        assertEquals(11, result);
    }


    @Test
    public void testSub() {
        Calculator c = new Calculator();
        int result = c.sub(6, 1);
        assertEquals(4, result);
    }

}
