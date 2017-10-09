package giris.dao;

import java.util.List;

import giris.model.Ekipman;

public interface EkipmanDAO {

	public Ekipman CreateEkipman(String ekipmanAdi);
	
	public void EkipmanSil(int id);
	
	public List<Ekipman> TumEkipmanBul();
	
	public List<String> TumEkipmanAdBul();
	
	public Ekipman EkipmanBul(int id);
	
	public Ekipman EkipmanGuncelle(int id, String ekipmanAdi);
	
}
