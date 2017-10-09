package giris.service;


import java.util.Date;
import java.util.List;

import giris.dao.MalzemeGirisDAO;
import giris.dao.MalzemeGirisDAOImpl;
import giris.model.Malzeme;
import giris.model.MalzemeGiri;

public class MalzemeGirisServiceImpl implements MalzemeGirisService {

	MalzemeGirisDAO malzemeGirisDao=new MalzemeGirisDAOImpl();
	
	
	@Override
	public MalzemeGiri MalzemeGirisYap(int girisAdet, Date girisTarih, String firma, int faturaNo, Date faturaTarih,
			String aciklama, String malzemeAdi,Malzeme malzeme) {
		MalzemeGiri malzemeGiris=malzemeGirisDao.MalzemeGirisYap(girisAdet, girisTarih, firma, faturaNo, faturaTarih, aciklama, malzemeAdi,malzeme);
		return malzemeGiris;
	}

	@Override
	public List<MalzemeGiri> TumMalzemeGirisleriGoster() {
		List<MalzemeGiri> malzemeGirisList=malzemeGirisDao.TumMalzemeGirisleriGoster();
		return malzemeGirisList;
	}

	@Override
	public MalzemeGiri MalzemeGirisBul(int id) {

		MalzemeGiri malzemeGiris=malzemeGirisDao.MalzemeGirisBul(id);
		
		return malzemeGiris;
	}

	@Override
	public void MalzemeGirisSil(int id) {
		malzemeGirisDao.MalzemeGirisSil(id);
	}

	@Override
	public MalzemeGiri MalzemeGuncelle(int id, int girisAdet, Date girisTarih, String firma, int faturaNo,
			Date faturaTarih, String aciklama, String firmaAdi, String malzemeAdi,Malzeme malzeme) {
		return malzemeGirisDao.MalzemeGuncelle(id, girisAdet, girisTarih, firma, faturaNo, faturaTarih, aciklama, firmaAdi, malzemeAdi,malzeme);
	}

	@Override
	public int MalzemeGirisStokHesapla(int id) {
		return malzemeGirisDao.MalzemeGirisStokHesapla(id);
	}

}
