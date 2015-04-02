package ke.co.greid.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class ErrorHandler {
	public String handleDatabaseException(DataAccessException da) {
		da.printStackTrace();
		return "error";
	}
	
	public String handleAccessExceptions(AccessDeniedException da) {
		da.printStackTrace();
		return "denied";
	}

}
