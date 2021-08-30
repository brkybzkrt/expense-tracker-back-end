package project.expenseTracker.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.expenseTracker.entities.Type;

public interface TypeDao extends JpaRepository<Type, Integer>{

}
