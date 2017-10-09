package giris.service;

import java.util.List;

import giris.dao.MalzemeDAO;
import giris.dao.MalzemeDAOImpl;
import giris.model.Malzeme;

public class MalzemeServiceImpl implements MalzemeService {

	MalzemeDAO malzemeDao=new MalzemeDAOImpl();
	
	@Override
	public Malzeme createMalzeme(String malzemeAdi, int maximum, int minimum) {
		return malzemeDao.createMalzeme(malzemeAdi, maximum, minimum);
	}
	
	

	@Override
	public Malzeme MalzemeBul(int id) {
		return malzemeDao.MalzemeBul(id);
	}

	@Override
	public List<Malzeme> TumMalzemeler() {
		return malzemeDao.TumMalzemeler();
	}

	@Override
	public void MalzemeSil(int id) {

		malzemeDao.MalzemeSil(id);
		
	}

	@Override
	public Malzeme MalzemeGuncelle(int id, String malzemeAdi, int maximum, int minimum,int mevcut) {
		return malzemeDao.MalzemeGuncelle(id, malzemeAdi, maximum, minimum,mevcut);
	}



	@Override
	public Malzeme createMalzeme1(String malzemeAdi, int maximum, int minimum, int mevcut) {
		Malzeme malzeme=malzemeDao.createMalzeme1(malzemeAdi, maximum, minimum, mevcut);
		return malzeme;
	}

}
