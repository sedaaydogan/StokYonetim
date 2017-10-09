package giris.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.internal.sessions.DirectCollectionChangeRecord.NULL;

import giris.controller.MalzemeGirisController;
import giris.model.Malzeme;
import giris.model.MalzemeGiri;
import giris.service.MalzemeGirisServiceImpl;
import giris.service.MalzemeServiceImpl;

public class MalzemeGirisDAOImpl implements MalzemeGirisDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public MalzemeGirisDAOImpl() {

		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	@Override
	public MalzemeGiri MalzemeGirisYap(int girisAdet, Date girisTarih, String firmaAdi, int faturaNo, Date faturaTarih,
			String aciklama, String malzemeAdi, Malzeme malzeme) {
		MalzemeGiri malzemeGiris = new MalzemeGiri(aciklama, faturaNo, faturaTarih, firmaAdi, girisAdet, girisTarih,
				malzemeAdi, malzeme);
		entityTransaction.begin();
		entityManager.persist(malzemeGiris);
		entityTransaction.commit();
		return malzemeGiris;
	}

	@Override
	public List<MalzemeGiri> TumMalzemeGirisleriGoster() {
		Query query = entityManager.createQuery("Select m from MalzemeGiri m");
		return query.getResultList();
	}

	@Override
	public MalzemeGiri MalzemeGirisBul(int id) {
		MalzemeGiri malzeme = entityManager.find(MalzemeGiri.class, id);

		if (malzeme != null) {
			return malzeme;
		}
		return null;
	}

	@Override
	public void MalzemeGirisSil(int id) {
		MalzemeGiri malzemeGiris = MalzemeGirisBul(id);
		if (malzemeGiris != null) {
			entityTransaction.begin();
			entityManager.remove(malzemeGiris);
			entityTransaction.commit();
		}
	}

	@Override
	public MalzemeGiri MalzemeGuncelle(int id, int girisAdet, Date girisTarih, String firma, int faturaNo,
			Date faturaTarih, String aciklama, String firmaAdi, String malzemeAdi, Malzeme malzeme) {
		MalzemeGiri malzemeGiris = MalzemeGirisBul(id);

		entityTransaction.begin();
		malzemeGiris.setAciklama(aciklama);
		malzemeGiris.setFaturaNo(faturaNo);
		malzemeGiris.setFaturaTarih(faturaTarih);
		malzemeGiris.setFirmaAdi(firmaAdi);
		malzemeGiris.setGirisAdet(girisAdet);
		malzemeGiris.setGirisTarih(girisTarih);
		malzemeGiris.setMalzemeAdi(malzemeAdi);
		malzemeGiris.setMalzemeAdi(malzemeAdi);
		entityTransaction.commit();
		return malzemeGiris;
	}

	@Override
	public int MalzemeGirisStokHesapla(int id) {

		MalzemeServiceImpl malzemeServiceImpl=new MalzemeServiceImpl();
		
		Malzeme malzeme=malzemeServiceImpl.MalzemeBul(id);
		
		malzeme.setMevcut(malzeme.getMevcut());
		
		return malzeme.getMevcut();
	}

}
