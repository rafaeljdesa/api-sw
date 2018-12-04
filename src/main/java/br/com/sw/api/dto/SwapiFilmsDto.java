package br.com.sw.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiFilmsDto {
	
	private List<String> films;

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	public Integer retornaQuantidadeFilmes() {
		return this.films.size();
	}
	
}
