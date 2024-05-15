package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="korisnik_id")
	private int korisnikId;

	private String ime;

	private String mail;

	private String password;

	private String prezime;

	private String role;

	private String username;

	//bi-directional many-to-many association to Korisnik
	@ManyToMany
	@JoinTable(
		name="prijatelji"
		, joinColumns={
			@JoinColumn(name="korisnik2_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="korisnik1_id")
			}
		)
	private List<Korisnik> korisniks1;

	//bi-directional many-to-many association to Korisnik
	@ManyToMany(mappedBy="korisniks1")
	private List<Korisnik> korisniks2;

	//bi-directional many-to-one association to Rezultati
	@OneToMany(mappedBy="korisnik")
	private List<Rezultati> rezultatis;

	public Korisnik() {
	}

	public int getKorisnikId() {
		return this.korisnikId;
	}

	public void setKorisnikId(int korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Korisnik> getKorisniks1() {
		return this.korisniks1;
	}

	public void setKorisniks1(List<Korisnik> korisniks1) {
		this.korisniks1 = korisniks1;
	}

	public List<Korisnik> getKorisniks2() {
		return this.korisniks2;
	}

	public void setKorisniks2(List<Korisnik> korisniks2) {
		this.korisniks2 = korisniks2;
	}

	public List<Rezultati> getRezultatis() {
		return this.rezultatis;
	}

	public void setRezultatis(List<Rezultati> rezultatis) {
		this.rezultatis = rezultatis;
	}

	public Rezultati addRezultati(Rezultati rezultati) {
		getRezultatis().add(rezultati);
		rezultati.setKorisnik(this);

		return rezultati;
	}

	public Rezultati removeRezultati(Rezultati rezultati) {
		getRezultatis().remove(rezultati);
		rezultati.setKorisnik(null);

		return rezultati;
	}

}