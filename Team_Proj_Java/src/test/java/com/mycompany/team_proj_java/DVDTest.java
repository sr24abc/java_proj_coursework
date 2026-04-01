/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.team_proj_java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author shravaniranshevare1806
 */
public class DVDTest {
    //creating test objects
    String[] langs = {"English","Spanish","French"};
    Member test = new Member("Shravani","B604","gmail",10);
    DVD testDVD = new DVD("Twisted Love","Ana",test,
                               "Spanish",langs);
    boolean result = test.lendItem(testDVD);
    
    /**
     * Test of getDirector method, of class DVD.
     */
    @Test
    public void testGetDirector() {
        String exp ="Ana";
        String result = testDVD.getDirector();
        assertEquals(exp,result);
    }

    /**
     * Test of setDirector method, of class DVD.
     */
    @Test
    public void testSetDirector() {
        String exp ="Cora";
        testDVD.setDirector("Cora");
        String result = testDVD.getDirector();
        assertEquals(exp,result);
    }
    
    /**
     * Test of setDirector method, of class DVD.
     * checks if method allows setting empty string as director
     */
    @Test
    public void testSetDirectorEmpty() {
        String exp ="Ana";
        testDVD.setDirector("");
        String result = testDVD.getDirector();
        assertEquals(exp,result);
    }

    /**
     * Test of getAudioLanguages method, of class DVD.
     */
    @Test
    public void testGetAudioLanguages() {
        String[] exp = langs;
        String[] result = testDVD.getAudioLanguages();
        assertArrayEquals(exp,result);
    }

    /**
     * Test of setAudioLanguages method, of class DVD.
     */
    @Test
    public void testSetAudioLanguages() {
        String[] newlangs= {"French","German","Hindi"};
        testDVD.setAudioLanguages(newlangs);
        String[] result = testDVD.getAudioLanguages();
        assertArrayEquals(newlangs,result);
    }
    
    /**
     * Test of setAudioLanguages method, of class DVD.
     * checks to see if method allows empty array to be set as audio languages
     */
    @Test
    public void testSetAudioLanguagesEmpty() {
        
        String[] newlangsempty= new String[testDVD.getAudioLanguages().length];
        testDVD.setAudioLanguages(newlangsempty);
        String[] result = testDVD.getAudioLanguages();
        assertArrayEquals(langs,result);
    }

    
    
}
