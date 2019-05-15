/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.util.ArrayList;

/**
 *
 * @author Tim
 */
public class Product {
        private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<OV_Chipkaart> ovkaarten;
	
	public Product (int prdnmr, String prdnm, String beschrijving, double prijs) {
		this.productNummer = prdnmr;
		this.productNaam = prdnm;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
        
        //hiermee kunnen we een leeg product aanmaken, voordat we chipkaarten etc hebben om toe te voegen.
	public Product() {
		
	}
        
	public void addOvChipkaarten(OV_Chipkaart ov) {
            if(ov != null){
		ovkaarten.add(ov);
            }
	}
	public OV_Chipkaart getOvChipkaart(int krnmr) {
		for (OV_Chipkaart o : ovkaarten) {
			if (o.getKaartnummer()== krnmr) {
				return o;
			}
		}
		return null;
	}
	public ArrayList<OV_Chipkaart> getOvChipkaarten() {
		return ovkaarten;
	}
	public void setOvChipkaarten(ArrayList<OV_Chipkaart> ovkaarten) {
		this.ovkaarten = ovkaarten;
	}
	public int getProductNummer() {
		return productNummer;
	}
	public void setProductNummer(int prdnmr) {
		this.productNummer = prdnmr;
	}
	public String getProductNaam() {
		return productNaam;
	}
	public void setProductNaam(String prdnmr) {
		this.productNaam = prdnmr;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
        }
        
        @Override
        public String toString(){
            return ("Productnummer: " + this.productNummer + "\n" +
                    "Productnaam: " + this.productNaam + "\n" +
                    "Beschrijving: " + this.beschrijving + "\n" +
                    "Prijs: " + this.prijs + "\n");
        }
}
