package giris.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import giris.model.Role;
import giris.model.User;
import giris.service.UserServiceImpl;

@ManagedBean
@SessionScoped
public class UserController {

	private int user_id;
	private int role_id;
	private String username;
	private String password;
	private String sicilNo;
	private Role role;
	private List<Role> roleList;
	private List<User> userList;
	
	

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public List<User> getUserList() {
		UserServiceImpl impl=new UserServiceImpl();
		userList=impl.findAllUser();
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Role> getRoleList() {
		UserServiceImpl impl=new UserServiceImpl();
		roleList=impl.findAllRole();
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSicilNo() {
		return sicilNo;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public void UserKaydet() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSicilNo(sicilNo);
		user.setRole(role);
		userServiceImpl.userKayýt(user);
	}

	public String getKullaniciDogrula() throws Exception {
		User user;
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		user = userServiceImpl.kullaniciDogrula(username, password);
		if (user != null) // Tabloda eleman varsa(User tablosunda veri) if içine girecek yoksa else ile boþ dönecek.
		{
			user_id = user.getId();
			return "anasayfa.xhtml?faces-redirect=true";
		} else
			RequestContext.getCurrentInstance().update("growl");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullanýcý adý veya Parola hatalý!", ""));

		return "";

	}

	
	public User UserEkle(){
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		Role role=userServiceImpl.findRole(role_id);
		return userServiceImpl.createUser(role, username, password, sicilNo,role.getRoleName());
	}
	
	public void UserSil(int id){
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		userServiceImpl.removeUser(id);
	}
	
	public void UserGuncelle(int id){
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		userServiceImpl.updateUser(id, username, password, sicilNo, role);
	}
	
}
