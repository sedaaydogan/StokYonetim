package giris.service;

import java.util.List;

import giris.model.Malzeme;

public interface MalzemeService {

	public Malzeme createMalzeme(String malzemeAdi, int maximum, int minimum);
	
	public Malzeme createMalzeme1(String malzemeAdi, int maximum, int minimum,int mevcut);
	
	public Malzeme MalzemeBul(int id);
	
	public List<Malzeme> TumMalzemeler();
	
	public void MalzemeSil(int id);
	
	public Malzeme MalzemeGuncelle(int id,String malzemeAdi,int maximum,int minimum,int mevcut);
	
}
