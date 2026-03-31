/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * the main system that handles all operations on the command line 
 */
public class ISA_system {
    public static Collection item_collection = new Collection();  //item collection declared 
                                                                  //this will later have a method to fill it up
    static Scanner input = new Scanner(System.in); // global input scanner declared
    
    public static String printItems(ArrayList<Item> items){
        // method to print out the search list items 
        String details="";
        for (int i =0 ; i<items.size();i++){
            details += i+1 + ")  " + items.get(i).toString()+ "\n";
        }
        return details;
    }
    
    
    public static void updateBook(int opt,Item item){
        // helper method specifically to update Book Items
        // casting was required cause , this method uses methods specific to its subclass
        // safe casting as before calling it is checked if item is of Book type
        Book Bookitem = (Book)item;
        switch(opt){ // uses a switch statement
            case 1 : System.out.println("Enter new title: ");  //if title is to be updated
            String newTitle = input.nextLine();
            Bookitem.setTitle(newTitle);
            System.out.println("Title changed");
            break;
            
            case 2: System.out.println("Enter new language: "); // update language
            String newLang = input.nextLine();
            Bookitem.setLanguage(newLang);
            System.out.println("Language changed");
            break;
            
            case 3 : Bookitem.clearDonator();   //clear Donator
            System.out.println("Donator cleared");
            break;
            
            case 4 : //member list // member index //get member
                Member mem = null;
                Bookitem.loanTo(mem);
                System.out.println("Borrower Updated");    // update borrower
                break;
                
            case 5: System.out.println("Enter new author name: ");  
            String author = input.nextLine();
            
            Bookitem.setAuthor(author); 
            System.out.println("Author Updated"); //update author name
            break;
            
            case 6: System.out.println("Enter new ISBN: ");
            String isbn = input.nextLine();
            
            Bookitem.setIsbn(isbn);
            System.out.println("ISBN Updated"); // update ISBN
            break;
            
        }
    }
    
    
    
    public static void updateDVD(int opt,Item item){
        //helper method specifically to update DVD Items
        // casting was required cause , this method uses methods specific to its subclass
        // safe casting as before calling it is checked if item is of DVD type
        DVD dvdItem = (DVD)item;
        switch(opt){ // switch statement used
            case 1 : System.out.println("Enter new title: ");  //update title
            String newTitle = input.nextLine();
            dvdItem.setTitle(newTitle);
            System.out.println("Title changed");
            break;
            
            case 2: System.out.println("Enter new language: "); //update language
            String newLang = input.nextLine();
            dvdItem.setLanguage(newLang);
            System.out.println("Language changed");
            break;
            
            case 3 : dvdItem.clearDonator();
            System.out.println("Donator cleared");  //update donor - clear donor
            break;
            
            case 4 : //member list // member index //get member
                Member mem = null;
                dvdItem.loanTo(mem);
                System.out.println("Borrower Updated");  //update borrower 
                                                          //case being if same member deleted old acc created new acc and then add that acc
                break;
                
            case 5: System.out.println("Enter new director name: "); //update director
            String director = input.nextLine();
            dvdItem.setDirector(director);
            System.out.println("Director Updated");
            break;
            
            case 6: System.out.println("Enter new languages and -1 if at the end : "); 
            // a loop user keeps entering languages till they want to end process
            // once done arraylist is converted to array and then updated
            String lang  = input.nextLine();
            ArrayList<String> langs = new ArrayList<String>();
            langs.add(lang);
            while (!lang.equals("-1")){
                System.out.println("Enter new languages and -1 if at the end : ");
                lang=input.nextLine();
                langs.add(lang);
            }
            String[] languages = langs.toArray(new String[0]);
            dvdItem.setAudioLanguages(languages);
            System.out.println("Audio languages changed");       //update array of audio languages
            break;
            
        }
    }
    
    public static void addBook(){
        // method specifically for adding Book item - will be shifted to collection class
        System.out.println("Enter title,author,language,isbn");
        String title = input.next();
        String author = input.next();
        String lang = input.next();
        String isbn = input.next();
        //Member show list //choose member 
        Member mem = null; //donated
        Item item = new Book(title,author,mem,lang,isbn);
        mem.addDonation(item);
        item_collection.addItem(item);
        System.out.println("Book Item added ");  
    }
    
