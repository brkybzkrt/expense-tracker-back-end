package project.expenseTracker.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.expenseTracker.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	boolean existsByEmail(String email);
}
