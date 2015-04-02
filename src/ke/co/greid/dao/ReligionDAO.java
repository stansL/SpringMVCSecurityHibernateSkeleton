package ke.co.greid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.Religion;

@Transactional
@Component
public class ReligionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//convenience method
	public Session getLocalSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Religion> getReligions() {
		return getLocalSession().createQuery("FROM Religion").list();
	}

	public Religion getReligion(Integer key) {
		return (Religion) getLocalSession().get(Religion.class, key);
	}
	
	

}
