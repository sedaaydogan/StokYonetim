package giris.controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import giris.model.Ekipman;
import giris.model.EkipmanServisGidi;
import giris.model.User;
import giris.service.EkipmanGidisService;
import giris.service.EkipmanGidisServiceImpl;
import giris.service.EkipmanService;
import giris.service.EkipmanServiceImpl;
import giris.service.UserService;
import giris.service.UserServiceImpl;

@ManagedBean
@SessionScoped
public class EkipmanGidisController {

	private int ekipmanId;
	private int userId;
	private String aciklama;
	private String firmaAdi;
	private Date gidisTarihi;
	private String model;
	private String seriNo;
	private List<EkipmanServisGidi> ekipmanServisGidisList;

	public EkipmanGidisController() {

	}
	
	public List<EkipmanServisGidi> getEkipmanServisGidisList() {
		EkipmanGidisService ekipmanGidisService=new EkipmanGidisServiceImpl();
		ekipmanServisGidisList=ekipmanGidisService.EkipmanServisGidisListele();
		return ekipmanServisGidisList;
	
	}

	public void setEkipmanServisGidisList(List<EkipmanServisGidi> ekipmanServisGidisList) {
		this.ekipmanServisGidisList = ekipmanServisGidisList;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public int getEkipmanId() {
		return ekipmanId;
	}

	public void setEkipmanId(int ekipmanId) {
		this.ekipmanId = ekipmanId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public Date getGidisTarihi() {
		return gidisTarihi;
	}

	public void setGidisTarihi(Date gidisTarihi) {
		this.gidisTarihi = gidisTarihi;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public EkipmanGidisController(int ekipmanId, int userId, String aciklama, String firmaAdi, Date gidisTarihi,
			String model, String seriNo) {
		super();
		this.ekipmanId = ekipmanId;
		this.userId = userId;
		this.aciklama = aciklama;
		this.firmaAdi = firmaAdi;
		this.gidisTarihi = gidisTarihi;
		this.model = model;
		this.seriNo = seriNo;
	}

	@Override
	public String toString() {
		return "EkipmanGidisController [ekipmanId=" + ekipmanId + ", userId=" + userId + ", aciklama=" + aciklama
				+ ", firmaAdi=" + firmaAdi + ", gidisTarihi=" + gidisTarihi + ", model=" + model + ", seriNo=" + seriNo
				+ "]";
	}


	public void EkipmanGidisKaydet(){
		
		EkipmanGidisService ekipmanGidisService=new EkipmanGidisServiceImpl();
		EkipmanService ekipmanService=new EkipmanServiceImpl();
		UserService userService=new UserServiceImpl();
		Ekipman ekipman=ekipmanService.EkipmanBul(ekipmanId);
		User user=userService.findUser(userId);
		
		ekipmanGidisService.EkipmanServisGidisYap(ekipman, model, user.getUsername(), gidisTarihi, firmaAdi, ekipman.getEkipmanAdi(), aciklama, user, seriNo);
	}

	
	
	public void EkipmanGidisSil(int id){
		
		EkipmanGidisService ekipmanGidisService=new EkipmanGidisServiceImpl();
		
		ekipmanGidisService.EkipmanServisGidisSil(id);
		
	}
}
