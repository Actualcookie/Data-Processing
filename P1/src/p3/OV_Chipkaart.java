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

import java.util.Date;

public class OV_Chipkaart {
	private int kaartnummer;
	private Date geldigTot;
	private int klasse;
	private Number saldo;
	private Reiziger reiziger;

	public OV_Chipkaart(int krtnmr, Date gldgTot, int kl, Number sal) {
		kaartnummer = krtnmr;
		geldigTot = gldgTot;
		klasse = kl;
		saldo = sal;
	}

	public OV_Chipkaart() {
	};

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
		return "Kaartnummer: " + kaartnummer + "\nEind datum : " + geldigTot + ". \nKlasse: " + klasse + " \nSaldo: " + saldo + "\n";
	}
}
