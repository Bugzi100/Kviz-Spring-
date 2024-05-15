package com.example.demo.ostale;

import model.Pitanje;

public class RezultatiPitanja {
	
	private Pitanje pitanje;
	private String odabranaOpcija;
	private boolean tacno;
	
	public RezultatiPitanja(Pitanje pitanje, String odabranaOpcija, boolean tacno) {
		super();
		this.pitanje = pitanje;
		this.odabranaOpcija = odabranaOpcija;
		this.tacno = tacno;
	}

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	public String getOdabranaOpcija() {
		return odabranaOpcija;
	}

	public void setOdabranaOpcija(String odabranaOpcija) {
		this.odabranaOpcija = odabranaOpcija;
	}

	public boolean isTacno() {
		return tacno;
	}

	public void setTacno(boolean tacno) {
		this.tacno = tacno;
	}

}
