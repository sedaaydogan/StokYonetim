package giris.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import giris.model.Ekipman;
import giris.service.EkipmanService;
import giris.service.EkipmanServiceImpl;

@ManagedBean
@SessionScoped
public class EkipmanController {

	private String ekipmanAdi;
	private List<Ekipman> ekipmanList;
	private List<String> ekipmanAdList;

	public List<Ekipman> getEkipmanList() {
		EkipmanServiceImpl ekipmanServiceImpl=new EkipmanServiceImpl();
		ekipmanList=ekipmanServiceImpl.TumEkipmanBul();
		return ekipmanList;
	}

	public void setEkipmanList(List<Ekipman> ekipmanList) {
		this.ekipmanList = ekipmanList;
	}

	public String getEkipmanAdi() {
		return ekipmanAdi;
	}

	public void setEkipmanAdi(String ekipmanAdi) {
		this.ekipmanAdi = ekipmanAdi;
	}
	
	public Ekipman EkipmanEkle(){
		EkipmanService ekipmanService=new EkipmanServiceImpl();
		Ekipman ekipman=ekipmanService.CreateEkipman(ekipmanAdi);
		return ekipman;
	}
	
	public List<Ekipman> EkipmanGetir(){
		EkipmanService ekipmanService=new EkipmanServiceImpl();
		List<Ekipman> ekipmanList=ekipmanService.TumEkipmanBul();
		return ekipmanList;
	}
	
	public void EkipmanSil(int id){
		EkipmanServiceImpl ekipmanService=new EkipmanServiceImpl();
		ekipmanService.EkipmanSil(id);
	}
	
	public void EkipmanGuncelle(int id){
		EkipmanServiceImpl ekipmanServiceImpl=new EkipmanServiceImpl();
		ekipmanServiceImpl.EkipmanGuncelle(id, ekipmanAdi);
	}

	public List<String> getEkipmanAdList() {
		EkipmanServiceImpl ekipmanServiceImpl=new EkipmanServiceImpl();
		ekipmanAdList=ekipmanServiceImpl.TumEkipmanAdBul();
		return ekipmanAdList;
	}

	public void setEkipmanAdList(List<String> ekipmanAdList) {
		this.ekipmanAdList = ekipmanAdList;
	}
	
	
}
