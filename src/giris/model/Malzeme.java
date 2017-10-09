package giris.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the "Malzeme" database table.
 * 
 */
@Entity
@Table(name = "\"Malzeme\"")
@NamedQuery(name = "Malzeme.findAll", query = "SELECT m FROM Malzeme m")
public class Malzeme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "MALZEME_GEN")
	@GeneratedValue(generator = "MALZEME_GEN")
	private Integer id;

	@Column(name = "malzeme_adi")
	private String malzemeAdi;

	private Integer maximum;

	private Integer minimum;

	private int mevcut;

	@OneToMany(mappedBy = "malzeme")
	private List<MalzemeGiri> malzemeGirisList;

	@OneToMany(mappedBy = "malzeme")
	private List<MalzemeCiki> malzemeCikisList;

	public Malzeme() {
	}

	public int getMevcut() {
		return mevcut;
	}

	public void setMevcut(int mevcut) {
		this.mevcut = mevcut;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMalzemeAdi() {
		return this.malzemeAdi;
	}

	public void setMalzemeAdi(String malzemeAdi) {
		this.malzemeAdi = malzemeAdi;
	}

	public Integer getMaximum() {
		return this.maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public Integer getMinimum() {
		return this.minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public List<MalzemeGiri> getMalzemeGirisList() {
		return malzemeGirisList;
	}

	public void setMalzemeGirisList(List<MalzemeGiri> malzemeGirisList) {
		this.malzemeGirisList = malzemeGirisList;
	}

	public List<MalzemeCiki> getMalzemeCikisList() {
		return malzemeCikisList;
	}

	public void setMalzemeCikisList(List<MalzemeCiki> malzemeCikisList) {
		this.malzemeCikisList = malzemeCikisList;
	}

	public Malzeme(String malzemeAdi, Integer maximum, Integer minimum) {
		super();
		this.malzemeAdi = malzemeAdi;
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public Malzeme(String malzemeAdi, Integer maximum, Integer minimum, int mevcut) {
		super();
		this.malzemeAdi = malzemeAdi;
		this.maximum = maximum;
		this.minimum = minimum;
		this.mevcut = mevcut;
	}

	@Override
	public String toString() {
		return "Malzeme [id=" + id + ", malzemeAdi=" + malzemeAdi + ", maximum=" + maximum + ", minimum=" + minimum
				+ ", mevcut=" + mevcut + ", malzemeGirisList=" + malzemeGirisList + ", malzemeCikisList="
				+ malzemeCikisList + "]";
	}

}