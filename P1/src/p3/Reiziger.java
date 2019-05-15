/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Tim
 */
public class Reiziger {
    
    private int identifier;
    private String voorletter;
    private Date gbdatum;
    private String naam;
    private ArrayList<OV_Chipkaart> OVChipkaarten = new ArrayList<>();

    public Reiziger(int id, String voorl, Date gbd, String nm) {
            identifier = id;
            voorletter = voorl;
            gbdatum = gbd;
            naam = nm;
    }

    public Reiziger() {
    }

    public int getID() {
            return identifier;
    }

    public void setID(int id) {
            this.identifier = id;
    }

    public String getVoorletter() {
            return voorletter;
    }

    public void setVoorletter(String voorletters) {
            this.voorletter = voorletters;
    }

    public String getNaam() {
            return naam;
    }

    public void setNaam(String naam) {
            this.naam = naam;
    }

    public Date getGBdatum() {
            return gbdatum;
    }
    
    public void setGBdatum(String gbdatum){
            Date gb = java.sql.Date.valueOf(gbdatum);
            setGBdatum(gb);
    }

    public void setGBdatum(Date gbdatum) {
            this.gbdatum = gbdatum;
    }

    @Override
    public String toString() {
            return "Naam Reiziger: " + voorletter + naam +  "\n Geboortedatum " + gbdatum + "\n";
    }

    public ArrayList<OV_Chipkaart> getMijnOvchipkaart() {
            return OVChipkaarten;
    }

    public OV_Chipkaart addMijnOvchipkaart(OV_Chipkaart OV) {
            OVChipkaarten.add(OV);
            return OV;
    }

    @Override
    public boolean equals(Object obj){
        boolean equal = false;
        if(obj == null){
            return equal;
        }
        
        if(obj instanceof Reiziger){
            Reiziger temprg = (Reiziger)obj;
            if(this.naam == null && temprg.getNaam() == null){
                if(     this.gbdatum.equals(temprg.getGBdatum()) &&
                        this.identifier == temprg.getID()){
                            
                    equal = true; 
                }
            }
            else if(this.gbdatum == null && temprg.getGBdatum() == null){
                if(this.naam.equals(temprg.getNaam()) && 
                   this.identifier == temprg.getID()){
                    equal = true;
                }
            }
            else if (this.gbdatum != null &&
                     temprg.getGBdatum() != null &&
                     this.naam != null && 
                     temprg.getNaam() != null){
                
                        if(this.naam.equals(temprg.getNaam()) && 
                           this.gbdatum.equals(temprg.getGBdatum()) &&
                           this.identifier == temprg.getID()){

                            equal = true;
                }
            }
        }
        return equal;
    }

}
