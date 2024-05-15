package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prijatelji {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "korisnik1_id", referencedColumnName = "korisnik_id")
	private Korisnik korisnik1;
	
	@ManyToOne
	@JoinColumn(name = "korisnik2_id", referencedColumnName = "korisnik_id")
	private Korisnik korisnik2;
	
	public Prijatelji() {
	}

	public Prijatelji(Korisnik korisnik1, Korisnik korisnik2) {
		this.korisnik1 = korisnik1;
		this.korisnik2 = korisnik2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Korisnik getKorisnik1() {
		return korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}
	
}
