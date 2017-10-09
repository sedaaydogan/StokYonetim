package giris.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "MalzemeCikis" database table.
 * 
 */
@Entity
@Table(name="\"MalzemeCikis\"")
@NamedQuery(name="MalzemeCiki.findAll", query="SELECT m FROM MalzemeCiki m")
public class MalzemeCiki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="MAL_CIK_GEN")
	@TableGenerator(name="MAL_CIK_GEN")
	private Integer id;

	private String aciklama;

	@Column(name="cikis_adet")
	private Integer cikisAdet;

	@Temporal(TemporalType.DATE)
	@Column(name="cikis_tarih")
	private Date cikisTarih;

	@Column(name="malzeme_adi")
	private String malzemeAdi;
	
	@ManyToOne
	private Malzeme malzeme;

	public MalzemeCiki() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAciklama() {
		return this.aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Integer getCikisAdet() {
		return this.cikisAdet;
	}

	public void setCikisAdet(Integer cikisAdet) {
		this.cikisAdet = cikisAdet;
	}

	public Date getCikisTarih() {
		return this.cikisTarih;
	}

	public void setCikisTarih(Date cikisTarih) {
		this.cikisTarih = cikisTarih;
	}

	public String getMalzemeAdi() {
		return this.malzemeAdi;
	}

	public void setMalzemeAdi(String malzemeAdi) {
		this.malzemeAdi = malzemeAdi;
	}

	public MalzemeCiki(String aciklama, Integer cikisAdet, Date cikisTarih, String malzemeAdi, Malzeme malzeme) {
		super();
		this.aciklama = aciklama;
		this.cikisAdet = cikisAdet;
		this.cikisTarih = cikisTarih;
		this.malzemeAdi = malzemeAdi;
		this.malzeme = malzeme;
	}

	@Override
	public String toString() {
		return "MalzemeCiki [id=" + id + ", aciklama=" + aciklama + ", cikisAdet=" + cikisAdet + ", cikisTarih="
				+ cikisTarih + ", malzemeAdi=" + malzemeAdi + ", malzeme=" + malzeme + "]";
	}

}