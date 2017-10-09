package giris.dao;

import java.util.Date;
import java.util.List;

import giris.model.Malzeme;
import giris.model.MalzemeCiki;

public interface MalzemeCikisDAO {

	public MalzemeCiki MalzemeCikisYap(Malzeme malzeme, int cikisAdet, Date cikisTarih, String aciklama,String malzemeAdi);
	
	public void MalzemeCikisSil(int id);
	
	public List<MalzemeCiki> MalzemeCikislariListele();
	
	public MalzemeCiki MalzemeCikisBul(int id);
	
}
