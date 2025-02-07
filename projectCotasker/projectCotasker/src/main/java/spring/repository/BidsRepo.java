package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entity.BidTable;

public interface BidsRepo extends JpaRepository<BidTable, Integer> {
	
}
