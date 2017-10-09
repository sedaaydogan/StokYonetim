package giris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import giris.model.Role;
import giris.model.User;


public interface UserDAO {

	public User createUser(Role role,String username, String password, String sicilNo, String roleName);
	
//	public User createUser1(Role role,String username, String password, String sicilNo);
	
	public User findUser(int id);

	public User kullaniciDogrula(String username, String password);

	public EntityManager getEntityManager();

	public EntityTransaction getEntityTransaction();

	public List findAllUser();

	public void userKayýt(User user);
	
	public Role createRole(String roleName);

	public Role findRole(int id);
	
	public List findAllRole();
	
	public List findAllRoleName();
	
	public void removeUser(int id);
	
	public User updateUser(int id,String username, String password, String sicilNo, Role role);
	
//	public User CreateUser2(int role_id,String username,String sicilNo,String password);
}
