package giris.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import giris.model.Role;
import giris.model.User;

public class UserDAOImpl implements UserDAO {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public UserDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("StokYonetim");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	@Override
	public List findAllUser() {
		Query query = entityManager.createQuery("Select u from User u");
		return query.getResultList();
	}

	@Override
	public User createUser(Role role, String username, String password, String sicilNo, String roleName) {
		User user = new User(sicilNo, password, username, roleName, role);
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public User findUser(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void removeUser(int id) {
		User user = findUser(id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
		}
	}

	@Override
	public User kullaniciDogrula(String username, String password) {
		try {
			String sql = "SELECT u FROM User u WHERE u.username= :username and u.password= :password";
			Query query = entityManager.createQuery(sql);
			query.setParameter("username", username);
			query.setParameter("password", password);

			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Role createRole(String roleName) {
		Role role = new Role(roleName);
		entityTransaction.begin();
		entityManager.persist(role);
		entityTransaction.commit();
		return role;
	}

	@Override
	public List<String> findAllRoleName() {
		Query query = entityManager.createQuery("Select r.roleName from Role r");
		return query.getResultList();
	}

	@Override
	public Role findRole(int id) {
		Role role = entityManager.find(Role.class, id);
		return role;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public EntityTransaction getEntityTransaction() {
		return entityTransaction;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			users = entityManager.createNamedQuery("User.findAll", User.class).getResultList();
			return users;
		} catch (Exception e) {
			return users;
		}
	}

	public List<Role> getRoles() {
		List<Role> roleList = new ArrayList<Role>();

		try {
			roleList = entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
			return roleList;
		} catch (Exception e) {
			return roleList;
		}
	}

	public void userKayýt(User user) {
		try {
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public User updateUser(int id, String username, String password, String sicilNo, Role role) {
		User user = findUser(id);
		if (user != null) {
			entityTransaction.begin();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			user.setSicilNo(sicilNo);
			entityTransaction.commit();
		}
		return user;
	}

	@Override
	public List findAllRole() {
		Query query=entityManager.createQuery("Select r from Role r");
		return query.getResultList();
	}

//	@Override
//	public User createUser1(Role role, String username, String password, String sicilNo) {
//		User user=new User(sicilNo, password, username, role);
//		
//		entityTransaction.begin();
//		entityManager.persist(user);
//		entityTransaction.commit();
//		return user;
//	}

//	@Override
//	public User CreateUser2(int role_id, String username, String sicilNo, String password) {
//		User user=new User(sicilNo, password, username, role_id);
//		return null;
//	}
}
