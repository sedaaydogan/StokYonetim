package giris.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the "EkipmanServisGidis" database table.
 * 
 */
@Entity
@Table(name="\"EkipmanServisGidis\"")
@NamedQuery(name="EkipmanServisGidi.findAll", query="SELECT e FROM EkipmanServisGidi e")
public class EkipmanServisGidi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="EKIP_GIDIS_GEN")
	@TableGenerator(name="EKIP_GIDIS_GEN")
	private Integer id;

	private String aciklama;

	@Column(name="ekipman_adi")
	private String ekipmanAdi;

	@Column(name="firma_adi")
	private String firmaAdi;

	@Temporal(TemporalType.DATE)
	@Column(name="gidis_tarihi")
	private Date gidisTarihi;

	@Column(name="kullanici_adi")
	private String kullaniciAdi;

	private String model;
	
	@Column(name="seri_no")
	private String seriNo;
	
	@ManyToOne
	private Ekipman ekipman;
	

	@ManyToOne
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EkipmanServisGidi() {
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
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

	public String getEkipmanAdi() {
		return this.ekipmanAdi;
	}

	public void setEkipmanAdi(String ekipmanAdi) {
		this.ekipmanAdi = ekipmanAdi;
	}

	public String getFirmaAdi() {
		return this.firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public Date getGidisTarihi() {
		return this.gidisTarihi;
	}

	public void setGidisTarihi(Date gidisTarihi) {
		this.gidisTarihi = gidisTarihi;
	}

	public String getKullaniciAdi() {
		return this.kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public EkipmanServisGidi(String aciklama, String ekipmanAdi, String firmaAdi, Date gidisTarihi, String kullaniciAdi,
			String model, String seriNo, Ekipman ekipman, User user) {
		super();
		this.aciklama = aciklama;
		this.ekipmanAdi = ekipmanAdi;
		this.firmaAdi = firmaAdi;
		this.gidisTarihi = gidisTarihi;
		this.kullaniciAdi = kullaniciAdi;
		this.model = model;
		this.seriNo = seriNo;
		this.ekipman = ekipman;
		this.user = user;
	}


	
	

}