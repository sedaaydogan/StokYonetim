package giris.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import giris.model.Ekipman;
import giris.model.EkipmanServisGidi;
import giris.model.User;

public class EkipmanGidisDAOImpl implements EkipmanGidisDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public EkipmanGidisDAOImpl() {

		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	@Override
	public EkipmanServisGidi EkipmanServisGidisYap(Ekipman ekipman, String model, String kullaniciAdi, Date gidisTarihi,
			String firmaAdi, String ekipmanAdi, String aciklama, User user,String seriNo) {

		EkipmanServisGidi ekipmanServisGidis = new EkipmanServisGidi(aciklama, ekipmanAdi, firmaAdi, gidisTarihi, kullaniciAdi, model, seriNo, ekipman, user);

		entityTransaction.begin();
		entityManager.persist(ekipmanServisGidis);
		entityTransaction.commit();
		return ekipmanServisGidis;
	}

	@Override
	public EkipmanServisGidi EkipmanServisGidisBul(int id) {

		EkipmanServisGidi ekipmanServisGidis = entityManager.find(EkipmanServisGidi.class, id);

		return ekipmanServisGidis;

	}

	@Override
	public List<EkipmanServisGidi> EkipmanServisGidisListele() {

		Query query = entityManager.createQuery("SELECT e FROM EkipmanServisGidi e");
		return query.getResultList();

	}

	@Override
	public void EkipmanServisGidisSil(int id) {

		EkipmanServisGidi ekipmanServisGidis = EkipmanServisGidisBul(id);

		if (ekipmanServisGidis != null) {
			entityTransaction.begin();
			entityManager.remove(ekipmanServisGidis);
			entityTransaction.commit();
		}

	}

}
