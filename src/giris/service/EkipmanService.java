package giris.service;

import java.util.List;

import giris.model.Ekipman;

public interface EkipmanService {

	public Ekipman CreateEkipman(String ekipmanAdi);
	
	public List<String> TumEkipmanAdBul();
	
	public void EkipmanSil(int id);
	
	public List<Ekipman> TumEkipmanBul();
	
	public Ekipman EkipmanBul(int id);
	
	public Ekipman EkipmanGuncelle(int id, String ekipmanAdi);
	
}
