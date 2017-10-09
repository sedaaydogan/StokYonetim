package giris.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "EkipmanServisDonus" database table.
 * 
 */
@Entity
@Table(name="\"EkipmanServisDonus\"")
@NamedQuery(name="EkipmanServisDonus.findAll", query="SELECT e FROM EkipmanServisDonus e")
public class EkipmanServisDonus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="EKIP_DONUS_GEN")
	@TableGenerator(name="EKIP_DONUS_GEN")
	private Integer id;

	private String aciklama;

	@Temporal(TemporalType.DATE)
	@Column(name="donus_tarih")
	private Date donusTarih;

	@Column(name="ekipman_adi")
	private String ekipmanAdi;

	@Column(name="fatura_no")
	private Integer faturaNo;

	@Temporal(TemporalType.DATE)
	@Column(name="fatura_tarih")
	private Date faturaTarih;

	@Column(name="parca_ucreti")
	private Integer parcaUcreti;

	@Column(name="servis_ucreti")
	private Integer servisUcreti;
	
	@Column(name="seri_no")
	private String seriNo;
	
	@ManyToOne
	private Ekipman ekipman;
	

	public EkipmanServisDonus() {
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

	public Date getDonusTarih() {
		return this.donusTarih;
	}

	public void setDonusTarih(Date donusTarih) {
		this.donusTarih = donusTarih;
	}

	public String getEkipmanAdi() {
		return this.ekipmanAdi;
	}

	public void setEkipmanAdi(String ekipmanAdi) {
		this.ekipmanAdi = ekipmanAdi;
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

	public Integer getParcaUcreti() {
		return this.parcaUcreti;
	}

	public void setParcaUcreti(Integer parcaUcreti) {
		this.parcaUcreti = parcaUcreti;
	}

	public Integer getServisUcreti() {
		return this.servisUcreti;
	}

	public void setServisUcreti(Integer servisUcreti) {
		this.servisUcreti = servisUcreti;
	}

	public EkipmanServisDonus(String aciklama, Date donusTarih, Integer faturaNo, Date faturaTarih,
			Integer parcaUcreti, Integer servisUcreti, String seriNo) {
		super();
		this.aciklama = aciklama;
		this.donusTarih = donusTarih;
		this.faturaNo = faturaNo;
		this.faturaTarih = faturaTarih;
		this.parcaUcreti = parcaUcreti;
		this.servisUcreti = servisUcreti;
		this.seriNo = seriNo;
	}

	@Override
	public String toString() {
		return "EkipmanServisDonus [id=" + id + ", aciklama=" + aciklama + ", donusTarih=" + donusTarih
				+ ", ekipmanAdi=" + ekipmanAdi + ", faturaNo=" + faturaNo + ", faturaTarih=" + faturaTarih
				+ ", parcaUcreti=" + parcaUcreti + ", servisUcreti=" + servisUcreti + ", seriNo=" + seriNo
				+ ", ekipman=" + ekipman + "]";
	}

	
	
}