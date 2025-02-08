package spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import spring.dto.BidsDTORequest;
import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;

public interface ControllerInteface {
	public ResponseEntity<UsersDTOResponse> addUser(UsersDTORequest dto);

	public boolean signin(String username, String password);

	public ResponseEntity<String> deleteUser(String username, String password);

	public ResponseEntity<UsersDTOResponse> updatePassword(String username, String password, String newpassword);

	public ResponseEntity<UsersDTOResponse> logout();

	public ResponseEntity<UsersDTOResponse> getUserById(int id);

	public boolean createTask(TasksDTORequest task);

	public ResponseEntity<List<TasksDTOResponse>> getallTask();

	public ResponseEntity<List<TasksDTOResponse>> getTaskByCategory(int id);

	public ResponseEntity<List<BidsDTOResponse>> getAllBiddersByTaskId(int task_id);

	public ResponseEntity<List<TasksDTOResponse>> getTasksForNotifications(int id);

	public boolean createBid(BidsDTORequest bidDto, String username);

	public boolean chooseBid(int bid_id);
}
