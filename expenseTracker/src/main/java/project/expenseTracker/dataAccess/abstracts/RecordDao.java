package project.expenseTracker.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordDao extends JpaRepository<Record, Integer> {

}
