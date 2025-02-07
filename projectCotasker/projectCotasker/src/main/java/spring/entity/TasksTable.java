package spring.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class TasksTable {

	@Id
	@Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    
    @Column(name="task_title", nullable = false)
    private String task_title;
    
    @Column(name="task_desc", nullable = false, columnDefinition = "TEXT")
    private String task_desc;
    
    @Column(name="task_category", nullable = false)
    private String task_category;
    
    @Column(name="location", nullable = false)
    private String location;
    
    @Column(name = "task_type", nullable = false)
    private String task_type;
    
    @Column(name="budget", nullable = false)
    private Double budget;
    
    @Column(name = "scheduled_date", nullable = false)
    private LocalDateTime scheduledDate;
    
    @Column(name = "must_haves")
    private String mustHaves;
    
//    @ManyToOne
//    @JoinColumn(name = "poster_id", nullable = false)
//    private int poster;
//    
//    @ManyToOne
//    @JoinColumn(name = "tasker_id")
//    private int tasker;
    
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.OPEN;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
    
//    @Column(name="username")
//    private String username;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private UsersTable user;
    
    
    @OneToMany(mappedBy="task")
    private List<BidTable> bidders = new ArrayList<>();
    
    
    
    
	

	public List<BidTable> getBidders() {
		return bidders;
	}

	public void setBidders(List<BidTable> bidders) {
		this.bidders = bidders;
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

	public UsersTable getUser() {
		return user;
	}

	public void setUser(UsersTable user) {
		this.user = user;
	}

	
	public TasksTable() {}

	public TasksTable(String task_title, String task_desc, String task_category, String location, String task_type,
			Double budget, LocalDateTime scheduledDate, String mustHaves, TaskStatus status, LocalDateTime createdAt,
			LocalDateTime updatedAt, UsersTable user, List<BidTable> bidders) {
		super();
		this.task_title = task_title;
		this.task_desc = task_desc;
		this.task_category = task_category;
		this.location = location;
		this.task_type = task_type;
		this.budget = budget;
		this.scheduledDate = scheduledDate;
		this.mustHaves = mustHaves;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.bidders = bidders;
	}

	
	
	
    
    
	
	
}
