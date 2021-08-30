package project.expenseTracker.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.expenseTracker.entities.EmailMessage;

public interface EmailMessageDao extends JpaRepository<EmailMessage, Integer> {

	
}
