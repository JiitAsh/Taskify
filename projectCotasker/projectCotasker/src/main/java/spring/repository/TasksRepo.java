package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.TasksTable;

@Repository
public interface TasksRepo extends JpaRepository<TasksTable, Integer> {

}
