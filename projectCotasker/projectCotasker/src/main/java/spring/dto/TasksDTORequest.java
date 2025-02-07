package spring.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import spring.entity.TaskStatus;
import spring.entity.UsersTable;



public class TasksDTORequest {
	
    private int task_id;
    private String task_title;
    private String task_desc;
    private String task_category;
    private String location;
    private String task_type;
    private Double budget;
    private LocalDateTime scheduledDate;
    private String mustHaves;
    private TaskStatus status = TaskStatus.OPEN;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private UsersTable user;
     
    
	public TasksDTORequest(int task_id, String task_title, String task_desc, String task_category, String location,
			String task_type, Double budget, LocalDateTime scheduledDate, String mustHaves, TaskStatus status,
			LocalDateTime createdAt, LocalDateTime updatedAt, UsersTable user) {
		
		this.task_id = task_id;
		this.task_title = task_title;
		this.task_desc = task_desc;
		this.task_category = task_category;
		this.location = location;
		this.task_type = task_type;
		this.budget = budget;
		this.scheduledDate = scheduledDate;
		this.mustHaves = mustHaves;
		this.status = status;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.user = user;
		
	}
	
	
	
	
	
	public TasksDTORequest() {
		
	}





	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	public String getTask_desc() {
		return task_desc;
	}
	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}
	public String getTask_category() {
		return task_category;
	}
	public void setTask_category(String task_category) {
		this.task_category = task_category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public LocalDateTime getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(LocalDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getMustHaves() {
		return mustHaves;
	}
	public void setMustHaves(String mustHaves) {
		this.mustHaves = mustHaves;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public UsersTable  getUser() {
		return user;
	}
	public void setUser(UsersTable user) {
		this.user = user;
	}
    
    
    
    
    
}
