package ke.co.greid.services;

import java.util.List;

import ke.co.greid.dao.MaritalStatuDAO;
import ke.co.greid.entities.MaritalStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaritalStatusService {
	@Autowired
	private MaritalStatuDAO controller;

	public List<MaritalStatus> getMaritalStatuses() {
		
		return controller.getMaritalStatuses();
	}

	public Object getMaritalStatus(Integer key) {
		
		return controller.getMaritalStatus(key);
	}

}
