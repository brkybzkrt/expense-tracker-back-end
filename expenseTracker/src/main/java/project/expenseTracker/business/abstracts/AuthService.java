package project.expenseTracker.business.abstracts;

import project.expenseTracker.entities.auth.AuthResponse;
import project.expenseTracker.entities.auth.Credentials;

public interface AuthService {

	AuthResponse authenticate(Credentials credentials);

	
}
