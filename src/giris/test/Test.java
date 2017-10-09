package giris.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import giris.controller.MalzemeGirisController;
import giris.model.Ekipman;
import giris.model.Malzeme;
import giris.model.Role;
import giris.model.User;
import giris.service.EkipmanService;
import giris.service.EkipmanServiceImpl;
import giris.service.MalzemeGirisServiceImpl;
import giris.service.MalzemeService;
import giris.service.MalzemeServiceImpl;
import giris.service.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();


		entityTransaction.begin();
		
		Role admin=userServiceImpl.createRole("admin");
		Role kullanici=userServiceImpl.createRole("user");
		
		entityTransaction.commit();
		
	}
}
