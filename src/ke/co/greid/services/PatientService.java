package ke.co.greid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import ke.co.greid.dao.PatientDAO;
import ke.co.greid.entities.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientDAO patientDAO;

	@Secured("ROLE_ADMIN")
	public List<Patient> getPatients() {

		return patientDAO.getPatients();
	}
   
	public void savePatient(Patient patient) {
		patientDAO.savePatient(patient);
		
	}

}
