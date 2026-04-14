/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;


import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;
import java.util.List;

/**
 *
 * the main system that handles all operations on the command line 
 */
public class ISA_system {
    public static Collection item_collection = new Collection();  //item collection declared 
                                                                  //this will later have a method to fill it up
    static Scanner input = new Scanner(System.in); // global input scanner declared
    
    
    public static ArrayList<Member> members = new ArrayList<>();

    
    //Member methods
    //Add a new member
    public static void addMember() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        while ((name == null) || (name.isEmpty())){
            System.out.println("Invalid name, Enter name again:");
            name = input.nextLine();
            
        }

        System.out.println("Enter address:");
        String address = input.nextLine();
        while ((address == null) || (address.isEmpty())){
            System.out.println("Invalid address, Enter address again:");
            address = input.nextLine();
        }

        System.out.println("Enter email:");
        String email = input.nextLine();
        while ((email == null) || (email.isEmpty())){
            System.out.println("Invalid email, Enter email again:");
            email = input.nextLine();
        }

        Member member = new Member(name, address, email, 0);
        members.add(member);

        System.out.println("Member added successfully!");
    }

    //Displays members
    public static void printMembers(ArrayList<Member> members) {
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ") " + members.get(i).getName());
        }
    }

    
    //Choose a member - from all members
    public static Member chooseMemberNormal() {
        if (members.isEmpty()) {
            System.out.println("No members available!");
            return null;
        }

        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ") " + members.get(i).getName());
        }
        System.out.println("Select member:");
        int choice = input.nextInt();
        input.nextLine();
        while ((choice<1) || (choice > members.size())){
            System.out.println("Invalid choice, choose again:");
            choice = input.nextInt();
            input.nextLine();
        }
        

        return members.get(choice - 1);
    }
    
    //searches members by name 
    public static ArrayList<Member> searchMembers(String name) {
        ArrayList<Member> results = new ArrayList<>();
        for (Member m : members) {
            if (m.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(m);
            }
        }
        return results;
    }
    
    //Choose a member - for search results
    public static Member chooseMember(ArrayList<Member> members) {
        if (members.isEmpty()) {
            System.out.println("No members available!");
            return null;
        }

        printMembers(members);
        System.out.println("Select member:");
        int choice = input.nextInt();
        input.nextLine();
        while ((choice<1) || (choice > members.size())){
            System.out.println("Invalid choice, choose again:");
            choice = input.nextInt();
            input.nextLine();
        }

        return members.get(choice - 1);
    }
    
    //removes a member from the system
    public static void removeMember() {
        System.out.println("Enter name of member to remove:");
        String name = input.nextLine();
        ArrayList<Member> results = searchMembers(name);

        if (results.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        Member removed = chooseMember(results);
        //clears donation info from items
        for (Item item : item_collection.getItems()) {
            if (item.getDonator() == removed) {
                item.clearDonator();
            }
        }
        members.remove(removed);
        System.out.println("Member removed successfully.");
    }
    
        
    
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
            while ((newTitle==null) || (newTitle.isEmpty())){
            System.out.println("Invalid title, enter again:");
            newTitle=input.nextLine();
        }
            Bookitem.setTitle(newTitle);
            System.out.println("Title changed");
            break;
            
            case 2: System.out.println("Enter new language: "); // update language
            String newLang = input.nextLine();
            while ((newLang==null) || (newLang.isEmpty())){
            System.out.println("Invalid language, enter again:");
            newLang=input.nextLine();
        }
            Bookitem.setLanguage(newLang);
            System.out.println("Language changed");
            break;
            
            case 3 : Bookitem.clearDonator();   //clear Donator
            System.out.println("Donator cleared");
            break;
            
            case 4 : 
                System.out.println("Enter the name of the member you want to lend to now: ");
                String search = input.nextLine();
                ArrayList <Member> members = searchMembers(search);
                
                Member mem = chooseMember(members); //gives out all the  search result members and returns the choice made by user
                if (mem != null){
                    Bookitem.loanTo(mem);
                    System.out.println("Borrower Updated");    // update borrower
                    break;
                }
                else{
                   System.out.println("Borrower selected does not exist");    // update borrower
                   break; 
                }
                
                
            case 5: System.out.println("Enter new author name: ");  
            String author = input.nextLine();
            while ((author==null) || (author.isEmpty())){
            System.out.println("Invalid author name, enter again:");
            author=input.nextLine();
            }
            Bookitem.setAuthor(author); 
            System.out.println("Author Updated"); //update author name
            break;
            
            case 6: System.out.println("Enter new ISBN: ");
            String isbn = input.nextLine();
            while ((isbn==null) || (isbn.isEmpty())){
            System.out.println("Invalid ISBN, enter again:");
            isbn=input.nextLine();
            }
            
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
            while ((newTitle==null) || (newTitle.isEmpty())){
            System.out.println("Invalid title, enter again:");
            newTitle=input.nextLine();
            }
            dvdItem.setTitle(newTitle);
            System.out.println("Title changed");
            break;
            
            case 2: System.out.println("Enter new language: "); //update language
            String newLang = input.nextLine();
            while ((newLang==null) || (newLang.isEmpty())){
            System.out.println("Invalid language, enter again:");
            newLang =input.nextLine();
            }
            dvdItem.setLanguage(newLang);
            System.out.println("Language changed");
            break;
            
            case 3 : dvdItem.clearDonator();
            System.out.println("Donator cleared");  //update donor - clear donor
            break;
            
            case 4 : 
                System.out.println("Enter the name of the member you want to lend to now: ");
                String search = input.nextLine();
                ArrayList <Member> members = searchMembers(search);
                Member mem = chooseMember(members); //gives out all the search result members and returns the choice made by user
                if (mem != null){
                    dvdItem.loanTo(mem);
                    System.out.println("Borrower Updated");  //update borrower 
                                                          //case being if same member deleted old acc created new acc and then add that acc
                    break;
                }
                else{
                   System.out.println("Borrower selected does not exist");    // update borrower
                   break; 
                }
                
                
            case 5: System.out.println("Enter new director name: "); //update director
            String director = input.nextLine();
            while ((director==null) || (director.isEmpty())){
            System.out.println("Invalid director name, enter again:");
            director=input.nextLine();
            }
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
        System.out.println("Enter title");
        String title = input.next();
        System.out.println("Enter author");
        String author = input.next();
        System.out.println("Enter language");
        String lang = input.next();
        System.out.println("Enter ISBN");
        String isbn = input.next();
        while ((title.isEmpty())|| (author.isEmpty())|| (lang.isEmpty())||(isbn.isEmpty())){
            System.out.println("Invalid entries, enter again: ");
            System.out.println("Enter title");
            title = input.next();
            System.out.println("Enter author");
            author = input.next();
            System.out.println("Enter language");
            lang = input.next();
            System.out.println("Enter ISBN");
            isbn = input.next();
        }
        // not sure if search or normal is applicable 
        Member mem = chooseMemberNormal(); // //gives out all the members and returns the choice made by user
        if (mem != null){
            Book book = new Book(title,author,mem,lang,isbn);
            item_collection.addBook(title,author,mem,lang,isbn);
            mem.addDonation(book);
            System.out.println("Book Item added ");   
        }
        else{
            System.out.println("Member does not exist on the system,book cannot be donated");
        }
        
    }
    
    public static void addDVD(){
        //method specifically for adding DVD item - will be shifted to collection class
        System.out.println("Enter title");
        String title = input.next();
        System.out.println("Enter director");
        String director = input.next();
        System.out.println("Enter language");
        String lang = input.next();
        while ((title.isEmpty())|| (director.isEmpty())|| (lang.isEmpty())){
            System.out.println("Invalid entries, enter again: ");
            System.out.println("Enter title");
            title = input.next();
            System.out.println("Enter director");
            director = input.next();
            System.out.println("Enter language");
            lang = input.next();
        }
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
        Member mem = chooseMemberNormal(); //gives out all the members and returns the choice made by user
        if (mem != null){
            DVD dvd = new DVD(title,director,mem,lang,languages); //new method - use just pass in attr
            item_collection.addDVD(title,director,mem,lang,languages);
            mem.addDonation(dvd);
            System.out.println("DVD Item added ");   
        }
        else{
            System.out.println("Member does not exist on the system,book cannot be donated");
        }
        
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
            while ((operation<1) || (operation>6)){
                System.out.println("Invalid operation choice, enter again: ");
                operation = input.nextInt();
                input.nextLine();
            }
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
                System.out.println("To Search, enter name of Member : ");
                String name = input.nextLine();
                ArrayList<Member> members= searchMembers(name); //this is later modified to memcollection
                Member mem = chooseMember(members);
                
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
                Member mem= item.getBorrower(); //get member who borrowed
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
                             2) Search for Members
                             3) Add Item
                             4) Add Member
                             5) Remove Member
                             6) Exit 
                           """);
        
        
        System.out.println("Please enter the operation: ");
        int choice = input.nextInt();
        input.nextLine();
        while ((choice<1)|| (choice>6)){
            System.out.println("Invalid opt, enter again: ");
            choice = input.nextInt();
            input.nextLine();
        }
        return choice;
    }
    
    public static void main(String[] args){
        // main method carrying out all the processes and calling everything
        // first displays menu and then keeps on going till exit is selected
        int choice = displayMenu();
        while (choice != 6){
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
                while ((option<1) || (option>4)){
                    System.out.println("Invalid opt, enter again: ");
                    option = input.nextInt(); //take user input 
                    input.nextLine();
                }
                doActions(option,item); // call doActions which takes care of the rest : update,remove,lend,return
            }
            else if (choice == 2){
                //choice 2 -> Search Member
                System.out.println("Enter name to search:");
                String name = input.nextLine();

                ArrayList<Member> results = searchMembers(name);

                if (results.isEmpty()) {
                    System.out.println("No members found.");
                } 
                else {
                    printMembers(results);
                }
            }
            
            
            else if (choice == 3){
                // choice 3 -> add Item -> two types : book or dvd
                System.out.println("Enter the type of item you want to add - Book or DVD: ");
                String type = input.nextLine();
                while ((type == null) || (type.isEmpty())){
                    System.out.println("Invalid type, Enter the type of item again: ");
                    type = input.nextLine();
                }
                //based on user response
                if (type.equals("Book")){  //either addBook is called
                    addBook();
                }
                if (type.equals("DVD")){ //or addDVD is called
                    addDVD();
                }
            }
            else if (choice == 4) {
                addMember();
            }
            
            else if (choice == 5) {
                removeMember();
            }
            choice = displayMenu(); //keep on displaying menu and taking choice 
          
    }
        System.out.println("Thank you for using ISA system, See you soon!!");
    
    
    
}}
