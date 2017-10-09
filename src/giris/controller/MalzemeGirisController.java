package giris.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import giris.model.Malzeme;
import giris.model.MalzemeGiri;
import giris.service.MalzemeGirisServiceImpl;
import giris.service.MalzemeServiceImpl;

@ManagedBean
@SessionScoped
public class MalzemeGirisController {

	private int girisAdet;
	private Date girisTarih;
	private String firma;
	private int faturaNo;
	private Date faturaTarih;
	private String aciklama;
	private int malzeme_id;


	private List<MalzemeGiri> malzemeGirisList;

	MalzemeServiceImpl malzemeServiceImpl = new MalzemeServiceImpl();


	public int getMalzeme_id() {
		return malzeme_id;
	}

	public void setMalzeme_id(int malzeme_id) {
		this.malzeme_id = malzeme_id;
	}

	public List<MalzemeGiri> getMalzemeGirisList() {
		MalzemeGirisServiceImpl girisServiceImpl = new MalzemeGirisServiceImpl();
		malzemeGirisList = girisServiceImpl.TumMalzemeGirisleriGoster();
		return malzemeGirisList;
	}

	public void setMalzemeGirisList(List<MalzemeGiri> malzemeGirisList) {
		this.malzemeGirisList = malzemeGirisList;
	}

	public int getGirisAdet() {
		return girisAdet;
	}

	public void setGirisAdet(int girisAdet) {
		this.girisAdet = girisAdet;
	}

	public Date getGirisTarih() {
		return girisTarih;
	}

	public void setGirisTarih(Date girisTarih) {
		this.girisTarih = girisTarih;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public int getFaturaNo() {
		return faturaNo;
	}

	public void setFaturaNo(int faturaNo) {
		this.faturaNo = faturaNo;
	}

	public Date getFaturaTarih() {
		return faturaTarih;
	}

	public void setFaturaTarih(Date faturaTarih) {
		this.faturaTarih = faturaTarih;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public MalzemeGirisController(int girisAdet, Date girisTarih, String firma, int faturaNo, Date faturaTarih,
			String aciklama) {
		super();
		this.girisAdet = girisAdet;
		this.girisTarih = girisTarih;
		this.firma = firma;
		this.faturaNo = faturaNo;
		this.faturaTarih = faturaTarih;
		this.aciklama = aciklama;
	}

	public MalzemeGirisController() {

	}

	public MalzemeGiri MalzemeGirisKayýt() {

		MalzemeGirisServiceImpl malzemeServiceImpl = new MalzemeGirisServiceImpl();
		MalzemeServiceImpl serviceImpl = new MalzemeServiceImpl();
		Malzeme malzeme = serviceImpl.MalzemeBul(malzeme_id);
		MalzemeGiri malzemeGiris = malzemeServiceImpl.MalzemeGirisYap(girisAdet, girisTarih, firma, faturaNo,
				faturaTarih, aciklama, malzeme.getMalzemeAdi(), malzeme);
		MalzemeGirisStokHesapla(malzeme.getId());
		return malzemeGiris;
	}

	public List<MalzemeGiri> MalzemeGirisleriGetir() {
		MalzemeGirisServiceImpl girisServiceImpl = new MalzemeGirisServiceImpl();
		malzemeGirisList = new ArrayList<MalzemeGiri>();
		malzemeGirisList = girisServiceImpl.TumMalzemeGirisleriGoster();
		for (MalzemeGiri m : malzemeGirisList) {
			System.out.println(m);
		}
		return malzemeGirisList;
	}

	public void MalzemeGirisSil(int id) {
		MalzemeGirisServiceImpl girisServiceImpl = new MalzemeGirisServiceImpl();

		girisServiceImpl.MalzemeGirisSil(id);

	}

	public void MalzemeSil(int id) {
		MalzemeGirisServiceImpl girisServiceImpl = new MalzemeGirisServiceImpl();
		girisServiceImpl.MalzemeGirisSil(id);
	}

	// Eski hali (Metod düzgün çalýþýyor testte. Fakat form ekranýnda ayný
	// deðil!!!)

	public int MalzemeGirisStokHesapla(int id) {

		MalzemeServiceImpl malzemeServiceImpl = new MalzemeServiceImpl();
		Malzeme malzeme = malzemeServiceImpl.MalzemeBul(id);

		System.out.println(malzeme.getMalzemeAdi());
		System.out.println(malzeme.getMevcut());
		malzeme.setMevcut(malzeme.getMevcut() + girisAdet);
		System.out.println(malzeme.getMevcut());
		malzemeServiceImpl.MalzemeGuncelle(id, malzeme.getMalzemeAdi(), malzeme.getMaximum(), malzeme.getMinimum(),
				malzeme.getMevcut());
		return malzeme.getMevcut();
	}
}
