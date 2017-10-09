package giris.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import giris.model.Malzeme;
import giris.service.MalzemeServiceImpl;

@ManagedBean(name="malzemeController", eager=true)
@SessionScoped
public class MalzemeController {

	private String malzemeAdi;
	private int maximum;
	private int minimum;
	private int mevcut;
	private List<Malzeme> malzemeList;

	
	public List<Malzeme> getMalzemeList() {
		MalzemeServiceImpl impl=new MalzemeServiceImpl();
		malzemeList=impl.TumMalzemeler();
		return malzemeList;
	}

	public void setMalzemeList(List<Malzeme> malzemeList) {
		this.malzemeList = malzemeList;
	}

	public int getMevcut() {
		return mevcut;
	}

	public void setMevcut(int mevcut) {
		this.mevcut = mevcut;
	}

	public String getMalzemeAdi() {
		return malzemeAdi;
	}

	public void setMalzemeAdi(String malzemeAdi) {
		this.malzemeAdi = malzemeAdi;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public MalzemeController(String malzemeAdi, int maximum, int minimum) {
		super();
		this.malzemeAdi = malzemeAdi;
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public MalzemeController(String malzemeAdi, int maximum, int minimum, int mevcut) {
		super();
		this.malzemeAdi = malzemeAdi;
		this.maximum = maximum;
		this.minimum = minimum;
		this.mevcut = mevcut;
	}

	@Override
	public String toString() {
		return "MalzemeController [malzemeAdi=" + malzemeAdi + ", maximum=" + maximum + ", minimum=" + minimum + "]";
	}

	public Malzeme MalzemeEkle() {
		MalzemeServiceImpl malzemeServiceImpl = new MalzemeServiceImpl();
		Malzeme malzeme = malzemeServiceImpl.createMalzeme(malzemeAdi, maximum, minimum);
		return malzeme;
	}

	public void MalzemeSil(int id) {
		MalzemeServiceImpl impl = new MalzemeServiceImpl();
		impl.MalzemeSil(id);
	}
	
	public MalzemeController() {

	}
	
	public Malzeme MalzemeGuncelle(int id){
		MalzemeServiceImpl impl=new MalzemeServiceImpl();
		Malzeme malzeme=impl.MalzemeGuncelle(id, malzemeAdi, maximum, minimum,mevcut);
		return malzeme;
	}
}
