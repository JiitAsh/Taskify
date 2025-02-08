package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.BidsDTORequest;
import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;
import spring.service.Services;

@RestController
@CrossOrigin
@RequestMapping("/Api/User")
public class Controller implements ControllerInteface {

	@Autowired
	Services service;

	@PostMapping("/Register")
	public ResponseEntity<UsersDTOResponse> addUser(@RequestBody UsersDTORequest dto) {

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
	public ResponseEntity<UsersDTOResponse> updatePassword(@RequestParam String username, @RequestParam String password,
			@RequestParam String newpassword) {
		return ResponseEntity.ok(service.updatePassword(username, password, newpassword));
	}

	@PostMapping("/Logout")
	public ResponseEntity<UsersDTOResponse> logout() {
		return ResponseEntity.ok(service.logout());
	}

	@GetMapping("/GetUser/{id}")
	public ResponseEntity<UsersDTOResponse> getUserById(@PathVariable int id) {
		return ResponseEntity.ok(service.getUserById(id));
	}

	@PostMapping("/CreateTask/{username}") // ToDo -- add category in pathVariable
	public boolean createTask(@RequestBody TasksDTORequest task, @PathVariable String username) {
		return service.createTask(task, "OPEN", username);
	}

	@GetMapping("/BrowseTasks")
	public ResponseEntity<List<TasksDTOResponse>> getallTask() {
		return ResponseEntity.ok(service.getAllTasks());
	}

	@GetMapping("/BrowseTasks/{username}")
	public ResponseEntity<List<TasksDTOResponse>> getTaskByCategory(@PathVariable String username) {
		return ResponseEntity.ok(service.getTasksByCustomerId(username));
	}

	@GetMapping("/MyTask/{task_id}") // to get all bidders
	public ResponseEntity<List<BidsDTOResponse>> getAllBiddersByTaskId(@PathVariable int task_id) {
		return ResponseEntity.ok(service.getBidsByTaskId(task_id));
	}

	@GetMapping("/Notifications/{username}")
	public ResponseEntity<List<TasksDTOResponse>> getTasksForNotifications(@PathVariable String username) {
		return ResponseEntity.ok(service.getAllTasksForNotifications(username));
	}
	
	@PostMapping("/CreateBid/{username}")
	public boolean createBid(@RequestBody BidsDTORequest bidDto, @PathVariable String username) {
		return service.createBid(bidDto, username);
	}

	@PutMapping("/choosebid/{bid_id}")
	public boolean chooseBid(@PathVariable int bid_id) {
		return service.chooseBid(bid_id);
	}

}
