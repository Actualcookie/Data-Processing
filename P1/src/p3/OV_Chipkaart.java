/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author Tim
 */

import java.util.ArrayList;
import java.util.Date;

public class OV_Chipkaart {
	private int kaartnummer;
	private Date geldigTot;
	private int klasse;
	private Number saldo;
	private Reiziger reiziger;
        private ArrayList<Product> producten;
        
	public OV_Chipkaart(int krtnmr, Date gldgTot, int kl, Number sal) {
		kaartnummer = krtnmr;
		geldigTot = gldgTot;
		klasse = kl;
		saldo = sal;
	}
        
        public OV_Chipkaart(){
            // leeg voor het maken van shell klassen
        }
        
        //Nulls in een lijst zijn vervelend voorals als je er dooreen wilt loopen.
        public void addProducten(Product pro){
            if(pro != null){
                producten.add(pro);
            }
        }
        
        //Get niet alle producten maar een gebaseerd op het nummer
        public Product getProductByNum(int productNummer) {
		for (Product p : producten) {
			if (p.getProductNummer() == productNummer) {
				return p;
			}
		}
		return null;
	}
        
        public ArrayList<Product> getProducten() {
		return producten;
	}
        
        // Hier zou null guarding ook handig kunnen zijn,
        //maar het is een stuk lastiger een hele lijst null te maken dan per ongeluk een product null te laten.
        public void setProducten(ArrayList<Product> pro){
                this.producten = pro;
        }
        
	public int getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public Number getSaldo() {
		return saldo;
	}

	public void setSaldo(Number saldo) {
		this.saldo = saldo;
	}
	
	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public String toString() {
		return "Kaartnummer: " + kaartnummer + "\n"
                        + "Eind datum : " + geldigTot + ". \n"
                        + "Klasse: " + klasse + " \n"
                        + "Saldo: " + saldo + "\n";
	}
}
