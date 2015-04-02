package ke.co.greid.services;

import java.io.Serializable;
import java.util.List;

import ke.co.greid.dao.AuthoritiesDAO;
import ke.co.greid.entities.Authorities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthoritiesService implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8262371126377567982L;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	public List<Authorities> getAuthorities() {
		return authoritiesDAO.getAuthorities();
	}

	public Authorities getAuthority(Integer key) {
		return authoritiesDAO.getAuthority(key);
	}

}
