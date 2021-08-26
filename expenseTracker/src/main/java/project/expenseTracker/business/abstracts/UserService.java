package project.expenseTracker.business.abstracts;

import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.User;

public interface UserService {

	
	 Result register(User user);

	 boolean isExistsByEmail(String email);
	
	 User getByEmail(String email);
}
