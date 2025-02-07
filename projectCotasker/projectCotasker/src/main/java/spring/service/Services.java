package spring.service;

import java.util.List;
import java.util.Optional;

import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
//import spring.dto.TaskDTORequest;
//import spring.dto.TaskDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;
//import com.dto.UserDTOResponse;s
//import spring.entity.Task;

public interface Services {

	UsersDTOResponse addUser(UsersDTORequest dto);

	boolean signin(String username, String password);

	boolean deleteUser(String username, String password);

	UsersDTOResponse updatePassword(String username, String password, String newpassword);

	UsersDTOResponse logout();

	UsersDTOResponse getUserById(int id);

	boolean createTask(TasksDTORequest task, String task_type);

	List<TasksDTOResponse> getAllTasks();

	List<TasksDTOResponse> getTasksByCustomerId(int id);

	List<BidsDTOResponse> getBidsByTaskId(int task_id);

	List<TasksDTOResponse> getAllTasksForNotifications(int id);

}
