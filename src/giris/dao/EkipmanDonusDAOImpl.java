package giris.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import giris.model.EkipmanServisDonus;

public class EkipmanDonusDAOImpl implements EkipmanDonusDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public EkipmanDonusDAOImpl() {

		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	@Override
	public EkipmanServisDonus EkipmanDonusYap(String aciklama, Date donusTarih, Integer faturaNo,
			Date faturaTarih, Integer parcaUcreti, Integer servisUcreti, String seriNo) {

		EkipmanServisDonus ekipmanServisDonus = new EkipmanServisDonus(aciklama, donusTarih, faturaNo,
				faturaTarih, parcaUcreti, servisUcreti, seriNo);

		entityTransaction.begin();
		entityManager.persist(ekipmanServisDonus);
		entityTransaction.commit();
		return ekipmanServisDonus;
	}

	@Override
	public EkipmanServisDonus EkipmanDonusBul(int id) {

		EkipmanServisDonus ekipmanServisDonus = entityManager.find(EkipmanServisDonus.class, id);

		return ekipmanServisDonus;

	}

	@Override
	public void EkipmanDonusSil(int id) {

		EkipmanServisDonus ekipmanServisDonus=EkipmanDonusBul(id);
		
		if (ekipmanServisDonus!=null) {
			entityManager.remove(ekipmanServisDonus);
		}
	}

	@Override
	public List<EkipmanServisDonus> EkipmanServisDonusListele() {
		
		Query query=entityManager.createQuery("Select e from EkipmanServisDonus e");
		
		return query.getResultList();

	}

}
