package spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
//import spring.dto.TaskDTORequest;
//import spring.dto.TaskDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;
import spring.entity.BidTable;
import spring.entity.TaskStatus;
import spring.entity.TasksTable;
//import spring.entity.Task;
import spring.entity.UsersTable;
import spring.repository.BidsRepo;
import spring.repository.TasksRepo;
import spring.repository.UsersRepo;
//import com.repository.TaskRepo;

@Service
public class ServicesImplementation implements Services {
	
	
	
	@Autowired		
	 UsersRepo user_repo;
	@Autowired
	TasksRepo task_repo;
	
	@Autowired
	BidsRepo bid_repo;
	
	@Override
	public UsersDTOResponse addUser(UsersDTORequest dto) {
		
		UsersTable user = new UsersTable();
		
		BeanUtils.copyProperties(dto, user);
		
		user.setDeleteflag(0);
		
		user_repo.save(user);
		
		UsersDTOResponse responsedto  = new UsersDTOResponse();
		
		responsedto.setId(dto.getId());
		responsedto.setMessage("Created with UserID: " + user.getId());
		
		return responsedto;
		
	}

	@Override
	public boolean signin(String username, String password) {
		// TODO Auto-generated method stub
		
		Optional<UsersTable> userOptional = user_repo.findByUsername(username);
        
        if (userOptional.isPresent()) {
            UsersTable user = userOptional.get();
            
            if(user.isDeleteflag() == 1) 
            {
            	return false;
            }
            
            return user.getPassword().trim().equals(password); 
        }
        return false;
	}

	@Override
	public boolean deleteUser(String username, String password) {
		// TODO Auto-generated method stub
		
		Optional<UsersTable> userOptional = user_repo.findByUsername(username);
		
		if (userOptional.isPresent())
		{
            UsersTable user = userOptional.get();
            
            if(user.getPassword().equals(password))
            {
            user.setDeleteflag(1);
            user_repo.save(user);
            return true;
            }
        }
		return false;
	}

	@Override
	public UsersDTOResponse updatePassword(String username, String password, String newpassword) {
		// TODO Auto-generated method stub
	    UsersDTOResponse responsedto  = new UsersDTOResponse();
	    
	   
	    Optional<UsersTable> userOptional = user_repo.findByUsername(username); 

	    if (userOptional.isPresent()) {
	        UsersTable user = userOptional.get();
	        
	        if (user.getPassword().equals(password)) {
	           if (!user.getPassword().equals(newpassword)) {
	                user.setPassword(newpassword);
	                user_repo.save(user);
	                responsedto.setMessage("Your password has been updated!");
	            } else {
	                responsedto.setMessage("Your new password cannot be the same as the old one.");
	            }
	        } else {
	        	
	            responsedto.setMessage("Your password cannot be updated, wrong password!");
	        }
	        return responsedto;
	    }
	    responsedto.setMessage("Your password cannot be updated, wrong username.");
	    return responsedto;
	}

		
	@Override
	public UsersDTOResponse logout() {
		// TODO Auto-generated method stub
		
		UsersDTOResponse responsedto  = new UsersDTOResponse();
	responsedto.setMessage("You have been logged out !!");
		
		return responsedto;
	}
	
