package giris.service;

import java.util.List;

import giris.dao.EkipmanDAO;
import giris.dao.EkipmanDAOImpl;
import giris.model.Ekipman;

public class EkipmanServiceImpl implements EkipmanService {

	EkipmanDAO ekipmanDao=new EkipmanDAOImpl();
	
	@Override
	public Ekipman CreateEkipman(String ekipmanAdi) {
		return ekipmanDao.CreateEkipman(ekipmanAdi);
	}

	@Override
	public void EkipmanSil(int id) {
		ekipmanDao.EkipmanSil(id);
	}

	@Override
	public List<Ekipman> TumEkipmanBul() {
		return ekipmanDao.TumEkipmanBul();
	}

	@Override
	public Ekipman EkipmanBul(int id) {
		return ekipmanDao.EkipmanBul(id);
	}

	@Override
	public Ekipman EkipmanGuncelle(int id, String ekipmanAdi) {
		Ekipman ekipman=ekipmanDao.EkipmanGuncelle(id, ekipmanAdi);
		return ekipman;
	}

	@Override
	public List<String> TumEkipmanAdBul() {
		return ekipmanDao.TumEkipmanAdBul();
	}

	
	
}
