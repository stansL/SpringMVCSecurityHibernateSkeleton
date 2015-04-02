package ke.co.greid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.MaritalStatus;

@Transactional
@Component
public class MaritalStatuDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	//convenience method
	public Session getLocalSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<MaritalStatus> getMaritalStatuses() {
		return getLocalSession().createQuery("FROM MaritalStatus").list();
	}

	public Object getMaritalStatus(Integer key) {
		
		return getLocalSession().get(MaritalStatus.class, key);
	}

}
