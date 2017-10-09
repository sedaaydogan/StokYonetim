package giris.service;

import java.util.Date;
import java.util.List;

import giris.dao.MalzemeCikisDAO;
import giris.dao.MalzemeCikisDAOImpl;
import giris.model.Malzeme;
import giris.model.MalzemeCiki;

public class MalzemeCikisServiceImpl implements MalzemeCikisService {

	MalzemeCikisDAO malzemeCikisDAO = new MalzemeCikisDAOImpl();

	@Override
	public MalzemeCiki MalzemeCikisYap(Malzeme malzeme, int cikisAdet, Date cikisTarih, String aciklama, String malzemeAdi) {

		MalzemeCiki malzemeCikis = malzemeCikisDAO.MalzemeCikisYap(malzeme, cikisAdet, cikisTarih, aciklama, malzemeAdi);
		return malzemeCikis;
	}

	@Override
	public void MalzemeCikisSil(int id) {

		malzemeCikisDAO.MalzemeCikisSil(id);

	}

	@Override
	public List<MalzemeCiki> MalzemeCikislariListele() {

		List<MalzemeCiki> malzemeCikisList = malzemeCikisDAO.MalzemeCikislariListele();

		return malzemeCikisList;
	}

	@Override
	public MalzemeCiki MalzemeCikisBul(int id) {

		MalzemeCiki malzemeCikis = malzemeCikisDAO.MalzemeCikisBul(id);

		return malzemeCikis;
	}

}
