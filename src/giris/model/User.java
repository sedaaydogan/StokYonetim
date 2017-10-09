package giris.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the "User" database table.
 * 
 */

@Table(name = "\"User\"")
@NamedQueries
(
		{ 
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByUser", query = "SELECT u FROM User u WHERE u.username=:username"),
		@NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password=:password"),
		}
)
@Entity

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "USER_GEN")
	@GeneratedValue(generator="USER_GEN")
	@Column(name = "id")
	private int id;
	@Column(name = "sicil_no")
	private String sicilNo;
	private String password;
	private String username;
	private String roleName;

	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<EkipmanServisGidi> ekipmanServisGidis;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSicilNo() {
		return sicilNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		roleName = role.getRoleName();
		this.roleName = roleName;
	}
	
	public User(String sicilNo, String password, String username, String roleName) {
		super();
		this.sicilNo = sicilNo;
		this.password = password;
		this.username = username;
		this.roleName = roleName;
	}
	

	public User(String sicilNo, String password, String username, String roleName, Role role) {
		super();
		this.sicilNo = sicilNo;
		this.password = password;
		this.username = username;
		this.roleName = roleName;
		this.role = role;
	}

	public User(String sicilNo, String password, String username, Role role) {
		super();
		this.sicilNo = sicilNo;
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [sicilNo=" + sicilNo + ", password=" + password + ", username=" + username + ", role=" + role
				+ "]";
	}

}