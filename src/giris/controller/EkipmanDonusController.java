package giris.controller;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import giris.service.EkipmanDonusService;
import giris.service.EkipmanDonusServiceImpl;

@ManagedBean
@SessionScoped
public class EkipmanDonusController {

	private String aciklama;
	private Date donusTarih;
	private int faturaNo;
	private Date faturaTarih;
	private String seriNo;
	private int servisUcret;
	private int parcaUcret;
	
	
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public Date getDonusTarih() {
		return donusTarih;
	}
	public void setDonusTarih(Date donusTarih) {
		this.donusTarih = donusTarih;
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
	public String getSeriNo() {
		return seriNo;
	}
	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}
	public int getServisUcret() {
		return servisUcret;
	}
	public void setServisUcret(int servisUcret) {
		this.servisUcret = servisUcret;
	}
	public int getParcaUcret() {
		return parcaUcret;
	}
	public void setParcaUcret(int parcaUcret) {
		this.parcaUcret = parcaUcret;
	}
	
	public void EkipmanDonusYap(){
		
		EkipmanDonusService ekipmanDonusService=new EkipmanDonusServiceImpl();
		ekipmanDonusService.EkipmanDonusYap(aciklama, donusTarih, faturaNo, faturaTarih, parcaUcret, servisUcret, seriNo);
		
	}
	
	
	
}

