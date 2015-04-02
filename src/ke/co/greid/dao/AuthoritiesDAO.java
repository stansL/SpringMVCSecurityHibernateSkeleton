package ke.co.greid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.Authorities;

@Transactional
@Component
public class AuthoritiesDAO {
	@Autowired
	private SessionFactory sessionFactory;	
	
	//convenience method
	public Session getLocalSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Authorities> getAuthorities() {
		return getLocalSession().createQuery("FROM Authorities").list();
	}

	public Authorities getAuthority(Integer key) {
		
		return (Authorities) getLocalSession().get(Authorities.class, key);
	}

	

}
