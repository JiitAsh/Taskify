package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.dto.UserDTORequest;
import spring.dto.UserDTOResponse;
import spring.service.Services;

@RestController
@CrossOrigin
@RequestMapping("/Api/User")
public class Controllers {
	
	@Autowired
	Services service; 
	
	@PostMapping("/Register")
	public ResponseEntity<UserDTOResponse> addUser(@Valid @RequestBody UserDTORequest dto){
		
		return ResponseEntity.ok(service.addUser(dto));
	}
	
	@PostMapping("/Signin")
	public boolean signin(@RequestParam String username, @RequestParam String password) {
	return service.signin(username, password);
	}
	
	  @PutMapping("/Delete")
	    public ResponseEntity<String> deleteUser(@RequestParam String username, @RequestParam String password) {
	        boolean deleted = service.deleteUser(username, password);
	        
	        if (deleted) {
	            return ResponseEntity.ok("User deleted successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or incorrect password.");
	        }
	    }
	
	@PutMapping("/UpdatePassword")
	public ResponseEntity<UserDTOResponse> updatePassword(@RequestParam String username, @RequestParam String password, @RequestParam String newpassword){
		return ResponseEntity.ok(service.updatePassword(username, password, newpassword));
	}
	
	@PostMapping("/Logout")
	public ResponseEntity<UserDTOResponse> logout(){
		return ResponseEntity.ok(service.logout());
	}
}
