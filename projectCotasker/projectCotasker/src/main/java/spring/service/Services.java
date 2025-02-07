package spring.service;

import java.util.List;

import spring.dto.BidsDTORequest;
import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;

public interface Services {

	UsersDTOResponse addUser(UsersDTORequest dto);

	boolean signin(String username, String password);

	boolean deleteUser(String username, String password);

	UsersDTOResponse updatePassword(String username, String password, String newpassword);

	UsersDTOResponse logout();

	UsersDTOResponse getUserById(int id);

	UsersDTOResponse getUserByUsername(String username);

	boolean createTask(TasksDTORequest task, String task_type);

	List<TasksDTOResponse> getAllTasks();

	List<TasksDTOResponse> getTasksByCustomerId(int id);

	List<BidsDTOResponse> getBidsByTaskId(int task_id);

	boolean createBid(BidsDTORequest bid, String username);

	List<TasksDTOResponse> getAllTasksForNotifications(int id);

}
