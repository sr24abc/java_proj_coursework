/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.team_proj_java;

/**
 *
 * @author shravaniranshevare1806
 */
public abstract class Item {
    // class Item - abstract parent class to DVD and Book
    
    private String title;
    private String language;
    private Member donatedBy;
    private Member onLoanTo;
    
    public Item(String title,String language,Member donatedBy){
        this.title=title;
        this.language=language;
        this.donatedBy=donatedBy;
        this.onLoanTo= null;
    }
    
    public String getTitle(){
        // returns title
        return title;
    }
    
    public void setTitle(String title){
        // sets title
        this.title=title;
    }
    
    public String getLanguage(){
        // returns language
        return language;
    }
    
    public void setLanguage(String language){
        // sets language
        this.language=language;
    }
    
    public void loanTo(Member borrower){ 
        // stores the member to whom item has been lent to
        onLoanTo=borrower;
    }
    
    public Member getBorrower(){
        // returns who has loaned the item
        return onLoanTo;
    }
    
    public boolean isAvailable(){
        // returns if item is available or not
        return (onLoanTo==null);
    }
    
    public void returnLoan(){
        // resets onLoanto
        onLoanTo=null;
    }
    
    public Member getDonator(){
        // returns donator
        return donatedBy;
    }
    
    public void clearDonator(){
        // clears donator
        donatedBy=null;
    }
}
