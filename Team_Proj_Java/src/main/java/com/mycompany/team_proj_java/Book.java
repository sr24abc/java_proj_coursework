package com.mycompany.team_proj_java;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shravaniranshevare1806
 */
public class Book extends Item {
    // class Book - subclass of Item
    
    private String author;
    private String isbn;
    
    public Book(String title,String author,Member donatedBy,
            String language,String isbn){
        super(title,language,donatedBy);
        this.author=author;
        this.isbn=isbn;
        
    }
    
    public String getAuthor(){
        // returns author
        return author;
    }
    
    public void setAuthor(String author){
        // sets author
        if (!author.equals(""))
        this.author=author;
    }
    
    public String getIsbn(){
        //returns ISBN
        return isbn;
    }
    
    public void setIsbn(String isbn){
        // sets ISBN
        if (!isbn.equals(""))
        this.isbn=isbn;
    }
    
    @Override
    public String toString(){
        // returns a string containing Book details including if on loan then member's name and email
        String details = "Title : " + super.getTitle() + " Language: " + super.getLanguage();
        details += "\n Author: "+ getAuthor() + " ISBN: "+ getIsbn();
        if (super.isAvailable()){
            details+= "\n"+"Book is available";
        }
        else{
            
            details += "\n"+"Book is on Loan to : "+super.getBorrower().getName() + " " + super.getBorrower().getEmail();
        }
        return details; 
    }
    
}

