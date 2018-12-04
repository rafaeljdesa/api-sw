package br.com.sw.api.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.sw.api.exception.PlanetaExisteException;

@ControllerAdvice
public class PlanetaExisteAdvice {
	
	@ResponseBody
	@ExceptionHandler(PlanetaExisteException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String planetaExisteHandler(PlanetaExisteException ex) {
		return ex.getMessage();
	}

}
