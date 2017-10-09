package giris.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import giris.model.Role;
import giris.model.User;



public interface UserService {

	public User createUser(Role role, String username, String password, String sicilNo, String roleName);
	
//	public User createUser1(String role_name, Role role,String username, String password, String sicilNo);

	public User findUser(int id);

	public User kullaniciDogrula(String username, String password);

	public EntityManager getEntityManager();

	public EntityTransaction getEntityTransaction();

	public List<User> findAllUser();

	public void userKayýt(User user);
	
	public Role createRole(String roleName);

	public Role findRole(int id);
	
	public List<String> findAllRoleName();
	
	public void removeUser(int id);
	
	public User updateUser(int id,String username, String password, String sicilNo, Role role);
	
	public List<Role> findAllRole();
	
//	public User CreateUser2(int role_id,String username,String sicilNo,String password);
}
