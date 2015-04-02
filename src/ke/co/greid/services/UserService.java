package ke.co.greid.services;

import java.util.List;

import ke.co.greid.dao.UserDAO;
import ke.co.greid.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDAO controller;

	public List<User> getUsers() {
		return controller.getUsers();
	}

	public int saveUser(User user) {
		return controller.saveUser(user);
		
	}

	public User getUser(Integer key) {
		
		return controller.getUser(key);
	}

}
