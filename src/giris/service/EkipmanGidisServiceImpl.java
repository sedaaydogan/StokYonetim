package giris.service;

import java.util.Date;
import java.util.List;

import giris.dao.EkipmanGidisDAO;
import giris.dao.EkipmanGidisDAOImpl;
import giris.model.Ekipman;
import giris.model.EkipmanServisGidi;
import giris.model.User;

public class EkipmanGidisServiceImpl implements EkipmanGidisService {

	EkipmanGidisDAO ekipmanGidisDAO = new EkipmanGidisDAOImpl();

	@Override
	public EkipmanServisGidi EkipmanServisGidisYap(Ekipman ekipman, String model, String kullaniciAdi, Date gidisTarihi,
			String firmaAdi, String ekipmanAdi, String aciklama, User user, String seriNo) {

		EkipmanServisGidi ekipmanServisGidis = ekipmanGidisDAO.EkipmanServisGidisYap(ekipman, model, kullaniciAdi,
				gidisTarihi, firmaAdi, ekipmanAdi, aciklama, user,seriNo);
		return ekipmanServisGidis;
	}

	@Override
	public EkipmanServisGidi EkipmanServisGidisBul(int id) {

		EkipmanServisGidi ekipmanServisGidis = ekipmanGidisDAO.EkipmanServisGidisBul(id);
		return ekipmanServisGidis;
	}

	@Override
	public List<EkipmanServisGidi> EkipmanServisGidisListele() {
		List<EkipmanServisGidi> ekipmanServisGidisList = ekipmanGidisDAO.EkipmanServisGidisListele();
		return ekipmanServisGidisList;
	}

	@Override
	public void EkipmanServisGidisSil(int id) {

		ekipmanGidisDAO.EkipmanServisGidisSil(id);
	}

}
