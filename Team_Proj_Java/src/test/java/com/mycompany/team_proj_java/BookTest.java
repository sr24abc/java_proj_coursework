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
public class BookTest {
    // creating test objects
    Member test = new Member("Shravani","B604","gmail",10);
    Book testbook = new Book("Twisted Love","Ana",test,
                               "Spanish","123456789");
    boolean result = test.lendItem(testbook);
    
    @Test
    public void testGetAuthor() {
        
        String exp ="Ana";
        String result = testbook.getAuthor();
        assertEquals(exp,result);
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        
        String exp="Rina";
        testbook.setAuthor("Rina");
        String result = testbook.getAuthor();
        assertEquals(exp,result);
        
    }
    /**
     * Test of setAuthor method, of class Book.
     * checks if method allows setting author name to empty string
     */
    
    @Test
    public void testSetAuthorEmpty() {
        
        String exp="Ana";
        testbook.setAuthor("");
        String result = testbook.getAuthor();
        assertEquals(exp,result);
        
    }

    /**
     * Test of getIsbn method, of class Book.
     */
    @Test
    public void testGetIsbn() {
        String isbn="123456789";
        String result = testbook.getIsbn();
        assertEquals(isbn,result);
    }

    /**
     * Test of setIsbn method, of class Book.
     */
    @Test
    public void testSetIsbn() {
        String isbn="210789";
        testbook.setIsbn("210789");
        String result = testbook.getIsbn();
        assertEquals(isbn,result);
    }
    
    /**
     * Test of setIsbn method, of class Book.
     * checks if method allows setting ISBN to empty string
     */
    @Test
    public void testSetIsbnEmpty() {
        String isbn="123456789";
        testbook.setIsbn("");
        String result = testbook.getIsbn();
        assertEquals(isbn,result);
    }

    
    
}
