package ke.co.greid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ke.co.greid.dao.BloodGroupDAO;
import ke.co.greid.entities.BloodGroup;

@Service
public class BloodGroupService {

	@Autowired
	private BloodGroupDAO controller;
	public List<BloodGroup> getBloodGroups() {
		
		return controller.getBloodGroups();
	}
	public BloodGroup getBloodGroup(Integer key) {
		
		return controller.getBloodGroup(key);
	}

}
