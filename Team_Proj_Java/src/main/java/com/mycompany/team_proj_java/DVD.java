/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;

/**
 *
 * @author shravaniranshevare1806
 */
import java.util.Arrays;

public class DVD extends Item {
    // DVD class - subclass of Item
    
    private String director;
    private String[] audioLanguages;
    
    public DVD(String title,String director,Member donatedBy,String language,
                String[] audioLanguages){
        super(title,language,donatedBy);
        this.director=director;
        this.audioLanguages=audioLanguages;
    }
    
    public String getDirector(){
        // returns director
        return director;
    }
    
    public void setDirector(String director){
        // sets director
        this.director=director;
    }
    
    public String[] getAudioLanguages(){
        // returns array of audio languages
        return audioLanguages;
    }
    
    public void setAudioLanguages(String[] languages){
        // sets array of audio languages
        audioLanguages=languages;
    }
    
    @Override
    public String toString(){
        // returns a string containing all details of DVD including if on loan then member's name and email
        
        String details = "Title : " + super.getTitle() +" Language: " + super.getLanguage();
        details+= "\n Director: "+ getDirector() + " set of audio languages: " + Arrays.toString(audioLanguages);
        if (super.isAvailable()){
            details += "\n"+ "DVD is available";
        }
        else{
            details += "\n"+ "DVD is loaned to: "+super.getBorrower().getName() + " " + super.getBorrower().getEmail();
        }
        return details;
    }
}

