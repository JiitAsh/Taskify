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

import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
//import jakarta.validation.Valid;
//import spring.dto.TaskDTORequest;
//import spring.dto.TaskDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;
//import spring.entity.Task;
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

	@PostMapping("/CreateTask") // ToDo -- add category in pathVariable
	public boolean createTask(@RequestBody TasksDTORequest task) {
		return service.createTask(task, "OPEN");
	}

	@GetMapping("/BrowseTasks")
	public ResponseEntity<List<TasksDTOResponse>> getallTask() {
		return ResponseEntity.ok(service.getAllTasks());
	}

	@GetMapping("/BrowseTasks/{id}")
	public ResponseEntity<List<TasksDTOResponse>> getTaskByCategory(@PathVariable int id) {
		return ResponseEntity.ok(service.getTasksByCustomerId(id));
	}

	@GetMapping("/MyTask/{task_id}") // to get all bidders
	public ResponseEntity<List<BidsDTOResponse>> getAllBiddersByTaskId(@PathVariable int task_id) {
		return ResponseEntity.ok(service.getBidsByTaskId(task_id));
	}

	@GetMapping("/Notifications/{id}")
	public ResponseEntity<List<TasksDTOResponse>> getTasksForNotifications(@PathVariable int id) {
		return ResponseEntity.ok(service.getAllTasksForNotifications(id));
	}

}
