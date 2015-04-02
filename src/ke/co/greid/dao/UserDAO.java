package ke.co.greid.dao;

import java.util.List;
import java.util.logging.Logger;

import ke.co.greid.entities.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserDAO {

	private Logger logger = Logger.getLogger(UserDAO.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// convenience method
	public Session getLocalSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getLocalSession().createQuery("FROM User").list();
	}

	public User getUser(String username) {
		Criteria cr = getLocalSession().createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		return (User) cr.uniqueResult();
	}

	@Transactional
	public int saveUser(User user) {

		String passwordEncoded = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordEncoded);
		logger.info("After Encoding and before Saving ::" + user.toString());
		return (int) getLocalSession().save(user);

	}

	public User getUser(Integer key) {
		return (User) getLocalSession().get(User.class, key);
	}

}
