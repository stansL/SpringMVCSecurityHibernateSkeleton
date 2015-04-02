package ke.co.greid.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.springframework.security.access.annotation.Secured;

import ke.co.greid.entities.Patient;
import ke.co.greid.services.PatientService;

@ManagedBean
public class PatientController {

	@ManagedProperty("#{patientService}")
	private PatientService patientService;	
	private List<Patient> patients;
	private Patient current = new Patient();
	private boolean skip;

	public Patient getCurrent() {
		return current;
	}

	public void setCurrent(Patient current) {
		this.current = current;
	}

	
	public PatientService getPatientService() {
		return patientService;
	}

	@PostConstruct
	public void init() {
		patients = patientService.getPatients();
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	public void save() { 
	
        FacesMessage msg = new FacesMessage("Successful", "The wrong one :Record  Saved For:" + current.getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	

}
