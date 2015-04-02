package ke.co.greid.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.Country;

@Transactional
@Component
public class CountryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// convenience method
	public Session getLocalSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Country> getCountries() {

		return getLocalSession().createQuery("FROM Country").list();
	}

	public Country getCountry(String key) {
		return (Country) getLocalSession().get(Country.class, key);
	}

}
