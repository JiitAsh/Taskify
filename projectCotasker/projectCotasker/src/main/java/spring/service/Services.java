package spring.service;

import spring.dto.UserDTORequest;
import spring.dto.UserDTOResponse;

public interface Services {
	
	UserDTOResponse addUser(UserDTORequest dto);
	boolean signin(String username, String password);
	boolean deleteUser(String username, String password);
	UserDTOResponse updatePassword(String username, String password, String newpassword);
	UserDTOResponse logout();
}
