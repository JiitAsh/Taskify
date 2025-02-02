package spring.dto;


import lombok.Data;
import spring.entity.Category;


@Data
public class UserDTORequest {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String phoneno;
	private String password;
	private String email;
	private Category category;	
	private boolean deleteflag = false;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		
	public UserDTORequest(String firstname, String lastname, String username, String phoneno, String password,
			String email, Category category) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.phoneno = phoneno;
		this.password = password;
		this.email = email;
		this.category = category;
		this.deleteflag = false;
	}
	
	public UserDTORequest() {
		this.deleteflag = false;
	}
	
	@Override
	public String toString() {
		return "UserDTORequest [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", phoneno=" + phoneno + ", password=" + password + ", email=" + email + ", category="
				+ category + ", deleteflag=" + deleteflag + "]";
	}	
}
