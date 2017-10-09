package giris.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import giris.model.Malzeme;
import giris.model.MalzemeCiki;
import giris.service.MalzemeCikisService;
import giris.service.MalzemeCikisServiceImpl;
import giris.service.MalzemeService;
import giris.service.MalzemeServiceImpl;

@ManagedBean
@SessionScoped
public class MalzemeCikisController {

	// variable
	private int malzeme_id;
	private String aciklama;
	private int cikisAdet;
	private Date cikisTarih;
	private String malzemeAdi;
	private List<MalzemeCiki> malzemeCikisList;

	// Getter and Setter method
	public int getMalzeme_id() {
		return malzeme_id;
	}

	public int getCikisAdet() {
		return cikisAdet;
	}

	public List<MalzemeCiki> getMalzemeCikisList() {
		MalzemeCikisService malzemeCikisService = new MalzemeCikisServiceImpl();
		malzemeCikisList = malzemeCikisService.MalzemeCikislariListele();
		return malzemeCikisList;
	}

	public void setMalzemeCikisList(List<MalzemeCiki> malzemeCikisList) {
		this.malzemeCikisList = malzemeCikisList;
	}

	public String getMalzemeAdi() {
		return malzemeAdi;
	}

	public void setMalzemeAdi(String malzemeAdi) {
		this.malzemeAdi = malzemeAdi;
	}

	public void setCikisAdet(int cikisAdet) {
		this.cikisAdet = cikisAdet;
	}

	public void setMalzeme_id(int malzeme_id) {
		this.malzeme_id = malzeme_id;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Date getCikisTarih() {
		return cikisTarih;
	}

	public void setCikisTarih(Date cikisTarih) {
		this.cikisTarih = cikisTarih;
	}

	// ToString
	@Override
	public String toString() {
		return "MalzemeCikisController [malzeme_id=" + malzeme_id + ", aciklama=" + aciklama + ", cikisAdet="
				+ cikisAdet + ", cikisTarih=" + cikisTarih + ", malzemeAdi=" + malzemeAdi + "]";
	}

	// Constructor
	public MalzemeCikisController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MalzemeCikisController(String aciklama, int cikisAdet, Date cikisTarih, String malzemeAdi) {
		super();
		this.aciklama = aciklama;
		this.cikisAdet = cikisAdet;
		this.cikisTarih = cikisTarih;
		this.malzemeAdi = malzemeAdi;
	}

	public MalzemeCiki MalzemeCikisYap() {
		MalzemeCikisService malzemeCikisService = new MalzemeCikisServiceImpl();
		MalzemeService malzemeService = new MalzemeServiceImpl();
		Malzeme malzeme = malzemeService.MalzemeBul(malzeme_id);
		MalzemeCiki malzemeCikis = malzemeCikisService.MalzemeCikisYap(malzeme, cikisAdet, cikisTarih, aciklama,
				malzeme.getMalzemeAdi());
		malzeme.setMevcut(malzeme.getMevcut() - cikisAdet);
		malzemeService.MalzemeGuncelle(malzeme_id, malzeme.getMalzemeAdi(), malzeme.getMaximum(), malzeme.getMinimum(),
				malzeme.getMevcut());
		return malzemeCikis;
	}

	public void MalzemeCikisSil(int id) {

		MalzemeCikisService malzemeCikisService = new MalzemeCikisServiceImpl();
		malzemeCikisService.MalzemeCikisSil(id);

	}

}
