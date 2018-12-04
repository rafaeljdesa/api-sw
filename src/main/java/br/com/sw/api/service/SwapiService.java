package br.com.sw.api.service;

import org.springframework.stereotype.Component;

@Component
public interface SwapiService {
	
	Integer retornaQuantidadeAparicoesPlaneta(String nomePlaneta);

}
