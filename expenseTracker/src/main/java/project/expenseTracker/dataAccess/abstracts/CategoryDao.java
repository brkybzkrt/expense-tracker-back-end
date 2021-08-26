package project.expenseTracker.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.expenseTracker.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	boolean existsByName(String name);

	Category findByName(String name);

}
