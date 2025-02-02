package spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Entity
@Data
@Table(name = "UsersTable",uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))

public class UsersTable {
	
	@Id  // primary key
	@Column(name="id")
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
	@Size(min = 10, max = 10)
	private String phoneno;
	
	 @Column(name = "email")
	    @Email(message = "Email should be valid")
	    private String email;
	 
	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private Category category;
	
//	to implement this logic - when we delete data flag turn true 
//	We only show false flag users - 
	
	@Column(name="deleteflag")
	private boolean deleteflag = false;
	
	
	
	
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

	public boolean isDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(boolean deleteflag) {
		this.deleteflag = deleteflag;
	}

	public UsersTable() {}
	
	public UsersTable(String firstname, String lastname, String username, String password,
			@Size(min = 10, max = 10) String phoneno, @Email(message = "Email should be valid") String email,
			Category category) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.phoneno = phoneno;
		this.email = email;
		this.category = category;
		this.deleteflag = false;
	}
	
}
