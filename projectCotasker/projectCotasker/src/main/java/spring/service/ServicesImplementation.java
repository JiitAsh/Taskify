package spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dto.BidsDTORequest;
import spring.dto.BidsDTOResponse;
import spring.dto.TasksDTORequest;
import spring.dto.TasksDTOResponse;
import spring.dto.UsersDTORequest;
import spring.dto.UsersDTOResponse;
import spring.entity.BidTable;
import spring.entity.TasksTable;
import spring.entity.UsersTable;
import spring.repository.BidsRepo;
import spring.repository.TasksRepo;
import spring.repository.UsersRepo;

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

		UsersDTOResponse responsedto = new UsersDTOResponse();

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

			if (user.isDeleteflag() == 1) {
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

		if (userOptional.isPresent()) {
			UsersTable user = userOptional.get();

			if (user.getPassword().equals(password)) {
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
		UsersDTOResponse responsedto = new UsersDTOResponse();

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

		UsersDTOResponse responsedto = new UsersDTOResponse();
		responsedto.setMessage("You have been logged out !!");

		return responsedto;
	}

	@Override
	public UsersDTOResponse getUserById(int id) {
		Optional<UsersTable> optionalUser = user_repo.findById(id);
		UsersDTOResponse userDto = new UsersDTOResponse();
		if (optionalUser.isPresent()) {
			UsersTable user = optionalUser.get();
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}

	@Override
	public UsersDTOResponse getUserByUsername(String username) {
		Optional<UsersTable> optUser = user_repo.findByUsername(username);
		UsersDTOResponse userDto = new UsersDTOResponse();
		if (optUser.isPresent()) {
			UsersTable user = optUser.get();
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}

	@Override
	public boolean createTask(TasksDTORequest task, String task_type, String username) {
		TasksTable new_task = new TasksTable();
		BeanUtils.copyProperties(task, new_task);
		UsersDTOResponse user = getUserByUsername(username);
		new_task.getUser().setId(user.getId());
		task_repo.save(new_task);
		return true;
	}

	@Override
	public List<TasksDTOResponse> getAllTasks() {
		List<TasksTable> allTasks = task_repo.findAll();
		ArrayList<TasksDTOResponse> taskDtoList = new ArrayList<>();
		for (TasksTable task : allTasks) {
			TasksDTOResponse dto = new TasksDTOResponse(task.getTask_id(), task.getTask_title(), task.getTask_desc(),
					task.getTask_category(), task.getLocation(), task.getTask_type(), task.getBudget(),
					task.getScheduledDate(), task.getMustHaves(), task.getStatus(), task.getCreatedAt(),
					task.getUpdatedAt(), task.getUser(), "");
//			BeanUtils.copyProperties(task, dto);
			taskDtoList.add(dto);
		}
		return taskDtoList;
	}

	@Override
	public List<TasksDTOResponse> getTasksByCustomerId(String username) {
		UsersDTOResponse user = getUserByUsername(username);
		int id = user.getId();
		List<TasksTable> allTasks = task_repo.findAll();
		ArrayList<TasksDTOResponse> taskDtoList = new ArrayList<>();
		for (TasksTable task : allTasks) {
			if (task.getUser().getId() == id) {
				TasksDTOResponse dto = new TasksDTOResponse(task.getTask_id(), task.getTask_title(),
						task.getTask_desc(), task.getTask_category(), task.getLocation(), task.getTask_type(),
						task.getBudget(), task.getScheduledDate(), task.getMustHaves(), task.getStatus(),
						task.getCreatedAt(), task.getUpdatedAt(), task.getUser(), "");
				taskDtoList.add(dto);
			}
		}
		return taskDtoList;
	}

	@Override
	public List<BidsDTOResponse> getBidsByTaskId(int task_id) {
		List<BidTable> allBids = bid_repo.findAll();
		ArrayList<BidsDTOResponse> bidsDTOList = new ArrayList<>();
		for (BidTable bid : allBids) {
			if (bid.getTask().getTask_id() == task_id) {

				UsersDTOResponse user = getUserById(bid.getBidder());
				String userName = user.getUsername();
				BidsDTOResponse dto = new BidsDTOResponse(bid.getBid_id(), bid.getBidder(), bid.getAmount(), bid.getProposal(),
						bid.getEstimatedHours(), bid.getIsAccepted(), userName);
				bidsDTOList.add(dto);
			}
		}
		return bidsDTOList;
	}

	@Override
	public List<TasksDTOResponse> getAllTasksForNotifications(String username) {
		
		List<TasksDTOResponse> allTasks = getTasksByCustomerId(username);
		Collections.sort(allTasks, Comparator.comparing(TasksDTOResponse::getUpdatedAt).reversed());
		return allTasks;
	}

	@Override
	public boolean createBid(BidsDTORequest bidDto, String username) {
		UsersDTOResponse user = getUserByUsername(username);
		bidDto.setBidder(user.getId());
		BidTable bid = new BidTable();
		BeanUtils.copyProperties(bidDto, bid);
		bid_repo.save(bid);
		return true;
	}


	@Override
	public boolean chooseBid(int bid_id) {
		Optional<BidTable> optBid=bid_repo.findById(bid_id);
		if(optBid.isPresent()) {
			BidTable bid=optBid.get();
			bid.setIsAccepted(1);
			bid_repo.save(bid);
		}
		return true;
	}
}
