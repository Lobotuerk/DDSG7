/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Luis
 */
public class VentanaLoginTest {
    
    public VentanaLoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getDni method, of class VentanaLogin.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        VentanaLogin instance = new VentanaLogin();
        String expResult = "123";
        String result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class VentanaLogin.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "";
        VentanaLogin instance = new VentanaLogin();
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class VentanaLogin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        VentanaLogin instance = new VentanaLogin();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class VentanaLogin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        VentanaLogin instance = new VentanaLogin();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
