package giris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import giris.model.Ekipman;

public class EkipmanDAOImpl implements EkipmanDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;
	
	public EkipmanDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	@Override
	public Ekipman CreateEkipman(String ekipmanAdi) {
		Ekipman ekipman=new Ekipman(ekipmanAdi);
		entityTransaction.begin();
		entityManager.persist(ekipman);
		entityTransaction.commit();
		return ekipman;
	}

	@Override
	public void EkipmanSil(int id) {
		Ekipman ekipman=EkipmanBul(id);
		if (ekipman!=null) {
			entityTransaction.begin();
			entityManager.remove(ekipman);
			entityTransaction.commit();
		}
	}

	@Override
	public List<Ekipman> TumEkipmanBul() {
		Query query=entityManager.createQuery("Select e from Ekipman e");
		return query.getResultList();
	}

	@Override
	public Ekipman EkipmanBul(int id) {
		Ekipman ekipman=entityManager.find(Ekipman.class, id);
		return ekipman;
	}

	@Override
	public Ekipman EkipmanGuncelle(int id,String ekipmanAdi) {
		Ekipman ekipman=EkipmanBul(id);
		if (ekipman!=null) {
			entityTransaction.begin();
			ekipman.setEkipmanAdi(ekipmanAdi);
			entityTransaction.commit();
		}
		return ekipman;
	}

	@Override
	public List<String> TumEkipmanAdBul() {
		Query query=entityManager.createQuery("Select e.ekipmanAdi from Ekipman e");
		return query.getResultList();
	}

	
	
}
