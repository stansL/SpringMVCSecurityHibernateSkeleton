package ke.co.greid.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import ke.co.greid.entities.User;
import ke.co.greid.services.UserService;

@ManagedBean
public class UserController {
	@ManagedProperty("#{userService}")
	private UserService userService;
	private List<User> users;
	private User current= new User();
	private Logger logger=Logger.getLogger(this.getClass().getName());
	


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getCurrent() {
		return current;
	}

	public void setCurrent(User current) {
		this.current = current;
	}
	
	@PostConstruct
	public void init(){
		users=userService.getUsers();		
	}
	public String create() {
		logger.info(current.toString());
		
		try {
			userService.saveUser(current);
			FacesMessage msg = new FacesMessage("Successful", "Saved Details For:"
					+ current.getUsername());
			FacesContext.getCurrentInstance().addMessage("successInfo", msg);
			return "create";
			
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error", "Did not save the record :"
					+ current.getUsername());
			FacesContext.getCurrentInstance().addMessage("erroInfo", msg);
			e.printStackTrace();
			return null;
		}

	}

}
