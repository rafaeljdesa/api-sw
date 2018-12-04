package br.com.sw.api.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import br.com.sw.api.exception.PlanetaNaoEncontradoException;

@ControllerAdvice
public class PlanetaNaoEncontradoAdvice {
	
	@ResponseBody
	@ExceptionHandler(PlanetaNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String planetaNaoEncotradoHandler(PlanetaNaoEncontradoException ex) {
		return ex.getMessage();
	}
	
}
