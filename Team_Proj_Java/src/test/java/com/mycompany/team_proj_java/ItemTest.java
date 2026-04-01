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
public class ItemTest {
    String[] langs = {"English","Spanish","French"};
    Member test = new Member("Shravani","B604","shravgmail",10);
    Item testItem = new DVD("Twisted Love","Ana",test,
                               "Spanish",langs);
    boolean result = test.lendItem(testItem);

    /**
     * Test of getTitle method, of class Item.
     */
    @Test
    public void testGetTitle() {
        String exp = "Twisted Love";
        String result = testItem.getTitle();
        assertEquals(exp,result);
    }

    /**
     * Test of setTitle method, of class Item.
     * checks to see if empty title is allowed to set
     */
    @Test
    public void testSetTitleEmpty() {
        String exp = "Twisted Love";
        testItem.setTitle("");
        String result = testItem.getTitle();
        assertEquals(exp,result);
    }
    
    /**
     * Test of setTitle method, of class Item.
     * 
     */
    @Test
    public void testSetTitle() {
        String exp = "Twisted Games";
        testItem.setTitle("Twisted Games");
        String result = testItem.getTitle();
        assertEquals(exp,result);
    }

    /**
     * Test of getLanguage method, of class Item.
     */
    @Test
    public void testGetLanguage() {
        String exp = "Spanish";
        String result = testItem.getLanguage();
        assertEquals(exp,result);
    }
    /**
     * Check to see if DVD methods work on polymorphic object realistically they should
     * after CASTING !!!
     */
    @Test
    public void CheckDVD(){
        String[] newlangs= {"French","German","Hindi"};
        ((DVD)testItem).setAudioLanguages(newlangs);
        String[] result = ((DVD)testItem).getAudioLanguages(); //item is now proper dvd obj after casting
        assertArrayEquals(newlangs,result);
        
    }

    /**
     * Test of setLanguage method, of class Item.
     */
    @Test
    public void testSetLanguage() {
        String exp = "French";
        testItem.setLanguage("French");
        String result = testItem.getLanguage();
        assertEquals(exp,result);
    }
    
    /**
     * Test of setLanguage method, of class Item.
     * check to see if setting empty language is allowed by method or not
     */
    @Test
    public void testSetLanguageEmpty() {
        String exp = "Spanish";
        testItem.setLanguage("");
        String result = testItem.getLanguage();
        assertEquals(exp,result);
    }


    /**
     * Test of LoanTo method, of class Item.
     */
    @Test
    public void testLoanTo() {
        Member newtest = new Member("Shriya","B604","shriyagmail",5);
        String exp = newtest.getEmail();
        testItem.loanTo(newtest);
        String result = testItem.getBorrower().getEmail();
        assertEquals(exp,result);
    }
    
    /**
     * Test of getBorrower method, of class Item.
     */
    @Test
    public void testGetBorrower() {
        Member newtest = new Member("Shriya","B604","shriyagmail",5);
        testItem.loanTo(newtest);
        String exp = "shriyagmail";
        String result = testItem.getBorrower().getEmail();
        assertEquals(exp,result);
        
    }

    /**
     * Test of isAvailable method, of class Item.
     */
    @Test
    public void testIsAvailable() {
        boolean exp = false;
        boolean result = testItem.isAvailable();
        assertEquals(exp,result);
    }

    /**
     * Test of returnLoan method, of class Item.
     */
    @Test
    public void testReturnLoan() {
        testItem.returnLoan();
        boolean exp = true;
        boolean result = testItem.isAvailable();
        assertEquals(exp,result);
    }

    /**
     * Test of getDonator method, of class Item.
     */
    @Test
    public void testGetDonator() {
        String exp = test.getEmail();
        String result = testItem.getDonator().getEmail();
        assertEquals(exp,result);
    }

    /**
     * Test of clearDonator method, of class Item.
     */
    @Test
    public void testClearDonator() {
        testItem.clearDonator();
        assertEquals(null,testItem.getDonator());
    }

    
    
}
