package spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bids")
public class BidTable {
    @Id
    @Column(name="bid_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid_id;
    
    @Column(name = "bidder_id", nullable = false)
    private int bidder;
    
    @Column(name = "amount", nullable = false)
    private Double amount;
    
    @Column(name="proposal", nullable = false, columnDefinition = "TEXT")
    private String proposal;
    
    @Column(name = "estimated_hours")
    private int estimatedHours;
    
    @Column(name = "is_accepted")
    private int isAccepted = 0;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name="task_id")
    private TasksTable task;
    
    

    
    
	public TasksTable getTask() {
		return task;
	}

	public void setTask(TasksTable task) {
		this.task = task;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public int getBidder() {
		return bidder;
	}

	public void setBidder(int bidder) {
		this.bidder = bidder;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public int getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	

	public BidTable() {
		
		// TODO Auto-generated constructor stub
	}

	public BidTable(int bidder, Double amount, String proposal, int estimatedHours, 
			LocalDateTime createdAt, TasksTable task) {
		this.bidder = bidder;
		this.amount = amount;
		this.proposal = proposal;
		this.estimatedHours = estimatedHours;
		this.isAccepted = 0;
		this.createdAt = createdAt;
		this.task = task;
	}

	
    
    
    
	
    
}