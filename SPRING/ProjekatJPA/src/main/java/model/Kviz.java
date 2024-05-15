package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the kviz database table.
 * 
 */
@Entity
@NamedQuery(name="Kviz.findAll", query="SELECT k FROM Kviz k")
public class Kviz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kviz_id")
	private int kvizId;

	private String kategorija;

	private String naslov;

	private int omiljeni;

	//bi-directional many-to-one association to Pitanje
	@OneToMany(mappedBy="kviz", fetch = FetchType.EAGER)
	private List<Pitanje> pitanjes;

	//bi-directional many-to-one association to Rezultati
	@OneToMany(mappedBy="kviz", fetch = FetchType.EAGER)
	private List<Rezultati> rezultatis;

	public Kviz() {
	}

	public int getKvizId() {
		return this.kvizId;
	}

	public void setKvizId(int kvizId) {
		this.kvizId = kvizId;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public int getOmiljeni() {
		return this.omiljeni;
	}

	public void setOmiljeni(int omiljeni) {
		this.omiljeni = omiljeni;
	}

	public List<Pitanje> getPitanjes() {
		return this.pitanjes;
	}

	public void setPitanjes(List<Pitanje> pitanjes) {
		this.pitanjes = pitanjes;
	}

	public Pitanje addPitanje(Pitanje pitanje) {
		getPitanjes().add(pitanje);
		pitanje.setKviz(this);

		return pitanje;
	}

	public Pitanje removePitanje(Pitanje pitanje) {
		getPitanjes().remove(pitanje);
		pitanje.setKviz(null);

		return pitanje;
	}

	public List<Rezultati> getRezultatis() {
		return this.rezultatis;
	}

	public void setRezultatis(List<Rezultati> rezultatis) {
		this.rezultatis = rezultatis;
	}

	public Rezultati addRezultati(Rezultati rezultati) {
		getRezultatis().add(rezultati);
		rezultati.setKviz(this);

		return rezultati;
	}

	public Rezultati removeRezultati(Rezultati rezultati) {
		getRezultatis().remove(rezultati);
		rezultati.setKviz(null);

		return rezultati;
	}

}