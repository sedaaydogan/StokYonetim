package giris.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "Ekipman" database table.
 * 
 */
@Entity
@Table(name="\"Ekipman\"")
@NamedQuery(name="Ekipman.findAll", query="SELECT e FROM Ekipman e")
public class Ekipman implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Ýd")
	@TableGenerator(name="EKIPMAN_GEN")
	@GeneratedValue(generator="EKIPMAN_GEN")
	private Integer id;

	@Column(name="ekipman_adi")
	private String ekipmanAdi;
	
	@OneToMany(mappedBy="ekipman")
	private List<EkipmanServisDonus> ekipmanSerDonList;
	
	@OneToMany(mappedBy="ekipman")
	private List<EkipmanServisGidi> ekipmanSerGidisList;

	public Ekipman() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEkipmanAdi() {
		return this.ekipmanAdi;
	}

	public void setEkipmanAdi(String ekipmanAdi) {
		this.ekipmanAdi = ekipmanAdi;
	}

	public Ekipman(String ekipmanAdi) {
		super();
		this.ekipmanAdi = ekipmanAdi;
	}

	public Ekipman(Integer id, String ekipmanAdi) {
		super();
		this.id = id;
		this.ekipmanAdi = ekipmanAdi;
	}

	@Override
	public String toString() {
		return "Ekipman [id=" + id + ", ekipmanAdi=" + ekipmanAdi + "]";
	}

	
	
	
}