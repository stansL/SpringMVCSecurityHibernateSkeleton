package ke.co.greid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.co.greid.dao.CountryDAO;
import ke.co.greid.entities.Country;

@Service
public class CountryService {
	
	@Autowired
	private CountryDAO countryDAO;

	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return countryDAO.getCountries();
	}

	public Country getCountry(String key) {
		return countryDAO.getCountry(key);
	}

}