    public static void addDVD(){
        //method specifically for adding DVD item - will be shifted to collection class
        System.out.println("Enter title,director,language");
        String title = input.next();
        String director = input.next();
        String lang = input.next();
        System.out.println("Enter new languages and -1 if at the end : ");
        String audiolang  = input.nextLine();
        ArrayList<String> langs = new ArrayList<String>();
        langs.add(lang);
        while (!audiolang.equals("-1")){  
            // a loop user keeps entering languages till they want to end process
            // once done arraylist is converted to array and then updated
            System.out.println("Enter new languages and -1 if at the end : ");
            audiolang=input.nextLine();
            langs.add(audiolang);
            }
        String[] languages = langs.toArray(new String[0]);
        //Member show list //choose member 
        Member mem = null; //donated
        Item item = new DVD(title,director,mem,lang,languages);
        item_collection.addItem(item);
        System.out.println("Book Item added ");  
    }
    
    
    public static void printOptions(){
        // method to print options available after an item is selected in search
        String details = """
                         1) Remove Item
                         2) Update Item
                         3) Lend Item
                         4) Return Item
                         """;
        System.out.println(details);
    }
    
    public static void doActions(int opt,Item item){
        // method to DO removal,update or lend and return of selected item
        // each if block calls helper methods to avoid having a huge chunk of code 
        if (opt==1){
            //remove item 
            item_collection.removeItem(item);
        }
        else if (opt==2){
           // update item - first generates and prints a string based on type of item
           String options = """
                              1) Update title
                              2) Update language
                              3) Clear Donor
                              4) Update Borrower 
                              """;
           if (item instanceof Book){
               options += """
                          5) Update Author
                          6) Update ISBN
                          """;
           }
           else {
              options += """
                          5) Update Director
                          6) Update AudioLanguages
                          """; 
        }
            System.out.println(options);
            int operation = input.nextInt();
            input.nextLine();
            // then calls helper methods to do the task
            if (item instanceof Book){
                updateBook(operation,item);
            }
            else {
                updateDVD(operation,item) ;
            }
    }
        else if (opt ==3){
            // lend item - first check if item is available 
            if (item.isAvailable()){
                //member list // check member list is full otheriwse does not exist 
                // get member whom i wanna lend to 
                Member mem = null;
                boolean ans = mem.lendItem(item); //this method returns true if successful
                if (ans){
                    System.out.println("Item successfully lent");  //item lent
                }
                else
                    System.out.println("Borrowal limit was reached "); // borrow limit for member was reached
            }
            else{
                System.out.println("Item is not available");// item was not available
            }
        }
        
        else if (opt == 4){
            // return item - checks if item is truly not available 
            if (!item.isAvailable()){
                // get member who wants to return item im assuming no due date constraint
                Member mem = null;
                mem.returnItem(item);
                System.out.println("Item returned"); //returns item
            }
            else
                System.out.println("Item was not being borrowed"); //item was not borrowed to begin with
        }
    
    }
    
    public static int displayMenu(){
        //method to display main menu and take input and return it to the while loop
        System.out.println("Welcome to ISA_System!");
        System.out.println("""
                           Here are the following things you can do: 
                            1) Search for Items
                            2) Add Item
                            3) Exit 
                           """);
        
        
        System.out.println("Please enter the operation: ");
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }
    
    public static void main(String[] args){
        // main method carrying out all the processes and calling everything
        // first displays menu and then keeps on going till exit is selected
        int choice = displayMenu();
        while (choice != 3){
            //choice 1 -> Search for items -> leads to other options
            if (choice==1){
                System.out.println("Please enter the title of the Item : ");
                String searchterm = input.nextLine();
                ArrayList<Item> items = item_collection.searchItems(searchterm);// result of search
                System.out.println(printItems(items));//print it
                System.out.println("Please enter the index of the Item : ");//choose one from search
                int opt = input.nextInt();
                input.nextLine();
                Item item = items.get(opt-1);//get the item
                item.toString();
                System.out.println("Please choose one of the following operations: ");//print further options
                printOptions();
                int option = input.nextInt(); //take user input 
                input.nextLine();
                doActions(option,item); // call doActions which takes care of the rest : update,remove,lend,return
            }
            
            else if (choice == 2){
                // choice 2 -> add Item -> two types : book or dvd
                System.out.println("Enter the type of item you want to add - Book or DVD: ");
                String type = input.nextLine();
                //based on user response
                if (type.equals("Book")){  //either addBook is called
                    addBook();
                }
                if (type.equals("DVD")){ //or addDVD is called
                    addDVD();
                }
            }
            choice = displayMenu(); //keep on displaying menu and taking choice 
          
    }
    
    
    
}}
