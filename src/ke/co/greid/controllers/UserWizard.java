package ke.co.greid.controllers;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ke.co.greid.entities.BloodGroup;
import ke.co.greid.entities.Country;
import ke.co.greid.entities.Gender;
import ke.co.greid.entities.MaritalStatus;
import ke.co.greid.entities.Patient;
import ke.co.greid.entities.Religion;
import ke.co.greid.services.PatientService;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class UserWizard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7794269208870657461L;

	private Patient patient = new Patient();

	private boolean skip;
	private Logger logger = Logger.getLogger(UserWizard.class.getName());

	@ManagedProperty("#{patientService}")
	private PatientService patientService;

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String create() {
		logger.info(patient.toString());
		
		try {
			patientService.savePatient(patient);
			FacesMessage msg = new FacesMessage("Successful", "Welcome :"
					+ patient.getFirstName());
			FacesContext.getCurrentInstance().addMessage("successInfo", msg);
			return "create";
			
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error", "Did not save the record :"
					+ patient.getFirstName());
			FacesContext.getCurrentInstance().addMessage("erroInfo", msg);
			e.printStackTrace();
			return null;
		}

	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
}