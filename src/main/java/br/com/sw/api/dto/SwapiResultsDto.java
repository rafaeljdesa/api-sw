package br.com.sw.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResultsDto {
	
	private Integer count;
	
	private List<SwapiFilmsDto> results;

	public List<SwapiFilmsDto> getResults() {
		return results;
	}

	public void setResults(List<SwapiFilmsDto> results) {
		this.results = results;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
