package spring.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsersTable")

public class UsersTable {
	
	@Id  // primary key
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // auto increment
	private int id;
	
	
	@Column(name="firstname", nullable = false)
	private String firstname;
	
	@Column(name="lastname", nullable = false)
	private String lastname;
	
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneno")
	private String phoneno;
	
	 @Column(name = "email") 
	 private String email;
	 
	 
	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private Category category;
	
	
	@Column(name="deleteflag")
	private int deleteflag = 0;
	
	
	@OneToMany(mappedBy="user")
	private List<TasksTable> tasks = new ArrayList<>();
	
	
	
	
	public List<TasksTable> getTasks() {
		return tasks;
	}

	public void setTasks(List<TasksTable> tasks) {
		this.tasks = tasks;
	}

	public int getDeleteflag() {
		return deleteflag;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int isDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}

	public UsersTable() {}

	public UsersTable(String firstname, String lastname, String username, String password, String phoneno,
			String email, Category category, List<TasksTable> tasks) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.phoneno = phoneno;
		this.email = email;
		this.category = category;
		this.deleteflag = 0;
		this.tasks = tasks;
	}
	
	
	
}