	@Override
	public UsersDTOResponse getUserById(int id) {
		Optional<UsersTable> optionalUser =  user_repo.findById(id);
		UsersDTOResponse userDto=new UsersDTOResponse();
		if(optionalUser.isPresent()) {
			UsersTable user=optionalUser.get();
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}

	@Override
	public boolean createTask(TasksDTORequest task, String task_type) {
		TasksTable new_task = new TasksTable();
		BeanUtils.copyProperties(task, new_task);
		task_repo.save(new_task);
		return true;
	}

	@Override
	public List<TasksDTOResponse> getAllTasks() {
		List<TasksTable> allTasks = task_repo.findAll();
		ArrayList<TasksDTOResponse> taskDtoList = new ArrayList<>();
		for(TasksTable task : allTasks) {
			TasksDTOResponse dto = new TasksDTOResponse(task.getTask_id(),task.getTask_title(), task.getTask_desc(), task.getTask_category(),task.getLocation(),
task.getTask_type(),task.getBudget(),  task.getScheduledDate(), task.getMustHaves(), task.getStatus(),
					task.getUser(), "");
//			BeanUtils.copyProperties(task, dto);
			taskDtoList.add(dto);
		}
		return taskDtoList;
	}

	@Override
	public List<TasksDTOResponse> getTasksByCustomerId(int id) {
		List<TasksTable> allTasks = task_repo.findAll();
		ArrayList<TasksDTOResponse> taskDtoList = new ArrayList<>();
		for(TasksTable task : allTasks) {
			if(task.getUser().getId()==id) {
				TasksDTOResponse dto = new TasksDTOResponse(task.getTask_id(),task.getTask_title(), task.getTask_desc(), task.getTask_category(),task.getLocation(),task.getTask_type(),task.getBudget(),  task.getScheduledDate(), task.getMustHaves(), task.getStatus(),task.getUser(), "");
				taskDtoList.add(dto);
			}
		}
		return taskDtoList;
	}

	@Override
	public List<BidsDTOResponse> getBidsByTaskId(int task_id) {
		List<BidTable> allBids = bid_repo.findAll();
		ArrayList<BidsDTOResponse> bidsDTOList = new ArrayList<>();
		for(BidTable bid : allBids) {
			if(bid.getTask().getTask_id()==task_id) {
				
				UsersDTOResponse user = getUserById(bid.getBidder());
				String userName = user.getUsername();
				BidsDTOResponse dto = new BidsDTOResponse(bid.getBidder(), bid.getAmount(), bid.getProposal() , 								bid.getEstimatedHours(), bid.getIsAccepted(), userName);
				bidsDTOList.add(dto);
			}
		}
		return bidsDTOList;
	}

	

//	@Override
//	public TaskDTOResponse createTask(TaskDTORequest task, String type) {
//		// TODO Auto-generated method stub
//
//	    TaskDTOResponse response = new TaskDTOResponse();
//		Task task1 = new Task();
//		BeanUtils.copyProperties(task, task1);
//		task1 = trepo.save(task1);
//		BeanUtils.copyProperties(task1, response);
//		response.setMessage("Created your task");
//		return response;
//	}

//	@Override
//	public List<Task> getAllTasks() {
//		// TODO Auto-generated method stub
//		return trepo.findAll();
//		
//	}

//	@Override
//	public List<TaskDTOResponse> getTaskByUsername(String Username) {
//		// TODO Auto-generated method stub
//		
//Optional<List<Task>> taskOptional =  trepo.getByUsername(Username);
//        
//        if (taskOptional.isPresent()) {
//            
//            List<Task> task = taskOptional.get();
//            List<TaskDTOResponse> taskDTOResponseList = new ArrayList<>();
//            
//            for (Task task3 : task) {
//                TaskDTOResponse taskDTOResponse = new TaskDTOResponse();
//                // Copy properties from Task to TaskDTOResponse
//                BeanUtils.copyProperties(task3, taskDTOResponse);
//                taskDTOResponseList.add(taskDTOResponse);
//            }
//            return taskDTOResponseList;
//        }
//		return Collections.emptyList();
//	}

	
//	@Override
//    public List<TaskDTOResponse> getTasksByCategory(String category) {
//       
//        Optional<List<Task>> tasksOptional = trepo.getByCategory(category);
//        
//        if (tasksOptional.isPresent()) {
//            
//            List<Task> tasks = tasksOptional.get();
//
//            return tasks.stream()
//                        .map(task -> {
//                            TaskDTOResponse taskDTOResponse = new TaskDTOResponse();
//                            BeanUtils.copyProperties(task, taskDTOResponse);  
//                            return taskDTOResponse;
//                        })
//                        .collect(Collectors.toList());  
//            }
//
//        return Collections.emptyList();
//    }

//	@Override
//	public TaskDTOResponse getTaskById(Long id) {
//		// TODO Auto-generated method stub
//		
//		TaskDTOResponse taskresponse = new TaskDTOResponse();
//		Optional<Task> task = trepo.findById(id);
//		
//		if(task.isPresent()) {
//			Task task1 = task.get();
//			
//			BeanUtils.copyProperties(task1, taskresponse);
//			taskresponse.setMessage("Task related to id: " + id);
//			return taskresponse;
//		}
//		
//		taskresponse.setMessage("No task found on this id");
//		return taskresponse;
//	}

}
