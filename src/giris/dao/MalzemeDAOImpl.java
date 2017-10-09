package giris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import giris.model.Malzeme;

public class MalzemeDAOImpl implements MalzemeDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public MalzemeDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	@Override
	public Malzeme createMalzeme(String malzemeAdi, int maximum, int minimum) {
		Malzeme malzeme = new Malzeme(malzemeAdi, maximum, minimum);

		entityTransaction.begin();
		entityManager.persist(malzeme);
		entityTransaction.commit();
		return malzeme;
	}

	@Override
	public Malzeme MalzemeBul(int id) {

		Malzeme malzeme = entityManager.find(Malzeme.class, id);
		return malzeme;
	}

	@Override
	public List<Malzeme> TumMalzemeler() {
		Query query = entityManager.createQuery("Select m from Malzeme m");
		return query.getResultList();
	}

	@Override
	public void MalzemeSil(int id) {
		Malzeme malzeme = MalzemeBul(id);
		if (malzeme != null) {
			entityTransaction.begin();
			entityManager.remove(malzeme);
			entityTransaction.commit();
		}

	}

	@Override
	public Malzeme MalzemeGuncelle(int id, String malzemeAdi, int maximum, int minimum,int mevcut) {
		Malzeme malzeme = MalzemeBul(id);
		if (malzeme != null) {
			entityTransaction.begin();
			malzeme.setMalzemeAdi(malzemeAdi);
			malzeme.setMaximum(maximum);
			malzeme.setMinimum(minimum);
			malzeme.setMevcut(mevcut);
			entityTransaction.commit();
		}
		return malzeme;
	}

	@Override
	public Malzeme createMalzeme1(String malzemeAdi, int maximum, int minimum, int mevcut) {
		Malzeme malzeme=new Malzeme(malzemeAdi, maximum, minimum, mevcut);
		entityTransaction.begin();
		entityManager.persist(malzeme);
		entityTransaction.commit();
		return malzeme;
	}

}
