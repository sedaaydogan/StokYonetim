package giris.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import giris.model.Malzeme;
import giris.model.MalzemeCiki;

public class MalzemeCikisDAOImpl implements MalzemeCikisDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public MalzemeCikisDAOImpl() {

		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	@Override
	public MalzemeCiki MalzemeCikisYap(Malzeme malzeme, int cikisAdet, Date cikisTarih, String aciklama,String malzemeAdi) {
		MalzemeCiki malzemeCikis = new MalzemeCiki(aciklama, cikisAdet, cikisTarih, malzemeAdi, malzeme);

		entityTransaction.begin();
		entityManager.persist(malzemeCikis);
		entityTransaction.commit();

		return malzemeCikis;
	}

	@Override
	public void MalzemeCikisSil(int id) {

		MalzemeCiki malzemeCikis=entityManager.find(MalzemeCiki.class, id);
		
		if(malzemeCikis!=null){
			entityTransaction.begin();
			entityManager.remove(malzemeCikis);
			entityTransaction.commit();
		}
	}

	@Override
	public List<MalzemeCiki> MalzemeCikislariListele() {

		Query query=entityManager.createQuery("Select m from MalzemeCiki m");
		return query.getResultList();
	}

	@Override
	public MalzemeCiki MalzemeCikisBul(int id) {

		MalzemeCiki malzemeCikis=entityManager.find(MalzemeCiki.class, id);
		
		if(malzemeCikis!=null){
			return malzemeCikis;
		}
		
		return null;
	}

}
