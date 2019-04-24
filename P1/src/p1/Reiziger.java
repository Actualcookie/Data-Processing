/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Tim
 */
public class Reiziger {
    
    /* 
    om een ID aan te maken gebruik ik een static zodat deze automatisch 
    optelt en stabiel blijft. Dit zal later moeten veranderen, omdat 
    de counter reset na het sluiten van het programma. 
    Voor nu zou het voldoende moeten zijn aangezien de rest 
    van de data ook verloren gaat.*/
    private static int counter = 0;
    private String naam;
    private Date gbdatum;
    private int identifier;
    
    public Reiziger(){
        this.naam = null;
        this.gbdatum = null;
        this.identifier = counter;
        counter++;
    }
    
    public String getNaam(){
        return this.naam;
    }
    
    public void setNaam(String nm){
        this.naam = nm;
    }
    
    
    public Date getGBDatum(){
        return this.gbdatum;
    }
    
    /* Dit laat ALLEEN dates toe om te worden toegevoegd geen strings */
    public void setGBDatum( String gb){
        Date new_gb = java.sql.Date.valueOf(gb);
        this.gbdatum = new_gb;
    }
    
        public int getID(){
        return this.identifier;
    }
    /*
        Deze functie lijkt onnodig maar is dat niet.
        Deze functie gaat in gebruik zodra de static counter 
        niet meer voldoende is.
        */
    public void setID(int id){
        this.identifier = id;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean equal = false;
        if(obj instanceof Reiziger){
            Reiziger temprg = (Reiziger)obj;
            
            if(     this.naam.equals(temprg.getNaam()) && 
                    this.gbdatum.equals(temprg.getGBDatum()) &&
                    this.identifier == temprg.getID()){
                
                equal = true;                
            }
        }
        return equal;
    }

}
