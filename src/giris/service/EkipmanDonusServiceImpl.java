package giris.service;

import java.util.Date;
import java.util.List;

import giris.dao.EkipmanDonusDAO;
import giris.dao.EkipmanDonusDAOImpl;
import giris.model.EkipmanServisDonus;

public class EkipmanDonusServiceImpl implements EkipmanDonusService{

	EkipmanDonusDAO ekipmanDonusDAO=new EkipmanDonusDAOImpl();
	
	@Override
	public EkipmanServisDonus EkipmanDonusYap(String aciklama, Date donusTarih,Integer faturaNo,
			Date faturaTarih, Integer parcaUcreti, Integer servisUcreti, String seriNo) {

		EkipmanServisDonus ekipmanServisDonus=ekipmanDonusDAO.EkipmanDonusYap(aciklama, donusTarih, faturaNo, faturaTarih, parcaUcreti, servisUcreti, seriNo);
		
		return ekipmanServisDonus;
	}

	@Override
	public EkipmanServisDonus EkipmanDonusBul(int id) {
		
		EkipmanServisDonus ekipmanServisDonus=ekipmanDonusDAO.EkipmanDonusBul(id);
		
		return ekipmanServisDonus;
	}

	@Override
	public void EkipmanDonusSil(int id) {
		
		ekipmanDonusDAO.EkipmanDonusSil(id);
		
	}

	@Override
	public List<EkipmanServisDonus> EkipmanServisDonusListele() {
		
		List<EkipmanServisDonus> ekipmanServisDonusList=ekipmanDonusDAO.EkipmanServisDonusListele();
		
		return ekipmanServisDonusList;
	}

}
