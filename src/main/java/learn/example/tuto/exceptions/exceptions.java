package learn.example.tuto.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exceptions {

	private Logger logger = LoggerFactory.getLogger(UserDefinedException.class);

	@ExceptionHandler(UserDefinedException.class)
	public ResponseEntity<ErrorDetails> HandlePatientExeption(UserDefinedException pe) {
     	logger.debug("entered into exception");
		ErrorDetails er= new ErrorDetails();
		er.setDescription(pe.getMessage());
		ResponseEntity<ErrorDetails> re = new ResponseEntity(er, HttpStatus.NOT_FOUND);
		logger.debug("exited from exception");
		return re;
	}

}
