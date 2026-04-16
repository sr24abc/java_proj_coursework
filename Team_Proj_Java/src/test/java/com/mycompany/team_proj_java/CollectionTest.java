/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author admin
 */
public class CollectionTest {
    
    public CollectionTest() {
    }
    
    /**
     * Test of addBook method, of class Collection.
     */
    @Test
    public void testAddBook() {
        Collection c = new Collection();
        Member donor = new Member("Ana", "Address", "ana@gmail.com", 0);

        c.addBook("The Shining", "Stephen King", donor, "English", "12345");

        assertEquals(1, c.getItems().size());
        assertTrue(c.getItems().get(0) instanceof Book);
    }

    /**
     * Test of addDVD method, of class Collection.
     */
    @Test
    public void testAddDVD() {
        Collection c = new Collection();
        Member donor = new Member("Ana", "Address", "ana@gmail.com", 0);
        String[] audioLanguages = {"English", "French"};

        c.addDVD("Frozen", "Disney", donor, "English", audioLanguages);

        assertEquals(1, c.getItems().size());
        assertTrue(c.getItems().get(0) instanceof DVD);
    }

    /**
     * Test of searchItems method, of class Collection.
     */
    @Test
    public void testSearchItems() {
        Collection c = new Collection();
        Member donor = new Member("Ana", "Address", "ana@gmail.com", 0);

        c.addBook("The Shining", "Stephen King", donor, "English", "12345");
        c.addDVD("Frozen", "Disney", donor, "English", new String[]{"English"});

        ArrayList<Item> results = c.searchItems("Shining");

        assertEquals(1, results.size());
        assertEquals("The Shining", results.get(0).getTitle());
    }

    /**
     * Test of getItem method, of class Collection.
     */
    @Test
    public void testGetItem() {
        Collection c = new Collection();
        Member donor = new Member("Ana", "Address", "ana@gmail.com", 0);

        c.addBook("The Shining", "Stephen King", donor, "English", "12345");

        Item result = c.getItem("The Shining");

        assertNotNull(result);
        assertEquals("The Shining", result.getTitle());
    }

    /**
     * Test of removeItem method, of class Collection.
     */
    @Test
    public void testRemoveItem() {
        Collection c = new Collection();
        Member donor = new Member("Ana", "Address", "ana@gmail.com", 0);

        c.addBook("The Shining", "Stephen King", donor, "English", "12345");
        Item item = c.getItem("The Shining");

        c.removeItem(item);

        assertEquals(0, c.getItems().size());
    }

    /**
     * Test of getItems method, of class Collection.
     */
    @Test
    public void testGetItems() {
        Collection c = new Collection();
        Member donor = new Member("Ana", "Address", "ana@gmail.com", 0);

        c.addBook("The Shining", "Stephen King", donor, "English", "12345");

        assertEquals(1, c.getItems().size());
    }
    
}
