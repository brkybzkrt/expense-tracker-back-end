package project.expenseTracker.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.expenseTracker.business.abstracts.SpendService;
import project.expenseTracker.dataAccess.abstracts.SpendDao;

@Service
public class SpendManager implements SpendService {

	private SpendDao spendDao;

	@Autowired
	public SpendManager(SpendDao spendDao) {
		super();
		this.spendDao = spendDao;
	}
}
