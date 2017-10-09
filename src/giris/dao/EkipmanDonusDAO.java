package giris.dao;

import java.util.Date;
import java.util.List;

import giris.model.EkipmanServisDonus;

public interface EkipmanDonusDAO {

	
	public EkipmanServisDonus EkipmanDonusYap(String aciklama, Date donusTarih, Integer faturaNo, Date faturaTarih, Integer parcaUcreti, Integer servisUcreti, String seriNo);
	
	public EkipmanServisDonus EkipmanDonusBul(int id);
	
	public void EkipmanDonusSil(int id);
	
	public List<EkipmanServisDonus> EkipmanServisDonusListele();
}
