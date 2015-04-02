package ke.co.greid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.Gender;

@Transactional
@Component
public class GenderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// convenience method
	public Session getLocalSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Gender> getGenders() {

		return getLocalSession().createQuery("FROM Gender").list();
	}

	public Gender getGender(Integer key) {
		return (Gender) getLocalSession().get(Gender.class, key);
	}

}
