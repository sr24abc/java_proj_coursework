/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;

/**
 *
 * @author arima
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a member of the ISA.
 * A member can donate items and borrow items.
 */
public class Member {

    //Basic member details
    private String name;
    private String address;
    private String email;

    //Total number of items donated by this member
    private int donatedQty;

    //List of items donated by this member
    private List<Item> donatedItems;
    
    //List of items currently borrowed by this member
    private List<Item> borrowing;


    /**
     * Constructor to create a new member:
     * @param name - Member's name
     * @param address - Member's address
     * @param email - Member's email
     * @param donatedQty - Initial number of donated items
     */
    public Member(String name, String address, String email, int donatedQty) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.donatedQty = donatedQty;

        // Initialize lists
        this.borrowing = new ArrayList<>();
        this.donatedItems = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getDonatedQty() {
        return donatedQty;
    }


    //Returns the list of donated items (@return)
    public List<Item> getDonatedItems() {
        return donatedItems;
    }
    
    
    //Returns the list of currently borrowed items (@return)
    public List<Item> getLoanItems() {
        return borrowing;
    }

   
    //Returns the number of items currently borrowed (@return)
    public int borrowingQty() {
        return borrowing.size();
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDonatedQty(int donatedQty) {
        this.donatedQty = donatedQty;
    }


    /**
     * Lends item to member if:
     * -The number of books the member has borrowed isn't 5
     * -And the item must be available
     * 
     * @param item the item to borrow
     * @return true if successful, false otherwise
     */
    public boolean lendItem(Item item) {
        int maxAllowed = Math.min(5, donatedQty);

        //Checks the borrowing limit
        if (borrowing.size() >= maxAllowed) {
            return false;
        }

        //Checks if the item is available
        if (item.isAvailable()) {
            borrowing.add(item); //Adds to borrowed list
            item.loanTo(this);   //Updates item status
            return true;
        }

        return false;
    }

    
    //Returns an item currently borrowed by this member
    //@param item the item to return
    public void returnItem(Item item) {
        if (borrowing.remove(item)) {
            item.returnLoan();  //Updates item status
        }
    }

    
     //Adds a donated item to this member
     //@param item the donated item
    public void addDonation(Item item) {
        donatedItems.add(item);
        donatedQty++; //Increments donation count
    }

    
    //Returns a string representation of the member
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", donatedQty=" + donatedQty +
                ", borrowing=" + borrowing.size() +
                ", donatedItems=" + donatedItems.size() +
                '}';
    }
    
    
}