package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the rezultati database table.
 * 
 */
@Entity
@NamedQuery(name="Rezultati.findAll", query="SELECT r FROM Rezultati r")
public class Rezultati implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rezultati_id")
	private int rezultatiId;

	private int skor;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Kviz
	@ManyToOne
	@JoinColumn(name="kviz_id")
	private Kviz kviz;

	public Rezultati() {
	}

	public int getRezultatiId() {
		return this.rezultatiId;
	}

	public void setRezultatiId(int rezultatiId) {
		this.rezultatiId = rezultatiId;
	}

	public int getSkor() {
		return this.skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Kviz getKviz() {
		return this.kviz;
	}

	public void setKviz(Kviz kviz) {
		this.kviz = kviz;
	}

}