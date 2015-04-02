package ke.co.greid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.co.greid.dao.GenderDAO;
import ke.co.greid.entities.Gender;

@Service
public class GenderService {
	@Autowired
	private GenderDAO controller;

	public List<Gender> getGenders() {
		
		return controller.getGenders();
	}

	public Object getGender(Integer key) {
		return controller.getGender(key);
	}

}
