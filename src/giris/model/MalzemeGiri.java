package giris.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "MalzemeGiris" database table.
 * 
 */
@Entity
@Table(name="\"MalzemeGiris\"")
@NamedQuery(name="MalzemeGiri.findAll", query="SELECT m FROM MalzemeGiri m")
public class MalzemeGiri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MAL_GIR_GEN")
	@GeneratedValue(generator="MAL_GIR_GEN")
	private Integer id;
	

	private String aciklama;

	@Column(name="fatura_no")
	private Integer faturaNo;

	@Temporal(TemporalType.DATE)
	@Column(name="fatura_tarih")
	private Date faturaTarih;

	@Column(name="firma_adi")
	private String firmaAdi;

	@Column(name="giris_adet")
	private Integer girisAdet;

	@Temporal(TemporalType.DATE)
	@Column(name="giris_tarih")
	private Date girisTarih;

	@Column(name="malzeme_adi")
	private String malzemeAdi;
	
	@ManyToOne
	private Malzeme malzeme;


	public MalzemeGiri() {
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

	public Integer getFaturaNo() {
		return this.faturaNo;
	}

	public void setFaturaNo(Integer faturaNo) {
		this.faturaNo = faturaNo;
	}

	public Date getFaturaTarih() {
		return this.faturaTarih;
	}

	public void setFaturaTarih(Date faturaTarih) {
		this.faturaTarih = faturaTarih;
	}

	public String getFirmaAdi() {
		return this.firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public Integer getGirisAdet() {
		return this.girisAdet;
	}

	public void setGirisAdet(Integer girisAdet) {
		this.girisAdet = girisAdet;
	}

	public Date getGirisTarih() {
		return this.girisTarih;
	}

	public void setGirisTarih(Date girisTarih) {
		this.girisTarih = girisTarih;
	}

	public String getMalzemeAdi() {
		return this.malzemeAdi;
	}

	public void setMalzemeAdi(String malzemeAdi) {
		this.malzemeAdi = malzemeAdi;
	}

	public Malzeme getMalzeme() {
		return malzeme;
	}


	public void setMalzeme(Malzeme malzeme) {
		this.malzeme = malzeme;
	}




	@Override
	public String toString() {
		return "MalzemeGiri [id=" + id + ", aciklama=" + aciklama + ", faturaNo=" + faturaNo + ", faturaTarih="
				+ faturaTarih + ", firmaAdi=" + firmaAdi + ", girisAdet=" + girisAdet + ", girisTarih=" + girisTarih
				+ ", malzemeAdi=" + malzemeAdi + ", malzeme=" + malzeme + "]";
	}


	public MalzemeGiri(String aciklama, Integer faturaNo, Date faturaTarih, String firmaAdi, Integer girisAdet,
			Date girisTarih, String malzemeAdi, Malzeme malzeme) {
		super();
		this.aciklama = aciklama;
		this.faturaNo = faturaNo;
		this.faturaTarih = faturaTarih;
		this.firmaAdi = firmaAdi;
		this.girisAdet = girisAdet;
		this.girisTarih = girisTarih;
		this.malzemeAdi = malzemeAdi;
		this.malzeme = malzeme;
	}






	
}