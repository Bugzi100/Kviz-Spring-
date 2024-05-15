package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pitanje database table.
 * 
 */
@Entity
@NamedQuery(name="Pitanje.findAll", query="SELECT p FROM Pitanje p")
public class Pitanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pitanje_id")
	private int pitanjeId;

	private String opcija1;

	private String opcija2;

	private String opcija3;

	private String opcija4;

	@Column(name="tacna_opcija")
	private String tacnaOpcija;

	private String tekst;

	//bi-directional many-to-one association to Kviz
	@ManyToOne
	@JoinColumn(name="kviz_id")
	private Kviz kviz;

	public Pitanje() {
	}

	public int getPitanjeId() {
		return this.pitanjeId;
	}

	public void setPitanjeId(int pitanjeId) {
		this.pitanjeId = pitanjeId;
	}

	public String getOpcija1() {
		return this.opcija1;
	}

	public void setOpcija1(String opcija1) {
		this.opcija1 = opcija1;
	}

	public String getOpcija2() {
		return this.opcija2;
	}

	public void setOpcija2(String opcija2) {
		this.opcija2 = opcija2;
	}

	public String getOpcija3() {
		return this.opcija3;
	}

	public void setOpcija3(String opcija3) {
		this.opcija3 = opcija3;
	}

	public String getOpcija4() {
		return this.opcija4;
	}

	public void setOpcija4(String opcija4) {
		this.opcija4 = opcija4;
	}

	public String getTacnaOpcija() {
		return this.tacnaOpcija;
	}

	public void setTacnaOpcija(String tacnaOpcija) {
		this.tacnaOpcija = tacnaOpcija;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Kviz getKviz() {
		return this.kviz;
	}

	public void setKviz(Kviz kviz) {
		this.kviz = kviz;
	}

}