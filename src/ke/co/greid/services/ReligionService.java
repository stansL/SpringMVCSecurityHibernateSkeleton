package ke.co.greid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.co.greid.dao.ReligionDAO;
import ke.co.greid.entities.Religion;

@Service
public class ReligionService {
	
	@Autowired
	private ReligionDAO religionDAO;

	public List<Religion> getReligions() {
		
		return religionDAO.getReligions();
	}

	public Object getReligion(Integer key) {
		return religionDAO.getReligion(key);
	}

}
