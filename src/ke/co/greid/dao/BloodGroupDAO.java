package ke.co.greid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.BloodGroup;

@Transactional
@Component
public class BloodGroupDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//convenience method
	public Session getLocalSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<BloodGroup> getBloodGroups() {
		return getLocalSession().createQuery("FROM BloodGroup").list();
	}

	public BloodGroup getBloodGroup(Integer key) {
		return (BloodGroup) getLocalSession().get(BloodGroup.class, key);
	}

}
