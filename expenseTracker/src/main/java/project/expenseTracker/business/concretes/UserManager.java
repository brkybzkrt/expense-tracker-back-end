package project.expenseTracker.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.expenseTracker.business.abstracts.UserService;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.core.utilities.results.SuccessResult;
import project.expenseTracker.dataAccess.abstracts.UserDao;
import project.expenseTracker.entities.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		this.passwordEncoder= new BCryptPasswordEncoder();
	}

	@Override
	public Result register(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user.setFullName(user.getFirstName()+" "+ user.getLastName());
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı başarıyla kayıt oldu.");
	}

	@Override
	public boolean isExistsByEmail(String email) {
		return  this.userDao.existsByEmail(email);
	}

	@Override
	public User getByEmail(String email) {
		return this.userDao.findByEmail(email);
	}
	
}
