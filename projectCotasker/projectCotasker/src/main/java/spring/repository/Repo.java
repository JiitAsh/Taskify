package spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.UsersTable;
@Repository
public interface Repo extends JpaRepository<UsersTable,Integer>{
	Optional<UsersTable> findByUsername(String username);
}
