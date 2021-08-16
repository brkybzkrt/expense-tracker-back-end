package project.expenseTracker.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.expenseTracker.entities.Spend;

public interface SpendDao extends JpaRepository<Spend, Integer> {

}
