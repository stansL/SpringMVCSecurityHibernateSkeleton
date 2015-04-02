package ke.co.greid.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ke.co.greid.entities.Patient;

@Transactional
@Component
public class PatientDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//convenience method
	public Session getLocalSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> getPatients() {
		return getLocalSession().createQuery("FROM Patient").list();
	}

	public void savePatient(Patient patient) {		
		
//		Patient patient2=(Patient) getLocalSession().save(patient);
		int id=(int) getLocalSession().save(patient);
		System.out.println(id);
		
	}

}
