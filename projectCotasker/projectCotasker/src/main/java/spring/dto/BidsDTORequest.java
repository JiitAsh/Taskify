package spring.dto;

import java.time.LocalDateTime;

import spring.entity.TasksTable;



public class BidsDTORequest {
	private int bid_id;
    private int bidder;
    private Double amount;
    private String proposal;
    private int estimatedHours;
    private int isAccepted = 0;
    private LocalDateTime createdAt = LocalDateTime.now();
    private TasksTable task;
    
    
    
	public BidsDTORequest() {
		
	}



	public BidsDTORequest(int bid_id, int bidder, Double amount, String proposal, int estimatedHours, int isAccepted,
			LocalDateTime createdAt, TasksTable task) {
		this.bid_id = bid_id;
		this.bidder = bidder;
		this.amount = amount;
		this.proposal = proposal;
		this.estimatedHours = estimatedHours;
		this.isAccepted = isAccepted;
		this.createdAt = createdAt;
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



	public TasksTable getTask() {
		return task;
	}



	public void setTask(TasksTable task) {
		this.task = task;
	}
    
	
	
    
    
}
