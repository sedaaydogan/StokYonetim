package giris.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import giris.dao.UserDAOImpl;
import giris.model.Role;
import giris.model.User;

public class UserServiceImpl implements UserService {

	private static UserDAOImpl userDAOImpl;

	public UserServiceImpl() {

		userDAOImpl = new UserDAOImpl();
	}

	public static UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}

	public User createUser(Role role,String username, String password, String sicilNo, String roleName) {
		return getUserDAOImpl().createUser(role,username, password, sicilNo, roleName);
	}

	public User findUser(int id) {
		return getUserDAOImpl().findUser(id);
	}

	public List<User> findAllUser() {
		return getUserDAOImpl().findAllUser();
	}

	
	public User kullaniciDogrula(String username, String password) {
		return getUserDAOImpl().kullaniciDogrula(username, password);
	}

	public EntityManager getEntityManager() {
		return getUserDAOImpl().getEntityManager();
	}

	public EntityTransaction getEntityTransaction() {
		return getUserDAOImpl().getEntityTransaction();
	}

	public List<User> getUsers() {
		return getUserDAOImpl().getUsers();
	}
	
	public List<Role> getRoles(){
		return getUserDAOImpl().getRoles();
	}

	public void userKayýt(User user) {
		getUserDAOImpl().userKayýt(user);
	}
	public Role createRole(String roleName) {
		return getUserDAOImpl().createRole(roleName);
	}

	public Role findRole(int id) {
		return getUserDAOImpl().findRole(id);
	}

	public List<String> findAllRoleName() {
		return getUserDAOImpl().findAllRoleName();
	}
	
	public void removeUser(int id){
		getUserDAOImpl().removeUser(id);
	}
	public User updateUser(int id,String username, String password, String sicilNo,Role role) {
		return getUserDAOImpl().updateUser(id, username, password, sicilNo, role);
	}

	@Override
	public List findAllRole() {
		return userDAOImpl.findAllRole();
	}

//	@Override
//	public User createUser1(String role_name, Role role, String username, String password, String sicilNo) {
//		User user=userDAOImpl.createUser1(role, username, password, sicilNo);
//		return user;
//	}

//	@Override
//	public User CreateUser2(int role_id, String username, String sicilNo, String password) {
//		UserDAOImpl daoImpl=new UserDAOImpl();
//		User user=daoImpl.CreateUser2(role_id, username, sicilNo, password);
//		return user;
//	}

}
